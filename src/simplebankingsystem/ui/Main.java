package simplebankingsystem.ui;

import simplebankingsystem.controller.BankController;

public class Main {
	public static void main(String[] args) {
		BankUI ui = new BankController();
		ui.initializeWithMsg();
	}
}
