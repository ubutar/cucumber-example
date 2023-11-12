package ub.code.definition.core.context;

import lombok.Getter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ub.code.services.config.FacadeModule;
import ub.util.nlp.CosineSimilarity;
import ub.util.nlp.Similarity;

@Configuration
@Import(FacadeModule.class)
@Getter
public class DefinitionsConfiguration {

    @Bean
    public Similarity cosineSimilarity() {
        return new CosineSimilarity();
    }
}
