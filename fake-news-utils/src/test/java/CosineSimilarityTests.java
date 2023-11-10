import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ub.util.nlp.CosineSimilarity;

public class CosineSimilarityTests {

    public CosineSimilarity util;
    @BeforeEach
    public void beforeEach() {
        util = new CosineSimilarity();
    }

    @Test
    public void testCosineSimilarity() {
        String textA =
                "Wonderland-Elbonia war live: reports of Wonderland strikes close to something in " +
                        "Unknown as fighting intensifies";
        String textB =
                "Wonderland-Elbonia war live updates: Unknown yet another ministry says something hit in overnight strikes; " +
                        "Wonderland agrees daily agreements";

        assert util.cosineSimilarity(textA, textB) > 0.7;

    }
}
