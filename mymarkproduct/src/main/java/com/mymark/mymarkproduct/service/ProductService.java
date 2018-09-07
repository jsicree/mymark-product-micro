/**
 * 
 */
package com.mymark.mymarkproduct.service;

import java.util.List;

import com.mymark.mymarkproduct.data.domain.Product;

/**
 * @author joseph_sicree
 *
 */
public interface ProductService {


	public List<Product> getAllProducts() throws ProductServiceException;

	public Product lookupProductById(Long id) throws ProductServiceException;

	public Product lookupProductByProductCode(String productCode) throws ProductServiceException;

	public Long getAvailableInventory(Long id) throws ProductServiceException;

}
