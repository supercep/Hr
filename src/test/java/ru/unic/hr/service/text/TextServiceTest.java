package ru.unic.hr.service.text;

import org.junit.Test;
import ru.unic.hr.model.WordWeight;
import ru.unic.hr.service.file.FileReader;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * Created by BritikovMI on 11.09.2019.
 */
public class TextServiceTest {

    @Test
    public void getSentences() {
        File file = new File("C:\\Users\\BritikovMI\\Desktop\\msft.txt");

        String filteredText = TextService.deleteStopWords(FileReader.getFileContent(file));

        List<String> sentences = TextService.getListOfSentences(filteredText);

        sentences
                .forEach(System.out::println);

        buildSimilarityMatrix(sentences);

        List<String> strings = Arrays.asList(filteredText.split(" "));

        Double[][] wordMatrix = new Double[sentences.size()][sentences.size()];



        /*List<WordWeight> weights = new ArrayList<>();
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

        List<String> sentences = TextService.getListOfSentences(filteredText);

        sentences.forEach(System.out::println);
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

        sentenceWeights.forEach((s, h) -> System.out.println(h + " " + s));*/
    }

    private void buildSimilarityMatrix(List<String> sentences) {
        Double[][] mtx = new Double[sentences.size()][sentences.size()];

        sentences.forEach(sn1 -> {
            sentences.forEach(sn2 -> {
                if(!sn1.equalsIgnoreCase(sn2)){}
                    //mtx[sn1][sn2] = sentenceSimilarity(sentences[sn1], sentences[sn2], stop_words); build an a sim mtx

                    }
            );
        });
    }

    public static List<WordWeight> countWeight(List<WordWeight> wordWeights, Integer maxCount) {
        wordWeights.forEach(ww -> {
            ww.setWeight(ww.getCounts() / (double) maxCount);
        });

        return wordWeights;

    }
}