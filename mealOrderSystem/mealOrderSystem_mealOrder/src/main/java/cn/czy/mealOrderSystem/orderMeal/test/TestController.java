package cn.czy.mealOrderSystem.orderMeal.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.czy.mealOrderSystem.orderMeal.business.MealOrderBusiness;
import cn.czy.mealOrderSystem.orderMeal.repository.MealOrderRepositoryBusiness;

@RestController
public class TestController {
	
//	@Autowired
//	private TestMybatis testMybatis;
	@Autowired
	private MealOrderBusiness mealOrderBusiness;

	@ResponseBody
	@RequestMapping( value = "/mealOrderSystem/t/", method = RequestMethod.GET)
	public List getMenuInfo() {
		 List list= mealOrderBusiness.queryMealOrder("20180707", "wangda");
		 System.out.println(list);
		 return list;
	}
}
