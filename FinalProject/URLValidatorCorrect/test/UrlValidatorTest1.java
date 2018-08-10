

import java.util.Random;

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest1 extends TestCase {

	   String lowercase = "abcdefghijklmnopqrstuvwxyz";
	   String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	   String numbers = "0123456789";
	   String punctuation = "`~!@#$%^&*()-_+=\\|{}[]';:/?.,><\""; 
	   String URI_permitted_chars = "!$&'()*+,;=";
	   
	   Random random = new Random();
	
	   public static final int INVALID_SCHEME_CHANCE = 25;		// % chance of invalid scheme
	   public static final int INVALID_AUTHORITY_CHANCE = 25; 	// % chance of invalid authority
	   
	   
   public UrlValidatorTest1(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
//You can use this function to implement your manual testing	   
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   //2Gx+://219.173.204.146
	   boolean val = urlVal.isValid("Gx+://www.google.com");
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
	   val = urlVal.isValid("http://google.com");
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
	   
	   // build our random url
	   ResultPair schemePair = generateScheme();
	   ResultPair authorityPair = generateAuthority();
	   
	   String url = schemePair.item + authorityPair.item; //+ "www.google.com";
	
	   
	   System.out.println(url);
	   boolean result = urlVal.isValid( url);
	   boolean expected = schemePair.valid;
	   assertTrue(result == expected);
	   
	   
   }
   
   // generate valid or invalid scheme
   ResultPair generateScheme()
   {

	   boolean schemeValid = true;

	   
	   // create a valid scheme  
	   String scheme = randoString(uppercase + lowercase + numbers, 20); 
	   String endScheme = randoString("+-.", 1);
	   
	   // if scheme is only +, - or . then it's invalid
	   if(scheme.length() == 0 && endScheme.length() > 0)
		   schemeValid = false;
	   
	   
	   // invalid if first char is number
	   if(scheme.length() > 0 && numbers.contains(Character.toString(scheme.charAt(0))))
			   schemeValid = false;
	   
	   if(random.nextInt(100) < INVALID_SCHEME_CHANCE)
	   {
		   schemeValid = false;
		   
		   String appendage = randoString(uppercase + lowercase + numbers, 25);
		   
		   // prevent appendage from being valid
		   while(appendage.contains("://"))
			   appendage = randoString(uppercase + lowercase + numbers, 25);
		   
		   scheme += appendage;
	   }
	   else
	   {
		   // "://" Is and invalid scheme
		   if(scheme.length() == 0)
			   schemeValid = false;
		   
		   scheme += "://";
	   }   
	   return new ResultPair(scheme, schemeValid);
   }
   
   
   // generate valid or invalid authority
   ResultPair generateAuthority()
   {
	   boolean authorityValid = true;
	   
	   // create a valid authority
	   
	   String authority = "";
	   
	   // generate user info?
	   if(random.nextInt(100) < 20)
	   {
		   authority = randoString(uppercase + lowercase + numbers + URI_permitted_chars, 257);
		   
		   if(random.nextInt(100) < 25)
		   {
			   authority += ":" + randoString(uppercase + lowercase + numbers + URI_permitted_chars, 257);
			   
		   }
		   authority += "@";
	   }
	   
	   authority += generateIP4().item;
	   
	
	   return new ResultPair(authority, authorityValid);
   }
   
   
   // generate valid or invalid ip4 address
   ResultPair generateIP4()
   {
	   String IP4 = "";
	   boolean validIP4 = true;
	   
	   for(int i = 0; i < 4; i++)
	   {
		   IP4 += Integer.toString(random.nextInt(256));
		   
		   if(i < 3) IP4 += ".";
	   }
	   
	   return new ResultPair(IP4, validIP4);
   }
   
   
   // generates random string from validChars
   public String randoString(String validChars, int limit)
   {
	   String retString = "";
	   
	   Random random = new Random();
	   
	   int numChars = random.nextInt(limit + 1);
	   int randPos = -1;
	   
	   for(int i = 0; i < numChars; i++)
	   {
		   randPos = random.nextInt(validChars.length());
		   retString += Character.toString(validChars.charAt(randPos));
		   
	   }
	   
	   
	   return retString;
   }
   

}
