package cn.czy.mealOrderSystem.orderMeal.test;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.czy.mealOrderSystem.base.model.MealInfo;
import cn.czy.mealOrderSystem.orderMeal.mapper.TestXmlMapper;

@Service(value="TestMybatis")
public class TestMybatis {

	@Resource
	private TestXmlMapper testXmlMapper;
	
	public List<MealInfo> getMealInfo() {
		//return testXmlMapper.findMealInfo();
		return null;
	}

}
