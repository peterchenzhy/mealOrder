package cn.czy.mealOrderSystem.orderMeal.business;

import java.util.List;

import cn.czy.mealOrderSystem.base.pojo.MealOrderRequestBean;

public interface MealOrderBusiness {

	//订餐
	public boolean mealOrder(List<MealOrderRequestBean> request);
	
	//查询订餐订餐结果
	public List queryMealOrder(String date,String name);
}
