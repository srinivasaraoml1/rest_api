package qa.automation.api.last;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.jayway.restassured.response.Response;

import qa.automation.api.GlobalData;
import static com.jayway.restassured.RestAssured.*;

public class GET_REQUEST {

	String baseUrl = "http://api.openweathermap.org/data/2.5/weather";

	@Test(priority = 1)
	public void GET_REQ() {
		Response p = given().
						get(baseUrl + "?q=London&appid=" + GlobalData.valid_api_key);
		
		System.out.println(p.getStatusCode());
		System.out.println(p.asString());
		Assert.assertEquals(p.getStatusCode(), GlobalData.success);
	}
	
	@Test(priority = 2)
	public void test_parameters() {
		Response resp = given().
						param("q", "London").
						param("appid", GlobalData.valid_api_key).
						when().
						get(baseUrl);
		
		System.out.println(resp.getStatusCode());
		System.out.println(resp.asString());
		Assert.assertEquals(resp.getStatusCode(), GlobalData.success);
	}
}
