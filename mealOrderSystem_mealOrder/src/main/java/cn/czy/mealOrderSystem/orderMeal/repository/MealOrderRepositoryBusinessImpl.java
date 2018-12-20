package cn.czy.mealOrderSystem.orderMeal.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.czy.mealOrderSystem.base.model.OrderStatistics;
import cn.czy.mealOrderSystem.base.pojo.CreateNewMenuRequestBean;
import cn.czy.mealOrderSystem.base.pojo.MealOrderRequestBean;
import cn.czy.mealOrderSystem.orderMeal.mapper.DaoMapper;

@Repository
public class MealOrderRepositoryBusinessImpl implements MealOrderRepositoryBusiness {

	@Autowired
	private DaoMapper daoMapper;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	@Transactional
	public boolean insertMealOrder(List<MealOrderRequestBean> req) {
		System.out.println("in repository...");
		int count = 0;
		for (MealOrderRequestBean request : req) {
			count = 0;
			String sql = "insert into meal_order values(?,?,?,?,?)";// date,stu_name,meal,quantity,eat_time
			count = jdbcTemplate.update(sql, new Object[] { request.getDate().trim(), request.getStuName().trim(),
					request.getMealName().trim(), request.getQuantity(), request.getEatTime() });
		}
		if (count > 0)
			return true;
		else
			return false;
	}

	@Override
	@Transactional
	public boolean createNewMenu(CreateNewMenuRequestBean request) {
		boolean rtn = false;
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append("delete from meal_menu where date=?");
		jdbcTemplate.update(sql.toString(), new Object[] { request.getDate() });

		sql = new StringBuilder();
		sql.append("delete from order_statistics where date=?");
		jdbcTemplate.update(sql.toString(), new Object[] { request.getDate() });
		
		sql = new StringBuilder();
		sql.append("delete from meal_order where date=?");
		jdbcTemplate.update(sql.toString(), new Object[] { request.getDate() });

		sql = new StringBuilder();
		sql.append("insert into meal_menu select ");
		sql.append("'" + request.getDate() + "',");
		sql.append(" mi.meal,mi.producer,mi.price from meal_info mi ");
		sql.append("where ");
		List<String> mealList = request.getMealNames();
		int length = mealList.size();
		if (length > 0) {
			for (int i = 0; i < length; i++) {
				sql.append("mi.meal='" + mealList.get(i).trim() + "'");
				if (i + 1 < length) {
					sql.append(" or ");
				}
			}
		}
		sql.append(" order by mi.meal,mi.producer");
		System.out.println(sql.toString());
		int count = jdbcTemplate.update(sql.toString());
		if (count > 0) {
			rtn = true;
		}

		sql = new StringBuilder();
		sql.append("insert into order_statistics (date,endtime,enddate)values (?,?,?)");
		count = 0;
		count = jdbcTemplate.update(sql.toString(),
				new Object[] { request.getDate(), request.getEndtime(), request.getEndDate() });
		if (count > 0)
			rtn = true;
		else
			rtn = false;

		return rtn;
	}

	private List<String> getmeals(List mealNames) {
		List<String> mealList = new ArrayList<String>();

		for (Object meal : mealNames) {
			Map mealmap = (Map) meal;
			mealList.add(mealmap.get("meal").toString().trim());
		}
		return mealList;
	}

	@Override
	@Transactional
	public List mealOrderStatisticsForShow(String date) {
		StringBuilder sql = new StringBuilder();
		sql.append(
				"select  mo.stu_name,mo.meal,mo.eat_time,mi.price, mo.quantity " + "from meal_order  mo, meal_info mi  "
						+ " where mo.date =? and mi.meal =mo.meal  " + " order by mo.stu_name,mo.meal,mo.eat_time ");
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql.toString(), new Object[] { date });
		return list;
	}

	@Override
	public List getMealMenuList() {
		StringBuilder sql = new StringBuilder();
		sql.append("select  date  from order_statistics where is_used = true order by date desc  limit 0 ,3");
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql.toString());
		return list;
	}

	@Override
	public List getMealMenuByDate(String date) {
		StringBuilder sql = new StringBuilder();
		sql.append("select  mm.date, mm.meal, mm.producer, mm.price " + "from meal_menu mm ,order_statistics os  "
				+ "where mm.date=? and os.date = mm.date and os.is_used =true order by mm.meal,mm.producer");
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql.toString(), new Object[] { date });
		return list;
	}

	@Override
	public List getMealInfo() {
		StringBuilder sql = new StringBuilder();
		sql.append("select producer,meal,price from meal_info order by producer");
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql.toString());
		return list;
	}

	@Override
	public List queryMealOrder(String date, String name) {
		List list = daoMapper.queryMealOrder(date, name);
		return list;
	}

	@Override
	public List queryOrderStatistics(String date,String endTime,boolean isUsed) {
		List list = daoMapper.queryOrderStatistics( date, endTime,isUsed);
		return list;
	}

	//暂时实现 个更新used 状态
	@Override
	public int updateOrderStatistics(OrderStatistics os) {
		int num =daoMapper.updateOrderStatistics(os);
		return num;
	}

	//定时任务 更新金额 数量
	@Override
	public int mealOrderStatisticsUpdateCount(String date) {
		// TODO Auto-generated method stub
		int num =daoMapper.mealOrderStatisticsUpdateCount(date);
		return num;
	}

}
