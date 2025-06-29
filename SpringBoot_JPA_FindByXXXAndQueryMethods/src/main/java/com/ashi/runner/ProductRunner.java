package com.ashi.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import com.ashi.SpringBootJpaFindByXxxAndQueryMethodsApplication;
import com.ashi.model.Product;
import com.ashi.repository.ProductRepository;

@Component
public class ProductRunner implements CommandLineRunner {

    private final SpringBootJpaFindByXxxAndQueryMethodsApplication springBootJpaFindByXxxAndQueryMethodsApplication;

	@Autowired
	private ProductRepository repo;

    ProductRunner(SpringBootJpaFindByXxxAndQueryMethodsApplication springBootJpaFindByXxxAndQueryMethodsApplication) {
        this.springBootJpaFindByXxxAndQueryMethodsApplication = springBootJpaFindByXxxAndQueryMethodsApplication;
    }

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Application started.....+++++++++++++++++++++\n\n");

		System.out.println("findById() :");
		repo.findById(301l).ifPresentOrElse(System.out::println, () -> System.out.println("product not found"));// {throw
																												// new
																												// IllegalArgumentException("Product
																												// not
																												// found");}

		System.out.println("findByBrand(String brand) :");
		
		List<Product> byBrand = repo.findByBrand("Apple");
		byBrand.stream().map(p -> p.getId() +" "+p.getBrand()).forEach(System.out::println);

		
		System.out.println(" findByPriceLessThan(Double price) :");
		repo.findByPriceLessThan(1000.0).stream().map(p -> p.getId() +" "+p.getPrice()).forEach(System.out::println);
		
		
		System.out.println(" findByPriceGreaterThan(Double price)");
		repo.getByPriceGreaterThan(50000.0).stream().map(p -> p.getId() +" "+p.getPrice()).forEach(System.out::println);
		
		
		System.out.println("findByIsAvailableTrue()");
		//using page
	    Pageable page = PageRequest.of(0, 10);
		repo.findByIsAvailableTrue(page).forEach(System.out::println);
		
		System.out.println(" findAllByOrderByStockDesc();");
		repo.findAllByOrderByStockDesc(page).forEach(System.out::println);
		
		
		System.out.println(" findByBrandOrName(String brand,String name);");
		repo. findByBrandOrName("Apple","Nike Air Max 90").forEach(System.out::println);
	
		
		System.out.println("findByBrandIn(List<String> brands);");
		repo.findByBrandIn(List.of("Apple","Dell")).forEach(System.out::println);
		
		
		System.out.println("countByBrand(Apple);"+repo.countByBrand("Apple"));
		
		
		repo.deleteByBrand("Apple");
		
		
		System.out.println("existsByName(String name);" +repo.existsByName("Redmi Note 12"));
		
		
		System.out.println(" findByPriceBetween(Double price1,Double price2);");
		repo. findByPriceBetween(1000.0,5000.0).forEach(System.out::println);
		
		
		
		
		
	}

}
