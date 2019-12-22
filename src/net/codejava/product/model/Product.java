package net.codejava.product.model;

public class Product {

	private Integer id;
	private String name;
	private String brand;
	private String sale;
	private String price;
	private String old_price;
	private String offer;
	private String total_rating;
	private String img_url;
	

	
	
	public Product(Integer id, String name, String brand, String sale, String price, String old_price, String offer,
			String total_rating, String img_url) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.sale = sale;
		this.price = price;
		this.old_price = old_price;
		this.offer = offer;
		this.total_rating = total_rating;
		this.img_url = img_url;
	}

	

	public Product(String name, String brand, String sale, String price, String old_price, String offer,
			String total_rating, String img_url) {
		super();
		this.name = name;
		this.brand = brand;
		this.sale = sale;
		this.price = price;
		this.old_price = old_price;
		this.offer = offer;
		this.total_rating = total_rating;
		this.img_url = img_url;
	}

	

	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getBrand() {
		return brand;
	}



	public void setBrand(String brand) {
		this.brand = brand;
	}



	public String getSale() {
		return sale;
	}



	public void setSale(String sale) {
		this.sale = sale;
	}



	public String getPrice() {
		return price;
	}



	public void setPrice(String price) {
		this.price = price;
	}



	public String getOld_price() {
		return old_price;
	}



	public void setOld_price(String old_price) {
		this.old_price = old_price;
	}



	public String getOffer() {
		return offer;
	}



	public void setOffer(String offer) {
		this.offer = offer;
	}



	public String getTotal_rating() {
		return total_rating;
	}



	public void setTotal_rating(String total_rating) {
		this.total_rating = total_rating;
	}



	public String getImg_url() {
		return img_url;
	}



	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}



	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", brand=" + brand + ", sale=" + sale + ", price=" + price +", total_rating="+ total_rating
				+ "]";
	}
	
	

}
