package com.universalcrackers.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.universalcrackers.model.CartItem;
import com.universalcrackers.service.CrackerService;

@Controller
@RequestMapping("/")
public class UniversalCrackersController
{

	@Autowired
	private CrackerService crackerService;
	
	private static ObjectMapper objectMapper;
	
	static{
		objectMapper = new ObjectMapper();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getIndex()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("categories", crackerService.getCategories().getResponseObject());
		mv.setViewName("view");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET,value ="/home")
	public ModelAndView getHome()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("categories", crackerService.getCategories().getResponseObject());
		mv.setViewName("view");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST,value ="/cart")
	public ModelAndView getCart(HttpServletRequest servletRequest)
	{
		ModelAndView mv = new ModelAndView();
		try{
			if(true){
				List<CartItem> cartItemsList = objectMapper.readValue(servletRequest.getParameter("cartItems"),
						objectMapper.getTypeFactory().constructCollectionType(List.class, CartItem.class));
				mv.addObject("cartItems", cartItemsList);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		mv.setViewName("cart");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET,value ="/checkout")
	public ModelAndView getCheckout()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("checkout");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET,value ="/placeOrder")
	public ModelAndView placeOrder()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("orderConfirmation");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET,value ="/backToHome")
	public ModelAndView backToHome()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("categories", crackerService.getCategories().getResponseObject());
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET,value ="/productList")
	public ModelAndView productList(@RequestParam("categories")String categories)
	{
		ModelAndView mv = new ModelAndView();
		if(!StringUtils.isEmpty(categories)){
			String[] categoriesStr = categories.split(",");
			List<Long> categoriesList = new ArrayList<Long>();
			for(String categoryStr : categoriesStr){
				categoriesList.add(new Long(categoryStr));
			}
			mv.addObject("products", crackerService.getProductList(categoriesList).getResponseObject());
		}
		mv.setViewName("products");
		return mv;
	}
}