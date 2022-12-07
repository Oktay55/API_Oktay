package Pojo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DocType {

    private Cookies cookies;

    private RequestSpecification reqSpec;

    private HashMap<String, String> credentials;

    private MaliDocType docType = new MaliDocType();


    @BeforeClass
    public void setup() {


        RestAssured.baseURI = "https://demo.mersys.io/";

        reqSpec = given()
                .log().body()
                .contentType(ContentType.JSON);

        credentials = new HashMap<>();
        credentials.put("username", "richfield.edu");
        credentials.put("password", "Richfield2020!");
        credentials.put("rememberMe", "true");

        cookies = given()
                .spec(reqSpec)
                .body(credentials)
                .when()
                .post("/auth/login")
                .then()
                .log().body()
                .statusCode(200)
                .body("scope", equalTo("openid"))
                .extract().detailedCookies();


    }

    @Test(priority = 1)
    public void addUserDocTypeTest() {

        docType.setActive("true");
        docType.setDescription("madre");
        docType.setName("chapin");
        docType.setRequired("true");
        docType.setSchoolId("6343bf893ed01f0dc03a509a");
        docType.setUseCamera("false");
        docType.setAttachmentStages("EXAMINATION");
        docType.setTranslateName("en", "bra");
        docType.setTranslateName("tr", "chi");


        docType.setId(given()
                .spec(reqSpec)
                .cookies(cookies)
                .body(docType)
                .when()
                .post("/school-service/api/attachments")
                .then()
                .log().body()
                .statusCode(201)
                .body("description", equalTo(docType.getDescription()))
                .body("name", equalTo(docType.getName()))
                .body("schoolId", equalTo(docType.getSchoolId()))
                .body("translateName[0].lang", equalTo(docType.getTranslateName().get(0).getLang()))
                .extract().jsonPath().getString("id"));


    }

    @Test(priority = 2)
    public void addUserDocTypeNegativeTest() {

        docType.setActive("true");
        docType.setDescription("madre");
        docType.setName("chapin");
        docType.setRequired("true");
        docType.setSchoolId("6343bf893ed01f0dc03a509a");
        docType.setUseCamera("false");
        docType.setAttachmentStages("EXAMINATION");
        docType.setTranslateName("en", "bra");
        docType.setTranslateName("tr", "chi");


        given()
                .spec(reqSpec)
                .cookies(cookies)
                .body(docType)
                .when()
                .post("/school-service/api/attachments")
                .then()
                .log().body()
                .statusCode(400);


    }

    @Test(priority = 3)
    public void editUserDocsTypes() {

        docType.setId(docType.getId());
        docType.setName("drake");
        docType.setDescription("twentyOne");
        docType.setAttachmentStages("EMPLOYMENT");
        docType.setSchoolId("6343bf893ed01f0dc03a509a");
        docType.setTranslateName("en", "bsd");



        given()
                .spec(reqSpec)
                .cookies(cookies)
                .body(docType)
                .when()
                .put("/school-service/api/attachments")
                .then()
                .log().body()
                .statusCode(200)
                .body("description", equalTo(docType.getDescription()))
                .body("name", equalTo(docType.getName()))
                .body("attachmentStages", equalTo(docType.getAttachmentStages()));

    }

        @Test(priority = 4)
    public void deleteUserDocsTypes() {

            given()
                    .cookies(cookies)
                    .pathParam("doc_id", docType.getId())

                    .when()
                    .delete("/school-service/api/attachments/{doc_id}") //comes from pathParam

                    .then()
                    .log().body()
                    .statusCode(200);



//            given()
//                    .spec(reqSpec)
//                    .cookies(cookies)
//                    .when()
//                    .delete("/school-service/api/attachments/" + docType.getId())
//                    .then()
//                    .log().body()
//                    .statusCode(200);
        }

    @Test(priority = 5)
    public void deleteUserDocTypeNegativeTest() {

        given()
                .cookies(cookies)
                .pathParam("doc_id", docType.getId())
                .log().uri()

                .when()
                .delete("/school-service/api/attachments/{doc_id}")
                .then()
                .log().body()
                .statusCode(400);

    }

}





