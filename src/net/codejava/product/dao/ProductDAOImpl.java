package net.codejava.product.dao;

import java.io.IOException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.jdbc.core.RowMapper;

import net.codejava.product.model.Product;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

public class ProductDAOImpl implements ProductDAO {

	private JdbcTemplate jdbcTemplate;

	public ProductDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

//	@Override
//	public int save(Product contact) throws IOException {
//		
//		Document doc = Jsoup.connect("https://www.jumia.ma/").get();
//		
//		Elements elements = doc.getElementsByClass("name");
//		
//		for(Element element: elements) {
//			String sql = "INSERT INTO contact (name, email, address, phone) VALUES (?, ?, ?, ?)";
//			
//			jdbcTemplate.update(sql, element.text(), contact.getEmail(), 
//						contact.getAddress(), contact.getPhone());
//		}
//		return 1;
//	}
	@Override
	public int save(Product product) throws IOException {
		for (int y = 1; y < 6; y++) {
			int i = 1;
			String currentURL = "https://www.jumia.ma/telephones-smartphones/?shipped_from=country_local&sort=popularity&dir=desc&page="
					+ y;
			Document document = Jsoup.connect(currentURL).get();
			Elements body1 = document.select(".sku.-gallery");

			for (Element product1 : body1) {
				if (product1.select(".mabaya").attr("class").equals("hidden mabaya sku -gallery -hidden")) {
					continue;
				} else {

					System.out.println("Products scraped count : " + i + "\n\n");
					String img_url = product1.select("div.image-wrapper.default-state img").attr("data-src");
					System.out.println("GET URL : " + img_url + "\n");
					String brand = product1.select("h2.title span.brand").text();
					System.out.println("GET BRAND : " + brand + "\n");
					String name = product1.select("h2.title span.name").text();
					System.out.println("GET NAME : " + name + "\n");
					String sale = product1.select("div.price-container.clearfix span.sale-flag-percent").text();
					System.out.println("GET SALE : " + sale + "\n");
					String price = product1.select("div.price-container.clearfix span.price-box.ri span.price span")
							.attr("data-price");
					System.out.println("GET PRICE: " + price + "\n");
					String old_price = product1
							.select("div.price-container.clearfix span.price-box.ri span.price.-old span")
							.attr("data-price");
					System.out.println("GET OLD PRICE: " + old_price + "\n");
					String offer = product1.select("div.additional-offers").text();
					System.out.println("GET OFFER: " + offer + "\n");
					String total_rating = product1.select("div.rating-stars div.total-ratings").text();
					System.out.println("GET TOTAL RATINGS: " + total_rating + "\n");
					System.out.println("************************************************************ \n\n");

					String sql = "INSERT INTO product (name, brand, sale, price, old_price, offer, total_rating, img_url) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

					jdbcTemplate.update(sql, name, brand, sale, price, old_price, offer, total_rating, img_url);
					i++;
				}

			}
		}
		return 1;
	}

	@Override
	public int update(Product product) {
		String sql = "UPDATE product SET name=?,  brand=?, sale=?, price=? ,old_price=? ,offer=? ,total_rating=?, img_url=? " + "WHERE contact_id=?";
		return jdbcTemplate.update(sql, product.getName(), product.getBrand(), product.getSale(), product.getPrice(),product.getOld_price(), product.getOffer(), product.getTotal_rating(), product.getImg_url(),
				product.getId());
	}

	@Override
	public Product get(Integer id) {
		String sql = "SELECT * FROM product WHERE product_id=" + id;

		ResultSetExtractor<Product> extractor = new ResultSetExtractor<Product>() {

			@Override
			public Product extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					String name = rs.getString("name");
					String brand = rs.getString("brand");
					String sale = rs.getString("sale");
					String price = rs.getString("price");
					String old_price = rs.getString("old_price");
					String offer = rs.getString("offer");
					String total_rating = rs.getString("total_rating");
					String img_url = rs.getString("img_url");

					return new Product(id, name, brand, sale, price, old_price, offer, total_rating, img_url);
				}
				return null;
			}

		};

		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM product WHERE product_id=" + id;
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<Product> list() {
		String sql = "SELECT * FROM product";

		RowMapper<Product> rowMapper = new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("product_id");
				String name = rs.getString("name");
				String brand = rs.getString("brand");
				String sale = rs.getString("sale");
				String price = rs.getString("price");
				String old_price = rs.getString("old_price");
				String offer = rs.getString("offer");
				String total_rating = rs.getString("total_rating");
				String img_url = rs.getString("img_url");
				
				return new Product(id, name, brand, sale, price, old_price, offer, total_rating, img_url);
			}
		};

		return jdbcTemplate.query(sql, rowMapper);
	}

}
