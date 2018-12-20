package cn.czy.mealOrderSystem.base.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtil {

	public static String getNowHHmm() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		String time = sdf.format(new Date());
		return time;
	}

	public static String getNowyyyyMMdd() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String time = sdf.format(new Date());
		return time;
	}

	public static void main(String[] args) {
		System.out.println(getNowHHmm());
	}

	public static String getNowyyyyMMddHHmmss() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String time = sdf.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
		return time;
	}
}
