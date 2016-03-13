package org.javabrains.mike.restfulWebservice.store;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreController {

	
	@RequestMapping(value = "/store", method = RequestMethod.GET)
	public ResponseEntity<Store>get(){
		Store store = new Store();
		store.setStoreNumber(1234);
		store.setStoreName("Macy's");
		store.setStoreType("clothing");
		return new ResponseEntity<Store>(store, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/store", method = RequestMethod.POST)
	public ResponseEntity<Store>update(@RequestBody Store store){
		
		if(store!=null){
			store.setStoreType(store.getStoreType());
		}
		
		
		return new ResponseEntity<Store>(store, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/storeType", method = RequestMethod.POST)
	public ResponseEntity <Store> getType(@RequestBody Store store, 
										  @RequestHeader(value = "auth-id", required=true) String authId) throws Exception
	{
		if(!authId.equals("CLIENT")){
			throw new Exception("invalid auth-id");
		}
		
		if(store.getStoreNumber() <2000 ){
			store.setStoreType("clothing");
		}else if(store.getStoreNumber()>=2000 && store.getStoreNumber()<3000){
			store.setStoreType("Grocery");
		}else if(store.getStoreNumber()>=3000 && store.getStoreNumber()<4000){
			store.setStoreType("Book");
		}
		return new ResponseEntity<Store>(store, HttpStatus.OK);
	}
	
}
