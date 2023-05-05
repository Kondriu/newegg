package org.onair.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class NeweggSearchResultsPage extends Page {

    @FindBy(xpath = "//li[@class='is-current']")
    WebElement searchLabel;
    @FindBy(xpath = "//h1[@class='page-title-text']/span")
    WebElement searchResultsTitle;

    @FindBy(xpath = "//span[@class='item-open-box-italic']/../../a[@title='View Details']")
    List<WebElement> resultsItemsTitles;

    @FindBy(xpath = "//div[@class='item-sponsored-box']/../div[@class='item-info']/a")
    List<WebElement> sponsoredItemsTitles;

    public NeweggSearchResultsPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public String getSearchResultsLabel() {
        waitFor(visibilityOf(searchLabel));
        String label = searchLabel.getText();
        return label.substring(label.indexOf("\"") + 1, label.length() - 1);
    }

    public String getResultsTitle() {
        waitFor(visibilityOf(searchResultsTitle));
        return searchResultsTitle.getText().toLowerCase();
    }

    public List<String> cleanResults() {

        List<String> sponsoredTitles = sponsoredItemsTitles.stream()
                .map(x -> x.getText())
                .map(x -> x.toLowerCase())
                .collect(Collectors.toList());

        List<String> resultTitles = resultsItemsTitles.stream()
                .map(x -> x.getText())
                .map(x -> x.toLowerCase())
                .collect(Collectors.toList());

        resultTitles.removeAll(sponsoredTitles);

        return resultTitles;
    }
}
