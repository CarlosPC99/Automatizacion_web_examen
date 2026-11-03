package com.nttdata.steps;

import com.nttdata.page.FinalizarCompraPage;
import com.nttdata.page.LoginPage;
import org.openqa.selenium.WebDriver;

public class FinalizarCompraSteps {
    private WebDriver driver;


    //constructor
    public FinalizarCompraSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void btnPresionarFinalizar(){
        this.driver.findElement(FinalizarCompraPage.btnFinalizarCompra).click();
    }
}
