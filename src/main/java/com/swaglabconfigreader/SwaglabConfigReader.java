package com.swaglabconfigreader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class SwaglabConfigReader {

	FileInputStream fis;

	Properties prop;

	private Properties getSwagLabconfig() {

		File file = new File("C:\\Swathy\\framework\\Swaglabs\\src\\main\\java\\Swaglabconfig\\config.properties");

		try {

			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		prop = new Properties();

		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}

	public String getBrowserName() {

		String browsername = getSwagLabconfig().getProperty("browser");

		return browsername;

	}

	public String getUrl() {

		String url = getSwagLabconfig().getProperty("url");

		return url;

	}

	public String getUserName() {

		String username = getSwagLabconfig().getProperty("username");

		return username;

	}

	public String getPassword() {

		String password = getSwagLabconfig().getProperty("password");

		return password;

	}
	
	public String getInvalidUserName() {

		String invalidusername = getSwagLabconfig().getProperty("invalidusername");

		return invalidusername;

	}

	public String getInvalidPassword() {

		String invalidpassword = getSwagLabconfig().getProperty("invalidpassword");

		return invalidpassword;

	}

	public String getFirstName() {

		String firstname = getSwagLabconfig().getProperty("firstname");

		return firstname;

	}

	public String getLastName() {

		String lastname = getSwagLabconfig().getProperty("lastname");

		return lastname;

	}

	public String getzip() {

		String zip = getSwagLabconfig().getProperty("zip");

		return zip;

	}
	public String getFirstName1() {

		String firstname1 = getSwagLabconfig().getProperty("firstname1");

		return firstname1;

	}

	public String getLastName1() {

		String lastname1 = getSwagLabconfig().getProperty("lastname1");

		return lastname1;

	}

	public String getzip1() {

		String zip1 = getSwagLabconfig().getProperty("zip1");

		return zip1;

	}
	public String getFirstName2() {

		String firstname2 = getSwagLabconfig().getProperty("firstname2");

		return firstname2;

	}

	public String getLastName2() {

		String lastname2 = getSwagLabconfig().getProperty("lastname2");

		return lastname2;

	}

	public String getzip2() {

		String zip2 = getSwagLabconfig().getProperty("zip2");

		return zip2;

	}
	public String getFirstName3() {

		String firstname3 = getSwagLabconfig().getProperty("firstname3");

		return firstname3;

	}

	public String getLastName3() {

		String lastname3 = getSwagLabconfig().getProperty("lastname3");

		return lastname3;

	}

	public String getzip3() {

		String zip3 = getSwagLabconfig().getProperty("zip3");

		return zip3;

	}
	public String getFirstName4() {

		String firstname4 = getSwagLabconfig().getProperty("firstname4");

		return firstname4;

	}

	public String getLastName4() {

		String lastname4 = getSwagLabconfig().getProperty("lastname4");

		return lastname4;

	}

	public String getzip4() {

		String zip4 = getSwagLabconfig().getProperty("zip4");

		return zip4;

	}

}