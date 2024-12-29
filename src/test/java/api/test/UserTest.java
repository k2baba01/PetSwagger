package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import api.endpoints.UserEndPoint;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest {

	Faker f;
	User UserPayLoad;

	@BeforeClass
	void setupData() {

		f = new Faker();
		UserPayLoad = new User();

		UserPayLoad.setId(f.idNumber().hashCode());
		UserPayLoad.setUserName(f.name().username());
		UserPayLoad.setFristName(f.name().firstName());
		UserPayLoad.setLastName(f.name().lastName());
		UserPayLoad.setEmail(f.internet().emailAddress());
		UserPayLoad.setPassword(f.internet().password());
		UserPayLoad.setPhone(f.phoneNumber().toString());

	}
	
	@Test(priority =1)
	void testPostUser()
	{
		Response response =UserEndPoint.CreateUser(UserPayLoad);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("************------>"+this.UserPayLoad.getUserName());
	}
	@Test(priority =2)
	void testGetUser()
	{
		System.out.println(this.UserPayLoad.getUserName());
		Response response = UserEndPoint.GetUser(this.UserPayLoad.getUserName());
		//
		response.then().log().all();
		//Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test(priority=3)
	void testUpdateUser
	{
		Response response = 
	}

}
