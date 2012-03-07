package at.srfg.kmt.ehealth.phrs.security.services;

import at.srfg.kmt.ehealth.phrs.PhrsConstants;
import at.srfg.kmt.ehealth.phrs.persistence.client.CommonDao;
import at.srfg.kmt.ehealth.phrs.persistence.client.PhrsStoreClient;
import at.srfg.kmt.ehealth.phrs.presentation.services.ConfigurationService;
import at.srfg.kmt.ehealth.phrs.presentation.services.UserSessionService;
import java.io.Serializable;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Authorization adapter for known Consent Manager
 * Handles conversion of identifiers needed between components and handles decision when no proper identifier available.
 * For the primary consent manager, one might  use either protocolIds or phrIds, however, we provide the selected prototcolid as a
 * session attribute for the consent manager to use. Alternatively, one could expose the phrId.
 * A local identifier (phrId or ownerId) is used to find a "ProtocolId". If that is not found, then the phrId will be used.
 *
 */
@SuppressWarnings("serial")
public class AuthorizationService implements Serializable {
	private final static Logger LOGGER = LoggerFactory
			.getLogger(AuthorizationService.class);

	private String ownerUri = null;

	// keep as public until JSF issue resolved...
	public boolean allowTest = true;

	public boolean allowCreate = true;
	public boolean allowView = true;
	public boolean allowEdit = true;
	public boolean allowDelete = true;
	public boolean allowList = true;
	public boolean allowViewChart = true;
	public boolean editMode = true;

	public static String MODIFY_YES = "yes";
	public static String MODIFY_NO = "no";

	private ConsentMgrService consentMgrService = null;

	// protected ConfigurationService config;

	public static AuthorizationService getDefault(int level) {
		AuthorizationService permit = new AuthorizationService();
		if (level == 0) {
			permit.setEditMode(false);
			permit.setAllowCreate(false);
			permit.setAllowDelete(false);
			permit.setAllowCreate(false);
		}
		return permit;

	}

	public AuthorizationService() {

		// lookup the filter ownerUri and store in session
		// REQUEST_USER_PHR_FILTER_PROTOCOL_NAMESPACE

		// config = ConfigurationService.getInstance();
		init();
		// request related
		UserSessionService.updateRequestToSessionParameters();
		consentMgrService = new ConsentMgrService();

	}

	/**
	 * Wrap Authorization tools
	 * 
	 * @param ownerUri
	 * @return
	 */
	public static AuthorizationService getDefaultByOwnerUri(String ownerUri) {
		AuthorizationService permit = new AuthorizationService();

		permit.ownerUri = ownerUri;
		return permit;

	}

	private void init() {

	}

	public boolean auditGrantRequest(String patientId, boolean isPhrId,
			 String resourceCode) {
		String idType = "phrid";
		if (!isPhrId)
			idType = PhrsConstants.PROTOCOL_ID_NAME;
		String requesterRole=UserSessionService.getSessionAttributeRole();
		
		return consentMgrService.auditGrantRequest(patientId, idType,
				requesterRole, resourceCode);
	}

	public boolean auditGrantRequest(String patientId, String idType,
			String requesterRole, String resourceCode) {
		return consentMgrService.auditGrantRequest(patientId, idType,
				requesterRole, resourceCode);
	}
    public String getProtocolId(String ownerUri) {
        CommonDao dao = PhrsStoreClient.getInstance().getCommonDao();
        return dao.getProtocolId(ownerUri);
    }
    /**
     *
     * Given the role of user, is their action permitted upon a resource owned
     * by another targetUser ? Uses the subjectRole of the logged in user, the
     * session Role PhrsConstants.AUTHORIZE_ROLE_PHRS_SUBJECT_CODE_* or the PHR
     * local role
     *
     * RoleCode (subject code) is derived from the Session attribute for role
     * @param targetUser
     * @param resourceCode
     * @param action
     * @return
     */
	public boolean grantAccessByPhrIdOnSessionUserRole(String targetUserPhrId, String resourceCode,
                                                       String action) {
		String subjectRole = UserSessionService.getSessionAttributeRole();

        String targetUserPID = getProtocolId(targetUserPhrId);
        if(targetUserPID == null) targetUserPID= targetUserPhrId;

        return permitAccessByPID(targetUserPID, resourceCode, action,
                subjectRole);
	}

    /**
     *
     * @param targetUser
     * @param resourceCode
     * @param action
     * @param subjectRole
     * @return
     */
    public boolean grantAccessByPhrIdAndRole(String targetUserPhrId, String resourceCode,
                                      String action,String subjectRole) {
        String targetUserPID = getProtocolId(targetUserPhrId);
        if(targetUserPID == null) targetUserPID= targetUserPhrId;

        return permitAccessByPID(targetUserPID, resourceCode, action,
                subjectRole);
    }


	public boolean grantAccessByProtocolId(String targetUser,
                                           String resourceCode, String action) {
		String subjectRole = UserSessionService.getSessionAttributeRole();

		return this.permitAccessByPID(targetUser, resourceCode, action,
                subjectRole);
	}

	/**
	 * 
	 * @param targetUser
	 * @param resourceCode
	 *            PhrsConstants.AUTHORIZE_RESOURCE_CODE_*
	 * @param action
	 *            PhrsConstants.AUTHORIZE_ACTION_CODE_READ , WRITE, UPDATE
	 * @param subjectRole
	 *            PhrsConstants.AUTHORIZE_ROLE_PHRS_SUBJECT_CODE_* or the PHR
	 *            local role
	 * @return
	 */
	public boolean permitAccessByPID(String targetUser,
                                     String resourceCode, String action, String subjectRole) {

		if (isResourceOwnedBySessionUser(targetUser)) {
			return true;
		}

		boolean result = false;

		if (consentMgrService != null) {
			if (isConsentMgrRole(subjectRole)) {

				consentMgrService.isPermittedByPID(targetUser, subjectRole,
						resourceCode, action);

			} else {
				LOGGER.debug("Not a consent mgt role" + resourceCode);
			}
		}

		return result;

	}

    /**
     *
     * @param targetUser
     * @return
     */
	public boolean isResourceOwnedBySessionUser(String targetUser) {
		return UserSessionService.isSessionUser(targetUser);

	}

	public List<String> getConsentSubjects() {
		return consentMgrService.callGetSubjects();
	}

	public List<String> getConsentResources() {
		return consentMgrService.callGetResources();
	}

	public boolean isConsentMgrRole(String subjectCode) {

		return ConsentMgrService.isConsentMgrRole(subjectCode);
	}

	public String getSessionUserLoginId() {
		return UserSessionService.getSessionAttributeUserLoginId();

	}

	public String getSessionUserOwnerUri() {
        return UserSessionService.getSessionAttributePhrId();

	}

	/**
	 * Get the role, but use isMedicalRole() to determine Default is
	 * PhrsConstants.AUTHORIZE_ROLE_PHRS_SUBJECT_CODE_USER
	 * 
	 * @return  session role
	 */
	public String getSessionUserRole() {

		String value = UserSessionService.getSessionAttributeRole();
		if (value != null && value.length() > 0) {
			// leave as null
			value = PhrsConstants.AUTHORIZE_ROLE_PHRS_SUBJECT_CODE_USER;
		}
		return value;
	}

	public static boolean isMedicalRole() {

		return ConfigurationService.getInstance().isMedicalCareRole(
				UserSessionService.getSessionAttributeRole());
	}

	public boolean hasFilterProtocolId() {
		return UserSessionService.hasSessionFilterProtocolId();

	}

	public String getFilterProtocolId() {

	    return UserSessionService.getSessionAttributeFilterProtocolId();

	}

	public String modify = MODIFY_NO;

	public String getModify() {
		return modify;
	}

	public void setModify(String modify) {
		this.modify = modify;
	}

	public void makeModifyYes() {
		modify = MODIFY_YES;
	}

	public void makeModifyNo() {
		modify = MODIFY_NO;
	}

	public void setAllowAllFalse() {
		allowList = false;
		allowEdit = false;
		allowDelete = false;
		allowList = false;
		allowCreate = false;
	}

	public boolean getAllowAll() {
		return isAllowAll();
	}

	public boolean isAllowAll() {
		return allowList && allowEdit && allowDelete && allowList;
	}

	public boolean getAllowAny() {
		return isAllowAny();
	}

	public boolean isAllowAny() {
		return allowList || allowEdit || allowDelete || allowList;
	}

	public void setPermittedActions() {
	}

	public boolean getAllowTest() {
		return allowTest;
	}

	public boolean isAllowTest() {
		return allowTest;
	}

	public void setAllowTest(boolean allowTest) {
		this.allowTest = allowTest;
	}

	public boolean getAllowCreate() {
		return allowCreate;
	}

	public boolean isAllowCreate() {
		return allowCreate;
	}

	public void setAllowCreate(boolean allowCreate) {
		this.allowCreate = allowCreate;
	}

	public boolean isAllowView() {
		return allowView;
	}

	public void setAllowView(boolean allowView) {
		this.allowView = allowView;
	}

	public boolean isAllowEdit() {
		return allowEdit;
	}

	public boolean getAllowEdit() {
		return allowEdit;
	}

	public void setAllowEdit(boolean allowEdit) {
		this.allowEdit = allowEdit;
	}

	public boolean getAllowDelete() {
		return allowDelete;
	}

	public boolean isAllowDelete() {
		return allowDelete;
	}

	public void setAllowDelete(boolean allowDelete) {
		this.allowDelete = allowDelete;
	}

	public boolean getAllowList() {
		return allowList;
	}

	public boolean isAllowList() {
		return allowList;
	}

	public void setAllowList(boolean allowList) {
		this.allowList = allowList;
	}

	public boolean getAllowViewChart() {
		return allowViewChart;
	}

	public boolean isAllowViewChart() {
		return allowViewChart;
	}

	public void setAllowViewChart(boolean allowViewChart) {
		this.allowViewChart = allowViewChart;
	}

	public boolean getEditMode() {
		return editMode;
	}

	public boolean isEditMode() {
		return editMode;
	}

	/*
	 * public boolean getEditMode() { System.out.println("permit getEditMode");
	 * return editMode; } public boolean editMode() {
	 * System.out.println("permit editMode"); return editMode; }
	 */
	public void setEditMode(boolean editMode) {

		this.editMode = editMode;
	}

	/*
	 * 
	 * @return
	 * 
	 * public String findFilterOwnerUri() { return
	 * UserSessionService.getRequestParameterFilterOwnerUri();
	 * 
	 * }
	 */

	public String getOwnerUri() {
		if (ownerUri != null)
			return ownerUri;
		return UserSessionService.getSessionAttributePhrId();
	}

	public void setOwnerUri(String ownerUri) {
		this.ownerUri = ownerUri;
	}

}
