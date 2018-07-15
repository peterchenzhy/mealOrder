package cn.czy.mealOrderSystem.orderMeal.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cn.czy.mealOrderSystem.base.constant.Constants;
import cn.czy.mealOrderSystem.base.pojo.CreateNewMenuRequestBean;
import cn.czy.mealOrderSystem.base.pojo.MealOrderRequestBean;
import cn.czy.mealOrderSystem.orderMeal.business.CreateNewMenuBusiness;
import cn.czy.mealOrderSystem.orderMeal.business.GetMealInfoBusiness;
import cn.czy.mealOrderSystem.orderMeal.business.GetMealMenuByDateBusiness;
import cn.czy.mealOrderSystem.orderMeal.business.GetMealMenuListBusiness;
import cn.czy.mealOrderSystem.orderMeal.business.MealOrderBusiness;
import cn.czy.mealOrderSystem.orderMeal.business.MealOrderStatisticsBusiness;
import cn.czy.mealOrderSystem.orderMeal.util.DownloadExcel;

@RestController
public class OrderMealController {

	@Autowired
	private MealOrderBusiness mealOrderBusiness;
	@Autowired
	private CreateNewMenuBusiness createNewMenuBusiness;
	@Autowired
	private MealOrderStatisticsBusiness mealOrderStatistics;
	@Autowired
	private GetMealMenuListBusiness getMealMenuListBusiness;
	@Autowired
	private GetMealMenuByDateBusiness getMealMenuByDateBusiness;
	@Autowired
	private GetMealInfoBusiness getMealInfoBusiness;

	// 订餐
	@RequestMapping(value = "/mealOrderSystem/mealOrder/", method = RequestMethod.POST)
	public List mealOrder(@RequestBody Map<String, Object> request) {
		System.out.println(request);
		List list = (List) request.get("orderData");
		List<MealOrderRequestBean> reqList = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			Map m = (Map) list.get(i);
			MealOrderRequestBean e = new MealOrderRequestBean();
			e.setDate(m.get("date").toString().trim());
			e.setEatTime(m.get("eatTime").toString().trim());
			e.setMealName(m.get("mealName").toString().trim());
			e.setQuantity(Integer.parseInt(m.get("quantity").toString().trim()));
			e.setStuName(m.get("stuName").toString().trim());
			reqList.add(e);
		}

		if (!reqList.isEmpty()) {
			if (mealOrderBusiness.mealOrder(reqList))
				// 提交订单后，查询结果返回页面
				return mealOrderBusiness.queryMealOrder(reqList.get(0).getDate(), reqList.get(0).getStuName());
		}
		return null;
	}

	// 生成统计信息
	@ResponseBody
	@RequestMapping(value = "/mealOrderSystem/mealOrderStatistics/", method = RequestMethod.POST)
	public List mealOrderStatistics(@RequestBody Map<String, Object> request) {
		String date = request.get("date").toString().trim();
		String download = request.get("download").toString().trim();
		System.out.println(date);
		System.out.println(download);
		if (!checkDate(date)) {
			return null;
		}
		List rtnList = mealOrderStatistics.mealOrderStatisticsForShow(date);
		System.out.println(rtnList);
		return rtnList;
	}

	// 下载统计信息
	@ResponseBody
	@RequestMapping(value = "/mealOrderSystem/mealOrderStatistics/", method = RequestMethod.GET)
	public List downloaddmealOrderStatistics(@RequestParam Map<String, Object> request, HttpServletResponse response) {
		String date = request.get("date").toString().trim();
		String download = request.get("download").toString().trim();
		System.out.println(date);
		System.out.println(download);
		if (!checkDate(date)) {
			return null;
		}
		List rtnList = mealOrderStatistics.mealOrderStatisticsForShow(date);
		System.out.println(rtnList);
		if (download.equals("true")) {
			DownloadExcel.downloadExcel(rtnList, date, response);
			return null;
		} else {
			return rtnList;
		}

	}

	// 生成当日订餐目录
	@RequestMapping(value = "/mealOrderSystem/createNewMenu/", method = RequestMethod.POST)
	public String createNewMenu(@RequestBody Map<String, Object> request) {
		System.out.println(request);
		List meals = new ArrayList<>();
		CreateNewMenuRequestBean req = new CreateNewMenuRequestBean();
		List list = (List) request.get("orderData");
		for (int i = 0; i < list.size(); i++) {
			Map m = (Map) list.get(i);
			meals.add(m.get("meal").toString().trim());
			if (i == 0) {
				req.setDate(m.get("date").toString().trim());
				req.setEndtime(m.get("endTime").toString().trim());
				req.setEndDate(m.get("endDate").toString().trim());
			}
		}
		req.setMealNames(meals);
		if (!checkDate(req.getDate()) || req.getMealNames().size() == 0) {
			return Constants.FAIL;
		} else {
			System.out.println("check passed");
			if (createNewMenuBusiness.createNewMenu(req))
				return Constants.SUCCESS;
			else
				return Constants.FAIL;
		}
	}

	// 获取可订餐页面列表(最近3天)
	@RequestMapping(value = "/mealOrderSystem/getMealMenuList/", method = RequestMethod.GET)
	public ModelAndView getMealMenu() {
		List list = getMealMenuListBusiness.GetMealMenuList();
		System.out.println(list);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("menuList");
		mav.addObject("list", list);
		return mav;
	}

	// 获取date日订餐页面
	@RequestMapping(value = "/mealOrderSystem/getMealMenuByDate/", method = RequestMethod.POST)
	public List getMealMenuByDate(@RequestBody Map<String, Object> request) {
		String date = request.get("date") == null ? null : request.get("date").toString().trim();
		if (date == null) {
			return null;
		}
		List rtnList = getMealMenuByDateBusiness.getMealMenuByDate(date);
		System.out.println(rtnList);
		return rtnList;
	}

	// 前往创建菜单页面
	@RequestMapping(value = "/mealOrderSystem/goCreateMenu/", method = RequestMethod.GET)
	public ModelAndView goCreateMenu() {
		List rtnList = getMealInfoBusiness.getMealInfo();
		System.out.println(rtnList);
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", rtnList);
		mav.setViewName("createMenu");
		return mav;
	}

	// 主页
	@RequestMapping(value = "/mealOrderSystem/welcome", method = RequestMethod.GET)
	public ModelAndView mealOrder() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("welcome");
		return mav;
	}

	@Autowired
	private MealOrderStatisticsBusiness t; // only for test
	// 主页

	@RequestMapping(value = "/mealOrderSystem/test/test", method = RequestMethod.GET)
	public void os() {
		t.mealOrderStatisticsUpdateState();
	}

	// 管理页面
	@RequestMapping(value = "/mealOrderSystem/manager", method = RequestMethod.GET)
	public ModelAndView manager() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("manager");
		return mav;
	}

	// checkdate
	private boolean checkDate(String date) {
		String datetmp = date.trim();
		if (datetmp.length() != 8) {
			return false;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		sdf.setLenient(false);
		try {
			sdf.parse(datetmp);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			return false;
		}

		return true;
	}
}
