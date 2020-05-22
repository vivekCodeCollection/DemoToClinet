package com.test.automation.APITest;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.test.automation.ApiAutomation.responsepojo.CreatePersonResponse;
import com.test.automation.ApiAutomation.service.Service;
import com.test.automation.Generic.Base.TestBase;
import com.test.automation.UiTest.TC001_Task;



public class CreatePersionAPITest extends TestBase{
	
	public static final Logger log = Logger.getLogger(CreatePersionAPITest.class.getName());
	String name;
	String surname;
	String city;
	String landmark;
	String state;
	String zipcode;
	
	@BeforeClass
	public void dataSetUp() throws IOException{
		init();
		name = "serviceTest";
		surname = "servicesurname";
		city = "servicecity";
		landmark = "servicelandmark";
		state = "statestate";
		zipcode = "560078";
	}
	
	
	@Test
	public void createPersionAPITest(){
		service = new Service();
		log.info("=======started verifyRegistration Test===========");
		response =  service.createPersionAPI(name, surname, city, landmark, state, zipcode);
		log.info("=======Created Person API===========");
		if(response.getStatusCode() == 200){

			System.out.println(response.asString());

			Gson gson = new Gson();
			CreatePersonResponse createPersonResponse = gson.fromJson(response.asString(), CreatePersonResponse.class);

			// Just printing to see data from response.
			System.out.println(createPersonResponse.getResponse().get(0).getAddress().getCity());
			System.out.println(createPersonResponse.getResponse().get(0).getName());
			System.out.println(createPersonResponse.getResponse().get(0).getSurname());
			System.out.println(createPersonResponse.getResponse().get(0).getAddress().getLandmark());

			Assert.assertEquals(createPersonResponse.getResponse().get(0).getAddress().getCity(), city);

			Assert.assertEquals(createPersonResponse.getResponse().get(0).getName(), name);
		}
		else{
			Assert.assertTrue(false, response.asString());
		}
	}

}
