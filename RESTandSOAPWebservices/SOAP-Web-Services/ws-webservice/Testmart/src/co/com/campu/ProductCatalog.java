package co.com.campu;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import co.com.campu.business.ProductServiceImpl;

//With this annotation we are done
//On glassfish there are some things that happen under the hood
//If you enter glassfish console you can see the ws and the wsdl
@WebService
@SOAPBinding(style=Style.RPC)
public class ProductCatalog {
	
	ProductServiceImpl productService = new ProductServiceImpl();
	
	//My goal is to create a webservice
	//that has an operation getProductCategories
	public List<String> getProductCategories() {
		
		return productService.getProductCategories();
		
	}
	
	//All the public methods inside the class anotated with @webservice
	//are recognized as operations
	@WebResult(partName = "lookupOutput")
	public List<String> getProducts(@WebParam(partName = "lookupInput") String category) {
		return productService.getProducts(category);
	}
	
}
