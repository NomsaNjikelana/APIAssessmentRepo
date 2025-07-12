package Tests;

import org.testng.annotations.Test;

import static Common.CommonTestData.Success_Status_Code;
import static Common.CommonTestData.email;
import static Common.RequestBuilder.getListOfUsers;

@Test
public class GetRequest {

  public void getStatusCode() throws Exception {
        getListOfUsers()
                .then()
                .assertThat()
                .statusCode(Success_Status_Code);
        System.out.println("Status code is verified successfully as " + Success_Status_Code);
    }


    public void CountListOfUsers() throws Exception {
        Integer userCount = getListOfUsers()
                .then()
                .extract()
                .path("data.size()");
        if (userCount == null) {
            System.out.println("No users found or response is invalid.");
        } else {
            System.out.println("Total number of users: " + userCount);
        }
    }

    public void printUserIdByEmail() throws Exception {

      Integer userId = getListOfUsers()
            .then()
            .extract()
            .path("data.find { it.email == '" + email + "' }?.id");
    if (userId == null) {
        System.out.println("User with email " + email + " not found.");
    } else {
        System.out.println(email + " has been located, user ID: " + userId);
    }
}

}
