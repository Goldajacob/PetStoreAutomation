package api.endpoints;
import static io.restassured.RestAssured.given;
import io.restassured.response.*;

import api.payload.User;
public class UserEndPoints {
	public static Response  CreateUser(User payload)
	{
    Response response = given()
     .contentType("application/json")
     .accept("application/json")
     .body(payload)
     
     .when()
     .post(Routes.create_url);
     
     return response;
}
	//GET USERS
	public static Response  GetUser(String userName)
	{
    Response response = given()
     .contentType("application/json")
     .accept("application/json")
     .pathParam("username",userName)
     
     
     .when()
     .get(Routes.get_url);
     
     return response;
}
	//UPDATE USER
	public static Response  UpdateUser(String userName,User payload)
	{
    Response response = given()
     .contentType("application/json")
     .accept("application/json")
     .pathParam("username", userName)
     .body(payload)
     
     .when()
     .put(Routes.update_url);
     
     return response;
}
	
	//DELETE USER
	public static Response  DeleteUser(String userName)
	{
    Response response = given()
     .contentType("application/json")
     .accept("application/json")
     .pathParam("username",userName)
     
     
     .when()
     .delete(Routes.delete_url);
     
     return response;
}

}