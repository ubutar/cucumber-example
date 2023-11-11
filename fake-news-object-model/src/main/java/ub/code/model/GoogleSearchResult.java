package ub.code.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoogleSearchResult {

    private String source;
    private String url;
    private String urlName;
    private String previewText;

    public GoogleSearchResult(String url, String urlName) {
        this.url = url;
        this.urlName = urlName;
    }
}
