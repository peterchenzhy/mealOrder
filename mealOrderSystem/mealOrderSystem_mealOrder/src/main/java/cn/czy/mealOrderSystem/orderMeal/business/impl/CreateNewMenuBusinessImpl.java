package cn.czy.mealOrderSystem.orderMeal.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.czy.mealOrderSystem.base.pojo.CreateNewMenuRequestBean;
import cn.czy.mealOrderSystem.orderMeal.business.CreateNewMenuBusiness;
import cn.czy.mealOrderSystem.orderMeal.repository.MealOrderRepositoryBusiness;

@Service
public class CreateNewMenuBusinessImpl implements CreateNewMenuBusiness {

	@Autowired
	private MealOrderRepositoryBusiness repository;

	@Override
	public boolean createNewMenu(CreateNewMenuRequestBean request) {
		// TODO Auto-generated method stub
		return repository.createNewMenu(request);
	}

}
