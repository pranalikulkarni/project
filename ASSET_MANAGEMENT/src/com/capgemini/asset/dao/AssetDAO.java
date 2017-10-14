package com.capgemini.asset.dao;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.asset.dto.Asset;
import com.capgemini.asset.dto.AssetAllocation;
import com.capgemini.asset.dto.Employee;
import com.capgemini.asset.dto.RequestAsset;
import com.capgemini.asset.dto.User;
import com.capgemini.asset.dto.ViewStatus;
import com.capgemini.asset.exception.AssetManagementException;

public interface AssetDAO {
	public String validateInfo(User u) throws AssetManagementException;
		
	public ArrayList<Asset> display()throws AssetManagementException;
	public int addAsset(Asset asset)throws AssetManagementException;
	//public int modifyAsset(int qty,int assetId)throws AssetManagementException;

	int updateAssetDetails(String assname, String assetdes,int AssetId)
			throws AssetManagementException;
	
	public int raiseAssetRequest(RequestAsset asset) throws AssetManagementException;
	public int assetName(String assetName) throws AssetManagementException;
	public ArrayList<ViewStatus> getRequestDetails(int empno)throws AssetManagementException;
	

	/*public int checkAsset(int assetId, int empNo);

	public boolean checkQuantity(int assetId);

	public void insertIntoAsset_Allocation(AssetAllocation al, int requestId);

	public void decreaseQuantity(int i, int assetId);

	public boolean checkEmpNo(int in4);



	public boolean checkDeptId(String dName);

	public ArrayList<RequestAsset> getAllRequestRaised();*/
}

