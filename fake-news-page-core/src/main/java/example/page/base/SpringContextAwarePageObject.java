package example.page.base;

import example.page.config.PagesProperties;
import org.springframework.context.ApplicationContext;

import java.util.Map;

public class SpringContextAwarePageObject {

    protected static ApplicationContext applicationContext;

    public static void setContext(ApplicationContext context) {
        applicationContext = context;
    }

    public String getPageProperty(String propertyKey) {
        Map bean = applicationContext.getBean(PagesProperties.PagesPropertiesMap.class);
        return bean.get(propertyKey).toString();
    }
}
