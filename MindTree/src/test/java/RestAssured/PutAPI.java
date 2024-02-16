package RestAssured;

import com.fasterxml.jackson.databind.util.JSONPObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

@Test
public class PutAPI {
    static Response response=null;

    public static void putresponseapi()
    {

        RequestSpecification reqspec = RestAssured.given();
        JSONObject jsonObject= new JSONObject();

        jsonObject.put("name", "Chai");
        jsonObject.put("description","fqwegsydhfgotigkf");
        Response response = reqspec.log().all().relaxedHTTPSValidation().body(jsonObject.toString()).put("https://chercher.tech/sample/api/product/create");
        System.out.println("Status code:" +response.statusCode());

    }
}
