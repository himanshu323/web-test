package restAPI;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringWriter;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.prefs.BackingStoreException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.output.WriterOutputStream;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.google.common.io.Files;
import com.google.gson.JsonArray;
import com.hellofresh.basemanager.ExtentListeners;
import com.hellofresh.commonutils.CommonUtils;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

/**
 * 
 * @author harora
 *
 */

public class GetAPI {

	public static Response getCountryByAlphaCode(RequestSpecification reqSpec, ResponseSpecification respSpec) throws IOException {

		ExtentListeners.testReport.get().info(MarkupHelper.createLabel("Request:", ExtentColor.CYAN));

		CommonUtils.enableLogging("GetCountryByAlphaCode");
		
		Response rsp = given().log().all().spec(reqSpec).when().get(ResourcesAPI.getCountryByAlphaCode()).then().spec(respSpec)
					.extract().response();
		;

		CommonUtils.writeLog("GetCountryByAlphaCode");
		
		ExtentListeners.testReport.get().info(MarkupHelper.createLabel("Response:", ExtentColor.CYAN));
		
		ExtentListeners.testReport.get().info(MarkupHelper.createCodeBlock(rsp.asString()));

		return rsp;

	}
	

	public static Response getAllCountriesAPIResponse(ResponseSpecification respSpec) throws IOException {

	
		ExtentListeners.testReport.get().info(MarkupHelper.createLabel("Request:", ExtentColor.CYAN));
		CommonUtils.enableLogging("GetAllCountries");

		Response rsp = given().log().all().when().get(ResourcesAPI.getAllCountries()).then().spec(respSpec)
				.extract().response();

		CommonUtils.writeLog("GetAllCountries");
		
		ExtentListeners.testReport.get().info(MarkupHelper.createLabel("Response:", ExtentColor.CYAN));
		
		ExtentListeners.testReport.get().info(MarkupHelper.createCodeBlock(rsp.asString()));

		return rsp;

	}

	public static Response getCountryByNameWithInvalidData(ResponseSpecification respSpec) throws IOException {

		ExtentListeners.testReport.get().info(MarkupHelper.createLabel("Request:", ExtentColor.CYAN));

		CommonUtils.enableLogging("GetCountryByNameWithInvalidData");
		
		Response rsp = given().log().all().when().get(ResourcesAPI.getCountryByInvalidName()).then().spec(respSpec)
				.extract().response();
		;

		CommonUtils.writeLog("GetCountryByNameWithInvalidData");
		
		ExtentListeners.testReport.get().info(MarkupHelper.createLabel("Response:", ExtentColor.CYAN));

		ExtentListeners.testReport.get().info(MarkupHelper.createCodeBlock(rsp.asString()));
		return rsp;
	}
}