

import java.util.Random;

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
//You can use this function to implement your manual testing	   
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   
	   boolean val = urlVal.isValid("http://www.google.com");
	   assertTrue(val);
   }
   
   
   public void testYourFirstPartition()
   {
	 //You can use this function to implement your First Partition testing	   

	  UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	 
	/*  From https://en.wikipedia.org/wiki/Uniform_Resource_Identifier 
	 * 5 basic parts to a valid url:
	 *   scheme: http, https, ftp, etc
	 *   	- cannot be empty
	 *   	- must be followed by colon (:)
	 *   	- letters, digits, '+', '.', '-'
	 *   authority: host name or ip number 
	 *   	- optional
	 *   	- optional user info section    jon:Pword@google.com
	 *   		- username 
	 *   		- optional password preceded by :
	 *   		- ! $ & ' ( ) * + , ; =  are valid
	 *   	- preceded by '//'
	 *  
	 *   	- optional port number
	 *   	- ip4 addresses must be dot notation
	 *   	- ip6 addresses must be inside brackets []
	 *   path:  /what/ever
	 *   	- may be empty
	 *   	- if authority is present it must begin with /
	 *   	- if no authority it cannot begin with //
	 *   	- can contain //
	 *   query: ?query=term&thing
	 *   	- optional
	 *   	- begins with ?
	 *   	- not well defined
	 * 	 fragment: #fragment
	 * 		- preceded by #
	 * 		
	 * 
	 *   other rules:
	 *   	: / ? # [ ] @ are reserved and must be percent encoded
	 *   	
	 */
	  

	  // possible input problems:
	   
	 //1. NULL input
	   boolean val = urlVal.isValid(null);
	   assertTrue(!val);
	   
	 // 2. Empty input string
	   val = urlVal.isValid("");
	   assertTrue(!val);
	   
	 // 3. valid schemes
	   val = urlVal.isValid("http:");
	   assertTrue(val);
	   
	   val = urlVal.isValid("https:");
	//   assertTrue(val);
	   
	   val = urlVal.isValid("ftp:");
	//   assertTrue(val);
	   
	   // invalid schemes
	   val = urlVal.isValid("<>[]:");
	   assertTrue(!val);
	   
	   val = urlVal.isValid(":");
	   assertTrue(!val);
	   
   }
   
   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing	   

   }
   //You need to create more test cases for your Partitions if you need to 
   
  
   public void testIsValid()
   {
	   //You can use this function for programming based testing
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   
	   String lowercase = "abcdefghijklmnopqrstuvwxyz";
	   String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	   
	   String validScheme = "+.=" + lowercase + uppercase;
	   
	   String scheme = randoString(validScheme);
	   System.out.print(scheme);
	   
	   assertTrue(urlVal.isValid( "https:"));
	   
   }
   
   
   // generates random string from validChars
   public String randoString(String validChars)
   {
	   String retString = "";
	   
	   Random random = new Random();
	   
	   int numChars = random.nextInt(257);
	   int randPos = -1;
	   
	   for(int i = 0; i < numChars; i++)
	   {
		   randPos = random.nextInt(validChars.length());
		   retString += Character.toString(validChars.charAt(randPos));
		   
	   }
	   
	   
	   return retString;
   }
   


}
