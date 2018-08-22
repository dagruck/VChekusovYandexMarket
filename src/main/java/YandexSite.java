import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

 class YandexSite {

    private WebDriver driver;
    YandexSite(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    String MarketUrl = "https://www.yandex.ru/";  //URL Yandex

    @FindBy(xpath = "//*[@data-id=\"market\"]")  //Market  Ya
       WebElement market;


    @FindBy(xpath = "//a[text()=\"Компьютеры\"]") // Computers
         WebElement computer;


    @FindBy(xpath = "//div[@class=\"catalog-menu__list\"]/a[text()=\"Ноутбуки\"]")   //notebook
      WebElement notebook;


    @FindBy(xpath = "//div[@class=\"catalog-menu__list\"]/a[text()=\"Планшеты\"]")   //tablet
       WebElement tablet;

    @FindBy(xpath = "//*[@id=\"glpriceto\"]")     //maxPrice
       WebElement maxPrice;
    @FindBy(xpath = "//*[@id=\"glpricefrom\"]")   //minPrice
       WebElement minPrice;




    //Массив
    @FindBy(xpath = "//div[@class=\"n-snippet-card2__hover\"]/..")
         List<WebElement> elements;


    @FindBy(xpath = "//*[@id=\"header-search\"]")  //Find product
       WebElement findProduct;
    @FindBy(xpath ="//span[text()= \"Найти\"]/..")   //Find button
      WebElement buttonFind;


    @FindBy(xpath ="//div[@class=\"n-title__text\"]/h1")       //Title product
      WebElement titleProduct;


    //JS for checkbox on/off
    public void selectCheckBox(String name) {
        String checkXpath = "//input[@name=\"Производитель " + name + "\"]";
             WebElement manufacture = driver.findElement(By.xpath(checkXpath));

        JavascriptExecutor executor = (JavascriptExecutor) driver;
              executor.executeScript("arguments[0].click()", manufacture);
    }


    }
