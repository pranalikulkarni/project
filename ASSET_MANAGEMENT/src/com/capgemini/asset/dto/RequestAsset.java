package com.capgemini.asset.dto;

import java.time.LocalDate;

public class RequestAsset {

	private int requestId;
	private int assetId;
	private int empNo;
	private LocalDate allocaDate;
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public int getAssetId() {
		return assetId;
	}
	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public LocalDate getAllocaDate() {
		return allocaDate;
	}
	public void setAllocaDate(LocalDate allocaDate) {
		this.allocaDate = allocaDate;
	}
	
	
}
