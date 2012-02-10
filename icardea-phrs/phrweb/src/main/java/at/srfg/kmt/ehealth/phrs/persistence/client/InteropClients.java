package at.srfg.kmt.ehealth.phrs.persistence.client;

import at.srfg.kmt.ehealth.phrs.PhrsConstants;
import at.srfg.kmt.ehealth.phrs.dataexchange.client.*;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.beanutils.DynaBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import at.srfg.kmt.ehealth.phrs.dataexchange.util.DynaBeanUtil;
import at.srfg.kmt.ehealth.phrs.persistence.api.GenericTriplestore;
import at.srfg.kmt.ehealth.phrs.persistence.api.Triple;
import at.srfg.kmt.ehealth.phrs.persistence.api.TripleException;

/**
 *
 * The available interoperability clients
 *
 */
public class InteropClients {

    @SuppressWarnings("unused")
    private final static Logger LOGGER = LoggerFactory.getLogger(InteropClients.class);
    VitalSignClient vitalSignClient;
    MedicationClient medicationClient;
    ProblemEntryClient problemEntryClient;
    SchemeClient schemeClient;
    TermClient termClient;
    ActorClient actorClient;
    DynaBeanClient dynaBeanClient;
    GenericTriplestore triplestore;
    PHRSRequestClient phrsRequestClient;

    public InteropClients(GenericTriplestore triplestore) throws Exception {
        this.triplestore = triplestore;
        init();

    }

    private void init() {
        vitalSignClient = new VitalSignClient(triplestore);
        vitalSignClient.setCreator(PhrsConstants.INTEROP_CREATOR_DEFAULT_PHR);

        medicationClient = new MedicationClient(triplestore);
        medicationClient.setCreator(PhrsConstants.INTEROP_CREATOR_DEFAULT_PHR);

        problemEntryClient = new ProblemEntryClient(triplestore);
        problemEntryClient.setCreator(PhrsConstants.INTEROP_CREATOR_DEFAULT_PHR);

        schemeClient = new SchemeClient(triplestore);
        
        actorClient= new ActorClient(triplestore);

        termClient = new TermClient(triplestore);

        dynaBeanClient = new DynaBeanClient(triplestore);
        //dynaBeanClient.setCreator(PhrsConstants.INTEROP_CREATOR_DEFAULT_PHR);
        
        phrsRequestClient=new PHRSRequestClient(triplestore);
    }

    public GenericTriplestore getTriplestore() {
        return triplestore;
    }
       public VitalSignClient getVitalSignClient() {

        return vitalSignClient;
    }

    public PHRSRequestClient getPHRSRequestClient() {

        return phrsRequestClient;
    }

    public MedicationClient getMedicationClient() {
        return medicationClient;
    }

    public ProblemEntryClient getProblemEntryClient() {
        return problemEntryClient;
    }

    public SchemeClient getSchemeClient() {
        return schemeClient;
    }

    public TermClient getTermClient() {
        return termClient;
    }

    public ActorClient getActorClient() {
        return actorClient;
    }

    public DynaBeanClient getDynaBeanClient() {
        return dynaBeanClient;
    }

    public DynaBean getResourceDynabean(String referenceId) {
        DynaBean dyna = null;
        try {
            dyna = getDynaBeanClient().getDynaBean(referenceId);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            LOGGER.error("", e);
        } catch (InstantiationException e) {
            e.printStackTrace();
            LOGGER.error("", e);
        } catch (TripleException e) {
            e.printStackTrace();
            LOGGER.error("", e);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("", e);
        }
        if (dyna != null) {
            System.out.println("DynaBeanUtil.toString(dyna)"
                    + DynaBeanUtil.toString(dyna));
        } else {
        }
        return dyna;
    }

    // TODO complete the refactoring of Triple based code to dynabean. Remove
    // PhrsStoreClient methods
    /**
     *
     * @param resourceURI
     * @param language
     * @return
     */
    public Collection<DynaBean> getTermResourceDynabeans(String resourceURI,
            String language) {

        Iterable<Triple> subjects = null;
        Collection<DynaBean> collection = new ArrayList<DynaBean>();

        if (termClient != null) {
            try {
                subjects = termClient.getTermsRelatedWith(resourceURI);
                for (Triple subject : subjects) {
                    String res = subject.getSubject();
                    DynaBean dyna = getResourceDynabean(res);
                    if (dyna != null) {
                        collection.add(dyna);

                    }
                }

            } catch (TripleException e) {
                e.printStackTrace();
                LOGGER.error("", e);
            } catch (Exception e) {
                e.printStackTrace();
                LOGGER.error("", e);
            }

        }

        return collection;
    }
}
