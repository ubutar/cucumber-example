import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ub.util.nlp.CosineSimilarity;
import ub.util.nlp.Similarity;

public class CosineSimilarityTests {

    public Similarity util;
    @BeforeEach
    public void beforeEach() {
        util = new CosineSimilarity();
    }

    @Test
    public void testCosineSimilarity() {
        String textA =
                "Wonderland-Elbonia interactions live: reports of Wonderland acting close to something in " +
                        "Unknown as uncertainty intensifies";
        String textB =
                "Wonderland-Elbonia interactions live updates: Unknown yet another ministry says something happened in overnight actions; " +
                        "Wonderland agrees daily agreements";

        assert util.similarity(textA, textB) > 0.7;

    }
}
