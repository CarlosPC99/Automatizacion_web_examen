package com.nttdata.stepsdefinitions;

import com.nttdata.page.FinalizarCompraPage;
import com.nttdata.steps.AgregarAlCarritoSteps;
import com.nttdata.steps.FinalizarCompraSteps;
import com.nttdata.steps.LoginSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import static com.nttdata.funtions.FuncionManager.*;

public class LoginStepsDef {
    private WebDriver driver;

    @Dado("que estoy en la página de la tienda")
    public void que_estoy_en_la_pagina_de_la_tienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/es/");
        screenShot();

    }

    @Y("me logueo con mi usuario: {string} y clave: {string}")
    public void me_logueo_con_mi_usuario_y_clave(String user, String password) {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.ingresoUsuarioYClave(user,password);
        screenShot();
    }


    @Cuando("navego a la categoria Clothes y subcategoria Men")
    public void navego_a_la_categoria_clothes_y_subcategoria_men(){
        AgregarAlCarritoSteps agregarAlCarritoSteps = new AgregarAlCarritoSteps(driver);
        agregarAlCarritoSteps.ingresarSeleccionClothes();
        screenShot();
    }

    @Y("agrego 2 unidades del primer producto al carrito")
    public void agrego_dos_unidades_del_primer_producto_al_carrito(){
        AgregarAlCarritoSteps agregarAlCarritoSteps = new AgregarAlCarritoSteps(driver);
        agregarAlCarritoSteps.agregarAlCarrito();
        screenShot();
    }
    @Entonces("valido en el popup la confirmación del producto agregado")
    public void valido_en_el_popup_la_confirmacion_del_producto_agregado() {
        AgregarAlCarritoSteps agregarAlCarritoSteps = new AgregarAlCarritoSteps(driver);
        agregarAlCarritoSteps.validarLblAddCheck();
        screenShot();
    }
    @Y("valido en el popup que el monto total sea calculado correctamente")
    public void valido_en_el_popup_que_el_monto_total_sea_calculado_correctamente(){
        AgregarAlCarritoSteps agregarAlCarritoSteps = new AgregarAlCarritoSteps(driver);
        agregarAlCarritoSteps.validarLblAddMonto();
        screenShot();
    }
    @Cuando("finalizo la compra")
    public void finalizo_la_compra(){
        FinalizarCompraSteps finalizarCompraSteps = new FinalizarCompraSteps(driver);
        finalizarCompraSteps.btnPresionarFinalizar();
        screenShot();
    }

//    @Entonces("todo ok")
//    public void todo_ok() {
//        System.out.print("TODO OK :) \n");
//    }

}
