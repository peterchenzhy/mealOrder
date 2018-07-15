package cn.czy.mealOrderSystem.orderMeal.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.czy.mealOrderSystem.base.model.OrderStatistics;
import cn.czy.mealOrderSystem.base.util.CommonUtil;
import cn.czy.mealOrderSystem.orderMeal.business.MealOrderStatisticsBusiness;
import cn.czy.mealOrderSystem.orderMeal.repository.MealOrderRepositoryBusiness;

@Service
public class MealOrderStatisticsBusinessImpl implements MealOrderStatisticsBusiness {
	@Autowired
	private MealOrderRepositoryBusiness mealOrderRepositoryBusiness;

	@Override
	public List mealOrderStatisticsForShow(String date) {
		// TODO Auto-generated method stub
		return mealOrderRepositoryBusiness.mealOrderStatisticsForShow(date);
	}

	@Override
	public void mealOrderStatisticsUpdateState() {
		//获取当前时间
		String now = CommonUtil.getNowHHmm();
		String day =CommonUtil.getNowyyyyMMdd();
		List list = mealOrderRepositoryBusiness.queryOrderStatistics(day, now,true);
		if(!list.isEmpty()) {
			for(int i = 0 ;i<list.size();i++) {
				OrderStatistics os = (OrderStatistics) list.get(i);
				//更新数据
				os.setUsed(false);
				mealOrderRepositoryBusiness.updateOrderStatistics(os);
			}
		}
		
	}

	@Override
	public void mealOrderStatisticsUpdateCount() {
		//查找当天is_used标志位false的数据进行统计
		String day =CommonUtil.getNowyyyyMMdd();
		mealOrderRepositoryBusiness.mealOrderStatisticsUpdateCount(day);
	}

}
