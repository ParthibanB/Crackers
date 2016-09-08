package com.universalcrackers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.universalcrackers.service.CrackerService;

@Controller
@RequestMapping("/")
public class UniversalCrackersController
{

	@Autowired
	private CrackerService crackerService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getIndex()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("view");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET,value ="/home")
	public ModelAndView getHome()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("view");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET,value ="/cart")
	public ModelAndView getCart()
	{
		ModelAndView mv = new ModelAndView();
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
		mv.setViewName("home");
		return mv;
	}
}