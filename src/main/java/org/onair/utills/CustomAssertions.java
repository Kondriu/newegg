package org.onair.utills;

import org.assertj.core.api.SoftAssertions;

import java.util.List;

public class CustomAssertions {

    public void assertItemsListContains(List<String> items, String searchItem){

        for (String item: items) {
            SoftAssertions.assertSoftly(softAssertions -> {
                softAssertions.assertThat(item)
                        .as(String.format("Item: %s \n doest contain searched element %s", item, searchItem))
                        .contains(searchItem.split(" "));
            });
        }
    }
}
