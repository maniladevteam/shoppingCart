package com.exam.cart;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.exam.products.ProductEnum;

public class Cart {
	private BigInteger pricingScheme = new BigInteger("0");
	public final HashMap<ProductEnum, Integer> items = new HashMap<>();
	private boolean promoCode = false;
	public BigDecimal total = new BigDecimal("0.00");
	public Cart(String pricingScheme) {
		this.pricingScheme = new BigInteger(pricingScheme);
	}

	private BigDecimal ApplyDiscount(ProductEnum productCode, int numberOfItems) {
		Double newTotal = 0d;
		Double small_discount = 0d;
		Double large_discount = 0d;
		
		if (productCode.equals(ProductEnum.ult_small) && numberOfItems > 2) {
			small_discount = small_discount - productCode.Getprice();
			
		}

		if (productCode.equals(ProductEnum.ult_large) && numberOfItems > 3) {
			large_discount  =  large_discount - productCode.Getprice();
		}
		
		newTotal = (productCode.Getprice() * numberOfItems) - (large_discount-small_discount);
		
		return new BigDecimal(newTotal.toString()).setScale(2,2);
		
	}

	private void SetTotalValue(BigDecimal total){
		this.total = total;
	}

	public BigDecimal GetTotalValue(){
		return this.total;
	}
	
	public void Add(ProductEnum product) {
		items.put(product, getQuantity(product) + 1);

	}

	public void Add(ProductEnum product, String promoCode) {
		if (!promoCode.equals("I<3AMAYSIM")) {
			throw new RuntimeException(promoCode + " is not a valid promocode!!");
		}
		this.promoCode = true;
		this.Add(product);

	}

	public int getQuantity(ProductEnum product) {

		return items.getOrDefault(product, 0);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (ProductEnum product : items.keySet()) {
		
			
			sb.append(items.get(product) + " x " + product + " "
					+ System.getProperty("line.separator"));
			this.total = total.add(new BigDecimal(ApplyDiscount(product, items.get(product)).toString()));
		}
		return sb.toString();
		
	}

}
