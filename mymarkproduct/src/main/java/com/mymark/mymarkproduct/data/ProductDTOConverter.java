package com.mymark.mymarkproduct.data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mymark.mymarkproduct.data.domain.InventoryItem;
import com.mymark.mymarkproduct.data.domain.Product;
import com.mymark.product.api.InventoryDto;
import com.mymark.product.api.InventoryDtoList;
import com.mymark.product.api.ProductDetailsDto;
import com.mymark.product.api.ProductDto;
import com.mymark.product.api.ProductInventoryResponse;


public final class ProductDTOConverter {

		public static ProductDto toProductDto(Product p) {
			ProductDto dto = new ProductDto();
			dto.setId(p.getId());
			dto.setName(p.getName());
			dto.setProductCode(p.getProductCode());
			dto.setPrice(p.getPrice());
			dto.setShortDescription(p.getShortDescription());
			return dto;
		}

		public static List<ProductDto> toProductDtoList(ArrayList<Product> prodList) {
			
			List<ProductDto> dtoList = new ArrayList<ProductDto>();
			
			for (Product p : prodList) {
				dtoList.add(toProductDto(p));
			}
			
			return dtoList;
		}

		public static ProductDetailsDto toProductDetailsDto(Product p, Long count) {
			ProductDetailsDto dto = new ProductDetailsDto();
			dto.setId(p.getId());
			dto.setName(p.getName());
			dto.setProductCode(p.getProductCode());
			dto.setPrice(p.getPrice());
			dto.setShortDescription(p.getShortDescription());
			dto.setLongDescription(p.getLongDescription());
			dto.setAvailableInventory(count);
			return dto;
		}

		public static InventoryDto toInventoryDto(InventoryItem item) {
			InventoryDto dto = new InventoryDto();
			dto.setId(item.getId());
//			dto.setInProcessDate(item.getInProcessDate());
//			dto.setReturnDate(item.getReturnDate());
//			dto.setSellDate(item.getSellDate());
			dto.setPrice(item.getProduct().getPrice());
			dto.setSku(item.getSku());
			dto.setStatus(item.getStatus().name());
			
			return dto;
		}

		public static InventoryDtoList toInventoryDtoList(List<InventoryItem> itemList) {

			InventoryDtoList dtoList = new InventoryDtoList();
			
			for (InventoryItem i : itemList) {
				dtoList.getInventory().add(toInventoryDto(i));				
			}
			return dtoList;
		}

}
