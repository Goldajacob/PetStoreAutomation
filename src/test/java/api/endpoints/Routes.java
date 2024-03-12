package api.endpoints;
/* Create User (POST) : https://petstore.swagger.io/v2/user/createWithArray
Get User(Get) :https://petstore.swagger.io/v2/user/{username}
UPDATE User (Put) :https://petstore.swagger.io/v2/user/{username}
Delete User (Delete) : https://petstore.swagger.io/v2/user/{username}
*/

public class Routes {

	public static String base_url = "https://petstore.swagger.io/v2/";
	//User Model
	public static String create_url=base_url+"user/createWithArray";
	public static String get_url=base_url+"user/{username}";

	public static String update_url=base_url+"user/{username}";

	public static String delete_url=base_url+"user/{username}";

}
