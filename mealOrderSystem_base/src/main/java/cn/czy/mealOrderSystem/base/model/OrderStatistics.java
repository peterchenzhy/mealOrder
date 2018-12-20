package cn.czy.mealOrderSystem.base.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderStatistics implements Serializable {
	private String date;
	private String endTime;
	private BigDecimal totalAmount;
	private int totalCount;
	private int noonCount;
	private int eveCount;
	private boolean isUsed;
	private String endDate;
	private boolean isStatistical;

	public String getDate() {
		return date;
	}

	public String getEndTime() {
		return endTime;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getNoonCount() {
		return noonCount;
	}

	public int getEveCount() {
		return eveCount;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public void setNoonCount(int noonCount) {
		this.noonCount = noonCount;
	}

	public void setEveCount(int eveCount) {
		this.eveCount = eveCount;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public boolean isStatistical() {
		return isStatistical;
	}

	public void setStatistical(boolean isStatistical) {
		this.isStatistical = isStatistical;
	}
}
