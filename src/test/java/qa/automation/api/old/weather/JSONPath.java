package qa.automation.api.old.weather;

import static com.jayway.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

import qa.automation.api.GlobalData;

public class JSONPath {

	// http://api.openweathermap.org/data/2.5/weather?id=1264527&appid=f7c2f9a273e120841ee074063fd90871
	String baseurl_city = "http://api.openweathermap.org/data/2.5/weather";

	// @Test
	public void f() {
		Response resp = given().param("id", 2172797).param("appid", GlobalData.valid_api_key).when().get(baseurl_city);
		Assert.assertEquals(resp.getStatusCode(), GlobalData.success);

		JsonPath x = new JsonPath(resp.asString());

		System.out.println(x.getString("coord"));
		System.out.println(resp.asString());
	}

	//@Test
	public void path() {
		Response resp = given().param("id", 2172797).param("appid", GlobalData.valid_api_key).when().get(baseurl_city);
		List<String> weather = resp.then().contentType(ContentType.JSON).extract().path("weather.description");

		float latitude = resp.then().contentType(ContentType.JSON).extract().path("coord.lat");

		float longitude = resp.then().contentType(ContentType.JSON).extract().path("coord.lon");

		System.out.println(latitude + ", " + longitude);
		System.out.println(weather.toString());
		String received_weather = given().param("lat", latitude).param("lon", longitude)
				.param("appid", GlobalData.valid_api_key).when().get(baseurl_city).then().contentType(ContentType.JSON)
				.extract().path("weather.description").toString();
		Assert.assertTrue(weather.contains(received_weather.substring(1, received_weather.length() - 1)));
	}

	
	@Test
	public void test(){
		
	}
	
}
