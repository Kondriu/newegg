package org.onair;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.onair.pages.NeweggHomePage;
import org.onair.pages.NeweggSearchResultsPage;
import org.onair.utills.CustomAssertions;


public class ApplicationPageTest extends BaseTest {
    CustomAssertions customAssertions = new CustomAssertions();

    @DisplayName("Check displaying search results page")
    @Test
    public void gettingSearchResultsPageTest() {
        final String searchString = "fish tank";
        NeweggSearchResultsPage resultsPage = new NeweggHomePage()
                .pageOpen()
                .typeTextForSearch(searchString)
                .clickSearchButton();
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(resultsPage.getResultsTitle()).isEqualToIgnoringCase(searchString);
            softAssertions.assertThat(resultsPage.getSearchResultsLabel()).isEqualToIgnoringCase(searchString);
        });
    }

    @DisplayName("Check search results output")
    @ParameterizedTest(name = "testing searching item: {0}")
    @MethodSource("org.onair.utills.SearchItemsFixture#getSearchingItems")
    public void verifyingTestResults(final String searchString) {

        NeweggSearchResultsPage resultsPage = new NeweggHomePage()
                .pageOpen()
                .typeTextForSearch(searchString)
                .clickSearchButton();
        customAssertions.assertItemsListContains(resultsPage.cleanResults(), searchString);
    }
}
