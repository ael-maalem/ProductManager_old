package net.codejava.product.dao;

import java.io.IOException;
import java.util.List;

import net.codejava.product.model.Product;

public interface ProductDAO {
	
	public int save(Product product) throws IOException;
	
	public int update(Product product);
	
	public Product get(Integer id);
	
	public int delete(Integer id);
	
	public List<Product> list(); 

}
