package cn.czy.mealOrderSystem.orderMeal.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.czy.mealOrderSystem.orderMeal.business.GetMealInfoBusiness;
import cn.czy.mealOrderSystem.orderMeal.repository.MealOrderRepositoryBusiness;
@Service
public class GetMealInfoBusinessImpl implements GetMealInfoBusiness{

	@Autowired
	private MealOrderRepositoryBusiness mealOrderRepositoryBusiness;
	@Override
	public List getMealInfo() {
		// TODO Auto-generated method stub
		return mealOrderRepositoryBusiness.getMealInfo();
	}

}
