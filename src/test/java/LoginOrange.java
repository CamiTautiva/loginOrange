import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class LoginOrange {

    public static void main(String[] args) throws InterruptedException {


        //Indicar la ubicacion de tu controlador de selenium
        System.setProperty("webdriver.chrome.driver", "D:\\Desarrollo Camilo\\Lista\\loginOrange\\src\\test\\resources\\chromedriver.exe");

        //Inicializa el controlador
        WebDriver driver = new ChromeDriver();

        //Ruta de almacenamiento de evidencias
        String screenShotDir ="D:\\Desarrollo Camilo\\Lista\\loginOrange\\src\\test\\resources\\Evidencias\\";

        //Abre URL en el navegador
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //Maximizar el navegador
        driver.manage().window().maximize();

        //Realiza acciones y toma captura de pantalla
        takeScreenShot(driver, screenShotDir, "screenshot1.png" );

        //Espera un momento para que puedas ver que se ha abierto el navegador

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //forma de buscar y almacenar los elementos web de una pagina
        //Paso 1 ingresar Usuario
        WebElement txtUsuario = driver.findElement(By.name("username"));
        //WebElement btonBuscar = driver.findElement(By.className("nav-icon-search"));
        //txtBuscar.click();
        takeScreenShot(driver, screenShotDir, "screenshot2.png" );
        //Thread.sleep(1000);

        //Paso 2. Ingresar texto
        txtUsuario.sendKeys("Admin");
        takeScreenShot(driver, screenShotDir, "screenshot3.png" );
        //Thread.sleep(1000);

        //Ingreso Contraseña
        WebElement txtContrasena = driver.findElement(By.name("password"));
        takeScreenShot(driver, screenShotDir, "screenshot2.png" );
        //Thread.sleep(1000);

        txtContrasena.sendKeys("admin123");
        takeScreenShot(driver, screenShotDir, "screenshot3.png" );
        //Thread.sleep(1000);

        //Doy clic en el boton Login
        WebElement btonLogin = driver.findElement(By.className("orangehrm-login-button"));
        takeScreenShot(driver, screenShotDir, "screenshot2.png" );
        //Thread.sleep(1000);

        btonLogin.click();
        takeScreenShot(driver, screenShotDir, "screenshot4.png" );
        //Thread.sleep(1000);

        //Selecciono la opcion Recruitment
        WebElement recruitmentMenu = driver.findElement(By.xpath("//nav//span[text()='Recruitment']"));
        takeScreenShot(driver, screenShotDir, "screenshot.png" );


        recruitmentMenu.click();
        //Thread.sleep(1000);

        //clic en Add
        WebElement addButton = driver.findElement(By.cssSelector("button.oxd-button.oxd-button--secondary i.oxd-icon.bi-plus"));
        takeScreenShot(driver, screenShotDir, "screenshot.png" );

        addButton.click();




        driver.quit();

    }


    public static void takeScreenShot(WebDriver driver, String screenshotDir, String fileName) {
        //Tomar Captura de pantalla
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //Define la ruta de almacenamiento
        String destinationPath = screenshotDir + fileName;

        //Copear el archivo en la ubicacion deseada
        try{
            FileUtils.copyFile(screenshotFile, new File(destinationPath));
            System.out.println("Captura de pantalla guardada con exito");
        } catch (IOException e){
            System.out.println("Ha ocurrido un error al guardar la captura de pantalla");
            throw new RuntimeException(e);
        }
    }
}