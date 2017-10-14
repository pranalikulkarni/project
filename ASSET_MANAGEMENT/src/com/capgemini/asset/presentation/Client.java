package com.capgemini.asset.presentation;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.PropertyConfigurator;

import com.capgemini.asset.dto.Asset;
import com.capgemini.asset.dto.AssetAllocation;
import com.capgemini.asset.dto.Employee;
import com.capgemini.asset.dto.User;
import com.capgemini.asset.exception.AssetManagementException;
import com.capgemini.asset.service.AssetService;
import com.capgemini.asset.service.AssetServiceImpl;
public class Client {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		PropertyConfigurator.configure("./resource/log4j.properties");
		
		/*AssetService service =new AssetServiceImpl();*/
		
		Asset ast=new Asset();
		Employee emp=new Employee();
		User user=new User();
			
		System.out.println("------Menu-------");
		System.out.println("1.Login");
		//System.out.println("2.View Asset Details");
		System.out.println("2.exit");
		System.out.println("Select Option");
		int op=sc.nextInt();
		switch(op)
		{
		case 1:
				ClientAbhi clien = new ClientAbhi();
				clien.loginDetails();
			break;
			
			
		case 2:
			System.exit(0);
			break;
		}

	}

	}

