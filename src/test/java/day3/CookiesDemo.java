   package day3;
   import static  io.restassured.RestAssured.*;
   import static io.restassured.matcher.RestAssuredMatchers.*;
   import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookiesDemo {
	
	//@Test(priority = 1)
    public void testCookies() {
		given()
		.when()
		.get("https://www.google.com/")
		.then()
		.cookie("AEC","AQTF6Hxur4OiZ-Np6qF52_LEP4Na0o53bjNFg0EDIn-kipPH8-txFLSGnA");
    }
	
	@Test
	public void getCookiesInfo() {
		Response res = given()
		.when()
		.get("https://www.google.com/");
		//String Cookie_Value = res.getCookie("AEC");
		//System.out.println("The Value Of Cookie is" +Cookie_Value);
		Map<String,String> map = res.getCookies();
		for(String k:map.keySet()) {
	          String cookie_value = res.getCookie(k);
	          System.out.println(k+"    " +cookie_value);
		}
		
	
    }
}
