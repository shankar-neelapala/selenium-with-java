package testngframework;

import org.testng.annotations.Test;

/*
 * 1. open application
 * 2. login
 * 3. logout
 */
public class FirstTestCase {

	@Test(priority = 1)
	void openApp() {
		System.out.println("Application Opened.");
	}
	
	@Test(priority = 2)
	void login() {
		System.out.println("Loign into app.");
	}
	
	@Test(priority = 3)
	void logout() {
		System.out.println("Logout from app.");
	}
}
