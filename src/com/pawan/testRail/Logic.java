package com.pawan.testRail;

import package1.ExcelDataConfig;

public class Logic {
	public static void main(String[] args) {
		ExcelDataConfig config = new ExcelDataConfig("C:\\myEclipse\\pawanTestRail\\pawanTestRail\\exefiles\\testdata.xlsx");
		int rows = config.getRowCount(0);
		
		for(int i = 0; i < rows; i++) {
				String value = config.getData(0, i, 5);
				
				if(value.equals("y")) {
					String id = config.getData(0, i, 0);
					String value_to_update = config.getData(0, i, 4);
					TestCaseManagment.updateTestCase(id, value_to_update);
				}else {
					
				}
		}
	}

}
