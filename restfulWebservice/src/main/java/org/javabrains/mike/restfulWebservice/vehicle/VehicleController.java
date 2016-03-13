package org.javabrains.mike.restfulWebservice.vehicle;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleController {

	/*
	 * ResponseEntity: allows you to modify request
	 * and response headers
	 */
	@RequestMapping(value = "/vehicle", method = RequestMethod.GET)
	public ResponseEntity<Car> get(){
		
		Car car = new Car();
		car.setColor("Blue");
		car.setMiles(100);
		car.setVin("1234");
		
		return new ResponseEntity<Car>(car,HttpStatus.OK); 
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST )
	public ResponseEntity<Car> update(@RequestBody Car car,
									  @RequestHeader(value = "auth-id", required=true) String authId) throws Exception{
		if(!authId.equals("CLIENT")){
			throw new Exception("Invalid auth-id");
		}
		
		if(car!=null ){
			car.setMiles(car.getMiles() + 100);
		}
		return new ResponseEntity<Car>(car,HttpStatus.OK); 
	}
	
	@RequestMapping(value = "/cars", method = RequestMethod.POST )
	public ResponseEntity<List<Car>>update(@RequestBody List<Car> cars){
		
		for(Car car: cars){
			car.setMiles(car.getMiles()+100);
		}
		return new ResponseEntity<List<Car>>(cars, HttpStatus.OK); 
	}
	
	@RequestMapping(value = "/carsandtrucks", method = RequestMethod.POST )
	public ResponseEntity <RequestWrapper> updateWithMultipleObjects(
			@RequestBody RequestWrapper requestWrapper){
		
		for(Car c: requestWrapper.cars){
			c.setMiles(c.getMiles() + 100);
		}
		
		requestWrapper.truck.setMiles(requestWrapper.truck.getMiles()+2300);
		 HttpHeaders responseHeaders = new HttpHeaders();
	        responseHeaders.setContentType(MediaType.valueOf("application/xml"));
		
		return new ResponseEntity<RequestWrapper>(requestWrapper,responseHeaders, HttpStatus.OK); 
	}
	
	
	
}
