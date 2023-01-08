package functional;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TasksTest {

    public WebDriver acessarAplicacao(){
        System.setProperty("webdriver.chrome.driver", "D:\\CursoDevOps\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://localhost:8001/tasks");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    @Test
    public void deveSalvarTarefaComSuecesso(){
        WebDriver driver = acessarAplicacao();
        //clicar em add Todo
        driver.findElement(By.id("addTodo")).click();
        //escrever a descricao
        driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
        //escrever a data
        driver.findElement(By.id("dueDate")).sendKeys("10/10/2030");
        //clicar em salvar
        driver.findElement(By.id("saveButton")).click();
        //validar mensagem de sucesso
        String message = driver.findElement(By.id("message")).getText();
        Assert.assertEquals("Sucess!",message);
        //fechar o browser
        driver.quit();
    }
}
