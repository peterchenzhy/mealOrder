package cn.czy.mealOrderSystem.orderMeal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.czy.mealOrderSystem.base.model.MealInfo;
import cn.czy.mealOrderSystem.base.model.MealOrder;
import cn.czy.mealOrderSystem.base.model.OrderStatistics;
@Mapper
public interface DaoMapper {

	public List<MealInfo> findMealInfo();

	public List<MealOrder> queryMealOrder(@Param("date") String date, @Param("name") String name);

	public List queryOrderStatistics(@Param("date") String date, @Param("endTime") String endTime,
			@Param("isUsed") boolean isUsed);

	public int updateOrderStatistics(@Param("os") OrderStatistics os);

	public int mealOrderStatisticsUpdateCount(@Param("date") String date);

}
