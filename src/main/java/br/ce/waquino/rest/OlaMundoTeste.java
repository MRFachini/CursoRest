package br.ce.waquino.rest;

import org.junit.Test;

import static io.restassured.RestAssured.*;

import org.junit.Assert;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class OlaMundoTeste {

	@Test
	public  void  testOlaMundo () {
		Response response = RestAssured.request(Method.GET,"https://restapi.wcaquino.me/ola");
		Assert.assertTrue(response.getBody().asString().equals("Ola Mundo!"));
		Assert.assertTrue(response.statusCode() == 200);
		Assert.assertTrue("O status code deveria ser 200",response.statusCode() == 200);
		Assert.assertEquals(200, response.statusCode());
		
		
		ValidatableResponse validacao = response.then();
		validacao.statusCode(200);
	}
	
	@Test
	public void devoConhecerOutrasFormasRestAssured() {
		Response response = RestAssured.request(Method.GET,"https://restapi.wcaquino.me/ola");
		ValidatableResponse validacao = response.then();
		validacao.statusCode(200);
		
		get("https://restapi.wcaquino.me/ola").then().statusCode(200);
		
		given()
		.when()
			.get("https://restapi.wcaquino.me/ola")
		.then()
			.assertThat()
			.statusCode(200);
		
		
	}
}
