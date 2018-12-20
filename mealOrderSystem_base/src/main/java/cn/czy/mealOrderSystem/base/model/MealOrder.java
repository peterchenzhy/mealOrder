package cn.czy.mealOrderSystem.base.model;

import java.io.Serializable;

public class MealOrder implements Serializable {

	private String date;
	private String stuName;
	private String meal;
	private int quantity;
	private String eatTime;

	public String getDate() {
		return date;
	}

	public String getStuName() {
		return stuName;
	}

	public String getMeal() {
		return meal;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getEatTime() {
		return eatTime;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setEatTime(String eatTime) {
		this.eatTime = eatTime;
	}
}
