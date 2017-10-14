package com.capgemini.asset.dto;

import java.time.LocalDate;

public class ViewStatus 
{	
	
	int empno;
	int allocationId;
	LocalDate allocationDate;
	public int getAllocationId() {
		return allocationId;
	}
	public void setAllocationId(int allocationId) {
		this.allocationId = allocationId;
	}
	public LocalDate getAllocationDate() {
		return allocationDate;
	}
	public void setAllocationDate(LocalDate allocationDate) {
		this.allocationDate = allocationDate;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getAssetId() {
		return assetId;
	}
	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}
	public String getAssetName() {
		return assetName;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	public String getAssetDes() {
		return assetDes;
	}
	public void setAssetDes(String assetDes) {
		this.assetDes = assetDes;
	}
	public String getStatus() {
		return status;
	}
	@Override
	public String toString() {
		return "ViewStatus [empno=" + empno + ", allocationId=" + allocationId
				+ ", allocationDate=" + allocationDate + ", empName=" + empName
				+ ", assetId=" + assetId + ", assetName=" + assetName
				+ ", assetDes=" + assetDes + ", status=" + status + "]";
	}
	public void setStatus(String status) {
		this.status = status;
	}
	String empName;
	int assetId;
	String assetName;
	String assetDes;
	String status;
	

}
