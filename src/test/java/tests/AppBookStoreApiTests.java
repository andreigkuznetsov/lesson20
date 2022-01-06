package tests;


import config.AppConfig;
import helper.LombokData;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static base.ApiEndpoints.*;
import static base.TestData.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.RestAssuredSpec.*;

public class AppBookStoreApiTests {

    public static AppConfig webConfig = ConfigFactory.create(AppConfig.class, System.getProperties());

    @BeforeAll
    static void startUrl() {
        RestAssured.baseURI = webConfig.apiUrl();

    }

    @Test
    @DisplayName("Проверка с использованием Lombok: проверяем поля в книге")
    void checksWithLombok() {

        LombokData data = given(requestSpec)
                .get(book + "?ISBN=" + isbn)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().as(LombokData.class);

        assertEquals(isbn, data.getIsbn());
        assertEquals(subTitle, data.getSubTitle());
        assertEquals(publisher, data.getPublisher());
        assertEquals(description, data.getDescription());
        assertEquals(website, data.getWebsite());
    }

        @Test
        @DisplayName("Проверка с использованием Groovy: проверяем наличие автора")
        void checksWitGroovy() {

            given(requestSpec)
                    .when()
                    .get(books)
                    .then()
                    .log().status()
                    .log().body()
                    .spec(responseSpec)
                    .body("books.findAll{it.author}.author.flatten()",
                            hasItem(author));
    }

}
