

		

		

describe('Jasmine', function()
{
	
	var using = require('jasmine-data-provider');
	var d= require("./data.js");
	

	beforeEach(function()
		{
	
	console.log("Started test case");
});

afterEach(function()
		{
			
			console.log("Ended test case");
		});
using(d.dataProvider, function(data, description) 	
{
it('BDD3', function()
{
	console.log("description : " + description);
console.log("My first jasmine framework = " + data.firstNumber);
console.log("My first jasmine framework = " + data.secondNumber);
console.log("My first jasmine framework = " + data.result);
console.log("***********************************************");
expect(true).toBe(true);
})
});
	
it('BDD4', function()
{
console.log("My second jasmine framework");
expect(true).toBe(true);
})

})