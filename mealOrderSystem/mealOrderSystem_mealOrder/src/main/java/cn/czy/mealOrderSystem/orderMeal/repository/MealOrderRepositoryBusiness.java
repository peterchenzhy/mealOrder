package cn.czy.mealOrderSystem.orderMeal.repository;

import java.util.List;

import cn.czy.mealOrderSystem.base.model.OrderStatistics;
import cn.czy.mealOrderSystem.base.pojo.CreateNewMenuRequestBean;
import cn.czy.mealOrderSystem.base.pojo.MealOrderRequestBean;

public interface MealOrderRepositoryBusiness {

	// 插入订餐表
	public boolean insertMealOrder(List<MealOrderRequestBean> req);

	// 新建菜单
	public boolean createNewMenu(CreateNewMenuRequestBean request);

	// 当天订餐统计
	public List mealOrderStatisticsForShow(String date);

	// 获取可订餐页面列表(最近3天)
	public List getMealMenuList();

	// 获取date日订餐页面
	public List getMealMenuByDate(String date);
	
	//获取菜单信息meal_info
	public List getMealInfo();	
	
	//查询订餐订餐结果
	public List queryMealOrder(String date,String name);
	
	//查询统计信息 order_statistics
	public List queryOrderStatistics(String date,String endTime,boolean isUsed);
	
	//更新统计信息 order_statistics
	public int updateOrderStatistics(OrderStatistics os);
	
	//定时任务，统计更新数量金额
	public int mealOrderStatisticsUpdateCount(String date);
}
