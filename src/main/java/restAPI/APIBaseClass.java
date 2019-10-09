package restAPI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class APIBaseClass {

	public  Properties prop;


	@BeforeTest
	@Parameters()

	public  void setupTest() throws IOException {
		
	
		prop = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/apiconfig.properties");
		prop.load(file);
		

	}
	
	@AfterTest
	public void teardown() {

	
	}
}
