package com.nttdata.page;

import org.openqa.selenium.By;

public class AgregarCarritoPage {
    //Localizadores de elementos
    public static By btnClothes = By.xpath("(//a[@class='dropdown-item'])[6]");
    public static By btnMen = By.xpath("(//li[@data-depth='0'])[1]/a");
    public static By imgProducto= By.xpath("(//img[@loading='lazy'])[2]");
    public static By btnAumentarProducto= By.xpath("//button[@class='btn btn-touchspin js-touchspin bootstrap-touchspin-up']");
    public static By btnAddCarrito =By.xpath("//button[@class='btn btn-primary add-to-cart']");
    public static By lblAddConfirmation =By.xpath("//*[@id='myModalLabel']");
    public static By lblSaldoPreCompra =By.xpath("//p[@class='product-price']");
    public static By lblCantidadPreCompra =By.xpath("(//strong)[3]");
    public static By lblTotalPreCompra =By.xpath(" (//div[@class='cart-content']/p/span)[4]");
}
