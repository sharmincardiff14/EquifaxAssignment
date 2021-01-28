package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiTest {
	
	@Test
	public void getEmpRecords() {
	RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";		 
	RequestSpecification httpRequest = RestAssured.given();
	Response response = httpRequest.request(Method.GET, "/employees");
	String jsonString =response.asString();
	 String responseBody = response.getBody().asString();
	 System.out.println("Response Body is =>  " + responseBody);	
	 Assert.assertEquals(jsonString.contains("success"), true);
	}
	
	@Test
	public void deleteEmpRecord() {
		
	 
	 int empid = 1;
	 
	 RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
	 RequestSpecification request = RestAssured.given(); 
	 request.header("Content-Type", "application/json"); 
	 Response response = request.delete("/delete/"+ empid); 
	 
	 int statusCode = response.getStatusCode();
	 System.out.println(response.asString());
	 Assert.assertEquals(statusCode, 200);
	 
	 String jsonString =response.asString();
	 Assert.assertEquals(jsonString.contains("successfully! deleted Records"), true);
	 }
	
	

}
