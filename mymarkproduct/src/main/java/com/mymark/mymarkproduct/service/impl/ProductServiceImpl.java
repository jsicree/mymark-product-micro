/**
 * 
 */
package com.mymark.mymarkproduct.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mymark.mymarkproduct.data.domain.InventoryItem;
import com.mymark.mymarkproduct.data.domain.Product;
import com.mymark.mymarkproduct.data.enums.InventoryStatus;
import com.mymark.mymarkproduct.repository.InventoryItemRepository;
import com.mymark.mymarkproduct.repository.ProductRepository;
import com.mymark.mymarkproduct.service.ProductService;
import com.mymark.mymarkproduct.service.ProductServiceException;

/**
 * @author joseph_sicree
 *
 */
public class ProductServiceImpl implements ProductService {

	protected final static Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private InventoryItemRepository inventoryRepo;

	/**
	 * 
	 */
	public ProductServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public ProductServiceImpl(ProductRepository productRepo, InventoryItemRepository inventoryRepo) {
		super();
		this.productRepo = productRepo;
		this.inventoryRepo = inventoryRepo;
	}

	@Override
	public List<Product> getAllProducts() throws ProductServiceException {
		List<Product> productList = new ArrayList<Product>();

		productList = productRepo.findAll();

		return productList;
	}

	@Override
	public Product lookupProductById(Long id) throws ProductServiceException {
		Optional<Product> p = productRepo.findById(id);

		if (p != null && p.isPresent()) {
			return p.get();
		} else {
			return null;
		}
	}

	@Override
	public Long getAvailableInventory(Long id) throws ProductServiceException {

		Long count = null;
		Optional<Product> p = productRepo.findById(id);
		if (p != null && p.isPresent()) {
			count = inventoryRepo.getAvailableInventoryCount(p.get().getId());			
		}
		
		return count;
	}

	@Override
	public Product lookupProductByProductCode(String productCode) throws ProductServiceException {
		Product p = productRepo.findByProductCode(productCode);
		return p;
	}

	@Override
	public InventoryItem getInventoryItem(String sku) throws ProductServiceException {

		InventoryItem item = inventoryRepo.findBySku(sku);
		return item;
	}

	@Override
	public InventoryItem updateInventoryItem(String sku, InventoryStatus status, Date updateDate) throws ProductServiceException {

		Date inProcessDate = null;
		Date sellDate = null;
		Date returnDate = null;

		InventoryItem existingItem = inventoryRepo.findBySku(sku);
		if (existingItem != null) {

			if (status == InventoryStatus.IN_PROCESS) {
				inProcessDate = updateDate;				
			} else if (status == InventoryStatus.RETURNED) {
				returnDate = updateDate;
			} else if (status == InventoryStatus.SOLD) {
				sellDate = updateDate;
			}
			
			existingItem.setInProcessDate(inProcessDate);
			existingItem.setSellDate(sellDate);
			existingItem.setReturnDate(returnDate);
			existingItem.setStatus(status);
			
			existingItem = inventoryRepo.save(existingItem);
			
		}
		
		return existingItem;
	}

	@Override
	public List<InventoryItem> getInventoryByProductCode(String productCode) throws ProductServiceException {

		List<InventoryItem> itemList = new ArrayList<InventoryItem>();
		
		Product p = productRepo.findByProductCode(productCode);
		if (p != null) {
			itemList = inventoryRepo.findByProduct(p);			
		}
		return itemList;
	}

}
