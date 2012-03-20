package at.srfg.kmt.ehealth.phrs.jsf.utils;

import java.util.Collection;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import at.srfg.kmt.ehealth.phrs.presentation.services.ModelLabelValue;
import at.srfg.kmt.ehealth.phrs.presentation.services.VocabularyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




// @ FacesConverter( value="labelLookup" )
public class LabelLookupConverter implements Converter {
    private static final Logger LOGGER = LoggerFactory.getLogger(LabelLookupConverter.class);
/**
 * from UI to data store...
 */
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2)
			throws ConverterException {
		if(arg2 !=null) {
			return arg2;
		}
		return arg2;

	}
	
	/**from value to UI view **/

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ConverterException {
	/*	String val="";
		if(arg2!=null && arg2 instanceof ModelLabelValue){
			ModelLabelValue lv = (ModelLabelValue)arg2;
			val = lv.getId();
			
		}
		return val;*/
		//String label="";
	
		if(arg2 != null){
			String language="en";
			try {
				if (FacesContext.getCurrentInstance().getExternalContext().getRequestLocale().getLanguage()!=null){
					language = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale().getLanguage();		
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}			
			try {


				if( arg2 instanceof String){
							ModelLabelValue lv= VocabularyService.getTerm((String)arg2, language);
							if(lv!=null) {
								return lv.getLabel();
							}
			
				} else if( arg2 instanceof Collection  ){
					
					ModelLabelValue lv=null;
					StringBuffer sb=new StringBuffer();
					Collection<String> temp= (Collection<String>)arg2;
					for(String termId:temp){
						lv = VocabularyService.getTerm(termId, language);
						if(lv!=null && lv.getLabel()!=null) {	
							if(sb.length() > 0) sb.append(",");
							sb.append(lv.getLabel());
						}
					}
					return sb.toString();
				}
			} catch (Exception e) {
				LOGGER.debug(e.getMessage(),e);
			}
		}
		if(arg2 != null) return arg2.toString();
		return "?";
	}



    
    
}
