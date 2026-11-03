package com.nttdata.steps;

import com.nttdata.page.AgregarCarritoPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.nttdata.funtions.FuncionManager.esperaImplicita;

public class AgregarAlCarritoSteps {
    private WebDriver driver;
    //constructor
    public AgregarAlCarritoSteps(WebDriver driver) {
        this.driver = driver;
    }
    public void btnClothes(){
        esperaImplicita();
        this.driver.findElement(AgregarCarritoPage.btnClothes).click();
    }
    public void btnMen(){
        this.driver.findElement(AgregarCarritoPage.btnMen).click();
    }

    public void imgProduct(){
        this.driver.findElement(AgregarCarritoPage.imgProducto).click();
    }
    public void aumentarProductos(){
        this.driver.findElement(AgregarCarritoPage.btnAumentarProducto).click();
    }
    public void btnAddCarrito(){
        this.driver.findElement(AgregarCarritoPage.btnAddCarrito).click();
    }

    public void ingresarSeleccionClothes() {
        btnClothes();
        esperaImplicita();
        btnMen();
        esperaImplicita();
    }

    public void agregarAlCarrito() {
        esperaImplicita();
        WebElement elemento = driver.findElement(By.className("thumbnail-top"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", elemento);
        imgProduct();
        esperaImplicita();
        elemento = driver.findElement(By.xpath("(//span[@class='control-label'])[3]"));
        js.executeScript("arguments[0].scrollIntoView(true);", elemento);
        aumentarProductos();
        btnAddCarrito();
    }
    public void validarLblAddCheck(){
        esperaImplicita();
        WebElement elemento = driver.findElement(AgregarCarritoPage.lblAddConfirmation);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String texto = (String) js.executeScript(
                "return arguments[0].lastChild.textContent.trim();", elemento
        );
        System.out.print("el texto es: "+ texto);
        if (!texto.contains("correctamente"))  {
            System.out.println("\nERROR EN VALIDACION");
            throw new AssertionError("ERROR: El mensaje de confirmación no es correcto");
        } else {
            System.out.println("CORRECTO");
        }

    }
    public void validarLblAddMonto() {
        esperaImplicita();
        String precio  = driver.findElement(AgregarCarritoPage.lblSaldoPreCompra).getText();
        String cantidad  = driver.findElement(AgregarCarritoPage.lblCantidadPreCompra).getText();
        String total  = driver.findElement(AgregarCarritoPage.lblTotalPreCompra).getText();

        String precioNumerico = precio.replace(" PEN", "").replace(",", ".");
        String cantidadNumerica = cantidad;
        String totalNumerico = total.replace(" PEN", "").replace(",", ".");

        double precioFinal = Double.parseDouble(precioNumerico);
        int cantidadFinal = Integer.parseInt(cantidadNumerica);
        double totalFinal = Double.parseDouble(totalNumerico);

        if (precioFinal * cantidadFinal != totalFinal)  {
            System.out.println(precioFinal +" " + cantidadFinal + " "+totalFinal);
            throw new AssertionError("\nERROR EN VALIDACION - el monto no era el mismo");
        } else {
            System.out.println("CORRECTO el total coincie: "+ totalFinal + " / "+ (precioFinal * cantidadFinal));
        }

    }


}
