package day4;
import static  io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateUser {
	@Test
	void test_CreateUser(ITestContext context) {
		Faker faker = new Faker();
		JSONObject data = new JSONObject();
		data.put("name",faker.name().fullName());
		data.put("gender", "Male");
		data.put("email",faker.internet().emailAddress());
		data.put("status","inactive");
		String bearerToken ="b033eaab7a831d4a53acb5e66429cc0ee5b56788c0d729b3734b3d77dcaa04e8";
		int id = given()
		.headers("Authorization", "Bearer "+bearerToken)
		.contentType("application/json")
		.body(data.toString())
		.when()
		.post("https://gorest.co.in/public/v2/users")
		.jsonPath().getInt("id");
		context.setAttribute("user_id", id);
	
		
	}
	
		
}