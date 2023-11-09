package example.page.config;

import example.page.constant.PageConstants;
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

    @Bean
    public PagesPropertiesMap getPagePropertiesMap() {
        PagesPropertiesMap map = new PagesPropertiesMap();
        map.put(PageConstants.GOOGLE_SEARCH_PAGE_KEY, googleSearchPage);
        map.put(PageConstants.GUARDIAN_TONE_PAGE_KEY, guardianTonePage);
        return map;
    }

    public static class PagesPropertiesMap extends HashMap<String, Object> {
    }
}
