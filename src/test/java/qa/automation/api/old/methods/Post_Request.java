package qa.automation.api.old.methods;

import static com.jayway.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class Post_Request {
	
	@Test
	public void post(){
		Response resp=	
				given().
				body("  {\"name\":\"Davince\"} ").
						when().
						contentType(ContentType.JSON).
						post("http://localhost:3000/profile");

//				Response resp = given().
//						body("{\"id\": 54, \"title\": \"TestAutomator\", \"author\": \"simandi\"}").
//						when().
//						contentType(ContentType.JSON).
//						post("http://localhost:3000/posts");
		System.out.println(resp.asString());
	}
}
