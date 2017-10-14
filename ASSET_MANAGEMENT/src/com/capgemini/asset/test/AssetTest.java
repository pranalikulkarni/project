package com.capgemini.asset.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.asset.dao.AssetAllocationDAO1Impl;
import com.capgemini.asset.dao.AssetDAO;
import com.capgemini.asset.dao.AssetDAOImpl;
import com.capgemini.asset.dao.IAssetAllocationDAO1;
import com.capgemini.asset.dto.Asset;
import com.capgemini.asset.dto.RequestAsset;
import com.capgemini.asset.exception.AssetManagementException;


public class AssetTest {

	IAssetAllocationDAO1 dao;
	AssetDAO dao1;
	@Before
	public void createObject() {
		
		dao = new AssetAllocationDAO1Impl();
		dao1 = new AssetDAOImpl();
	}
	
	@Test
	public void testChecKAsset()
	{
		//AssetAllocation assetAlloc = new AssetAllocation();
		
		try {
			
			int id = dao.checkAsset(207,133637);
			Assert.assertTrue((id>0));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void testRaiseRequest()
	{
		RequestAsset reqAsset = new RequestAsset();
		reqAsset.setAssetId(204);
		reqAsset.setEmpNo(133377);
		String date = "13-08-2017";
		DateTimeFormatter drf=DateTimeFormatter.ofPattern("dd-MM-yyyy");
		reqAsset.setAllocaDate(LocalDate.parse(date,drf));
		
		try {
			int id = dao1.raiseAssetRequest(reqAsset);
			Assert.assertTrue((id>0));
		} catch (AssetManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testAddAsset()
	{
		Asset asse = new Asset();
		asse.setAssetId(209);
		asse.setAssetName("abcd");
		asse.setAssetDes("asdsad");
		asse.setQuantity(10);
		asse.setStatus("unallocated");
		try {
			int aid = dao1.addAsset(asse);
			Assert.assertTrue((aid>0));
		} catch (AssetManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
