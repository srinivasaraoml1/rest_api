package qa.automation.api.old.weather;

import static com.jayway.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import qa.automation.api.GlobalData;

public class TransferAPIResponse {

	// http://api.openweathermap.org/data/2.5/weather?id=1264527&appid=f7c2f9a273e120841ee074063fd90871
	String baseurl_city = "http://api.openweathermap.org/data/2.5/weather";
	// api.openweathermap.org/data/2.5/weather?lat=35&lon=139
	
	@Test
	public void f() {
		Response resp = given().
				param("id", 2172797).
				param("appid", GlobalData.valid_api_key).
				when().
				get(baseurl_city);
		String lat = resp.
				then().
				contentType(ContentType.JSON).
				extract().
				path("");
	}
}
