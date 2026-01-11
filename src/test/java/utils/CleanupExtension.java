package utils;

import api.methods.UserApi;
import io.restassured.response.Response;
import api.request.UserRequest;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.util.HashSet;
import java.util.Set;

public class CleanupExtension implements AfterEachCallback {
    private static final Set<UserRequest> users = new HashSet<>();

    public static void addUserToDeletionList(UserRequest userRequest) {
            users.add(userRequest);
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) throws Exception {
        for (UserRequest user : users) {
            Response response = UserApi.doLoginUser(user);
            String token = response.jsonPath().getString("accessToken");
            if (token != null) {
                UserApi.doDeleteUser(token);
            }
        }
        users.clear();
    }
}
