package com.BornChilren.RestfulAPI;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
// import com.fasterxml.jackson.datatype:jackson-datatype-jsr310;

import com.BornChilren.RestfulAPI.Model.BornChildren;


public class BornChildrenControllerTest extends AbstractTest{
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }
    
    @Test
    public void getAllChildren() throws Exception{
        String url = "http://localhost:8081/api/v1/BornChildren/allchildren";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(url)
        .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        System.out.println(status);
        assertEquals(200, status);
    }
    @Test
    public void addchild() throws Exception{
        String url = "http://localhost:8081/api/v1/BornChildren/addchild";
        BornChildren bornChild = new BornChildren();
        bornChild.setNameOfTheChild("Lydiah Naishiaku");
        bornChild.setPlaceOfBirth("Nanyuki");
        bornChild.setGender("female");
        bornChild.setWeight(78);
        bornChild.setMothersName("Nancy Chesang");
        bornChild.setMothersAge(48);
        bornChild.setMothersOccupation("Lawyer");
        bornChild.setMaritalStatus("Married");
        String inputJson = super.mapToJson(bornChild);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(url)
        .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
   
        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
    }
    /* org.springframework.web.util.NestedServletException: Request processing failed; nested exception is org.springframework.orm.jpa.JpaSystemException: identifier of an instance of com.BornChilren.RestfulAPI.Model.BornChildren was altered from 1 to null; nested exception is org.hibernate.HibernateException: identifier of an instance of com.BornChilren.RestfulAPI.Model.BornChildren was altered from 1 to null
 at */
    @Test
    public void updateChild() throws Exception{
        String url = "http://localhost:8081/api/v1/BornChildren/editchild/1";
        BornChildren bornKiddo = new BornChildren();
        bornKiddo.setRegistrationNumber((long) 1);
        bornKiddo.setNameOfTheChild("Meshack Lpidiwa");
        bornKiddo.setGender("Male");
        String inputJson = super.mapToJson(bornKiddo);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(url)
        .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
   
        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);

    }

}