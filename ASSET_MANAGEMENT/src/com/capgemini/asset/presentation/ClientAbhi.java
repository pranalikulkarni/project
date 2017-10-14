package com.capgemini.asset.presentation;

	import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.asset.dao.AssetAllocationDAO1Impl;
import com.capgemini.asset.dto.Asset;
import com.capgemini.asset.dto.AssetAllocation;
import com.capgemini.asset.dto.RequestAsset;
import com.capgemini.asset.dto.User;
import com.capgemini.asset.dto.ViewStatus;
import com.capgemini.asset.exception.AssetManagementException;
import com.capgemini.asset.service.AssetAllocationServiceImpl;
import com.capgemini.asset.service.AssetService;
import com.capgemini.asset.service.AssetServiceImpl;
import com.capgemini.asset.service.IAssetAllocationService;

public class ClientAbhi {

	
	public void loginDetails() {
		
		ClientEkata ce = new ClientEkata();
		IAssetAllocationService ser = new AssetAllocationServiceImpl();
		Scanner sc = new Scanner(System.in);
		AssetService service  = new AssetServiceImpl();
		User user = new User();
		String ch3 = null;
		do
		{
			System.out.println("Select User Type");
			System.out.println("1. Manager");
			System.out.println("2. Admin");
			int ch = sc.nextInt();
			
			switch (ch) {
			case 1:
				String choiceselect;
					do{
						System.out.println("Enter User Name");
						String name = sc.next();
						user.setUserType("manager");
						boolean res;
						try {
							res = service.isValidName(name);
							if(res==true)
							{
								user.setUserName(name);
								break;
							}
							else
								System.out.println("Enter Valid Name");
						} catch (AssetManagementException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}while(true);
					do{
						System.out.println("Enter Password");
						String pass = sc.next();
						boolean res;
						try {
							res = service.isValidPassword(pass);
							if(res==true)
							{
								user.setUserPassword(pass);
								break;
							}
							else
								System.out.println("Password should contain one uppercase,one lowercase,one digit and one special character");
						} catch (AssetManagementException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
					}while(true);
						
					try {
						String id = service.validateInfo(user);
						if(id!=null)
						{
							String ch4;
							do
							{
								String empId;
								RequestAsset rqAsset = new RequestAsset();
								System.out.println("1. Raise a request for allocation of asset to an employee");
								System.out.println("2. View status of the request");
								int choice = sc.nextInt();
								switch(choice)
								{
									case 1:
										do
										{
											System.out.println("Enter employee ID");
											 empId = sc.next();
											boolean res=ser.isValidEmpNo(empId);
											boolean r1=ser.checkEmpNo(Integer.parseInt(empId));
											if(res)
											{
												if(r1)
												
												rqAsset.setEmpNo(Integer.parseInt(empId));	
												break;
											}
											else
											{
												System.out.println("Employee Id should be of 6 digits.");
											}
										}while(true);
										System.out.println("Enter Asset name");
										String assetName = sc.next();
										int r2=ser.checkAsset(service.assetName(assetName),Integer.parseInt(empId));
										if(r2>0)
										{
											System.out.println("already allocated..");
											break;
										}
										
										
										System.out.println("Enter request for asset date in dd-MM-yyyy format");
										String mydate=sc.next();
										DateTimeFormatter drf=DateTimeFormatter.ofPattern("dd-MM-yyyy");
										rqAsset.setAllocaDate(LocalDate.parse(mydate,drf));
										int requestAllocationId = service.raiseAssetRequest(rqAsset);
										System.out.println(requestAllocationId);
										//LocalDate myDate = LocalDate.parse(date.toString());
										int assetId = service.assetName(assetName);
										rqAsset.setAssetId(assetId);
										break;
									case 2:
										do
										{
											System.out.println("Enter Employee Id:");
											String empno=sc.next();
											boolean res1 = ser.isValidEmpNo(empno);
											
											if(res1)
											{
												ArrayList<ViewStatus> list=service.getRequestDetails(Integer.parseInt(empno));
												ArrayList<RequestAsset> list1=ser.getAllRequestRaised();
												System.out.println("Status of asset allocation:\n");
												System.out.println("Allocation Id\tEmp.No\tEmp.Name  Asset Id  Asset Name  Asset Details Allocation Date  Status\n");
												for(ViewStatus v:list)
												{
													System.out.println(v.getAllocationId()+"    \t    "+v.getEmpno()+" \t "+v.getEmpName()+"\t "+v.getAssetId()+" \t  "+v.getAssetName()+"\t   "+v.getAssetDes()+"\t   "+v.getAllocationDate()+" \t"+"allocated"+"\n");
												}
												
												
												
												System.out.println("Request Id Asset Id   Emp No.\t  Allocation Date Status \n");
												for(RequestAsset r:list1)
												{
													System.out.println(r.getRequestId()+"    \t    "+r.getAssetId()+" \t "+r.getEmpNo()+" \t "+r.getAllocaDate()+" \t"+"request in progress"+"\n");
												}
												break;
											}
											else
												System.out.println("Employee Id should be of 6 digits.");
											
										}while(true);
										break;
										
								}
								System.out.println("Do you want to continue as manager?(yes/no)");
								ch4 = sc.next();
							}while(ch4.equalsIgnoreCase("yes"));
							//AssetAllocation asset = new AssetAllocation();
							
						}
					} catch (AssetManagementException e1) {
						
						e1.printStackTrace();
					}
					break;
			case 2:
				
					do{
						System.out.println("Enter User Name");
						user.setUserType("admin");
						String name = sc.next();
						boolean res;
						try {
							res = service.isValidName(name);
							if(res==true)
							{
								user.setUserName(name);
								break;
							}
							else
								System.out.println("Enter Valid Name");
						} catch (AssetManagementException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}while(true);
					do{
						System.out.println("Enter Password");
						String pass = sc.next();
						boolean res;
						try {
							res = service.isValidPassword(pass);
							if(res==true)
							{
								user.setUserPassword(pass);
								break;
							}
							else
								System.out.println("Password should contain one uppercase,one lowercase,one digit and one special character");
						} catch (AssetManagementException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}while(true);
					try {
						String id = service.validateInfo(user);
						if(id!=null)
						{
							AssetAllocation asset = new AssetAllocation();
							do
							{
											System.out.println("1.Do you wish to add/Modify assets? ");
											System.out.println("2.View all request raised. ");
											System.out.println("3.Approve or reject raised requests");
											System.out.println("4.Exit.");
											
											int op1=sc.nextInt();
											
										switch(op1)
										{
										
										case 1:
												System.out.println("1.add asset\n 2.modify asset\n");
												System.out.println("Select Option");
												int op2=sc.nextInt();
												switch(op2)
												{
												case 1:
													try {
															service.display();
															Asset asset1=new Asset();
															System.out.println("Enter new asset details:");
															System.out.println("Enter asset name:");
															String asname=sc.next();
															asset1.setAssetName(asname);
															
															System.out.println("Enter asset des:");
															String asdes=sc.next();
															asset1.setAssetDes(asdes);
															
															System.out.println("Enter asset quant:");
															int asq=sc.nextInt();
															asset1.setQuantity(asq);
															
															System.out.println("Enter asset status:");
															String asst=sc.next();
															asset1.setStatus(asst);
															
																try
																{
																	int assetid=service.addAsset(asset1);
																	System.out.println("Asset details inserted:"+assetid);
																}
																catch(AssetManagementException e)
																{
																	System.out.println(e.getMessage());
																}
															break;
															
														
													} catch (AssetManagementException e1) {
														// TODO Auto-generated catch block
														e1.printStackTrace();
													}
													
														break;
												case 2:
													
														try {
																List<Asset>list=service.display();
																for(Asset as:list)
																{
																	System.out.println(as);
																}
																System.out.println("Enter asset name:");
																String assetname=sc.next();
																System.out.println("Enter asset description:");
																String assetdes=sc.next();
																System.out.println("Enter asset Id you want to modify:");
																int assetId=sc.nextInt();
																
																service.updateAssetDetails(assetname, assetdes, assetId);
																System.out.println("Asset details updated successfully..");
															} 
														catch (AssetManagementException e) {
																// TODO Auto-generated catch block
																e.printStackTrace();
															}
														break;
												}
												break;
										case 2:
											ce.forADmin2();
											break;
											
										
										case 3:
											
											ce.forAdmin3();
											break;
											
										case 4:
											System.out.println("You have logged out successfully");
											System.exit(0);
											
										}
										System.out.println("Do u want to continue?(yes/no):");
										choiceselect=sc.next();
							}while(choiceselect.equalsIgnoreCase("yes"));
						}
					} catch (AssetManagementException e1) {
						
						e1.printStackTrace();
					}
					break;
			
			default:
				break;
			}
			System.out.println("Do u want to login again?(yes/no):");
			ch3=sc.next();
		}while(ch3.equalsIgnoreCase("yes"));
		
	}
}
	



	
			
			

