package com.log.simple;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class simplelog1 {

	public static void main(String[] args) {
		
		List<String> mainList = new ArrayList<>();
		// TODO Auto-generated method stub
		String fPath = "D:\\Work\\LTMS\\Maintaince\\Logs\\LTMS_Logs_05_05_2022_08_00_01\\31_LTMSCommDecodeLog_04_05_2022.txt";
		
		List<String> data = readFileIntoList(fPath);
		
		
		List<String> stringNotValidDT = new ArrayList<>();
		List<String> sqlDtimeOverflow = new ArrayList<>();
		List<String> cannotOpenDB = new ArrayList<>();
		List<String> loginFiledUser = new ArrayList<>();
		List<String> ipNotCorrFrmt = new ArrayList<>();
		List<String> inVldObjName = new ArrayList<>();
		List<String> timeOutExp = new ArrayList<>();
		List<String> remaining = new ArrayList<>();
		
		for (var item : data) {
			if (item.contains("String was not recognized as a valid DateTime")) {
				stringNotValidDT.add(item);
			} else if (item.contains("SqlDateTime overflow. Must be between 1/1/1753 12:00:00 AM")) {
				sqlDtimeOverflow.add(item);
			} 
			else if (item.contains("Cannot open database")) {
				cannotOpenDB.add(item);
			} 
			else if (item.contains("Login failed for user")) {
				loginFiledUser.add(item);
			} 
			else if (item.contains("Input string was not in a correct format")) {
				ipNotCorrFrmt.add(item);
			} 
			else if (item.contains("Invalid object name")) {
				inVldObjName.add(item);
			} 
			else if (item.contains("Timeout expired.  The timeout period elapsed prior to completion of the operation or the server is not responding")) {
				timeOutExp.add(item);
			} 
			else {
				remaining.add(item);
				System.out.println(item + "\n");
			}
			mainList.addAll(stringNotValidDT);
			mainList.addAll(sqlDtimeOverflow);
			mainList.addAll(cannotOpenDB);
			mainList.addAll(loginFiledUser);
			mainList.addAll(ipNotCorrFrmt);
			mainList.addAll(inVldObjName);
			mainList.addAll(timeOutExp);
			mainList.addAll(remaining);
		}
		//System.out.println(mainList);
		
		System.out.println("=============================================================================");
		System.out.println("Toatal Counts");
		System.out.println("String was not recognized as a valid DateTime : " +stringNotValidDT.size() +"\n" +
				"SqlDateTime overflow : " +sqlDtimeOverflow.size() +"\n" +
				"Cannot open database : " +cannotOpenDB.size() +"\n" +
				"Login failed for user : " +loginFiledUser.size() +"\n" +
				"Input string was not in a correct format : " +ipNotCorrFrmt.size() +"\n" +
				"Invalid object name : " +inVldObjName.size() +"\n" +
				"Timeout expired. : " +timeOutExp.size() +"\n" + 
				"Remaining. : " +remaining.size() +"\n");
		
		System.out.println("=============================================================================");
		
//		for(int i = 0 ; i < mainList.size();i++)
//		{
//			System.out.println("!!======================================================================!!");
//			System.out.println("List of Logs" + i);
//			System.out.println("!@!======================================================================!@!");
//			String lstString = mainList.get(i);
//			System.out.println("/n"+ lstString + "/n");
//		}
	}

	public static List<String> readFileIntoList(String file) {
		List<String> lines = Collections.emptyList();
		try {
			lines = Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lines;
	}

}
