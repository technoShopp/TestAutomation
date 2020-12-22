package stepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import AppObjectRepository.MobileCalculatorOR;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MobileCalculatorStepDefinitions extends MobileCalculatorOR{
	
	String sum=null;
	String g,h;
	
		@Given("the numbers abc")
		public void the_numbers_abc() {
		   
			System.out.println("Select ABC mapping");
			
			
	
		}


		

		@Given("the numbers def")
		public void the_numbers_def() {
			
			System.out.println("Select DEF mapping");
		  
			
		}
		@When("the addition opeartion is performed")
		public void the_addition_opeartion_is_performed() {
			getA().click();
			getB().click();
			getC().click();
			
	g=	getgEle().getAttribute("text").toString();
			getOperator().click();
			
			 getD().click();
			   getE().click();
			   getF().click();
				
				h=	getgEle().getAttribute("text").toString();
				getEqualTo().click();
				sum= getgEle().getAttribute("text").toString();
			
			
		}
		@Then("the sum should be equal to the correct number")
		public void the_sum_should_be_equal_to_the_correct_number() {
		    
			System.out.println(sum);
			System.out.println(h);
			String[] k=h.split("\\+");

			System.out.println(k);
			int i=Integer.parseInt(g);
			int j=Integer.parseInt(k[1]);

			int expSum = i+j;
			System.out.println(expSum);
			int actSum= Integer.parseInt(sum);
			System.out.println(actSum);
		assertEquals(actSum, expSum);
			
		}






}
