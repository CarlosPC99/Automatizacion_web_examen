#language: es
@testfeature
Característica: Validacion
  Yo, como usuario
  Quiero, tener una opción para iniciar sesión
  Para validar el precio de un producto


  @test
  Escenario: Validación del precio de un producto
    Dado que estoy en la página de la tienda
    Y me logueo con mi usuario: "prueba_1@gmail.com" y clave: "Prueba12345678"
    Cuando navego a la categoria Clothes y subcategoria Men
    Y agrego 2 unidades del primer producto al carrito
    Entonces valido en el popup la confirmación del producto agregado
    Y valido en el popup que el monto total sea calculado correctamente
