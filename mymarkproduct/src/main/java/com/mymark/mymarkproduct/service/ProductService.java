/**
 * 
 */
package com.mymark.mymarkproduct.service;

import java.util.Date;
import java.util.List;

import com.mymark.mymarkproduct.data.domain.InventoryItem;
import com.mymark.mymarkproduct.data.domain.Product;
import com.mymark.mymarkproduct.data.enums.InventoryStatus;

/**
 * @author joseph_sicree
 *
 */
public interface ProductService {


	public List<Product> getAllProducts() throws ProductServiceException;

	public Product lookupProductById(Long id) throws ProductServiceException;

	public Product lookupProductByProductCode(String productCode) throws ProductServiceException;

	public Long getAvailableInventory(Long id) throws ProductServiceException;

	public InventoryItem getInventoryItem(String sku) throws ProductServiceException;
	
	public InventoryItem updateInventoryItem(String sku, InventoryStatus status, Date updateDate) throws ProductServiceException;

	public List<InventoryItem> getInventoryByProductCode(String productCode) throws ProductServiceException;
	
}
