import YadMark.RunTest;
import com.hp.lft.report.ReportException;
import com.hp.lft.report.Reporter;
import com.hp.lft.sdk.GeneralLeanFtException;
import org.junit.*;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import unittesting.UnitTestClassBase;

import java.util.concurrent.TimeUnit;

public class MarketTest extends UnitTestClassBase {
    private WebDriver driver;
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        instance = new RunTest();
        globalSetup( RunTest.class);
    }
    @Before
    public void setUpBefore() {

        //selenium web driver path
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vchekusov\\IdeaProjects\\Marcet-master-master\\Marcet-master-master\\chromedriver.exe");
        //selenium web driver config
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test

    //  Тест поиска ноутбуков
    public void notebookTest() throws ReportException {

//        1.      Открыть браузер Chrome и развернуть на весь экран.
//        2.      Зайти на yandex.ru.
//        3.      Перейти в яндекс маркет
//        4.      Выбрать раздел Компьютеры
//        5.      Выбрать раздел Ноутбуки
//        6.      Задать параметр поиска до 30000 рублей.
//        7.      Выбрать производителя HP и Lenovo
//        8.      Нажать кнопку Применить.
//        9.      Проверить, что элементов на странице 12.
//        10.  Запомнить первый элемент в списке.
//        11.  В поисковую строку ввести запомненное значение.
//        12.  Найти и проверить, что наименование товара соответствует запомненному значению.

        YandexSite marketPage = new YandexSite(driver);

        driver.get(marketPage.MarketUrl );

        marketPage.market.click();
        Reporter.reportEvent( "Переход на сайт ","Done" );
        marketPage.computer.click();
        Reporter.reportEvent( "Переход в компьютеры ","Done" );
        marketPage.notebook.click();
        Reporter.reportEvent( "Переход в ноутбуки ","Done" );
        marketPage.maxPrice.sendKeys("30000");
        Reporter.reportEvent( "Выбор МАХ цена","Done" );
        marketPage.selectCheckBox("HP");
        marketPage.selectCheckBox("Lenovo");
        //wait download page
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Reporter.reportEvent( "Выбор Производителя","Done" );
        //на странице 48 елемнтов по умолчанию
        Assert.assertEquals(48, marketPage.elements.size());

        String device = marketPage.elements.get(0).getText();
        String[] deviceParts = device.split("\n");

        marketPage.findProduct.sendKeys(deviceParts[1]);
        marketPage.buttonFind.submit();
        Reporter.reportEvent( "Выбор элемента и поиск","Done" );
        String deviceFind = marketPage.titleProduct.getText().substring(0, 35);

        Assert.assertEquals(deviceParts[1], deviceFind);
        System.out.println("Элементы совпадают!");
        Reporter.reportEvent( "Элементы совпадают!","Done" );
        Reporter.reportEvent( "Done","Done" );
    }

    @Test

//        1.      Открыть браузер Chrome и развернуть на весь экран.
//        2.      Зайти на yandex.ru.
//        3.      Перейти в яндекс маркет
//        4.      Выбрать раздел Компьютеры
//        5.      Выбрать раздел Планшеты
//        6.      Задать параметр поиска от 20000 рублей.
//        7.      Задать параметр поиска до 25000 рублей.
//        8.      Выбрать производителей Acer и DELL
//        9.      Нажать кнопку Применить.
//        10.  Проверить, что элементов на странице  12.
//        11.  Запомнить первый элемент в списке.
//        12.  В поисковую строку ввести запомненное значение.
//        13.  Найти и проверить, что наименование товара соответствует запомненному значению.


    public void tabletTest() throws ReportException {

        YandexSite marketPage = new YandexSite(driver);

        driver.get(marketPage.MarketUrl );

        marketPage.market.click();
        Reporter.reportEvent( "Переход на сайт ","Done" );
        marketPage.computer.click();
        Reporter.reportEvent( "Переход в компьютеры ","Done" );
        marketPage.tablet.click();
        Reporter.reportEvent( "Переход в планшеты ","Done" );
        marketPage.minPrice.sendKeys("20000");
        marketPage.maxPrice.sendKeys("40000");
        Reporter.reportEvent( "Выбор  цен","Done" );
        marketPage.selectCheckBox("ASUS");
        marketPage.selectCheckBox("Apple");
        Reporter.reportEvent( "Выбор Производителя","Done" );
        //wait download page
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //на странице 24 елемнтов по умолчанию
        Assert.assertEquals(24, marketPage.elements.size());

        String device = marketPage.elements.get(0).getText();
        String[] deviceParts = device.split("\n");

        marketPage.findProduct.sendKeys(deviceParts[0]);
        marketPage.buttonFind.submit();
        Reporter.reportEvent( "Выбор элемента и поиск","Done" );
        String deviceFind = marketPage.titleProduct.getText();

        Assert.assertEquals(deviceParts[0], deviceFind);

    }

    @After
    public void tearDownAfter() throws ReportException {
        Reporter.reportEvent( "Тест закончен","Done" );
        driver.quit();

    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        globalTearDown();
    }
}
