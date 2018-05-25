package qa.automation.api.old.posts;

import static com.jayway.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.google.gson.JsonObject;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import net.minidev.json.JSONObject;

public class REQ {

	@Test(priority = 1)
	public void POST_REQ() {
//		JSONObject data = new JSONObject();
//		data.put("id", "007");
//		data.put("title", "Samaron");
//		data.put("author", "Assistant");
		
		Posts p = new Posts();
		p.setId("77");
		p.setAuthor("Samuel");
		p.setTitle("Object_Post_Req");
		
		Response resp = given().
						body(p).
						when().
						content(ContentType.JSON).
						post("http://localhost:3000/posts");
		System.out.println("Response is: " + resp.getStatusCode());
		System.out.println(resp.asString());
	}
	
	//@Test(priority = 2)
	public void PUT_REQ(){
		Posts p = new Posts();
		p.setId("4");
		p.setAuthor("Updated Samuel Author Name");
		p.setTitle("updated Samuel Title Name");
		
		Response resp = given().
						contentType(ContentType.JSON).
						body(p).
						put("http://localhost:3000/posts");
		System.out.println(resp.getStatusCode());
		System.out.println(resp.asString());
	}
}
