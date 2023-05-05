package org.onair.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class NeweggHomePage extends Page{

    @FindBy(xpath = "//input[@type='search']")
    WebElement searchFieldInput;    // = getDriver().findElement(By.xpath("//input[@type='search']"));
    @FindBy(xpath = "//button[@class='ico ico-search']")
    WebElement searchButton;        // = getDriver().findElement(By.xpath("//button[@class='ico ico-search']"));

    public NeweggHomePage() {
        PageFactory.initElements(getDriver(), this);
    }

    public NeweggHomePage pageOpen(){
        visitPage("https://www.newegg.com/");
        return this;
    }

    public NeweggHomePage typeTextForSearch(String searchString){
        waitFor(visibilityOf(searchFieldInput));
        searchFieldInput.clear();
        searchFieldInput.click();
        searchFieldInput.sendKeys(searchString);
        return this;
    }

    public NeweggSearchResultsPage clickSearchButton() {
        waitFor(visibilityOf(searchButton));
        searchButton.click();
        return new NeweggSearchResultsPage();
    }

}
