package qa.automation.api.last;

import static com.jayway.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import qa.automation.api.old.methods.Process_REQ;

public class DEMO_REQ {
	
	String base_Url = "http://localhost:3000";
	POSTS p = new POSTS();
	Response resp;
	
	@BeforeClass
	public void start() throws IOException{
		new Process_REQ().start_server();
	}
	
	@Test(priority = 1)
	public void POST_REQ() {
		p.setId("2");
		p.setTitle("TestAutomator");
		p.setAuthor("Davinci");
		
		resp = given().
				body(p).
				when().
				contentType(ContentType.JSON).
				post(base_Url+"/posts");
		
		System.out.println(resp.getStatusCode());
		System.out.println("POST REQUEST RESPONSE");
		System.out.println("----------------------------------------");
		System.out.println(resp.asString());
		System.out.println("----------------------------------------");
	}
	
	@Test(priority = 2)
	public void view_post_changes(){
		new Process_REQ().open_browser();
	}
	
	@Test(priority = 3)
	public void PUT_REQ() {
		p.setId("22");
		p.setTitle("Updated TestAutomator");
		p.setAuthor("Updated Davinci");
		
		resp = given().
				body(p).
				when().
				contentType(ContentType.JSON).
				put(base_Url+"/posts/2");
		
		System.out.println(resp.getStatusCode());
		System.out.println("PUT REQUEST RESPONSE");
		System.out.println("----------------------------------------");
		System.out.println(resp.asString());
		System.out.println("----------------------------------------");
	}
	
	@Test(priority = 4)
	public void view_put_changes(){
		new Process_REQ().open_browser();
	}
	
	@Test(priority = 5)
	public void PATCH_REQ(){
		p.setTitle("Updated Title by PUT Request");
		
		resp = given().
				body(p).
				when().
				contentType(ContentType.JSON).
				patch(base_Url+"/posts/2");
		
		System.out.println(resp.getStatusCode());
		System.out.println("PATCH REQUEST RESPONSE");
		System.out.println("----------------------------------------");
		System.out.println(resp.asString());
		System.out.println("----------------------------------------");
	}
	
	@Test(priority = 6)
	public void view_patch_changes(){
		new Process_REQ().open_browser();
	}
	
	@Test(priority = 7)
	public void DELETE_REQ(){
		resp = given().
				when().
				delete(base_Url+"/posts/2");
		
		System.out.println(resp.getStatusCode());
		System.out.println("DELETE REQUEST RESPONSE");
		System.out.println("----------------------------------------");
		System.out.println(resp.asString());
		System.out.println("----------------------------------------");
				
	}
}
