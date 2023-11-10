package ub.util.nlp;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CosineSimilarity {

    public double cosineSimilarity(String one, String two) {
        List<String> wordsOne = Arrays.asList(one.split("\\W"));
        List<String> wordsTwo = Arrays.asList(two.split("\\W"));

        return cosineSimilarity(wordsOne, wordsTwo);
    }

    private double cosineSimilarity(List<String> wordsOne, List<String> wordsTwo) {

        Map<String, Long> wfmOne = calculateWordFrequency(wordsOne);
        Map<String, Long> wfmTwo = calculateWordFrequency(wordsTwo);

        return cosineSimilarity(wfmOne, wfmTwo);
    }

    // tfm
    private Map<String, Long> calculateWordFrequency(List<String> words) {
        return words.stream()
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));
    }

    /*
        cosine similarity [A, B] =
                A * B / ||A|| * ||B||
     */
    private double cosineSimilarity(Map<String, Long> firstVector, Map<String, Long> secondVector) {

        double scalarProduct = 0d;

        double nA = 0d;
        double nB = 0d;

        for (Map.Entry<String, Long> entry : firstVector.entrySet()) {

            String word = entry.getKey();

            long fA = entry.getValue();
            long fB = secondVector.getOrDefault(word, 0L);

            scalarProduct += fA * fB;
            nA += fA * fA;
            nB += fA * fB;
        }

        return scalarProduct / Math.sqrt(nA) / Math.sqrt(nB);
    }
}
