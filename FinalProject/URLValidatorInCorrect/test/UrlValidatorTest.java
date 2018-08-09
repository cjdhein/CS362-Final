

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
	   
	   UrlValidator uv;
	   String testUrl;
	   boolean res;
	   
	   // Default Schemes
	   uv = new UrlValidator();
	   
	   testUrl = "http://www.google.com";
	   res = uv.isValid(testUrl);
	   assertit(testUrl,true,res);
	   
	   testUrl = "https://www.google.com";	   
	   res = uv.isValid(testUrl);
	   assertit(testUrl,true,res);	   
	   
	   testUrl = "ftp://www.google.com";	   
	   res = uv.isValid(testUrl);
	   assertit(testUrl,true,res);
	   
	   testUrl = "dog";
	   res = uv.isValid(testUrl);
	   assertit(testUrl, false,res);

	   testUrl = "http://";
	   res = uv.isValid(testUrl);
	   assertit(testUrl, false,res);
	   
	   testUrl = "http://www.com";
	   res = uv.isValid(testUrl);
	   assertit(testUrl, false,res);
	   
	   testUrl = "http://www.66.88";
	   res = uv.isValid(testUrl);
	   assertit(testUrl, false,res);	
	   
	   // Test with all schemes
	   uv = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
	   
	   testUrl = "http://www.google.com";
	   res = uv.isValid(testUrl);
	   assertit(testUrl,true,res);
	   
	   testUrl = "https://www.google.com";	   
	   res = uv.isValid(testUrl);
	   assertit(testUrl,true,res);	   
	   
	   testUrl = "ftp://www.google.com";	   
	   res = uv.isValid(testUrl);
	   assertit(testUrl,true,res);
	   
	   testUrl = "dog";
	   res = uv.isValid(testUrl);
	   assertit(testUrl, false,res);
	   
	   testUrl = "http://";
	   res = uv.isValid(testUrl);
	   assertit(testUrl, false,res);
	   
	   testUrl = "http://www.com";
	   res = uv.isValid(testUrl);
	   assertit(testUrl, false,res);
	   
	   testUrl = "http://www.66.88";
	   res = uv.isValid(testUrl);
	   assertit(testUrl, false,res);	
	   	   
   }
   
   
   public void testYourFirstPartition()
   {
	 //You can use this function to implement your First Partition testing	   

   }
   
   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing	   

   }
   //You need to create more test cases for your Partitions if you need to 
   
   public void testIsValid()
   {
	   //You can use this function for programming based testing

   }
   
   public void assertit(String tested, boolean expected, boolean actual)
   {
	   if (expected != actual)
	   {
		   System.out.println(tested + " -- expected " +expected + " got " +actual );
	   }
	   else
	   {
		   System.out.println(tested + " passed" );
	   }
   }
}
