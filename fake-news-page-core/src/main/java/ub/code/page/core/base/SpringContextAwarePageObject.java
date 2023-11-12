package ub.code.page.core.base;

import ub.code.page.core.config.PagesProperties;
import org.springframework.context.ApplicationContext;

public class SpringContextAwarePageObject {

    protected static ApplicationContext applicationContext;

    public static void setContext(ApplicationContext context) {
        applicationContext = context;
    }

    public String getPageProperty(String propertyKey) {
        PagesProperties.PagesPropertiesMap bean = applicationContext.getBean(PagesProperties.PagesPropertiesMap.class);
        return bean.get(propertyKey).toString();
    }
}
