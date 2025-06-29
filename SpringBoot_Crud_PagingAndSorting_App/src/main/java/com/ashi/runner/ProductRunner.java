package com.ashi.runner;

import java.util.List;
import java.util.SortedMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.ashi.exception.ProductNotFoundException;
import com.ashi.models.Product;
import com.ashi.service.ProductService;

@Component
public class ProductRunner implements CommandLineRunner {

	@Autowired
	private ProductService service;

	@Override
	public void run(String... args) {

		// Product product = new Product(1101, "Mouse","Electronics", 2000.1, 10);
//		Product product = new Product();
//		product.setCategory("Electronics");
//		product.setName("Mouse");
//		product.setPrice(2000.25);
//		product.setStock(10);
//		
//		service.insertProduct(product);

		// service.deleteProductById(51);

		/*
		 * System.out.println("get product By Id  : "); Product productByProductId =
		 * null; try { productByProductId = service.getProductByProductId(1001); } catch
		 * (ProductNotFoundException e) {
		 * 
		 * System.err.println( e.getMessage()); }
		 * System.out.println(productByProductId);
		 */

		System.out.println("===================get all products :========================");
		List<Product> allProducts2 = service.getAllProducts();// crt+2 .. l
		allProducts2.stream().forEach(System.out::println);
		System.out.println("===============================================================");

		// Sorting
		System.out.println("==============Sorting===============================");
		List<Product> allSortedProducts = service.getAllSortedProducts(true, "stock"); // table coloumn name

		allSortedProducts.stream().map(p -> p.getName() + "==>" + p.getStock()).forEach(System.out::println);

		System.out.println("====================================================================");

		// Paging
		System.out.println("==================Paging======================");

		// create Sort Object
		boolean asc = false;
		Sort sort = Sort.by(asc ? Direction.ASC : Direction.DESC, "stock");// column attribute

		int n = 1;
		Page<Product> productsByPage = service.getProductsByPage(n, 10, sort);// pageNo (starts from 0) , pageSize
		// Page
		// Page object contains Meta Data( totalnopages,current page no,
		// nextPage,previousPage)

		productsByPage.stream().map(p -> p.getId() + "-->" + p.getName() + " " + p.getStock())
				.forEach(System.out::println);

		System.out.println("pages " + n + "/" + productsByPage.getTotalPages());

		System.out.println(productsByPage.hasNext());
		System.out.println(productsByPage.getTotalElements());// total table records
		System.out.println(productsByPage.getNumberOfElements());// current Page no. of records
		System.out.println(productsByPage.hasPrevious());
		System.out.println(productsByPage.isFirst());

		System.out.println("======================================================================");

		// Example

		System.out.println("===================Example=======================");

		Product product = new Product();
		product.setCategory("Accessories");

		List<Product> productsByElectronics = service.getProductsByXXX(product, sort);
		productsByElectronics.stream().map(p -> p.getCategory() + " " + p.getStock()).forEach(System.out::println);

		System.out.println("======================================================================");

		// Example with Pagging with sorting
		System.out.println("================Example with Pagging with sorting =========================");

		Page<Product> productsByXXXPagging = service.getProductsByXXXPagging(product, sort, 2, 5);
		productsByXXXPagging.stream().map(p -> p.getCategory() + " " + p.getStock()).forEach(System.out::println);

		System.out.println("======================================================================");

	}

}
