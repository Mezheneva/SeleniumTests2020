
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RestAssuredTest {

    @Test
    public void getSingleUserRequest(){
        when()
                .get("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .body("data.id", equalTo(2),
                        "data.email", containsString("janet.weaver@reqres.in"),
                        "data.first_name", containsString("Janet"),
                "data.last_name", containsString("Weaver"),
                "data.avatar", containsString("https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg"));

    }

    @Test
    public void postLoginSuccessfulRequest(){

        JSONObject requestParams = new JSONObject();
        requestParams.put("email", "eve.holt@reqres.in");
        requestParams.put("password", "cityslicka");

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(requestParams.toJSONString())
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .statusCode(200)
                .body("token",  containsString("QpwL5tke4Pnpja7X4"));
    }



}
