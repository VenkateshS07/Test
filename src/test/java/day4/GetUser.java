package day4;
import static  io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetUser {
	@Test
	void test_GetUser(ITestContext context) {
		int id = (int) context.getAttribute("user_id");
		String bearerToken ="b033eaab7a831d4a53acb5e66429cc0ee5b56788c0d729b3734b3d77dcaa04e8";
		given()
		.headers("Authorization","Bearer "+bearerToken)
		.pathParam("id", id)
		.when()
		.get("https://gorest.co.in/public/v2/users/{id}")
		.then()
		.statusCode(200)
		.log().all();
	}

}
