package com.capgemini.asset.dao;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.asset.dto.AcceptRejectRequest;
import com.capgemini.asset.dto.AssetAllocation;
import com.capgemini.asset.dto.RequestAsset;
import com.capgemini.asset.dto.ViewStatus;
import com.capgemini.asset.exception.AssetManagementException;

public interface IAssetAllocationDAO1 {
	
	public int checkAsset(int assetId,int empId) throws Exception;
	
	public Boolean checkEmpNo(int EmpNo);
	
	
	
	public Boolean checkQuantity(int assetId)throws AssetManagementException;
	
	public void decreaseQuantity(int qty,int assetID)throws AssetManagementException;
	public void insertIntoAsset_Allocation(AssetAllocation a, int i)throws AssetManagementException;
	public ArrayList<RequestAsset> getAllRequestRaised()throws AssetManagementException;

	public List<AcceptRejectRequest> getAcceptRejectRequest(int deptId)throws AssetManagementException;
}

