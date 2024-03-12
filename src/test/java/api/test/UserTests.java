package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
	
	Faker faker;
	User userpayload;
	public Logger logger;

	@BeforeClass
	public void setUpData()
	{
		faker = new Faker();
		userpayload=new User();
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5, 10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		
		//logs
		
		logger = LogManager.getLogger(this.getClass());
		
	}
	@Test(priority=1)
	
	public void testCreateUser()
	{
		logger.info("*******Creating User******");
     Response response =UserEndPoints.CreateUser(userpayload);
     response.then().log().all();
     Assert.assertEquals(response.getStatusCode(), 200);
     logger.info("*******User is created******");
}
	@Test(priority=2)
	public void testGetUser()
	{
		logger.info("*******Get User******");
     Response response =UserEndPoints.GetUser(this.userpayload.getUsername());
     response.then().log().all();
     Assert.assertEquals(response.getStatusCode(), 200);
     logger.info("******* User is retrived******");
}
	@Test(priority=3)
	public void testUpdateUser()
	{
		logger.info("*******Upadate User******");
		userpayload.setLastName(faker.name().lastName());
		userpayload.setPhone(faker.phoneNumber().cellPhone());
     Response response =UserEndPoints.UpdateUser(this.userpayload.getUsername(), userpayload);
     response.then().log().all();
     Assert.assertEquals(response.getStatusCode(), 200);
     logger.info("******* User is updated******");
     //Check the data after update
     
     Response responseAfterUpdate =UserEndPoints.GetUser(this.userpayload.getUsername());
     Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);

}
	@Test(priority=4)
	public void testDeleteUser()
	{
		logger.info("*******Delete User******");
     Response response =UserEndPoints.DeleteUser(this.userpayload.getUsername());
     response.then().log().all();
     Assert.assertEquals(response.getStatusCode(), 200);
     logger.info("******* User is deleted******");
	}
	
}
