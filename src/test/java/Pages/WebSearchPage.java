package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class WebSearchPage {
   WebDriver driver;

    public WebSearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id='APjFqb']")
    public WebElement searchBar;

    @FindBy(xpath = "//*[@name='btnK']")
    public WebElement searchButton;



    public boolean isSearchbarDisplayed() {
        return searchBar.isDisplayed();
    }

    public void searchButton(){
        searchButton.click();
    }



}

