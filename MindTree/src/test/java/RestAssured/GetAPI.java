package RestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

@Test
public class GetAPI {
        RequestSpecification reqspec = RestAssured.given();
        static Response response=null;

        public static void getResponsestatus() {
            response = RestAssured.get("https://api.github.com/users/zellwk/repos");

            String res = response.body().toString();
            System.out.println("status code:" + response.getStatusCode());
            System.out.println("Response time:" + response.getTime());

        }
    }


