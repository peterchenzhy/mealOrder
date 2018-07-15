package cn.czy.mealOrderSystem.orderMeal.business;

import java.util.List;

public interface MealOrderStatisticsBusiness {

	public List mealOrderStatisticsForShow(String date);

	//定时任务，更新状态
	public void mealOrderStatisticsUpdateState();
	
	//定时任务，更新数量
	public void mealOrderStatisticsUpdateCount();
}
