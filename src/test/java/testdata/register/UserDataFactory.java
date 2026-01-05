package testdata.register;

import com.github.javafaker.Faker;
import api.request.UserRequest;
import constants.Constants;

public class UserDataFactory {
    private static final Faker faker = new Faker();

    public static UserRequest generateValidUserData() {
        return UserRequest.builder()
                .email(faker.internet().emailAddress())
                .password(Constants.DEFAULT_PASSWORD)
                .name(faker.name().firstName())
                .build();
    }

    public static UserRequest generateUserDataWithShortPassword() {
        return generateValidUserData().toBuilder().password(Constants.INVALID_PASSWORD).build();
    }


}
