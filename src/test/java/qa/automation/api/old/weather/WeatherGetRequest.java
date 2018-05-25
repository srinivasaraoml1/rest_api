package qa.automation.api.old.weather;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

import qa.automation.api.GlobalData;
import static com.jayway.restassured.RestAssured.*;

public class WeatherGetRequest {

	/*
	 * ALL GET REQUEST
	 */
	
	String baseurl_city = "http://api.openweathermap.org/data/2.5/weather";
	

	// Request by City with a valid api key
	// @Test(priority = 1)
	public void Request1() {
		Response p = get("http://api.openweathermap.org/data/2.5/weather?q=London&appid=" + GlobalData.valid_api_key);
		System.out.println(p.getStatusCode());
		System.out.println(p.asString());
		Assert.assertEquals(p.getStatusCode(), GlobalData.success);
	}

	// Request by City with a invalid api key
	// @Test(priority = 2)
	public void Request2() {
		Response p = get(
				"http://api.openweathermap.org/data/2.5/weather?q=London&appid=f7c2f" + GlobalData.invalid_api_key);
		System.out.println(p.getStatusCode());
		Assert.assertEquals(p.getStatusCode(), GlobalData.authorization_required);
	}

	// How to use parameters with REST Assured
	// @Test
	public void test_parameters() {
		Response resp = given().param("q", "London").param("appid", GlobalData.valid_api_key).when().get(baseurl_city);
		System.out.println(resp.getStatusCode());
		System.out.println(resp.asString());
		Assert.assertEquals(resp.getStatusCode(), GlobalData.success);
	}

	// @Test
	public void single_line_Test() {
		given().param("q", "London").param("appid", GlobalData.valid_api_key).when().get(baseurl_city).then()
				.assertThat().statusCode(200);
	}

	// @Test
	public void line_Test() {
		Response resp = given().param("q", "London").param("appid", GlobalData.valid_api_key).when().get(baseurl_city);
		System.out.println(resp.asString());
	}

	@Test
	public void City_id() {
		Response resp = given().param("id", 2172797).param("appid", GlobalData.valid_api_key).when().get(baseurl_city);
		Assert.assertEquals(resp.getStatusCode(), GlobalData.success);
		System.out.println(resp.getStatusCode());
		System.out.println(resp.asString());
		//Response resp = when().get("api.openweathermap.org/data/2.5/weather?id=2172797&appid=f7c2f9a273e120841ee074063fd90871")
	}
}
