# language: es
# ------------------------------------------------------------------------------
@PayRetailers
Característica: HOM

  Antecedentes: Acceder al home de pay retailers
    Dado el navegador abierto, el usuario se dirige a la aplicación PayRetailers
    
  @HOM01
  Escenario: PR-0001-HOM.01.Comprobar acceso a empezar ahora
    Entonces click en empezar ahora
    Y comprobar que se ha accedido correctamente a Empezar ahora

  @HOM02
  Escenario: PR-0002-HOM.01.Comprobar acceso a Nuestra solucion
    Entonces click en Nuestra Solución
    Y comprobar que se ha accedido correctamente a Nuestra Solución
