package com.abbosidev

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import jakarta.ws.rs.core.MediaType.APPLICATION_JSON
import org.junit.jupiter.api.Test

@QuarkusTest
class HelloGraphQLResourceTest {

    @Test
    fun `test hello endpoint`() {
        val query = """
            query {
                sayHello
            }
        """.trimIndent()
        given()
            .`when`()
            .body(query)
            .post("/graphql/")
            .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
    }
}