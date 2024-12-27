package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class UserEndPoint {

	public static Response CreateUser(User payload) {
		Response response = given()
					.accept(ContentType.JSON)
					.contentType(ContentType.JSON)
					.body(payload)
				.when()
					.post(Routes.PostUrl);
		return response;

	}

	public static Response GetUser(String userName) {
		Response response = given().pathParam("username", userName).when().get(Routes.GetUrl);
		return response;
	}

	public static Response updateUser(String userName, User payload) {
		Response response = given().pathParam("username", userName).body(payload).accept("application.json")
				.contentType("ContentType.json").when().put(Routes.UpdateUrl);
		return response;
	}

	public static Response DeleteUser(String userName) {
		Response response = given().pathParam("username", userName).when().delete(Routes.DeleteUrl);
		return response;
	}
}
