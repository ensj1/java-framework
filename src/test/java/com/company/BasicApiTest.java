package com.company;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.LinkedList;

import com.company.utils.RestAssuredUtil;
import org.junit.Test;

public class BasicApiTest extends BaseTest {

    @Test
    public void T01_StatusCodeAndGetClientsTest() {
        RestAssuredUtil.getResponse("swagger.json").then().and().statusCode(is(200));
    }

    @Test
    public void T02_GetAndroidModelPackageOptions() {
        RestAssuredUtil.getResponse("swagger.json").then().assertThat()
        .body("info.description", containsString("This is an online"));
    }

    @Test
    public void T03_CheckBody() {
        RestAssuredUtil.getResponse("swagger.json").then().assertThat()
        .body("tags.name", hasItems("gen", "clients"));
    }

    @Test
    public void T04_CheckMock() {
        LinkedList mockedList = mock(LinkedList.class);
        when(mockedList.get(0)).thenReturn("first");
        assertEquals("first", mockedList.get(0));
    }
}
