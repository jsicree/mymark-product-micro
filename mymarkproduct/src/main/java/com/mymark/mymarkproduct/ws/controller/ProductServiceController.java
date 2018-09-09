package com.mymark.mymarkproduct.ws.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mymark.mymarkproduct.data.ProductDTOConverter;
import com.mymark.mymarkproduct.data.domain.InventoryItem;
import com.mymark.mymarkproduct.data.domain.Product;
import com.mymark.mymarkproduct.data.enums.InventoryStatus;
import com.mymark.mymarkproduct.service.ProductService;
import com.mymark.mymarkproduct.service.ProductServiceException;
import com.mymark.mymarkproduct.ws.ApiException;
import com.mymark.mymarkproduct.ws.ApiMessages;
import com.mymark.product.api.InventoryDtoList;
import com.mymark.product.api.ProductDetailsDto;
import com.mymark.product.api.ProductDetailsResponse;
import com.mymark.product.api.ProductDtoList;
import com.mymark.product.api.ProductInventoryResponse;
import com.mymark.product.api.ProductsResponse;
import com.mymark.product.api.UpdateInventoryRequest;
import com.mymark.product.api.UpdateInventoryResponse;

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

	@RequestMapping(value = "/product/{productCode}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<ProductDetailsResponse> getProductByProductCode(
			@PathVariable(required = true) String productCode) throws ApiException {

		ProductDetailsResponse response = new ProductDetailsResponse();
		log.info("In getProductByProductCode...");

		try {

			Product product = productService.lookupProductByProductCode(productCode);
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

	@RequestMapping(value = "/inventory/{productCode}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<ProductInventoryResponse> getInventoryByProduct(
			@PathVariable(required = true) String productCode) throws ApiException {

		ProductInventoryResponse response = new ProductInventoryResponse();
		
		List<InventoryItem> itemList;
		try {
			itemList = productService.getInventoryByProductCode(productCode);
			InventoryDtoList list = ProductDTOConverter.toInventoryDtoList(itemList);
			response.setInventory(list);
		} catch (ProductServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@RequestMapping(value = "/inventory/", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<UpdateInventoryResponse> updateInventory(@RequestBody UpdateInventoryRequest request)
			throws ApiException {

		UpdateInventoryResponse response = new UpdateInventoryResponse();

		InventoryItem item = null;
		try {
			item = productService.updateInventoryItem(request.getSku(), InventoryStatus.valueOf(request.getNewStatus()),
					request.getStatusDate().getTime());
		} catch (ProductServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.setInventory(ProductDTOConverter.toInventoryDto(item));

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}