package day2;
import static  io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class DiffrentWaysToCreatePostRequest {
	/* Different Ways To Create POST Request Body
	 1) Post request body using hashmap
	 2) Post request body using org.json
	 3) Post request body using POJO class
	 4) Post request body using external json file
	 */
	
	//1) Post Request Body Using HashMap
	//@Test(priority = 1)
     public void testPostUsingHashmap() {
    	 HashMap data = new HashMap();
    	 data.put("id", "5");
    	 data.put ("name","scott");
    	 data.put("location", "france");
    	 data.put("phone", "8736787");
    	 String courseArr[] = {"C","C++"};
    	 data.put("courses", courseArr);
    	 
    	 given()
    	 .contentType("application/json")
    	 .body(data)
    	 .when()
    	 .post("http://localhost:3000/students")
    	 .then()
    	 .statusCode(201)
    	 .body("id", equalTo("5"))
    	 .body("name",equalTo("scott"))
    	 .body("location",equalTo("france"))
    	 .body("phone",equalTo("8736787"))
    	 .body("courses[0]",equalTo("C"))
    	 .body("courses[1]",equalTo("C++"))
    	 .header("Content-Type", "application/json")
    	 .log().all();   	 
     }
	//@Test(priority = 2)
	public void deleteUser() {
		given()
		.when()
		.delete("http://localhost:3000/students/4")
		.then()
		.statusCode(200)
		.log().all();
	}
	
	
	
	//2)Post Request Body Using Org.JSON Library
	//Pre Request - Org.Json Library On POM>XML
//	@Test(priority = 1)
	public void testPostUsingJsonLibrary() {
		
		JSONObject data = new JSONObject();
		data.put("id","5");
		data.put("name","venkat");
		data.put("location", "t.kallupatti");
		data.put("phone", "876376734");
		String coursesARR[] = {"Java", "Selenium", "Rest_Assured"};
		data.put("courses", coursesARR);
		given()
		.contentType("application/json")
		.body(data.toString())
		.when()
		.post("http://localhost:3000/students")
		.then()
		.statusCode(201)
		.body("id", equalTo("5"))
		.body("name",equalTo("venkat"))
   	    .body("location",equalTo("t.kallupatti"))
   	    .body("phone",equalTo("876376734"))
   	    .body("courses[0]",equalTo("Java"))
   	    .body("courses[1]",equalTo("Selenium"))
   	    .body("courses[2]", equalTo("Rest_Assured"))
   	    .header("Content-Type", "application/json")
   	    .log().all();   	
	}
	
	//@Test(priority = 2)
		public void deleteUser2() {
			given()
			.when()
			.delete("http://localhost:3000/students/5")
			.then()
			.statusCode(200)
			.log().all();
		}
		
		
		
		//3)Post Request Body Using POJO Class
		//@Test(priority = 1)
		public void testPostUsingPOJO() {
			POJO_Post_Request data = new POJO_Post_Request();
			data.setId("6");
			data.setName("Sakthi");
			data.setLocation("Ambur");
			data.setPhone("8743678");
		    String coursesARR[] = {"C", "C++", "JAVA"};
		    data.setCourses(coursesARR);
			given()
			.contentType("application/json")
			.body(data)
			.when()
			.post("http://localhost:3000/students")
			.then()
			.statusCode(201)
			.body("id", equalTo("6"))
			.body("name",equalTo("Sakthi"))
	   	    .body("location",equalTo("Ambur"))
	   	    .body("phone",equalTo("8743678"))
	   	    .body("courses[0]",equalTo("C"))
	   	    .body("courses[1]",equalTo("C++"))
	   	    .body("courses[2]", equalTo("JAVA "))
	   	    .header("Content-Type", "application/json")
			.log().all();
		}
		//@Test(priority = 2)
		public void deleteUser3() {
			given()
			.when()
			.delete("http://localhost:3000/students/6")
			.then()
			.statusCode(200)
			.log().all();
		}
		
		@Test(priority = 1)
		//4) Post Request Using External JSON File	
		public void testPostUsingExternalFile() throws FileNotFoundException {
			File f = new File(".\\body.json");
			FileReader fr = new FileReader(f);
			JSONTokener jt = new JSONTokener(fr);
			JSONObject data = new JSONObject(jt);
			
			given() 
			.contentType("application/json")
			.body(data.toString())
			.when()
			.post("http://localhost:3000/students")
			.then()
			.statusCode(201 	)
			.body("id", equalTo("7"))
			.body("name",equalTo("venkat"))
	   	    .body("location",equalTo("madurai"))
	   	    .body("phone",equalTo("87434"))
	   	    .body("courses[0]",equalTo("JAVA"))
	   	    .body("courses[1]",equalTo("Selenium"))
	   	    .body("courses[2]", equalTo("RestAssured"))
	   	    .header("Content-Type", "application/json")
			.log().all();
		}
		@Test(priority = 2)
		public void deleteUser4() {
			given()
			.when()
			.delete("http://localhost:3000/students/7")
			.then()
			.statusCode(200)
			.log().all();
		}
		
}
