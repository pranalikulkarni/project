package com.capgemini.asset.service;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.asset.dto.Asset;
import com.capgemini.asset.dto.AssetAllocation;
import com.capgemini.asset.dto.Employee;
import com.capgemini.asset.dto.RequestAsset;
import com.capgemini.asset.dto.User;
import com.capgemini.asset.dto.ViewStatus;
import com.capgemini.asset.exception.AssetManagementException;

public interface AssetService {
	public int managerLogin(Employee mgr) throws AssetManagementException;
	
	public ArrayList<Asset> display()throws AssetManagementException;
	public int addAsset(Asset asset)throws AssetManagementException;
	
	public int updateAssetDetails(String assname, String assetdes,int AssetId)
			throws AssetManagementException;
	public boolean isValidName(String name) throws AssetManagementException;
	public boolean isValidPassword(String pass) throws AssetManagementException;
	
	public String validateInfo(User u) throws AssetManagementException;
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
