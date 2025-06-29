package com.ashi.service;

import java.util.List;
import java.util.SortedMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ashi.exception.ProductNotFoundException;
import com.ashi.models.Product;
import com.ashi.repository.ProductRepository;

@Service

public class ProductService implements IProductService {

	@Autowired
	private ProductRepository repo;

	@Override
	public void insertProduct(Product p) {

		repo.save(p);

	}

	@Override
	public void deleteProductById(Integer id) {

		repo.deleteById(id);

	}

	@Override
	public List<Product> getAllProducts() {
		return repo.findAll();
	}

	@Override
	public Product getProductByProductId(Integer id) throws ProductNotFoundException {

		return repo.findById(id).orElseThrow(() -> new ProductNotFoundException("product not found"));
	}

	@Override
	public List<Product> getAllSortedProducts(boolean asc, String... props) {

		// sorting
		// 1.create Sort Object

		Sort sort = Sort.by(asc ? Direction.ASC : Direction.DESC, props);
		//

		return repo.findAll(sort);

	}

	@Override
	public Page<Product> getProductsByPage(int pageNo, int pageSize, Sort sort) {

		// pageing

		// 1.create Pagable object
		// with the the help of Pagerequest.of()

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort); // 1st prefernec go to sort then pageging

		return repo.findAll(pageable);

	}

	@Override
	public List<Product> getProductsByXXX(Product p, Sort sort) {

		// 1.create Example object

		Example<Product> example = Example.of(p);

		return repo.findAll(example, sort);
	}

	@Override
	public Page<Product> getProductsByXXXPagging(Product p, Sort sort, int pageNo, int pageSize) {

		// using exsiting methods
		// Page<Product> productsByPage = this.getProductsByPage(pageNo, pageSize,
		// sort);

		// 1.create Pageble object
		Pageable pageable = PageRequest.of(pageNo-1, pageSize, sort);

		// 2.create Example
		Example<Product> ex = Example.of(p);
		
		return repo.findAll(ex, pageable);

	}

}
