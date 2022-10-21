import com.sun.source.tree.WhileLoopTree;
import jdk.security.jarsigner.JarSigner;
import okio.Timeout;
import org.apache.http.util.Asserts;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.CertificateRevokedException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class abcd {
    public static <exception extends Throwable> void main(String[] args) throws IOException, InterruptedException, AWTException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("headless");
        System.setProperty("webdriver.chrome.driver", "C:/Users/kalyan/Desktop/Selenium by Hima/Drivers/ANT/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");

//        driver.manage().window().maximize();

//        System.out.println(driver.getPageSource());


//        HANDELING CALENDOR-----------------------
//        ChromeOptions ch = new ChromeOptions();
//        ch.addArguments("headless");
//        System.setProperty("webdriver.chrome.driver", "C:/Users/kalyan/Desktop/Selenium by Hima/Drivers/ANT/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.interviewbit.com/api-testing-interview-questions/#what-protocols-can-be-tested-using-api-testing");
//        driver.manage().window().maximize();
//        System.out.println(driver.getCurrentUrl());
//        System.out.println(driver.getTitle());
//        System.out.println(driver.getWindowHandles());
//        Thread.sleep(5000);
//        String open = Keys.chord(Keys.CONTROL, Keys.ENTER);
//         driver.findElement(By.xpath("//a[text()='Forgotten password?']")).sendKeys(open);
//         Set<String> list = driver.getWindowHandles();
//        System.out.println(list);
//
//               Iterator<String>itr   = list.iterator();
//              String par = itr.next();
//              String ch = itr.next();
//              driver.switchTo().window(ch);

//        driver.get("https://www.naukri.com/mnjuser/homepage");
//        driver.manage().window().maximize();
////        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//        driver.findElement(By.id("usernameField")).sendKeys("kalyankumpati68@gmail.com");
//        driver.findElement(By.id("passwordField")).sendKeys("kalyan@54");
//////
//        driver.findElement(By.xpath("//button[text()='Login']")).click();
//        driver.findElement(By.xpath("//div[@attribute='kaluan']"));

    /*   WebElement cal = driver.findElement(By.xpath("//input[@id ='datepicker']"));
       cal.click();
        String MonthAndYear = driver.findElement(By.xpath("//div[@class ='ui-datepicker-title']")).getText();
        System.out.println(MonthAndYear);
        String month = MonthAndYear.split(" ")[0];
        String year = MonthAndYear.split(" ")[1];

        while (!(month.equalsIgnoreCase("June")&&(year.equalsIgnoreCase("2023")))){
            WebElement nex = driver.findElement(By.xpath("//span[text() ='Next']"));
            nex.click();
            MonthAndYear = driver.findElement(By.xpath("//div[@class ='ui-datepicker-title']")).getText();
            month = MonthAndYear.split(" ")[0];
            year = MonthAndYear.split(" ")[1];
        }
     */
        /*   SWITCH TO MULTIPLE WINDOWS--------------------------------------------------

//        driver.get("https://www.google.co.in/webhp?authuser=0");
//        driver.manage().window().maximize();
//        driver.findElement(By.xpath("//a[@class='gb_A']")).click();
//    }
//}
//        String title1 = driver.getWindowHandle();
////        System.out.println("parent"+ title1);
//
//        String keys = Keys.chord(Keys.CONTROL, Keys.ENTER);
//        driver.findElement(By.xpath("//a[text()='Forgotten password?']")).sendKeys(keys);
//
//        Set<String> windows = driver.getWindowHandles();
//        System.out.println(windows.size());
//
//          Iterator<String> itr = windows.iterator();
//                 String parentwindow = itr.next();
//                 String childwindow = itr.next();
//        System.out.println(parentwindow);
//        System.out.println(childwindow);
//        driver.switchTo().window(childwindow);
//        Thread.sleep(5000);
//        driver.switchTo().window(parentwindow);

*/

      //ASSERTIONS-HARD ASSERTION AND SOFT ASSERTION--------------------------
        SoftAssert softAssert = new SoftAssert();
        FileInputStream fileInputStream = new FileInputStream("C:/Users/kalyan/IdeaProjects/22032022/src/inputs.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);

        System.setProperty("webdriver.chrome.driver","C:/Users/kalyan/Desktop/Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(properties.getProperty("url"));
        driver.manage().window().maximize();
        String current = driver.getCurrentUrl();

        softAssert.assertEquals(current, properties.getProperty("url"));

        driver.findElement(By.id("email")).sendKeys(properties.getProperty("uname"));

       String name = driver.findElement(By.id("email")).getAttribute("value");
        softAssert.assertEquals(name, properties.getProperty ("uname"));

        driver.findElement(By.id("pass")).sendKeys(properties.getProperty("pass"));
        String word = driver.findElement(By.id("pass")).getAttribute("value");

        softAssert.assertEquals(word, properties.getProperty("pass"));
        softAssert.assertAll();


        /*TO HANDLE THE SECRE WEBPAGES -------------------------------------------------
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setAcceptInsecureCerts(true);

        System.setProperty("webdriver.chrome.driver", "C:/Users/kalyan/Desktop/Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver(desiredCapabilities);
        driver.get("http://www.cacert.com");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[text()='Join']")).click();
*/
 /*     HEADLESS-TO DO TASK WITH OUT OPENING BROWSER----------------------------------------------------
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("headless");
        System.setProperty("webdriver.chrome.driver", "C:/Users/kalyan/Desktop/Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("http://www.facebook.com");
        driver.manage().window().maximize();
        driver.findElement(By.id("email")).sendKeys("jhs");
        driver.findElement(By.id("pass")).sendKeys("sjfh");
*/
/* TO TAKE SCREEN SHOT-----------------------------------------------------
        File srcfile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File dstfile = new File("C:/Users/kalyan/IdeaProjects/22032022/src/kk.png ");
        FileHandler.copy(srcfile, dstfile);
*/
// PROPERTIES FILE (TO GIVE INPUTS FROM ANOTHER FILE)-----------------------------------------
     /*      FileInputStream fileInputStream = new FileInputStream("C:/Users/kalyan/IdeaProjects/22032022/src/inputs.properties");
           Properties properties = new Properties();
           properties.load(fileInputStream);
        driver.get(properties.getProperty("url"));
        driver.manage().window().maximize();
        driver.findElement(By.id("email")).sendKeys(properties.getProperty("uname"));
        driver.findElement(By.id("pass")).sendKeys(properties.getProperty("pass"));
        driver.findElement(By.name("login")).click();

// Action class
//        System.setProperty("webdriver.chrome.driver", "C:/Users/kalyan/Desktop/Drivers/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://stackoverflow.com/questions/36099077/java-repeated-letter-check-in-string/36099830#36099830");
//        driver.manage().window().maximize();
//
//        WebElement element = driver.findElement(By.xpath("(//img[@alt='user avatar'])[6]"));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(element).build().perform();

//        EXPLISIT WAIT---------------------------------------------
//        driver.findElement(By.xpath("(//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu'])[1]")).click();
//        driver.findElement(By.xpath("//div[text()='Amritsar']")).click();
//
//        WebDriverWait wait = new WebDriverWait(driver, 50);/*

      */
//        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[text()='Ajmer']")))).click();


  /*     //IMPLISITLY WAIT-----------------------------
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.MICROSECONDS);
        WebElement ele = driver.findElement(By.xpath("//input[@class ='inputtext _55r1 _6luy']"));
        ele.sendKeys("kalyan");

        /*PAGE LOAD TIMEOUT-----------------------------------------------------
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MICROSECONDS)
        driver.get("https://www.facebook.com");
        driver.manage().window().maximize();
*/
// STALE ELEMENT EXCEPTION----------------------------
//        driver.navigate().refresh();
//        WebElement ele = driver.findElement(By.xpath("//input[@class ='inputtext _55r1 _6luy']"));
//ele.sendKeys("kalyan");

//    }
//}
/*
// EXCEPTION HANDELING i.e TRY CATCH----------------------------
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("sjhdg");
        try {
            driver.findElement(By.xpath("//input[@id='pas']")).sendKeys("djf");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("try not executed");
        }

}
*/
//        DIFFERENT OPERATIONS USING JAV SCRIPT EXECUTER---------------------------------
//        WebElement uname = driver.findElement(By.xpath("//input[@id='email']"));
//        WebElement send = driver.findElement(By.xpath("//input[@id='pass']"));
//
//        uname.sendKeys("jdwkj");
//        WebElement login = driver.findElement(By.xpath("//button[@value='1']"));
//        WebElement scrolldown = driver.findElement(By.xpath("//a[text()='Facebook Pay']"));
//        border(driver, uname);
////        click(driver, login);
////        sdown(driver);
////        scrolto(driver);
////        sview(driver,scrolldown);
////        refresh(driver);
////        senddata(driver, send);
//        newalert(driver,"fuckoff");
//    }
//    public static void border(WebDriver driver, WebElement uname) {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].style.border='3px solid red'", uname);
//
//    }
//
//    public static void click(WebDriver driver,WebElement login) {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();", login);
//    }
//    public static void sdown(WebDriver driver)
//    {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,1500)" );
//    }
//    public static void scrolto(WebDriver driver)
//    {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollTo(0, 1500)");
//    }
//
//    public static void sview(WebDriver driver, WebElement scrolldown)
//    {
//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        js.executeScript("arguments[0].scrollIntoView(true);",scrolldown);
//    }
//    public static void refresh(WebDriver driver)
//    {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("history.go(0)");
//    }
//    public static void senddata(WebDriver driver, WebElement send)
//    {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].value='hgdsgf'",send);
//    }
//    public static void newalert(WebDriver driver, String message)
//    {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("alert('"+message+"')");
//    }
//}

////   DRAG AND DROP FUNCTIONALITY-------------------------
//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
//        WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
//        WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
//
//        Actions action = new Actions(driver);
////        action.dragAndDrop(drag, drop).build().perform();
//action.moveToElement(drag).clickAndHold().moveToElement(drop).release().build().perform();
//  TO MOVE OVER MOUSE OVER ELEMENT----------------------------------
//        WebElement element = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
////WebElement cap = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
//        Actions action = new Actions(driver);
//        action.moveToElement(element).build().perform();

//TO CLICK INSIDE MOUSE OVER ELEMENTS--------------------------------------------
//        WebElement element = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
//        action.moveToElement(ele).click().build().perform();

//TO GIVE CAPITAL LETTERS IN SEARCH BOX----------------------------------
//        action.moveToElement(cap).click().build().perform();
//        action.moveToElement(cap).click().keyDown(Keys.SHIFT).sendKeys("jads").build().perform();
//        TO DOUBLE CLICK ON THE TEXT------------------------------------
//        action.moveToElement(cap).click().keyDown(Keys.SHIFT).sendKeys("jads").doubleClick().build().perform();
//
//        TO RIGHT CLICK ON THE ELEMENT-------------------------------

//        WebElement element = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
//        WebElement ele = driver.findElement(By.xpath("(//SPAN[@class='nav-text'])[5]"));

//OPEN ALL LINKS IN DIFFERENT TABS----------------------------------------------------------------
//        WebElement element = driver.findElement(By.xpath("(//section[@class='hsg-footer__nav-column hsg-footer__nav-column-left'])[1]"));
  /*      List<WebElement> list = driver.findElements(By.tagName("a"));
        System.out.println(list.size());
        for (int i = 1; i < list.size(); i++) {
            System.out.println(list.get(i).getText());
            System.out.println(list.get(i).getAttribute("href"));
            String open = Keys.chord(Keys.CONTROL, Keys.ENTER);
            list.get(i).sendKeys(open);
        }
        driver.close();
    }
}*/

////        DIFF B/W ALERT AND NORMAL POPUP
//         driver.findElement(By.xpath("//button[text()='OK']")).click();

//FILE UPLOAD SECOND TYPE --------------------------------
//        driver.findElement(By.xpath("//input[@id='imagesrc']")).sendKeys("C:\\Users\\kalyan\\Downloads\\XPath Selenium Selectors.docx"
//        driver.findElement(By.xpath("//input[@id='imagesrc']")).click();

//  **********click*****************************

/*      /* WebElement upload = driver.findElement(By.xpath("//input[@id='imagesrc']"));
        JavascriptExecutor button = ((JavascriptExecutor) driver);
        button.executeScript("arguments[0].click();", upload);

        Actions anctions = new Actions(driver);
        anctions.moveToElement(upload).click().build().perform();*/

//        FILE UPLOAD------------------------------------
  /*      StringSelection copy = new StringSelection("C:\\Users\\kalyan\\Downloads\\XPath Selenium Selectors.docx");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(copy,null);

//      paste the location of file,,,,
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);*/

////

////   FRAMES-----------------------------------+
      /*  driver.switchTo().frame("index of frame 0");
        driver.switchTo().frame("name or id of frame")
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='top.html']")));

        System.out.println(driver.findElement(By.xpath("(//body[@bgcolor='red']/h2)[1]")).getText());
        driver.switchTo().defaultContent();
        driver.switchTo().parentFrame();*/

////ALERTS--------------------------

//        driver.findElement(By.name("proceed")).click();
//        Thread.sleep(5000);
////        driver.switchTo().alert().dismiss();
////        driver.switchTo().alert().accept();
////        driver.switchTo().alert().sendKeys("54");
//        System.out.println(driver.switchTo().alert().getText());

//        driver.switchTo().defaultContent();


// TO IDENTIFY THE BROKEN LINKS--------------------------------+
//        WebElement broke = driver.findElement(By.cssSelector(".hsg-footer__nav-column.hsg-footer__nav-column-left"));
//        driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
   /*     List<WebElement> links = driver.findElements(By.tagName("a"));

        System.out.println(links.size());
        for (int i = 1; i < links.size(); i++) {

            String find = links.get(i).getAttribute("href");
            System.out.println(find);

            URL url = new URL(find);

            URLConnection conn = url.openConnection();

            HttpURLConnection connection = (HttpURLConnection) conn;
            connection.connect();

            if (connection.getResponseCode() == 200) {
                System.out.println("link ok");
            } else {
                System.err.println("not work" + connection.getResponseCode());
           }
            }
        }
    }
}
*/

////        IDENTIFY LINKS OF PIRTICULAR SECTION IN FOOTER-----------------------------

 /*       WebElement sec = driver.findElement(By.cssSelector(".hsg-footer__nav-column.hsg-footer__nav-column-left"));
        List<WebElement> tion = sec.findElements(By.tagName("a"));

        System.out.println(tion.size());
        for (int i =1; i<tion.size(); i++){
            System.out.println(tion.get(i).getText());
            System.out.println(tion.get(i).getAttribute("href"));
    }*/

////        IDENTIFY LINKS IN FOOTER----------------
/*        WebElement footer = driver.findElement(By.xpath("//div[@class='KxwPGc SSwjIe']"));
        List<WebElement> element = footer.findElements(By.tagName("a"));
        System.out.println(element.size());

        for (int i = 0; i < element.size(); i++) {
            System.out.println(element.get(i).getText());
            System.out.println(element.get(i).getAttribute("href"));
        }
    }
}*/
////      IDENTIFY LINKS IN WEBPAGE-------------------------
//        List<WebElement> open = driver.findElements(By.tagName("a"));
//        System.out.println(open.size());
//        for (int i = 1; i < open.size(); i++) {
//            System.out.println(open.get(i).getText());
//            System.out.println(open.get(i).getAttribute("href"));
//
//        }
//    }
//}


//        AUTOSUGGESTION DROPDOWN--------------
  /*      driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("testing");
        Thread.sleep(5000);
        List<WebElement> system = driver.findElements(By.xpath("//span[text()='testing']"));
        System.out.println(system.size());
        for (int i = 1; i < system.size(); i++) {
            System.out.println(system.get(i).getText());
            if (system.get(i).getText().equalsIgnoreCase("testing interview questions")) {
                system.get(i).click();
                break;
            }
        }
    }
    }*/
// DYNAMIC OR DEPENDANT DROPDOWN---------------
//        driver.findElement(By.xpath("(//INPUT[@CLASS='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu'])[1]")).click();
//        driver.findElement(By.xpath("(//div[@CLASS='css-76zvg2 r-cqee49 r-ubezar r-1kfrs79'])[1]")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("(//div[@class='css-76zvg2 r-cqee49 r-ubezar r-1kfrs79'])[1]")).click();
//    }
//}
//}

// STATIC DROPDOWN--------------------

//        WebElement staticdd = driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep'])[6]"));
//
//        Select select = new Select(staticdd);
//
//        select.selectByIndex(2);
//        select.selectByValue("IND");
//        select.selectByVisibleText("IND");


//XPATHS:-------------------
//        driver.findElement(By.xpath("//input[@id = 'email']")).sendKeys("eeee");
//        driver.findElement(By.xpath("//input[@id = 'email' and @data-testid = 'royal_email']")).sendKeys("4554e55");
//        driver.findElement(By.xpath("//input[@id = 'email' or @data-testid = 'royal_email']")).sendKeys("455455");
//        driver.findElement(By.xpath("//a[text() = 'Forgotten password?']")).click();
//        driver.findElement(By.xpath("//a[contains(text(),'Forg')]")).click();
//        driver.findElement(By.xpath("//input[contains(@name,'p')]")).sendKeys("dsds");
//        driver.findElement(By.xpath("//input[starts-with(@data-testid,'royal_p')]")).sendKeys("SFD");
//        driver.findElement(By.linkText("Create a Page")).click();
//        driver.findElement(By.partialLinkText("Create a Pa")).click();
//        driver.findElement(By.className("footer__item__link")).click();
//driver.close();
//        System.out.println(driver.findElement(By.name("email")).getAttribute("value"));
//driver.findElement(By.id("pass")).sendKeys("kalyan54");
//System.out.println(driver.findElement(By.id("email")).getAttribute("class"));
////System.out.println(driver.findElement(By.id("email")).getAttribute("value"));
//       WebElement uname = driver.findElement(By.id("email"));
//System.out.println(uname.getAttribute("value"));
//driver.close();

//LOCATATERS TO FIND UNIQUE WEB ELEMENTS:-------------------------

//        System.out.println(driver.getTitle());
//        System.out.println(driver.getCurrentUrl());
//    System.out.println(driver.getPageSource());
//        driver.navigate().to("http://www.amazon.com");
//        driver.navigate().back();
//        driver.navigate().forward();
//        driver.quit();
//driver.navigate().refresh();
//    }
//}
//    }
////}
