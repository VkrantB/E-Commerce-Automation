package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class CSVReaderUtility {
	public static Iterator<User> readCSVFile(String fileName) {

		File csvfile = new File(System.getProperty("user.dir") + "\\testData\\"+ fileName);
		FileReader fileReader = null;
		CSVReader csvReader;
		String[] line;
		List<User> userList = null;
		User userData;
		try {
			fileReader = new FileReader(csvfile);
			csvReader = new CSVReader(fileReader);
			csvReader.readNext();// Reading the Column --- Row 1 i.e. Skipped Column names

			// Row--- 4 [No Row or end of CSV file--- > readNext will return null
			userList = new ArrayList<User>();

			while ((line = csvReader.readNext()) != null) {
				userData = new User(line[0], line[1]);
				userList.add(userData);
			}
			/* Just for printing the Users in Console
			for (User user : userList) {
				System.out.println(user);
			}
			
			 * for (User userData : userList) { System.out.println(userData); }
			 */
		} catch (CsvValidationException | IOException e) {

			e.printStackTrace();
		}
		return userList.iterator();
	}

}
