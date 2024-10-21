package day1;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

import static  io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class httpRequest {
	int id;
	/*@Test
	public void getUser() {
         given()
	    .when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.body("page",equalTo(2))
		.log().all();
		
	}*/
	@Test(priority = 1)
	public void createUser() {
		HashMap data = new HashMap();
		data.put("name","Venkatesh");
		data.put("job","software tester");
		id = given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
		//.then()
		//.statusCode(201)
		//.log().all();
		
	}
	@Test(priority = 2, dependsOnMethods = {"createUser"})
	public void updateUser() {
		HashMap dataUpdate = new HashMap();
		dataUpdate.put("name", "venkatesh.s");
		dataUpdate.put("job", "actor");
	    given()
	    	.contentType("application/json")
	    	.body(dataUpdate)
	    	
	    .when()
	    .put("https://reqres.in/api/users/"+id)
	   
	    .then()
	    .statusCode(200)
	    .log().all();	}
    @Test(priority = 3)
	public void deleteUser() {
		given()
		
		.when()
		.delete("https://reqres.in/api/user/"+id)
		
		.then()
		.statusCode(204)
		.log().all();
	   
	}
}

