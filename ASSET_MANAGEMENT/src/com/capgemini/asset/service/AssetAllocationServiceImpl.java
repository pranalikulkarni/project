package com.capgemini.asset.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.capgemini.asset.dao.AssetAllocationDAO1Impl;
import com.capgemini.asset.dao.IAssetAllocationDAO1;
import com.capgemini.asset.dto.AcceptRejectRequest;
import com.capgemini.asset.dto.AssetAllocation;
import com.capgemini.asset.dto.RequestAsset;
import com.capgemini.asset.exception.AssetManagementException;


public class AssetAllocationServiceImpl implements IAssetAllocationService{

	IAssetAllocationDAO1 dao;
	public AssetAllocationServiceImpl() {
		dao  = new AssetAllocationDAO1Impl();
	}

	@Override
	public ArrayList<RequestAsset> getAllRequestRaised()throws AssetManagementException {
		
		return dao.getAllRequestRaised();
	}

	@Override
	public List<AcceptRejectRequest> getAcceptRejectRequest(int deptId)throws AssetManagementException {
		
		return dao.getAcceptRejectRequest(deptId);
	}

	@Override
	public int checkAsset(int assetId, int empId)throws AssetManagementException {
		
		try {
			return dao.checkAsset(assetId, empId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	

	@Override
	public Boolean checkQuantity(int assetId)throws AssetManagementException {
		
		return dao.checkQuantity(assetId);
	}

	@Override
	public void insertIntoAsset_Allocation(AssetAllocation a, int i)throws AssetManagementException {
		dao.insertIntoAsset_Allocation(a, i);
	}

	@Override
	public void decreaseQuantity(int qty, int assetID)throws AssetManagementException {
		
		dao.decreaseQuantity(qty, assetID);
	}

	@Override
	public Boolean checkEmpNo(int EmpNo) throws AssetManagementException{
		
		return dao.checkEmpNo(EmpNo);
	}

	@Override
	public Boolean isValidEmpNo(String EmpNo) throws AssetManagementException{
	String patt="[0-9]{6,}";
		
		
		boolean res = Pattern.matches(patt, EmpNo);
	
		return res;
		
	}

}
