package step.context;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;

@NoArgsConstructor
public class GuardianTestContext extends HashMap<String, Object> {

    @AllArgsConstructor
    public enum ContextVar {
        NEWS_TITLE("first.news.title"),
        GOOGLE_SEARCH_RESULTS("google.search.results")
        ;
        private String key;

        public String $() {
            return key;
        }

        public ContextVar $(String key) {
            return Arrays.stream(values())
                    .filter(v -> StringUtils.equalsIgnoreCase(v.$(), key))
                    .findFirst().orElse(null);
        }

    }

    public Object put(ContextVar key, Object value) {
        return super.put(key.$(), value);
    }

    public Object get(ContextVar key) {
        return super.get(key.$());
    }
}
