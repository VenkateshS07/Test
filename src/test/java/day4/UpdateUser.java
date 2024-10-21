package day4;
import static  io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class UpdateUser {
	@Test
	void test_Updateuser(ITestContext context) {
        int id = (int) context.getAttribute("user_id");
		Faker faker = new Faker();
		JSONObject data = new JSONObject();
		data.put("name",faker.name().fullName());
		data.put("gender", "Female");
		data.put("email",faker.internet().emailAddress());
		data.put("status","active");
		String bearerToken ="b033eaab7a831d4a53acb5e66429cc0ee5b56788c0d729b3734b3d77dcaa04e8";
		 given()
		.headers("Authorization", "Bearer "+bearerToken)
		.contentType("application/json")
		.pathParam("id", id)
		.body(data.toString())
		.when()
		.put("https://gorest.co.in/public/v2/users/{id}")
		.then()
		.statusCode(200)
		.log().all();
		
	}

}
