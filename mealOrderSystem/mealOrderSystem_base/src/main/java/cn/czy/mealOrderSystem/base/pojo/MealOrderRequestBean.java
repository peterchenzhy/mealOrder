package cn.czy.mealOrderSystem.base.pojo;

public class MealOrderRequestBean {

	// 菜品
	private String mealName;
	// 学生姓名
	private String stuName;
	// 份数
	private int quantity;
	// date
	private String date;
	// eat_time
	private String eatTime;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getMealName() {
		return mealName;
	}

	public void setMealName(String mealName) {
		this.mealName = mealName;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getEatTime() {
		return eatTime;
	}

	public void setEatTime(String eatTime) {
		this.eatTime = eatTime;
	}
}
