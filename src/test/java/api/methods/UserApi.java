package api.methods;

import api.endpoints.UserEndpoints;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import api.request.UserRequest;

import static io.restassured.RestAssured.given;

public class UserApi {

    public static Response doLoginUser(UserRequest body) {
        return given()
                .contentType(ContentType.JSON)
                .body(body, ObjectMapperType.GSON)
                .post(UserEndpoints.LOGIN);
    }

    public static void doDeleteUser(String bearer) {
        given()
                .header("Authorization", bearer)
                .delete(UserEndpoints.DELETION);
    }

    public static void doRegisterUser(UserRequest body) {
        given()
                .contentType(ContentType.JSON)
                .body(body, ObjectMapperType.GSON)
                .post(UserEndpoints.REGISTRATION);
    }

}
