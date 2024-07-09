package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class _13_Get_SoftAssertIleExpectedDataTesti {
    /**
     * http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
     * gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
     * Response Body
     * {
     * "status": "success",
     * "data": {
     *          "id": 3,
     *          "employee_name": "Ashton Cox",
     *          "employee_salary": 86000,
     *           "employee_age": 66,
     *          "profile_image": ""
     * },
     * "message": "Successfully! Record has been fetched."
     * }

     */

    @Test
    public void test() {
        // url ve request body hazirla
        String url = "http://dummy.restapiexample.com/api/v1/employee/3";

        // 2- expected data hazirla
        JSONObject dataexpData = new JSONObject();
        dataexpData.put("id", 3);
        dataexpData.put("employee_name", "Ashton Cox");
        dataexpData.put("employee_salary", 86000);
        dataexpData.put("employee_age", 66);
        dataexpData.put("profile_image", "");

        JSONObject expectedReqBody =new JSONObject();
        expectedReqBody.put("status", "success");
        expectedReqBody.put("data", dataexpData);
        expectedReqBody.put("message", "Successfully! Record has been fetched.");


        // 3. response'i kaydet

        Response response = given().when().get(url);
        response.prettyPrint();

        // 4- Assert

        JsonPath responseJsonPath=response.jsonPath();

        assertEquals(responseJsonPath.get("status"),expectedReqBody.get("status"));
        assertEquals(responseJsonPath.get("message"),expectedReqBody.get("message"));
        assertEquals(responseJsonPath.get("data.id"),
                     expectedReqBody.getJSONObject("data").get("id"));
        assertEquals(responseJsonPath.get("data.employee_name"),
                    expectedReqBody.getJSONObject("data").get("employee_name"));
        assertEquals(responseJsonPath.get("data.employee_salary"),
                    expectedReqBody.getJSONObject("data").get("employee_salary"));
        assertEquals(responseJsonPath.get("data.employee_age"),
                    expectedReqBody.getJSONObject("data").get("employee_age"));
        assertEquals(responseJsonPath.get("data.profile_image"),
                    expectedReqBody.getJSONObject("data").get("profile_image"));



    }
}
