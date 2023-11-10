package step.context;

import lombok.Getter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ub.util.nlp.CosineSimilarity;

@Configuration
@Getter
public class DefinitionsConfiguration {

    @Bean
    public CosineSimilarity cosineSimilarity() {
        return new CosineSimilarity();
    }
}
