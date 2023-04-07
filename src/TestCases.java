import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
 public class TestCases extends Parameters{
////	1- create one test case that goes to the website and
////	SIGNUP - once the Signup process is done you need to
////	create an assertion that the Test case is passed.
////	note:- you need to fill in the information about registration with your
////	real email - as we are going to create another test cases that require
////	you to sign in
	@Test(priority=1)
	public void SignUp() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys("Alaa");
		driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys("Allouzi");
		driver.findElement(By.xpath("//*[@id=\"email_address\"]")).sendKeys("AlaaAllouzi91@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Alaa1991");
		driver.findElement(By.xpath("//*[@id=\"password-confirmation\"]")).sendKeys("Alaa1991");
		driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("AlaaAllouzi91@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("Alaa1991");
		driver.findElement(By.xpath("//*[@id=\"send2\"]")).click();
		String actual=driver.getTitle();
		String expected ="My Account";
		myAssertion.assertEquals(actual, expected);
		myAssertion.assertAll();
		
		Thread.sleep(5000);
	}
//	//***********************************************************************************************************
////	2- create test cases that let the search bar in the home
////	page search RANDOMLY about one of the following
////	( Jacket, t-shirt, jeans for men, jeans for women,pants)
////	once the item is selected print in the console the name of the selected item
	@Test(priority=2)
	public void HomeSearchRandom() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/a/img")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	 String []searchList= {"Jacket","t-shirt","jeans for men","jeans for women","pants"};
	 Random rand =new Random();
		int randomSearchList=rand.nextInt(4); 
	WebElement inputSearch  = driver.findElement(By.xpath("//*[@id=\"search\"]"));
   		inputSearch.sendKeys(searchList[randomSearchList]);
        System.out.println(searchList[randomSearchList]);
        Thread.sleep(3000);
        
        
        

   		
 

	}
//	//**************************************************************************************************************************************
//	3- in the home page if you scroll down you will see 5 items
//	( Radiant tee, breathe-easy tank, argus all-weather tank, hero
//	hoodie, fusion backpack )
//	you need to add the above item in the following counts
//	A- Radiant tee - 3 items
//	B- breathe- easy tank - 2 items
//	C- argus all weather tank - 4 items
//	D- hero hoodie - 1 item
//	E-fusion backpack 5 items
//	NOTE : THE SIZE AND COLOR SHOULD BE RANDOMLY SELECTED
	  @Test(priority = 3)
 	  public void randomlyAdd() throws InterruptedException {
 		 
 			Random rand = new Random();
 			// Radianttee 
 			driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/a/img")).click();
 			driver.findElement(
 	
 			By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[1]/div/a/span/span/img"))
 				.click();
 			driver.manage().window().fullscreen();
 			
 			
 			String[] size = { "//*[@id=\"option-label-size-143-item-166\"]", "//*[@id=\"option-label-size-143-item-167\"]",
 					"//*[@id=\"option-label-size-143-item-168\"]", "//*[@id=\"option-label-size-143-item-169\"]",
 					"//*[@id=\"option-label-size-143-item-170\"]" };

 			String[] color = { "//*[@id=\"option-label-color-93-item-50\"]", "//*[@id=\"option-label-color-93-item-56\"]",
 					"//*[@id=\"option-label-color-93-item-57\"]" };
			int  Radianttee=3;
		for (int i=0;i<Radianttee;i++) {
 				int sizeNumRan = rand.nextInt(5);
 				int colorNumRan = rand.nextInt(3);
 				Thread.sleep(5000);
 				driver.findElement(By.xpath(size[sizeNumRan])).click();
 				Thread.sleep(4000);
 				driver.findElement(By.xpath(color[colorNumRan])).click();
 				Thread.sleep(4000);
 				//driver.findElement(By.name("qty")).clear();
 			//	driver.findElement(By.name("qty")).sendKeys("3");
 				Thread.sleep(4000);
 				driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]")).click();
 				
 				Thread.sleep(4000);
 			
 		}
 			 //breathe- easy tank
		driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/a/img")).click();
 			driver.manage().window().fullscreen();
 			Thread.sleep(4000);
 			
 			driver.findElement(
 					By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[2]/div/a/span/span/img"))
 					.click();
 			Thread.sleep(4000);
 			String[] color2 = { "//*[@id=\"option-label-color-93-item-57\"]","//*[@id=\"option-label-color-93-item-59\"]",
 					"//*[@id=\"option-label-color-93-item-60\"]" };
 			Thread.sleep(4000);
 			for (int i=0;i<2;i++) {
 				int sizeNumRan = rand.nextInt(5);
 				int colorNumRan = rand.nextInt(3);
 				Thread.sleep(5000);
  				driver.findElement(By.xpath(size[sizeNumRan])).click();
 				Thread.sleep(4000);
 				driver.findElement(By.xpath(color2[colorNumRan])).click();
 				Thread.sleep(4000);
 				driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]")).click();
 				
 				Thread.sleep(4000);
 			}
 			
 			// argus all weather tank
 			driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/a/img")).click();
 			driver.manage().window().fullscreen();
 			driver.findElement(
 					By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[3]/div/a/span/span/img"))
 					.click();
 			Thread.sleep(5000);
 			for (int i=0;i<7;i++) {
 				int sizeNumRan = rand.nextInt(5);
 				
 				Thread.sleep(5000);
 				driver.findElement(By.xpath(size[sizeNumRan])).click();
 				Thread.sleep(5000);
 				driver.findElement(By.xpath("//*[@id=\"option-label-color-93-item-52\"]")).click();
 				Thread.sleep(000);
 				driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]")).click();
 				Thread.sleep(5000);
 			}
// 			
// 			//argus all weather tank
//// 			driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/a/img")).click();
////
//// 		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
////
//// 		WebElement DivContainSize = driver
//// 				.findElement(By.xpath("//*[@id="product-options-wrapper"]/div/div/div[1]/div"));
//// 		List<WebElement> Size = DivContainSize.findElements(By.tagName("div"));
//// 		System.out.println(Size.size());
////
//// 		WebElement DivContaincolors = driver
//// 				.findElement(By.xpath("//*[@id="product-options-wrapper"]/div/div/div[2]/div"));
//// 		List<WebElement> Color = DivContaincolors.findElements(By.tagName("div"));
////
//// 		System.out.println(Color.size());
////
//// 		for (int i = 0; i < 3; i++) {
////
//// 			int RandomSize = rand.nextInt(Size.size());
//// 			Thread.sleep(3000);
//// 			Size.get(RandomSize).click();
////
//// 			Thread.sleep(3000);
////
//// 			int RandomColor = rand.nextInt(Color.size());
//// 			Thread.sleep(3000);
//// 			Color.get(RandomColor).click();
////
//// 			driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]")).click();
////
//// 			Thread.sleep(3000);
//
 	//	}
 			// hero hoodie
 			
 			driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/a/img")).click();
 			driver.findElement(
 					By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[4]/div/a/span/span/img"))
 					.click();
 			int size_num = rand.nextInt(4);
 			int colorNumRan = rand.nextInt(3);
 			driver.findElement(By.xpath(size[size_num])).click();
 			String[] color4 = { "//*[@id=\"option-label-color-93-item-49\"]","//*[@id=\"option-label-color-93-item-52\"]",
 					"//*[@id=\"option-label-color-93-item-53\"]" };
 			driver.findElement(By.xpath(color4[colorNumRan])).click();
 	
 			driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]")).click();
 	
 			
 			// fusion backpack
 			driver.manage().window().fullscreen();
 			driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/a/img")).click();
 			driver.findElement(
 					By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[5]/div/a/span/span/img"))
 					.click();
 			    driver.findElement(By.name("qty")).clear();
 				driver.findElement(By.name("qty")).sendKeys("5");
 				driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]")).click();
 				Thread.sleep(6000);
 	
			}
	  
		  
	  

	  //**********************************************************************************************************************
//	  4- ONCE YOU FINISH ADDING THE PREVIOUS ITEMS
//	  YOU NEED TO GO TO THE CHECKOUT PAGE AND
//	  COMPLETE THE PROCESS OF SHIPPING THE ADDRESS
	  
	  @Test(priority = 4)
	  public void Checkout_Page() throws InterruptedException {
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			
		  driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/a/img")).click();
		  Thread.sleep(4000);
			driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[1]/a")).click();
			 Thread.sleep(4000);
			driver.findElement(By.xpath("//*[@id=\"top-cart-btn-checkout\"]")).click();
			 Thread.sleep(6000);
			 //newaddress
			driver.findElement(By.xpath("//*[@id=\"checkout-step-shipping\"]/div[2]/button")).click();
			 Thread.sleep(4000);
			//Company
			driver.findElement(By.name("company")).sendKeys("Aura for integrated solution");
			
			// Street Address 
			driver.findElement(By.name("street[0]")).sendKeys("alrwabi");
			driver.findElement(By.name("street[1]")).sendKeys("alsahabeh");
			driver.findElement(By.name("street[2]")).sendKeys("street 123");
			//City 
			 Thread.sleep(4000);
			driver.findElement(By.name("city")).sendKeys("Amman");
			//State/Province
			 WebElement stateDdl=  driver.findElement(By.name("region_id"));
		   Select stateSelect=new Select(stateDdl);
		  stateSelect.selectByValue("4");
		 
		    //Zip/Postal Code
			  driver.findElement(By.name("postcode")).sendKeys("51838");
				 Thread.sleep(4000);

			  // Select Country
			  WebElement countryDdl=driver.findElement(By.name("country_id"));
			  Select countrySelect=new Select(countryDdl);
			  countrySelect.selectByVisibleText("Jordan");
				 Thread.sleep(4000);

		    //Phone Number 
			  driver.findElement(By.name("telephone")).sendKeys("07979999999");
				 Thread.sleep(4000);

            // shipHere
			  driver.findElement(By.xpath("/html/body/div[2]/aside[2]/div[2]/footer/button[1]")).click();
           //Next
			  Thread.sleep(4000);
			  driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button")).click();
			  Thread.sleep(4000);
			  driver.findElement(By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button")).click();	
	  }
//************************************************************************************************************************
//	  5- AFTER THE CHECK OUT YOU WILL SEE A BUTTON CALLED
//	  PLACE ORDER, ONCE PRESSED YOU WILL BE MOVING TO THE PAGE
//	  THAT INCLUDES THE INVOICE NUMBER DO ONE ASSERTION THAT
//	  MAKES SURE THE FINAL PRICE IS CORRECT
	  
	@Test(priority = 5)
	public void PlaceOrderPrice () throws InterruptedException {
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Thread.sleep(5000);
	driver.findElement(By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/p[1]/a")).click();
	Thread.sleep(5000);
	WebElement price_path= driver.findElement(By.xpath("/html/body/div[1]/main/div[3]/div/div[2]/p[1]/a"));
	String price = price_path.getText().replaceAll("\\$","");
	System.out.println(price);
	double  actual_Price= Double.parseDouble(price);
	System.out.println(actual_Price+80);
	Double expected_price=571.0 ;
//	myAssertion.assertEquals(actual_Price,expected_price);
//	myAssertion.assertAll();
////	System.out.println(price);
////	String splitedPrice []=price.split("");
////	System.out.println(splitedPrice[1]);
////	String theNumofprice=splitedPrice[0];
////	System.out.println(theNumofprice+60);
////	//int actualPrice=Integer.parseInt(theNumofprice);
////	String TheNumUpdated=theNumofprice.replace("$","");
////	int actualPriceNumUpdated=Integer.parseInt(TheNumUpdated);
////	System.out.println(actualPriceNumUpdated);
//	
//	
//		
	}	
	//****************************************************************************************************************************
//	6- create one test case that goes to the website and signsin with your email and password, then go to my account
//	from my account go to my orders, and from there go andre-order the same 5 times
//	7- after you have done the re-order process 5 times
//	if you go to my account then my orders you will see all
//	orders that you have made, from there make one
//	assertion that the price of the 5 invoices are the same
	@Test(priority = 6)
	public void fiveTimeReorder() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	//	signin
	driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/a")).click();
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("AlaaAllouzi91@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("Alaa1991");
	driver.findElement(By.xpath("//*[@id=\"send2\"]")).click();
	//myaccount 
	for(int i=0;i<5;i++) {
	driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/span")).click();
	driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/div/ul/li[1]/a")).click();
	driver.findElement(By.xpath("//*[@id=\"block-collapsible-nav\"]/ul/li[2]/a")).click();
	//reorder
	driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr[1]/td[6]/a[2]")).click();
	
	}
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[4]/div/div[1]/ul/li[2]/a")).click();
	WebElement price_path1= driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr[1]/td[4]/span"));
	String price1 = price_path1.getText().replaceAll("\\$","");
	System.out.println(price1);
    double  actual_Price1= Double.parseDouble(price1);
    System.out.println(actual_Price1);
    Thread.sleep(3000);
	WebElement price_path2= driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr[2]/td[4]/span"));
	String price2 = price_path2.getText().replaceAll("\\$","");
    double  actual_Price2= Double.parseDouble(price2);
    System.out.println(actual_Price2);
    Thread.sleep(3000);
    WebElement price_path3= driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr[3]/td[4]/span"));
	String price3 = price_path3.getText().replaceAll("\\$","");
    double  actual_Price3= Double.parseDouble(price3);
    System.out.println(actual_Price3);
    Thread.sleep(3000);
    WebElement price_path4= driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr[4]/td[4]/span"));
	String price4 = price_path4.getText().replaceAll("\\$","");
    double  actual_Price4= Double.parseDouble(price4);
    System.out.println(actual_Price4);
    Thread.sleep(3000);
    WebElement price_path5= driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr[5]/td[4]/span"));
	String price5 = price_path5.getText().replaceAll("\\$","");
    double  actual_Price5= Double.parseDouble(price5);
    System.out.println(actual_Price5);
    double  actual_Prices=actual_Price1+actual_Price2+actual_Price3+actual_Price4+actual_Price5;
    System.out.println(actual_Prices);
    
    Double expected_price=2135.6;
    myAssertion.assertEquals(actual_Prices,expected_price);
	myAssertion.assertAll();

//	Thread.sleep(5000);
//	driver.findElement(By.id("reorder-item-7921")).click();
//	driver.findElement(By.id("reorder-item-7929")).click();
//	driver.findElement(By.id("reorder-item-7915")).click();
//	driver.findElement(By.id("reorder-item-7917")).click();
//	driver.findElement(By.id("reorder-item-7931")).click();
//	driver.findElement(By.id("reorder-item-7931")).click();
//	driver.findElement(By.xpath("//*[@id=\"reorder-validate-detail\"]/div[2]/div[1]/button")).click();
	
	}
		
	}

