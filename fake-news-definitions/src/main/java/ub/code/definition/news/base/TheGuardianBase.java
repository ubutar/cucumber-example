package ub.code.definition.news.base;

import org.springframework.beans.factory.annotation.Autowired;
import ub.code.definition.context.GuardianTestContext;
import ub.code.model.GoogleSearchResult;
import ub.code.services.GoogleFacade;
import ub.code.services.GuardianFacade;
import ub.util.nlp.Similarity;

import java.util.List;

import static ub.code.definition.context.GuardianTestContext.ContextVar.GOOGLE_SEARCH_RESULTS;
import static ub.code.definition.context.GuardianTestContext.ContextVar.NEWS_TITLE;

public class TheGuardianBase {

    @Autowired
    protected Similarity similarityCalc;

    protected GuardianTestContext context;

    @Autowired
    protected GuardianFacade guardian;

    @Autowired
    protected GoogleFacade google;

    @SuppressWarnings("unchecked")
    protected int googleResultsExceedingSimilarityThreshold(double score) {
        return (int) ((List<GoogleSearchResult>) context.get(GOOGLE_SEARCH_RESULTS))
                .stream().filter(gsr ->
                        similarityCalc.similarity(gsr.getUrlName(),
                                context.get(NEWS_TITLE).toString()) >= score)
                .count();
    }
}
