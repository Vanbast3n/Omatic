Feature: Demo1


  Scenario Outline: Scenario1
    Given Estoy en la pagina principal y quito popup covid y acepto cookies
    When  Despliego el dropdown de hoteles destino y selecciono el que me interesa "<hotelSelected>"
    And   Despliego el calendario y selecciono las fechas
          |monthsAhead|checkIn|checkOut |
          |12         |14     |17       |
    And   Pulso el boton para reservar
    And   Selecciono tipo de habitacion
    Then  Coloco el raton sobre la cabecera para desplegar informacion
    Examples:
    |hotelSelected                  |
    |Hesperia Barcelona Ramblas     |




