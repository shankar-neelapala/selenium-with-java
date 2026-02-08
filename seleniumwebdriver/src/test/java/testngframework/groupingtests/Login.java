package testngframework.groupingtests;

import org.testng.annotations.Test;

public class Login {

	@Test(priority = 1, groups = {"sanity"})
	void l1() {
		System.out.println("login 1");
	}
	
	@Test(priority = 2, groups = {"sanity"})
	void l2() {
		System.out.println("login 2");
	}
}
