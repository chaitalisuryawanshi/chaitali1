package mytest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {
    public static void main(String[] args) throws FileNotFoundException {

        //File file1 = new File("C:\\Users\\chaitali.2105788\\IdeaProjects\\MindTree\\src\\main\\resources\\data\\TestData.Properties");
        File file = new File(System.getProperty("user.dir")+ "\\src\\main\\resources\\data\\TestData.Properties");

        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();

        //load properties file
        try {
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }

        WebDriver driver = new EdgeDriver();

        driver.get(prop.getProperty("URL"));
        driver.findElement(By.id("Email")).sendKeys(prop.getProperty("username"));
        driver.findElement(By.id("Passwd")).sendKeys(prop.getProperty("password"));
        driver.findElement(By.id("SignIn")).click();


        System.out.println("URL ::" + prop.getProperty("URL"));
        System.out.println("Username::" +prop.getProperty("username"));
        System.out.println("Password::" +prop.getProperty("password"));

    }
}
