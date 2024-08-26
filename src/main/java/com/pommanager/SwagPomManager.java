package com.pommanager;

import com.Baseclass.Baseclass;
import com.PomClass.SwagLabLoginpom;
import com.PomClass.SwagOrder1Pom;
import com.PomClass.SwagOrder2Pom;
import com.PomClass.SwagOrder3Pom;
import com.PomClass.SwagOrder4Pom;
import com.PomClass.SwagOrder5Pom;
import com.swaglabconfigreader.SwaglabConfigReader;

public class SwagPomManager extends Baseclass {

	private SwagLabLoginpom login;
	private SwaglabConfigReader reader;
	private SwagOrder1Pom order1;
	private SwagOrder2Pom order2;
	private SwagOrder3Pom order3;
	private SwagOrder4Pom order4;
	private SwagOrder5Pom order5;

	public SwagLabLoginpom getSwagLabLoginpom() {

		if (login == null) {

			login = new SwagLabLoginpom(driver);

		}
		return login;
	}

	public SwaglabConfigReader getSwaglabConfigReader() {

		if (reader == null) {

			reader = new SwaglabConfigReader();

		}
		return reader;
	}

	public SwagOrder1Pom getoOrder1Pom() {

		if (order1 == null) {

			order1 = new SwagOrder1Pom(driver);

		}
		return order1;
	}

	public SwagOrder2Pom getoOrder2Pom() {

		if (order2 == null) {

			order2 = new SwagOrder2Pom(driver);

		}
		return order2;
	}

	public SwagOrder3Pom getoOrder3Pom() {

		if (order3 == null) {

			order3 = new SwagOrder3Pom(driver);

		}
		return order3;
	}
	
	public SwagOrder4Pom getoOrder4Pom() {

		if (order4 == null) {

			order4 = new SwagOrder4Pom(driver);

		}
		return order4;
	}

	public SwagOrder5Pom getoOrder5Pom() {

		if (order5 == null) {

			order5 = new SwagOrder5Pom(driver);

		}
		return order5;
	}
}
