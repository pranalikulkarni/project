package com.capgemini.asset.dto;

public class AcceptRejectRequest 
{
	//Attributes From Employee Table
	
	private String empName;
	private int mgr;
	
	//Attributes From Department Table
	private int deptId;                
	private String Dept_Name;			
	
	//Attributes from Asset_Allocation Table
	private int AssetId;
	private int EmpNo;
	
	//Attributes from Asset Table
	private String assetName;
	private String assetDes;
	private String status;
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDept_Name() {
		return Dept_Name;
	}
	public void setDept_Name(String dept_Name) {
		Dept_Name = dept_Name;
	}
	public int getAssetId() {
		return AssetId;
	}
	public void setAssetId(int assetId) {
		AssetId = assetId;
	}
	public int getEmpNo() {
		return EmpNo;
	}
	public void setEmpNo(int empNo) {
		EmpNo = empNo;
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
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "AcceptRejectRequest [empName=" + empName + ", mgr=" + mgr
				+ ", deptId=" + deptId + ", Dept_Name=" + Dept_Name
				+ ", AssetId=" + AssetId + ", EmpNo=" + EmpNo + ", assetName="
				+ assetName + ", assetDes=" + assetDes + ", status=" + status
				+ "]";
	}
	
	
}
