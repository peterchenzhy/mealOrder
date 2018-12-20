package cn.czy.mealOrderSystem.orderMeal.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

public class DownloadExcel {

	public static void downloadExcel(List list, String date, HttpServletResponse response) {

		// 设置表头
		List<String> headList = new ArrayList<String>();
		headList.add("姓名");
		headList.add("餐名");
		headList.add("时间");
		headList.add("单价");
		headList.add("数量");

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet(date + "统计表");
		createHead(workbook, sheet, headList);
		// filename
		String fileName = "订餐统计表" + date;

		// 设置日期格式
		HSSFCellStyle style = workbook.createCellStyle();
		style.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));

		// 新增数据行，并且设置单元格数据
		int rowNum = 1;
		for (int i = 0; i < list.size(); i++) {
			Map map = (Map) list.get(i);
			HSSFRow row = sheet.createRow(rowNum);
			row.createCell(0).setCellValue(map.get("stu_name").toString());
			row.createCell(1).setCellValue(map.get("meal").toString());
			row.createCell(2).setCellValue(map.get("eat_time").toString());
			row.createCell(3).setCellValue(map.get("price").toString());
			row.createCell(4).setCellValue(map.get("quantity").toString());
			rowNum++;
		}

		// 设置response参数，可以打开下载页面
		try {
			response.setContentType("application/octet-stream");
			//response.setHeader("Content-disposition", "attachment;filename=" + (fileName + ".xls"));
response.setHeader("Content-Disposition", "attachment;fileName="+ new String((fileName+".xls").getBytes("GB2312"),"ISO-8859-1")); 
			response.flushBuffer();
			workbook.write(response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 创建表头
	private static void createHead(HSSFWorkbook workbook, HSSFSheet sheet, List headList) {

		HSSFRow row = sheet.createRow(0);
		// 设置为居中加粗
		HSSFCellStyle style = workbook.createCellStyle();
		HSSFFont font = workbook.createFont();
		font.setBold(true);
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setFont(font);

		HSSFCell cell;
		for (int i = 0; i < headList.size(); i++) {
			cell = row.createCell(i);
			cell.setCellValue(headList.get(i).toString());
			cell.setCellStyle(style);
		}

	}
}
