

		

		

describe('JasmineSpec3', function()
{
	
	var using = require('jasmine-data-provider');
	var d= require("./data.js");


	
	function operationCount()
	{
		element.all(by.css("option")).count().then(function(itemCount){
			console.log(itemCount);
		});
	}
	
	
function selectOperation(operation)
{
	element.all(by.css("option")).each(function(item){
		item.getAttribute("value").then(function(attr){
			if(attr==operation)
			{
			item.click();
		     }
			
			
		})
		
		
		
	})	
	}

function getElementText(a,b)
{
	a.getText().then(function(text){
		
		console.log(text);
		expect(text).toBe(b)
	
})
}

function getElementTextOnly(a)
{
	var actual;
	
	a.getText().then(function(text){
		
		console.log("From Function : "+text);
		actual= text;
		console.log("After assigning : "+actual);
		return actual;

	
})
}

function validateElementTextOnly(a,v)
{
	
	a.getText().then(function(text){
		
		console.log("From Function : "+text);
		expect(Number(text)).toEqual(v);

	
})
}

function mul(a,c)
	{
		
	var e =element(by.css('form.form-inline.ng-valid.ng-dirty.ng-submitted.ng-valid-parse .ng-binding'));
	var multi=a*c;
	console.log("Expected : "+multi);
	
	element(by.model("first")).sendKeys(a);
	selectOperation("MULTIPLICATION")
	element(by.model("second")).sendKeys(c);	
	element(by.id("gobutton")).click();
	validateElementTextOnly(e,multi);

	
	}

	function add(a,c)
	{
		var b =element(by.css('h2.ng-binding'));
	var sum= Number(a)+Number(c);
	console.log(sum);
		element(by.model("first")).sendKeys(a);
		selectOperation("ADDITION")
		element(by.model("second")).sendKeys(c);	
		element(by.id("gobutton")).click();
		validateElementTextOnly(b,sum);
		
	}




	
/*using(d.dataProvider, function(data, description) 	
{
it('BDD5+description', function()
{
console.log("My first jasmine framework = " + data.firstNumber);
console.log("My first jasmine framework = " + data.secondNumber);
console.log("My first jasmine framework = " + data.result);
console.log("******************************** ");
expect(true).toBe(true);
})
});
	

using(d.dataProvider, function(data, description) 	
		{
it('BDD6', function()
		{
	var b =element(by.css('.ng-binding'));
	var res= data.result;
	browser.get('http://juliemr.github.io/protractor-demo/');
        operationCount();
	 	element(by.model("first")).sendKeys(data.firstNumber);
		selectOperation("DIVISION")
		element(by.model("second")).sendKeys(data.secondNumber);	
		element(by.id("gobutton")).click();
		getElementText(b, res);
		})
});*/



using(d.dataProvider, function(data, description) 	
		{
it('Calculator Opeartios', function()
		{
	
	
       mul(data.firstNumber,data.secondNumber)

      add(data.firstNumber,data.secondNumber)
      
       
		})
});

})