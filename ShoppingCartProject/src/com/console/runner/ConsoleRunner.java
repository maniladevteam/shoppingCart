package com.console.runner;

import com.exam.cart.Cart;
import com.exam.products.ProductEnum;

public class ConsoleRunner {

	public static void main(String[] args) {
		Cart cart = new Cart("10");
		cart.Add(ProductEnum.ult_small);
		cart.Add(ProductEnum.ult_small);
		cart.Add(ProductEnum.ult_small);
		cart.Add(ProductEnum.ult_large);
		System.out.println(cart);
		System.out.println(cart.total);
		System.out.println(cart.items);
		
	}

}
