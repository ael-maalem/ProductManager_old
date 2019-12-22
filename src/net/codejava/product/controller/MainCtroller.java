package net.codejava.product.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.product.dao.ProductDAO;
import net.codejava.product.model.Product;

@Controller
public class MainCtroller {
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value = "/")
	public ModelAndView listProduct(ModelAndView model){
	    List<Product> listProduct = productDAO.list();
	    model.addObject("listProduct", listProduct);
	    model.setViewName("index");
	 
	    return model;
	}

}
