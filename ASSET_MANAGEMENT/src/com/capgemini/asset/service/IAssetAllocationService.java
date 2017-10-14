package com.capgemini.asset.service;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.asset.dto.AcceptRejectRequest;
import com.capgemini.asset.dto.AssetAllocation;
import com.capgemini.asset.dto.RequestAsset;
import com.capgemini.asset.dto.ViewStatus;
import com.capgemini.asset.exception.AssetManagementException;

public interface IAssetAllocationService {
	public ArrayList<RequestAsset> getAllRequestRaised()throws AssetManagementException;
	public List<AcceptRejectRequest> getAcceptRejectRequest(int deptId)throws AssetManagementException;
	
	public int checkAsset(int assetId,int empId)throws AssetManagementException;
	
	public Boolean checkEmpNo(int EmpNo)throws AssetManagementException;
	public Boolean checkQuantity(int assetId)throws AssetManagementException;
	
	public void insertIntoAsset_Allocation(AssetAllocation a, int i)throws AssetManagementException;
	public void decreaseQuantity(int qty,int assetID)throws AssetManagementException;	
	
	public Boolean isValidEmpNo(String EmpNo) throws AssetManagementException;
}
