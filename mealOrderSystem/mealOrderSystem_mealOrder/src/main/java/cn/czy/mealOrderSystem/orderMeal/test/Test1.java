package cn.czy.mealOrderSystem.orderMeal.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext("cn.czy.mealOrderSystem.orderMeal");
		TestMybatis testMybatis =(TestMybatis)context.getBean("TestMybatis");
		List x =testMybatis.getMealInfo();
		System.out.println(x);
	}

}
