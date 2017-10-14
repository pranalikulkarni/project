package com.capgemini.asset.dto;

import java.time.LocalDate;

public class AssetAllocation {

	private int assetAllcationId;
	private int assetId;
	private int empNo;
	private LocalDate allocationDate;
	private LocalDate releaseDate;
	
	public int getAssetAllcationId() {
		return assetAllcationId;
	}
	public void setAssetAllcationId(int assetAllcationId) {
		this.assetAllcationId = assetAllcationId;
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
	public LocalDate getAllocationDate() {
		return allocationDate;
	}
	public void setAllocationDate(LocalDate allocationDate) {
		this.allocationDate = allocationDate;
	}
	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	
}
