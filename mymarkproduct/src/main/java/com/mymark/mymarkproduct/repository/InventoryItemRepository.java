package com.mymark.mymarkproduct.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mymark.mymarkproduct.data.domain.InventoryItem;
import com.mymark.mymarkproduct.data.domain.Product;

/**
 * Repository to manage {@link InventoryItem} instances.
 * 
 */
@Repository 
public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {

// TODO: get inventory count by product id and status	
	@Query("SELECT COUNT(*) FROM INVENTORY WHERE PRODUCT_ID=:productId AND STATUS='AVAILABLE'")
    Long getAvailableInventoryCount(@Param("productId") Long productId);

	@Query("SELECT i FROM INVENTORY i WHERE PRODUCT_ID=:productId AND STATUS='AVAILABLE'")
    List<InventoryItem> getAllAvailableInventory(@Param("productId") Long productId);

	@Query("SELECT i.id FROM INVENTORY i WHERE PRODUCT_ID=:productId AND STATUS='AVAILABLE'")
    List<Long> getIdsForAllAvailableInventory(@Param("productId") Long productId);

	InventoryItem findBySku(String sku);

    List<InventoryItem> findByProduct(Product product);

}

