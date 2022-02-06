import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstTest {

    @Test
    public void checkMobilePayment() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.get("https://next.privat24.ua/mobile");

        By phoneNumber = By.xpath("//input[@data-qa-node='phone-number']");
        driver.findElement(phoneNumber).sendKeys("671077778");

        By amount = By.xpath("//input[@data-qa-node='amount']");
        driver.findElement(amount).sendKeys("1");

        By numberdebitSource = By.xpath("//input[@data-qa-node='numberdebitSource']");
        driver.findElement(numberdebitSource).sendKeys("5309233034765085");

        By expiredebitSource = By.xpath("//input[@data-qa-node='expiredebitSource']");
        driver.findElement(expiredebitSource).sendKeys("0124");

        By cvvdebitSource = By.xpath("//input[@data-qa-node='cvvdebitSource']");
        driver.findElement(cvvdebitSource).sendKeys("891");


        Thread.sleep(2000);

        By name = By.xpath("//input[@data-qa-node='firstNamedebitSource']");
        driver.findElement(name).sendKeys("Juliana");

        By lastName = By.xpath("//input[@data-qa-node='lastNamedebitSource']");
        driver.findElement(lastName).sendKeys("Janssen");

        By submit = By.xpath("//button[@data-qa-node='submit']");
        driver.findElement(submit).click();

        By cardNumberFrom = By.xpath("//td[@data-qa-node='card']");
        Assert.assertEquals("5309 **** **** 5085", driver.findElement(cardNumberFrom).getText());

        By numberConfirm = By.xpath("//div[@data-qa-node='details']");
        Assert.assertEquals("Поповнення телефону. На номер +380671077778", driver.findElement(numberConfirm).getText());

        By recipient = By.xpath("//span[@data-qa-node='nameB']");
//        System.out.println(driver.findElement(recipient).getText());
        Assert.assertEquals("Kyivstar Ukraine", driver.findElement(recipient).getText());

        By payAmount = By.xpath("//div[@data-qa-node='amount']");
        Assert.assertEquals("1 UAH", driver.findElement(payAmount).getText());

        By commission = By.xpath("//span[@data-qa-node='commission']");
//        System.out.println(driver.findElement(commission).getText());
        Assert.assertEquals("2", driver.findElement(commission).getText());

        By  commissionCurrency = By.xpath("//span[@data-qa-node='commission-currency']");
//        System.out.println(driver.findElement( commissionCurrency).getText());
        Assert.assertEquals(" UAH", driver.findElement( commissionCurrency).getText());

    }


}
