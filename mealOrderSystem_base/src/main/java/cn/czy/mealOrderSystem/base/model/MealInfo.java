package cn.czy.mealOrderSystem.base.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class MealInfo implements Serializable{

	private String meal;
	
	private String producer ;
	
	private BigDecimal price ;

	public String getMeal() {
		return meal;
	}

	public String getProducer() {
		return producer;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
}
