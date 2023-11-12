package ub.util.nlp;

import org.apache.commons.lang3.StringUtils;

public interface Similarity {

    @SuppressWarnings("deprecation")
    default double similarity(String s1, String s2)  {
        return Math.abs(1.0d - StringUtils.getLevenshteinDistance(s1, s2) / Math.sqrt(s1.length() * s2.length()) / 2);
    }

}
