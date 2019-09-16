package ru.unic.hr.service.text;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import ru.unic.hr.model.WordWeight;
import ru.unic.hr.service.file.FileReader;

import java.io.File;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * Created by BritikovMI on 11.09.2019.
 */
public class TextServiceTest {

    @Test
    public void getSentences() {
        File file = new File("C:\\Users\\BritikovMI\\Desktop\\msft.txt");

        String filteredText = TextService.deleteStopWords(FileReader.getFile(file));

        List<String> strings = Arrays.asList(filteredText.split(" "));

        List<WordWeight> weights = new ArrayList<>();
        Map<String, Integer> wght = new HashMap<>();
        strings.forEach(str -> {
            wght.put(str, StringUtils.countMatches(filteredText, str));
        });

        List<WordWeight> finalWeights = weights;
        wght.forEach((s, integer) -> {
            WordWeight ww = new WordWeight();
            ww.setWord(s);
            ww.setCounts(integer);
            finalWeights.add(ww);
        });
        weights = finalWeights.stream()
                .sorted(WordWeight.compareByCounts.reversed())
                .collect(Collectors.toList());
        Integer maxCount = weights.get(0).getCounts();

        weights = countWeight(weights, maxCount);

        List<String> sentences = TextService.getSentences(filteredText);

        Map<String, Double> sentenceWeights = new HashMap<>();
        List<WordWeight> finalWeights1 = weights;
        sentences.forEach(snt -> {
            AtomicReference<Double> cvv = new AtomicReference<Double>(0D);
            Arrays.asList(snt.split(" "))
                    .forEach(word -> {
                        WordWeight ww = new WordWeight();
                        if(finalWeights1.stream().anyMatch(wh -> wh.getWord().equalsIgnoreCase(word))) {
                             finalWeights1.stream().filter(wh -> wh.getWord().equalsIgnoreCase(word)).collect(Collectors.toList()).forEach(s-> System.out.println(word + " " + s.getWeight()));
                        }
                        WordWeight finalWw = ww;
                        cvv.updateAndGet(v -> v + finalWw.getWeight());
                    });
            sentenceWeights.put(snt, cvv.get());
        });

        sentenceWeights.forEach((s, h) -> System.out.println(h + " " + s));
    }

    public static List<WordWeight> countWeight(List<WordWeight> wordWeights, Integer maxCount) {
        wordWeights.forEach(ww -> {
            ww.setWeight(ww.getCounts() / (double) maxCount);
        });

        return wordWeights;

    }
}