package qa.automation.utils;

import java.util.HashMap;
import java.util.Set;

import static com.jayway.restassured.RestAssured.given;

import javax.annotation.meta.When;

import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jayway.restassured.response.Response;

public class Utils {

	public static HashMap<String, String> json_to_hashmap(String json_string) {
		HashMap<String, String> map = new Gson().fromJson(json_string, new TypeToken<HashMap<String, String>>() {
		}.getType());
		return map;
	}

	 public static Object response(HashMap<Object, Object> map) {
	 Object params = "";
	 Set data = map.keySet();
	 for(Object d : data){
	 params += ".param(\""+d+"\", \""+map.get(d)+"\")";
	 }
	 Response resp;
	
	 return params;
	 }
	 
	 
//	public Response resp(HashMap<Object, Object> map){
//		Response response;
//		
//		for(Object d : map.keySet()){
//			response = given().param(d, map.get(d));
//		}
//		
//		return response;
//	}
}
