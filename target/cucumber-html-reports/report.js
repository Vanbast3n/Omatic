$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/web/Feature1.feature");
formatter.feature({
  "name": "Demo1",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Scenario1",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Estoy en la pagina principal y quito popup covid y acepto cookies",
  "keyword": "Given "
});
formatter.step({
  "name": "Despliego el dropdown de hoteles destino y selecciono el que me interesa \"\u003chotelSelected\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "Despliego el calendario y selecciono las fechas",
  "keyword": "And ",
  "rows": [
    {
      "cells": [
        "monthsAhead",
        "checkIn",
        "checkOut"
      ]
    },
    {
      "cells": [
        "12",
        "14",
        "17"
      ]
    }
  ]
});
formatter.step({
  "name": "Pulso el boton para reservar",
  "keyword": "And "
});
formatter.step({
  "name": "Selecciono tipo de habitacion",
  "keyword": "And "
});
formatter.step({
  "name": "Coloco el raton sobre la cabecera para desplegar informacion",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "hotelSelected"
      ]
    },
    {
      "cells": [
        "Hesperia Barcelona Ramblas"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Scenario1",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Estoy en la pagina principal y quito popup covid y acepto cookies",
  "keyword": "Given "
});
formatter.match({
  "location": "Feature1Steps.estoy_en_la_pagina_principal_y_quito_popup_covid_y_acepto_cookies()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Despliego el dropdown de hoteles destino y selecciono el que me interesa \"Hesperia Barcelona Ramblas\"",
  "keyword": "When "
});
formatter.match({
  "location": "Feature1Steps.despliego_el_dropdown_de_hoteles_destino_y_selecciono_el_que_me_interesa(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Despliego el calendario y selecciono las fechas",
  "rows": [
    {
      "cells": [
        "monthsAhead",
        "checkIn",
        "checkOut"
      ]
    },
    {
      "cells": [
        "12",
        "14",
        "17"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "Feature1Steps.despliego_el_calendario_y_selecciono_las_fechas(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Pulso el boton para reservar",
  "keyword": "And "
});
formatter.match({
  "location": "Feature1Steps.pulso_el_boton_para_reservar()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Selecciono tipo de habitacion",
  "keyword": "And "
});
formatter.match({
  "location": "Feature1Steps.selecciono_tipo_de_habitacion()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Coloco el raton sobre la cabecera para desplegar informacion",
  "keyword": "Then "
});
formatter.match({
  "location": "Feature1Steps.coloco_el_raton_sobre_la_cabecera_para_desplegar_informacion()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});