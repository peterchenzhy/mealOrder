package cn.czy.mealOrderSystem.orderMeal.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.czy.mealOrderSystem.orderMeal.business.GetMealMenuListBusiness;
import cn.czy.mealOrderSystem.orderMeal.repository.MealOrderRepositoryBusiness;

@Service
public class GetMealMenuBusinessImpl implements GetMealMenuListBusiness {

	@Autowired
	private MealOrderRepositoryBusiness mealOrderRepositoryBusiness;

	@Override
	public List GetMealMenuList() {
		// TODO Auto-generated method stub
		return mealOrderRepositoryBusiness.getMealMenuList();
	}

}
