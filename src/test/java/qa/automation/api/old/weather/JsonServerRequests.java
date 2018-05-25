package qa.automation.api.old.weather;

import static com.jayway.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class JsonServerRequests {

	// GET Request
	//@Test
	public void f() {
		Response resp = given().when().get("http://localhost:3000/posts");
		System.out.println(resp.asString());
	}

	// POST Request
	@Test
	public void f2(){
		Response resp = given().
		body("{\"id\": 68, \"title\": \"TestAutomator\", \"author\": \"sangameswari\"}").
		when().
		contentType(ContentType.JSON).
		post("http://localhost:3000/posts");
		
		System.out.println(resp.asString());
	}
	
	
}
