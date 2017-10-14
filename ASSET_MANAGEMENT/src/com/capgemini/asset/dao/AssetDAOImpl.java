package com.capgemini.asset.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;






import java.util.List;

import org.apache.log4j.Logger;

import com.capgemini.asset.dto.Asset;
import com.capgemini.asset.dto.AssetAllocation;
import com.capgemini.asset.dto.RequestAsset;
import com.capgemini.asset.dto.User;
import com.capgemini.asset.dto.ViewStatus;
import com.capgemini.asset.exception.AssetManagementException;
import com.capgemini.asset.utility.DatabaseConnection;

public class AssetDAOImpl implements AssetDAO{
	Logger logger=Logger.getLogger(AssetDAOImpl.class);
	@Override
	public String validateInfo(User u) throws AssetManagementException {
		
		String id = null;
		try {
			
			Connection con = DatabaseConnection.getConnection();
			String validQuerry = "select userid from user_master where username=? and userpassword=? and usertype=?";
			PreparedStatement pst = con.prepareStatement(validQuerry);
			pst.setString(1, u.getUserName());
			pst.setString(2, u.getUserPassword());
			pst.setString(3, u.getUserType());
			ResultSet rs = pst.executeQuery();
			
			if(rs.next())
			{
				id = rs.getString("userid");
			}
			else
			{
			throw new AssetManagementException("invalid user details");
			}
		}
		catch(SQLException e)
		{
			
			throw new AssetManagementException(e.getMessage());
		}
		return id;
	}

	@Override
	public int updateAssetDetails(String assname,String assetdes,int AssetId)
			throws AssetManagementException {
		try
		{			
			Connection con=DatabaseConnection.getConnection();
			String updateQuery="update asset set assetname=?,assetdes=? where assetid=?";
			PreparedStatement ps=con.prepareStatement(updateQuery);
			ps.setString(1,assname);
			ps.setString(2,assetdes);
			ps.setInt(3, AssetId);
			int rows=ps.executeUpdate();
			if(rows==1)
			{
				return rows;
			}
			else
			{
			throw new AssetManagementException("failed to update assets");
			}
		}
		catch(SQLException e)
		{
			
			throw new AssetManagementException(e.getMessage());
		}
	}

	@Override
	public int addAsset(Asset asset) throws AssetManagementException {
		try{
			
			Connection con=DatabaseConnection.getConnection();
			String insertquery="insert into Asset values(assetId_seq.nextval,?,?,?,?)";
			PreparedStatement ps;
			ps=con.prepareStatement(insertquery);
			ps.setString(1, asset.getAssetName());
			ps.setString(2, asset.getAssetDes());
			ps.setInt(3, asset.getQuantity());
			ps.setString(4, asset.getStatus());
			
			int row=ps.executeUpdate();
			if(row==1)
			{			
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select assetId_seq.currval from dual");
				if(rs.next())
				{
					int assetid=rs.getInt(1);
				
					return assetid;
				}				
			}		
			else
			throw new AssetManagementException("Error while Adding record");	
		}
		catch(SQLException e)
		{		
				throw new AssetManagementException(e.getMessage());
		}
		return 0;
	}

	@Override
	public ArrayList<Asset> display() throws AssetManagementException {
		ArrayList<Asset> list=new ArrayList<>();
		try
		{
			Connection con=DatabaseConnection.getConnection();
			String selectQuery="select assetid,assetname,assetdes,quantity,status from asset";
		Statement st=con.createStatement();
		
			
			ResultSet rs=st.executeQuery(selectQuery);
			while(rs.next())
			{
				Asset as=new Asset();
				as.setAssetId(rs.getInt("assetid"));
				as.setAssetName(rs.getString("assetname"));
				as.setAssetDes(rs.getString("assetdes"));
				as.setQuantity(rs.getInt("quantity"));
				as.setStatus(rs.getString("status"));				
				list.add(as);
				//return list;
			}
		}
		catch(SQLException e)
		{
			logger.error(e.getMessage());
			throw new AssetManagementException(e.getMessage());
		}
			
	return list;
	}

	@Override
	public int raiseAssetRequest(RequestAsset asset)
			throws AssetManagementException {
		int id = 0;
		try {
			Connection con = DatabaseConnection.getConnection();
			String querry = "insert into request_table values (requestseq.nextval,?,?,?)";
			PreparedStatement pst1 = con.prepareStatement(querry);
			
			
			
			
			 
			 
			pst1.setInt(1, asset.getAssetId());
			pst1.setInt(2, asset.getEmpNo());
			pst1.setDate(3, Date.valueOf(asset.getAllocaDate()));
			
			int r = pst1.executeUpdate();
			if(r>0)
			{
				String s = "select requestseq.currval from dual";
				Statement st = con.createStatement();
				ResultSet rs1 = st.executeQuery(s);
				
				if(rs1.next())
				{
					id = rs1.getInt(1);
					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
		
	}

	@Override
	public int assetName(String assetName) throws AssetManagementException {
		
		int assetId = 0;
		try {
			Connection con = DatabaseConnection.getConnection();
			String query = "select assetid from asset where assetname = ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, assetName);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next())
			{
				assetId = rs.getInt("assetid");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return assetId;
	}	
	
	
	
	
	
	@Override
	public ArrayList<ViewStatus> getRequestDetails(int empno)throws AssetManagementException
	{
	Connection con=null;
		
		Logger logger=Logger.getLogger(Asset.class);
			
			//Statement st;
			ArrayList<ViewStatus>list=new ArrayList<ViewStatus>();
			
				try {
					con = DatabaseConnection.getConnection();
					
					String selectQuery="select e.empno,e.ename,a.assetId,a.assetName,a.assetDes,a.quantity,a.status,al.allocationId,al.allocation_date  from Asset a,Employee1 e,Asset_Allocation al where (a.assetId=al.assetId) and (e.empno=al.empno) and al.empno=?";
					PreparedStatement ps=con.prepareStatement(selectQuery);
					ps.setInt(1, empno);
					
						ResultSet rs= ps.executeQuery();
						/*Asset bean=new Asset();
						Employee bean1=new Employee();*/
						
						ViewStatus record =new ViewStatus();
						
					while(rs.next())
					{
						record.setEmpno(empno);
						record.setEmpName(rs.getString("ename"));
						record.setAllocationId(rs.getInt("allocationId"));
						record.setAllocationDate(rs.getDate("allocation_date").toLocalDate());
						record.setAssetId(rs.getInt("assetId"));
						record.setAssetName(rs.getString("assetName"));
						record.setAssetDes(rs.getString("assetDes"));
					//	bean.setQuantity(rs.getInt("quantity"));
						record.setStatus(rs.getString("status"));
						list.add(record);
						
						//return list;
					}
					
					if(list.size()==0)
					{
						System.out.println("No request raised for this employee..");
					}
					else
					{
					
					/*for(ViewStatus a:list)
					{
						
						System.out.println(a.getAllocationId()+"    \t    "+a.getEmpno()+" \t "+a.getEmpName()+"\t "+a.getAssetId()+" \t  "+a.getAssetName()+"\t   "+a.getAssetDes()+"\t   "+a.getAllocationDate()+" \t"+"allocated"+"\n");
					}*/
					}
					logger.info(list.size()+"records displayed");
				} 
				catch (Exception e) {
					logger.error(e.getMessage());
					e.printStackTrace();
				}
				return list;
	}
	

}

