package testngframework.groupingtests;

import org.testng.annotations.Test;

public class Signup {

	@Test(priority = 1, groups = {"regression"})
	void s1() {
		System.out.println("signup 1");
	}
	
	@Test(priority = 2, groups = {"regression"})
	void s2() {
		System.out.println("signup 2");
	}
}
