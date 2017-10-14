package com.capgemini.asset.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.capgemini.asset.dao.AssetDAO;
import com.capgemini.asset.dao.AssetDAOImpl;
import com.capgemini.asset.dto.Asset;
import com.capgemini.asset.dto.AssetAllocation;
import com.capgemini.asset.dto.Employee;
import com.capgemini.asset.dto.RequestAsset;
import com.capgemini.asset.dto.User;
import com.capgemini.asset.dto.ViewStatus;
import com.capgemini.asset.exception.AssetManagementException;

public class AssetServiceImpl implements AssetService{

	AssetDAO dao;
	@Override
	public int managerLogin(Employee mgr) throws AssetManagementException {
		return 0;
	}

	public AssetServiceImpl() {
		dao=new AssetDAOImpl();
	}

	@Override
	public int addAsset(Asset asset) throws AssetManagementException {
		
		return dao.addAsset(asset);
	}

	@Override
	public int updateAssetDetails(String assname, String assetdes, int AssetId)
			throws AssetManagementException {
		return dao.updateAssetDetails(assname, assetdes, AssetId);
	}

	@Override
	public ArrayList<Asset> display() throws AssetManagementException {
		return dao.display();
	}
	@Override
	public boolean isValidName(String name) throws AssetManagementException{
		
		String patt = "[A-Z][a-z]{4,20}";
		boolean res = Pattern.matches(patt, name);
		
		return res;
	}

	@Override
	public boolean isValidPassword(String pass) throws AssetManagementException{
		
		String patt="[A-Z_a-z_0-9@]+{4,}";
		
		//String patt = "(?=.*[A-Z])(?=.*/d)(?=.*[a-z]).{4,}";
		boolean res = Pattern.matches(patt, pass);
	
		return res;
	}

	@Override
	public String validateInfo(User u) throws AssetManagementException {
		
		return dao.validateInfo(u);
	}

	@Override
	public int raiseAssetRequest(RequestAsset asset)
			throws AssetManagementException {
		return dao.raiseAssetRequest(asset);
	}

	@Override
	public int assetName(String assetName) throws AssetManagementException {
		
		return dao.assetName(assetName);
	}

	@Override
	public ArrayList<ViewStatus> getRequestDetails(int empno)throws AssetManagementException {
		// TODO Auto-generated method stub
		return dao.getRequestDetails(empno);
	}

	

	
	

}
