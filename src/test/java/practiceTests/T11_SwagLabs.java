package practiceTests;

//import javax.xml.xpath.XPath;

//import java.util.ArrayList;
//import java.util.List;
import org.testng.annotations.Test;
import NGtests.T1_LogInOut;

public class T11_SwagLabs extends T1_LogInOut{
	
	//private List<String> successList = new ArrayList<>();
	//private List<String> failedList = new ArrayList<>();
	
	// Test 1 - Valid user names with Valid Password
	
	
	@Test (priority = 1)
	public void logInTest() throws Exception{
		
		System.out.println("		Test - 1: Valid user names with Valid Password");
		
		for (int i = 0; i < usernames.length; i++) {
			
			logIn(usernames[i], password);
			Thread.sleep(2000);
			logOut();
			
		}
	}
	
	// Test 2 - Invalid user names with Invalid Password
	@Test (priority = 2)
	public void invaliLogTest() throws Exception{
		System.out.println("\n		Test - 2: Invalid user names with Invalid Password");
		for (int i = 0; i < wrongUserNames.length; i++) {
			
			for (int j = 0; j < wrongPasscodes.length; j++) {
				
				logIn(wrongUserNames[i], wrongPasscodes[j]);
				Thread.sleep(1000);
				logOut();
			}
		}
	}
	
	// Test 3 - Valid user names with Invalid Passwords
	@Test (priority = 3)
	public void invalidLogTest2() throws Exception{
		System.out.println("\n		Test - 3: Valid user names with Invalid Passwords");
		for (int i = 0; i < usernames.length; i++) {
			
			for (int j = 0; j < wrongPasscodes.length; j++) {
				
				logIn(usernames[i], wrongPasscodes[j]);
				Thread.sleep(1000);
				logOut();
			}
		}
		
	}
	
	//Test - 4 - Invalid user names with Valid Password
	@Test (priority = 4)
	public void invalidLogTest3() throws Exception{
		System.out.println("\n		Test - 4: Invalid user names with Valid Password");
		for (String user: wrongUserNames) {
			logIn(user, password);
			Thread.sleep(1000);
			logOut();
		}
	}
}
