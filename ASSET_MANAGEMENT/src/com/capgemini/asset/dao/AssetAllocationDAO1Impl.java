package com.capgemini.asset.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.capgemini.asset.dto.AcceptRejectRequest;
import com.capgemini.asset.dto.Asset;
import com.capgemini.asset.dto.AssetAllocation;
import com.capgemini.asset.dto.Employee;
import com.capgemini.asset.dto.RequestAsset;
import com.capgemini.asset.exception.AssetManagementException;
import com.capgemini.asset.utility.DatabaseConnection;


public class AssetAllocationDAO1Impl implements IAssetAllocationDAO1{

	@Override
	public int checkAsset(int assetId, int empId) throws AssetManagementException {
		
		Connection conn;
		int row = 0;
		try {
			conn = DatabaseConnection.getConnection();
		
		//String checkAsset="select mgr from Employee1";
		String checkAsset1="select assetid,empno from asset_allocation where assetid=? and empno=?";
		PreparedStatement ps=conn.prepareStatement(checkAsset1);
		ps.setInt(1, assetId);
		ps.setInt(2, empId);
		//PreparedStatement ps1=conn.prepareStatement(checkAsset1);
		Asset a1=new Asset();
		
		
		 ResultSet rs= ps.executeQuery();
		if(rs.next())
			{
				row=rs.getInt(1);
			}
		

		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}
	
	Boolean row;
	@Override
	public Boolean checkEmpNo(int EmpNo) {
		
		Connection conn;
		try {
			conn = DatabaseConnection.getConnection();
		
		//String checkAsset="select mgr from Employee1";
		String checkAsset1="select empno from employee1 where empno=?";
		PreparedStatement ps=conn.prepareStatement(checkAsset1);
		ps.setInt(1, EmpNo);
		//PreparedStatement ps1=conn.prepareStatement(checkAsset1);
		Employee e1=new Employee();
		
		
	ResultSet rs= ps.executeQuery();
		
		if(!rs.isBeforeFirst())
		{
			row=false;
			
		}
		else if(rs.next())
		{
			row=true;
			e1.setEmpId(EmpNo);
			return row;
			//System.out.println("Invalid department id.");
		}
		
		

		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}



	

	@Override
	public Boolean checkQuantity(int assetId) {
		

		try {
			Connection con = DatabaseConnection.getConnection();
			String query = "select quantity from asset where assetid=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, assetId);
			ResultSet rs  = pst.executeQuery();
			while(rs.next())
			{
				
				if(rs.getInt(1)>0)
				{
					return true;
				}
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void decreaseQuantity(int qty, int assetID) {
		
		int r = 0;
		try {
			Connection con = DatabaseConnection.getConnection();
			String query = "update asset set quantity = quantity - ? where assetid=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, qty);
			pst.setInt(2, assetID);
			r = pst.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void insertIntoAsset_Allocation(AssetAllocation a, int i) {
		
		Connection conn;
		try {
			conn = DatabaseConnection.getConnection();
			String checkAsset2="delete from request_table where requestid=? ";
		//String checkAsset="select mgr from Employee1";
		String checkAsset1="insert into asset_allocation values(allocationId_seq.nextval,?,?,?,?)";
		
		
		PreparedStatement ps=conn.prepareStatement(checkAsset1);
		ps.setInt(1, a.getAssetId());
		ps.setInt(2, a.getEmpNo());
		ps.setDate(3, Date.valueOf(a.getAllocationDate()));
		ps.setDate(4, Date.valueOf(a.getAllocationDate().plusDays(10)));
		//PreparedStatement ps1=conn.prepareStatement(checkAsset1);
		AssetAllocation al1=new AssetAllocation();
		
		
	int row= ps.executeUpdate();
	PreparedStatement ps1=conn.prepareStatement(checkAsset2);
	ps1.setInt(1, i);
		int row2=ps1.executeUpdate();
		//decreaseQuantity(qty, a.getAssetId());
	if(row==1 && row2==1)
	{
		Statement st=conn.createStatement();
		
		
		ResultSet rs=st.executeQuery("select allocationId_seq.currval from dual");
		if(rs.next())
		{
			int cid=rs.getInt(1);
			System.out.println("Your Request Has Been Approved "); 
			System.out.println("Your Allocation Id is - "+cid);
		}
		
	}
		
		

		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<RequestAsset> getAllRequestRaised() {
		
		Logger logger=Logger.getLogger(Asset.class);
		ArrayList<RequestAsset> list_1 = new ArrayList<RequestAsset>();

	try {
		Connection conn = DatabaseConnection.getConnection();
		String selectQuery="select requestid,assetid,empno,Allocation_Date from request_table";
		PreparedStatement ps=conn.prepareStatement(selectQuery);
		
		ResultSet rs= ps.executeQuery();
		
		while(rs.next())
		{
			 RequestAsset bean=new RequestAsset();
				
			bean.setRequestId(rs.getInt("requestid"));
			bean.setAssetId(rs.getInt("assetid"));
			bean.setEmpNo(rs.getInt("empno"));
			bean.setAllocaDate(rs.getDate("Allocation_Date").toLocalDate());
			
			list_1.add(bean);
			
		}
		logger.info(list_1.size()+"records displayed");
	}
	catch (Exception e) {
		logger.error(e.getMessage());
		e.printStackTrace();
	}
	return list_1;
	}

	@Override
	public List<AcceptRejectRequest> getAcceptRejectRequest(int deptId) {
		
		Logger logger=Logger.getLogger(Asset.class);
		ArrayList<AcceptRejectRequest>list_3 = new ArrayList<AcceptRejectRequest>();
		
		try
		{
			Connection conn = DatabaseConnection.getConnection();
			String selectQuery="select e.ename,e.mgr,d.dept_id,d.dept_name,a.assetid,e.empno,a.assetname,a.assetdes,a.status from department1 d,employee1 e,asset a,asset_allocation al where (d.dept_id=e.dept_id) and (a.assetid=al.assetid) and (e.empno=al.empno) and d.dept_id=?";
			PreparedStatement ps=conn.prepareStatement(selectQuery);
			ps.setInt(1, deptId);
			
			ResultSet rs= ps.executeQuery();
			
			
			while(rs.next())
			{
				AcceptRejectRequest bean=new AcceptRejectRequest();
				bean.setEmpName(rs.getString("ename"));
				bean.setMgr(rs.getInt("mgr"));
				bean.setDeptId(rs.getInt("dept_id"));
				bean.setDept_Name(rs.getString("dept_name"));
				bean.setAssetId(rs.getInt("assetid"));
				bean.setEmpNo(rs.getInt("empno"));
				bean.setAssetName(rs.getString("assetname"));
				bean.setAssetDes(rs.getString("assetdes"));
				bean.setStatus(rs.getString("status"));
			
				list_3.add(bean);
				
			}
			logger.info(list_3.size()+"records displayed");
		}
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		
		
		return list_3;
	}





	

}
