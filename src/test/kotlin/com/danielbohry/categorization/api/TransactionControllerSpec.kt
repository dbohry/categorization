package com.danielbohry.categorization.api

import com.danielbohry.categorization.AbstractIntegrationTest
import io.restassured.RestAssured
import io.restassured.http.ContentType
import org.apache.http.HttpStatus
import org.junit.Before
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired

class TransactionControllerSpec : AbstractIntegrationTest() {

    @Autowired
    lateinit var helper: TransactionHelper

    @Before
    fun setup() {
        helper.deleteAll()
    }

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

    @Test
    fun `should save a transaction`() {
        RestAssured
                .given()
                .port(serverPort)
                .`when`()
                .contentType(ContentType.JSON)
                .body(helper.buildTransactionDTO(args = null))
                .post("/api/v1/transactions")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED)
                .log().all()
    }

    @Test
    fun `should update a transaction`() {
        val id = helper.createTransaction()

        RestAssured
                .given()
                .port(serverPort)
                .`when`()
                .contentType(ContentType.JSON)
                .body(helper.buildTransactionDTO(args = null))
                .put("/api/v1/transactions/$id")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .log().all()
    }

}