package cn.czy.mealOrderSystem.orderMeal.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.czy.mealOrderSystem.orderMeal.business.GetMealMenuByDateBusiness;
import cn.czy.mealOrderSystem.orderMeal.repository.MealOrderRepositoryBusiness;

@Service
public class GetMealMenuByDateBusinessImpl implements GetMealMenuByDateBusiness {

	@Autowired
	private MealOrderRepositoryBusiness mealOrderRepositoryBusiness;

	@Override
	public List getMealMenuByDate(String date) {

		return mealOrderRepositoryBusiness.getMealMenuByDate(date);
	}

}
