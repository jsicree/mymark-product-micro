package com.mymark.mymarkproduct.ws.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mymark.mymarkproduct.data.ProductDTOConverter;
import com.mymark.mymarkproduct.data.domain.Product;
import com.mymark.mymarkproduct.service.ProductService;
import com.mymark.mymarkproduct.service.ProductServiceException;
import com.mymark.mymarkproduct.ws.ApiException;
import com.mymark.mymarkproduct.ws.ApiMessages;
import com.mymark.product.api.ProductDetailsDto;
import com.mymark.product.api.ProductDetailsResponse;
import com.mymark.product.api.ProductDtoList;
import com.mymark.product.api.ProductsResponse;

/**
 * Handles requests for the form page examples.
 */
@CrossOrigin
@RestController
@RequestMapping("api")
public class ProductServiceController {

	@Autowired
	protected ProductService productService;
	
	@Autowired
	protected MessageSource messageSource;

	protected final static Logger log = LoggerFactory.getLogger(ProductServiceController.class);

	public ProductServiceController() {

	}

	@RequestMapping(value = "/products", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<ProductsResponse> getProducts() throws ApiException {
		
		ProductsResponse response = new ProductsResponse();
		log.info("In getProducts...");
		ArrayList<Product> prodList = null;
		
		try {
			prodList = (ArrayList<Product>) productService.getAllProducts();
			ProductDtoList dtoList = new ProductDtoList();
			dtoList.getProducts().addAll(ProductDTOConverter.toProductDtoList(prodList));
			response.setProducts(dtoList);
		} catch (ProductServiceException e) {
			log.error("ProductServiceException thrown while getting all products.", e);
			e.printStackTrace();
			throw new ApiException(ApiMessages.SERVICE_EXCEPTION_MSG, e);
		}

		return new ResponseEntity<>(response, HttpStatus.OK);
	}	
	
	@RequestMapping(value = "/product/{prodId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<ProductDetailsResponse> getProductById(
			@PathVariable(required = true) Long prodId) throws ApiException {
		
		ProductDetailsResponse response = new ProductDetailsResponse();
		log.info("In getProductById...");
		
		try {
			
			Product product = productService.lookupProductById(prodId);
			if (product != null) {
				Long count = productService.getAvailableInventory(product.getId());
				
				ProductDetailsDto dto = ProductDTOConverter.toProductDetailsDto(product, count);
				response.setProductDetails(dto);
			}
						
		} catch (ProductServiceException e) {
			log.error("ProductServiceException thrown while getting product details.", e);
			e.printStackTrace();
			throw new ApiException(ApiMessages.SERVICE_EXCEPTION_MSG, e);
		}

		return new ResponseEntity<>(response, HttpStatus.OK);
	}		
	
}