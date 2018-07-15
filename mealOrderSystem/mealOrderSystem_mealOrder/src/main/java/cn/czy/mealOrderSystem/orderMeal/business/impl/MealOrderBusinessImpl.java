package cn.czy.mealOrderSystem.orderMeal.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.czy.mealOrderSystem.base.pojo.MealOrderRequestBean;
import cn.czy.mealOrderSystem.orderMeal.business.MealOrderBusiness;
import cn.czy.mealOrderSystem.orderMeal.repository.MealOrderRepositoryBusiness;

@Service
public class MealOrderBusinessImpl implements MealOrderBusiness {

	@Autowired
	private MealOrderRepositoryBusiness repository;

	@Override
	public boolean mealOrder(List<MealOrderRequestBean> request) {
		return repository.insertMealOrder(request);
	}

	@Override
	public List queryMealOrder(String date, String name) {
		// TODO Auto-generated method stub
		return repository.queryMealOrder(date,name);
	}

}
