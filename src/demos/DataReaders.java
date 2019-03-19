package demos;

import java.util.List;

import utilities.CSV;
import utilities.Excel;

public class DataReaders {

	public static void main(String[] args) {
		readXLS();

	}
	
	public static void readCSV() {
		String fileName = "/Users/abhay/Documents/selenium/selenium_workspace/SeleniumTraining/src/utilities/UserAccounts.csv";
		List<String[]> newUsers = CSV.get(fileName);
		
		for (String[] user : newUsers) {
			System.out.println("***NEW USER****");
			System.out.println(user[0]);
			System.out.println(user[1]);
			System.out.println(user[2]);
		}
		
	}
	
	public static void readXLS() {
		String[][] arr = Excel.get("/Users/abhay/Documents/selenium/selenium_workspace/SeleniumTraining/src/utilities/UserLogin.xls");
		for (String[] row : arr) {
			System.out.print("[ ");
			for (String element : row) {
				System.out.print(element + " ");
			}
			System.out.println("]");
		}
	}

}
