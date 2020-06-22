package stepDefinitions.web;

import base.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

import org.openqa.selenium.WebDriver;
import runner.Hooks;


public class Feature1Steps extends TestBase {


    @Given("Estoy en la pagina principal y quito popup covid y acepto cookies")
    public void estoy_en_la_pagina_principal_y_quito_popup_covid_y_acepto_cookies() throws Exception {
        homePage.acceptCookiesPolicy();
        homePage.closeCovidPopup();
    }

    @When("Despliego el dropdown de hoteles destino y selecciono el que me interesa {string}")
    public void despliego_el_dropdown_de_hoteles_destino_y_selecciono_el_que_me_interesa(String hotel) throws Exception {
        homePage.extractHotelListFromDropDownAndSelectHotel(hotel);
    }

    @When("Despliego el calendario y selecciono las fechas")
    public void despliego_el_calendario_y_selecciono_las_fechas(DataTable dates) throws Exception {
        homePage.selectDateOneYearAhead(dates);

    }

    @When("Pulso el boton para reservar")
    public void pulso_el_boton_para_reservar() throws Exception {
        homePage.clickOnButtonToBook();
    }

    @When("Selecciono tipo de habitacion")
    public void selecciono_tipo_de_habitacion() throws Exception {
        roomTypePage.clickOnButtonToBookTheFirstType();
    }

    @Then("Coloco el raton sobre la cabecera para desplegar informacion")
    public void coloco_el_raton_sobre_la_cabecera_para_desplegar_informacion() throws Exception {
        checkOutPage.moveMouseOverHeader();

    }


}
