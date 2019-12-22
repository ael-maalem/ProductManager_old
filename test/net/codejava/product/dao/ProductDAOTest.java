package net.codejava.product.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;

//Jsoup
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
//

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import net.codejava.product.dao.ProductDAO;
import net.codejava.product.dao.ProductDAOImpl;
import net.codejava.product.model.Product;

class ProductDAOTest {

	private DriverManagerDataSource datasource;
	private ProductDAO dao;
	private JdbcTemplate jdbcTemplate;

	@BeforeEach
	void setupBeforeEach() {
		datasource = new DriverManagerDataSource();

		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/product?autoReconnect=true&useSSL=false");
		datasource.setUsername("root");
		datasource.setPassword("ebaypaypal");

		dao = new ProductDAOImpl(datasource);
	}

//	void testSave() throws IOException {
//		Product contact = new Product("naser","naser98@gmail.com","kenitra","06023340");
//		int result = dao.save(contact);
//		
//		assertTrue( result > 0 );
//	}

	@Test
	void testSave() throws IOException {

		Product product = new Product(null, "n", "n", "n", "n", "n", "n", "n", "n");
		int result = dao.save(product);
		
		assertTrue( result > 0 );

	}
	// }

	@Test
	void testUpdate() {
		Product product = new Product(30, "n", "n", "n", "n", "n", "n", "n", "n");
		int result = dao.update(product);

		assertTrue(result > 0);
	}

	@Test
	void testGet() {
		Product product = dao.get(30);
		if (product != null) {
			System.out.println(product);
		}

		assertNotNull(product);
	}

	@Test
	void testDelete() {
		int result = dao.delete(50);
		assertTrue(result > 0);
	}

	@Test
	void testList() {
		List<Product> listContacts = dao.list();

		for (Product product : listContacts) {
			System.out.println(product);
		}

		assertTrue(!listContacts.isEmpty());
	}

}
