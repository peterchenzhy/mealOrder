package cn.czy.mealOrderSystem.orderMeal.business;

import java.util.List;

import cn.czy.mealOrderSystem.base.pojo.CreateNewMenuRequestBean;

public interface CreateNewMenuBusiness {

//创建菜单
	public boolean createNewMenu(CreateNewMenuRequestBean request);
}
