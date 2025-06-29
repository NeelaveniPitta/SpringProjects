package com.ashi.service;


import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.ashi.exception.ProductNotFoundException;
import com.ashi.models.Product;

public interface IProductService {

	void insertProduct(Product p);
	
	void deleteProductById(Integer id);
	
	List<Product> getAllProducts();
	
	Product getProductByProductId(Integer id) throws ProductNotFoundException;
	
	List<Product> getAllSortedProducts(boolean asc,String ...props);//table coloumn names
	
	
	
	Page<Product> getProductsByPage(int pageNo , int pageSize,Sort sort);
	
	
	List<Product> getProductsByXXX(Product p,Sort sort);
	
	Page<Product> getProductsByXXXPagging(Product p,Sort sort,int pageNo , int pageSize);


	

}
