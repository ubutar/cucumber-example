package ub.code.page.core.config;

import ub.code.page.core.constant.PageConstants;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
@Data
public class PagesProperties {

    @Value("${"+PageConstants.GUARDIAN_TONE_PAGE_KEY+"}")
    private String guardianTonePage;

    @Value("${"+PageConstants.GOOGLE_SEARCH_PAGE_KEY+"}")
    private String googleSearchPage;

    @Value("${"+PageConstants.PAGE_MINOR_EVENT_TIMEOUT +"}")
    private Integer webPageMinorTimeout;

    @Bean
    public PagesPropertiesMap getPagePropertiesMap() {
        PagesPropertiesMap map = new PagesPropertiesMap();
        map.put(PageConstants.GOOGLE_SEARCH_PAGE_KEY, googleSearchPage);
        map.put(PageConstants.GUARDIAN_TONE_PAGE_KEY, guardianTonePage);
        map.put(PageConstants.PAGE_MINOR_EVENT_TIMEOUT, webPageMinorTimeout);
        return map;
    }

    public static class PagesPropertiesMap extends HashMap<String, Object> {
    }
}
