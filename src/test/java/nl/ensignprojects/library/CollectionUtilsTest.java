package nl.ensignprojects.library;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static org.assertj.core.api.Assertions.assertThat;


@Slf4j
class CollectionUtilsTest {

    @Test
    @DisplayName("Odd sized collection - list")
    void testOddList() {
        List<String> words = Stream.of("this", "is", "an", "example", "collection", "to", "prove", "that", "it", "will", "work").collect(toList());

        List<List<String>> lists = CollectionUtils.makeBatch(words, 2);

        log.info("full list: {}", lists);

        log.info("Test odd sized collection, size: {}", words.size());
        lists.forEach(l -> log.info("batched: {}", l));

        org.junit.jupiter.api.Assertions.assertAll(
                () -> assertThat(lists.size()).isEqualTo(6),
                () -> assertThat(lists.get(lists.size() - 1).size()).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("Odd sized collection - set")
    void testOddSet() {
        Set<String> words = Stream.of("this", "is", "an", "example", "collection", "to", "prove", "that", "it", "will", "work").collect(toSet());

        List<List<String>> lists = CollectionUtils.makeBatch(words, 2);

        log.info("Test odd sized collection, size: {}", words.size());
        lists.forEach(l -> log.info("batched: {}", l));

        org.junit.jupiter.api.Assertions.assertAll(
                () -> assertThat(lists.size()).isEqualTo(6),
                () -> assertThat(lists.get(lists.size() - 1).size()).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("Even sized collection")
    void testEven() {
        List<String> words = Stream.of("this", "is", "an", "example", "collection", "to", "prove", "that", "it", "works").collect(toList());

        List<List<String>> lists = CollectionUtils.makeBatch(words, 2);

        log.info("Test even sized collection, size: {}", words.size());
        lists.forEach(l -> log.info("batched: {}", l));

        org.junit.jupiter.api.Assertions.assertAll(
                () -> assertThat(lists.size()).isEqualTo(5),
                () -> assertThat(lists.get(lists.size() - 1).size()).isEqualTo(2)
        );
    }

    @Test
    @DisplayName("Batch size larger than collection size")
    void testBatchSizeLargerThanCollection() {
        List<String> words = Stream.of("this", "is", "an", "example", "collection", "to", "prove", "that", "it", "works").collect(toList());

        List<List<String>> lists = CollectionUtils.makeBatch(words, 100);

        log.info("Batch size ({}) > collection size ({})", 100, words.size());
        lists.forEach(l -> log.info("batched: {}", l));

        org.junit.jupiter.api.Assertions.assertAll(
                () -> assertThat(lists.size()).isEqualTo(1),
                () -> assertThat(lists.get(lists.size() - 1).size()).isEqualTo(10)
        );
    }


    @Test
    @DisplayName("Empty collection")
    void testEmptyCollection() {
        List<List<Object>> lists = CollectionUtils.makeBatch(Collections.emptyList(), 3);
        assertThat(lists.size()).isEqualTo(1);
        assertThat(lists.get(0).size()).isEqualTo(0);
    }
}