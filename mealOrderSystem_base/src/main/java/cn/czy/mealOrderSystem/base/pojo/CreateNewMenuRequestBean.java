package cn.czy.mealOrderSystem.base.pojo;

import java.util.List;

public class CreateNewMenuRequestBean {

	private String date;

	private List mealNames;

	private String endTime;

	private String endDate;

	public String getDate() {
		return date;
	}

	public List getMealNames() {
		return mealNames;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setMealNames(List mealName) {
		this.mealNames = mealName;
	}

	public String getEndtime() {
		return endTime;
	}

	public void setEndtime(String time) {
		this.endTime = time;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}
