package testngframework;

import org.testng.Assert;
import org.testng.annotations.Test;
/*
 * Dependency methods allow one test method to depend on another test method (or group).
	If the dependent method fails or is skipped, TestNG will skip the test that depends on it.
	dependsOnMethods={list of dependent methods}
 */
public class DependencyMethods {

	@Test(priority = 1)
	void m1() {
		Assert.assertTrue(true);
	}
	
	@Test(priority = 2, dependsOnMethods = {"m1"})
	void m2() {
		Assert.assertTrue(false);
	}
	
	@Test(priority = 3, dependsOnMethods = {"m1"})
	void m3() {
		Assert.assertTrue(true);
	}
	
	@Test(priority = 4, dependsOnMethods = {"m1", "m2"})
	void m4() {
		Assert.assertTrue(true);
	}
}
