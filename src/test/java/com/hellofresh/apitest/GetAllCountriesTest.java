package com.hellofresh.apitest;

import java.io.IOException;

import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import restAPI.APIBaseClass;
import restAPI.APIValidations;
import restAPI.GetAPI;




public class GetAllCountriesTest extends APIBaseClass {


	 ResponseSpecification respSpec;
	
	 Response getResponse;
	
	
	
	@Test()
	public void getAllCountriesAndValidate() throws IOException{
		
		
		APIValidations.intialize(prop.getProperty("getCountriesBaseURI"), prop.getProperty("getCountriesBasePath"));
		
		respSpec= APIValidations.setResponseValidationForCountries("US","DE","GB");
		
		getResponse = GetAPI.getAllCountriesAPIResponse(respSpec);
	
		
	}
	
	

}
