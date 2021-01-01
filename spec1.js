

			beforeEach(function()
			{
				
				console.log("Started test case");
			});
			
			afterEach(function()
					{
						
						console.log("Ended test case");
					});



describe('Jasmine', function()
{
it('BDD1', function()
{
console.log("My first jasmine framework");
expect(true).toBe(true);
})

it('BDD2', function()
{
console.log("My second jasmine framework");
expect(true).toBe(false);
})

})