package ub.code.core.testng.config;

import lombok.Getter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ub.util.nlp.CosineSimilarity;
import ub.util.nlp.Similarity;

@Configuration
@Getter
public class OtherDefinitionsConfiguration {

    @Bean
    public Similarity cosineSimilarity() {
        return new CosineSimilarity();
    }
}
