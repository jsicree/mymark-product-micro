package com.mymark.mymarkproduct.data;

import java.util.ArrayList;
import java.util.List;

import com.mymark.mymarkproduct.data.domain.Product;
import com.mymark.product.api.ProductDetailsDto;
import com.mymark.product.api.ProductDto;


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

}
