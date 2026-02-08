package testngframework.groupingtests;

import org.testng.annotations.Test;

public class Payment {

	@Test(priority = 1, groups = {"sanity", "regression", "functional"})
	void p1() {
		System.out.println("payment 1");
	}
	
	@Test(priority = 2, groups = {"sanity", "regression", "functional"})
	void p2() {
		System.out.println("payment 2");
	}
}
