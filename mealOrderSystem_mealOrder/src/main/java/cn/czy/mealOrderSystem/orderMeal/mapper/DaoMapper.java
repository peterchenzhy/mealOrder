package cn.czy.mealOrderSystem.orderMeal.mapper;

import cn.czy.mealOrderSystem.base.model.MealInfo;
import cn.czy.mealOrderSystem.base.model.MealOrder;
import cn.czy.mealOrderSystem.base.model.OrderStatistics;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface DaoMapper {

	public List<MealInfo> findMealInfo();

	public List<MealOrder> queryMealOrder(@Param("date") String date, @Param("name") String name);

	public List<OrderStatistics> queryOrderStatistics(@Param("date") String date, @Param("endTime") String endTime,
			@Param("isUsed") boolean isUsed);

	public int updateOrderStatistics(@Param("os") OrderStatistics os);

	public int mealOrderStatisticsUpdateCount(@Param("date") String date);

}
