package com.ashi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashi.model.Product;

import jakarta.transaction.Transactional;

import java.util.List;

import javax.sound.midi.VoiceStatus;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByBrand(String brand);// select * from products where brand = ?

	// get product list whose price is less than 1000
	List<Product> findByPriceLessThan(Double price);

	List<Product> findByPriceGreaterThan(Double price);

	List<Product> getByPriceGreaterThan(Double price);

	// note : Spring 3.x findByxxx ,getByxxx ,readByxxx

	//boolean
	Page<Product> findByIsAvailableTrue(Pageable page);// select * from products where isavilable = true;

	// price in desc

	List<Product> findAllByOrderByStockDesc(Pageable page);// select * from products Order by stock desc;

	// multiple conditions
	// select * from products where name = ? and/Or brand = ?
	
	List<Product> findByCategoryAndBrand(String category, String brand);
	List<Product> findByNameOrDescription(String name, String description);
	List<Product> findByCategoryAndIsAvailable(String category, Boolean available);
	List<Product> findByBrandAndPriceLessThan(String brand, Double price);
	List<Product> findByCategoryAndPriceBetween(String category, Double min, Double max);

	
	
	
	List<Product> findByBrandOrName(String brand,String name);
	
	List<Product> findByPriceBetween(Double price1,Double price2);
	
	//string
	
	List<Product> findByNameContaining(String keyword);
	
	List<Product> findByNameStartingWith(String prefix);
	
	List<Product> findByNameEndingWith(String suffix);

	
	//In
	
	List<Product> findByCategoryIn(List<String> categories);
	
	List<Product> findByBrandIn(List<String> brands);//select * from products where brand IN('Apple','Dell);

	
	//Advanced not the finderMethods
	Long countByBrand(String brand);

	@Transactional
	void deleteByBrand(String brand);
	
	
	boolean existsByName(String name);

	
	
	
	

}
