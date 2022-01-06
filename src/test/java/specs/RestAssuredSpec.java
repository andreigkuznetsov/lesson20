package specs;


import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;

public class RestAssuredSpec {
    static public RequestSpecification requestSpec =
            with()
                    .filter(new AllureRestAssured())
                    .contentType(ContentType.JSON);

    static public ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();
}
