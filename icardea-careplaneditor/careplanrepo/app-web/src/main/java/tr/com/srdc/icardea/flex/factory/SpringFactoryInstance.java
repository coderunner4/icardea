package tr.com.srdc.icardea.flex.factory;

import org.springframework.web.context.support.WebApplicationContextUtils;

import flex.messaging.FactoryInstance;
import flex.messaging.FlexContext;
import flex.messaging.FlexFactory;
import flex.messaging.config.ConfigMap;

public class SpringFactoryInstance extends FactoryInstance {

	/**
	 * @param factory
	 * @param id
	 * @param properties
	 */
	public SpringFactoryInstance(FlexFactory factory, String id, ConfigMap properties) {
		super(factory, id, properties);
	}

	public Object getSpringBean() {
		return WebApplicationContextUtils.getWebApplicationContext(FlexContext.getServletContext()).getBean(getSource());
	}

}
