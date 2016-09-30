package com.exam.products;

public enum ProductEnum {
	ult_small("Unlimited 1GB", 24.90), ult_medium("Unlimited 2GB", 29.90), ult_large("Unlimited 5GB",
			44.90), one_gb("1 GB Data-pack", 9.90);

	private String productName;
	private Double price = 0.00;

	public String GetProductName() {
		return this.productName;
	}

	public Double Getprice() {
		return this.price;
	}

	ProductEnum(String productName, Double price) {
		this.productName = productName;
		this.price = price;
	}

}
