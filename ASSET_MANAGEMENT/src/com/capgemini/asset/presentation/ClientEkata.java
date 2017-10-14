package com.capgemini.asset.presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.asset.dto.AssetAllocation;
import com.capgemini.asset.dto.RequestAsset;
import com.capgemini.asset.exception.AssetManagementException;
import com.capgemini.asset.service.AssetAllocationServiceImpl;
import com.capgemini.asset.service.IAssetAllocationService;

public class ClientEkata {

	IAssetAllocationService service;
	public ClientEkata()
	{
		service = new AssetAllocationServiceImpl();
	}
	
	public void forADmin2() throws AssetManagementException
	{
		ArrayList<RequestAsset> AllAsset = service.getAllRequestRaised();
		System.out.println("Request Id Asset Id   Emp No.\t  Allocation Date  \n");
		for(RequestAsset a:AllAsset)
		{
			System.out.println(a.getRequestId()+"    \t    "+a.getAssetId()+" \t "+a.getEmpNo()+" \t "+a.getAllocaDate()+"\n");
		}
	}
	
	public void forAdmin3() throws AssetManagementException
	{
		String shoice;
		do
		{
			boolean flag1;
			Scanner sc = new Scanner(System.in);
			List<RequestAsset> reqAsset = service.getAllRequestRaised();
				//System.out.println("Request Id Asset Id Emp No.\tAllocation Date \n");
				for(RequestAsset a:reqAsset)
				{
					System.out.println(a.getRequestId()+"    \t    "+a.getAssetId()+" \t "+a.getEmpNo()+" \t "+a.getAllocaDate()+"\n");
				}
				do
					{
						System.out.println("Enter employee id for approve/reject request:\n");
						String in4=sc.next();
						boolean fg1=service.isValidEmpNo(in4);
						if(fg1)
						{
							flag1= service.checkEmpNo(Integer.parseInt(in4));
							break;
						}
						else
							System.out.println("Enter Valid employee id");
					}while(true);
				if(flag1)
				{
					
						System.out.println("1.Approve request \n 2.Reject request");
						int ch1=sc.nextInt();
						
						switch (ch1) 
						{
							case 1:
								
								
								
								for(RequestAsset a:reqAsset)
								{
												AssetAllocation al=new AssetAllocation();
												int f1=service.checkAsset(a.getAssetId(),a.getEmpNo());
												boolean fg=service.checkQuantity(a.getAssetId());
												if(fg)
												{
													
												
													if(f1!=a.getAssetId())
					
													{
														al.setAssetId(a.getAssetId());
														al.setEmpNo(a.getEmpNo());
													
														al.setAllocationDate(a.getAllocaDate());
														service.insertIntoAsset_Allocation(al,a.getRequestId());
														service.decreaseQuantity(1, a.getAssetId());
														System.out.println("request approved..");
														break;
													}
													else
													{
														System.out.println("already allocated asset..");
																
													}
												}
								}
								
								break;
								
							case 2:
								System.out.println("request rejected..");
								break;
							default:
								System.out.println("invalid choice..");
								break;
						}//switch
					
				}//out if
				else
					System.out.println("Employee ID does not exist in the table.");
				System.out.println("Do you wish to enter employee id again(yes/no)");
				shoice = sc.next();
		}while(shoice.equalsIgnoreCase("yes"));
		
		
	}//function
}//class
	

			
		
		


