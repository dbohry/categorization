package com.danielbohry.categorization.api

import com.danielbohry.categorization.AbstractIntegrationTest
import io.restassured.RestAssured
import org.apache.http.HttpStatus
import org.junit.Test

class TransactionControllerSpec : AbstractIntegrationTest() {

    @Test
    fun `should get all transactions`() {
        RestAssured
                .given()
                .port(serverPort)
                .`when`()
                .get("/api/v1/transactions")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .log().all()
    }

}