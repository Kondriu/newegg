package org.onair.fixtures;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class SearchItemsFixture {

    public static Stream<Arguments> getSearchingItems() {
        return Stream.of(
                Arguments.of("fish tank"),
                Arguments.of("Cell Phone"),
                Arguments.of("iphone 14 pro")
        );
    }
}

