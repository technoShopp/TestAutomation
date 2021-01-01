	var Jasmine2HtmlReporter = require('protractor-jasmine2-html-reporter');
exports.config = {
	
		//seleniumAddress:'http://localhost:4444/wd/hub',
			specs:['spec1.js'],
			onPrepare : function()
			{
				browser.driver.manage().window().maximize();
				browser.get('http://juliemr.github.io/protractor-demo/');
				console.log("---MAXIMISED----");
				 
					      jasmine.getEnv().addReporter(
					        new Jasmine2HtmlReporter({
					          savePath: './target/reports',
					          takeScreenshots: true,
					          takeScreenshotsOnlyOnFailures: true
					        })
					      );
					   
			},

			capabilities : {
				'browserName':'chrome',
				"chromeOptions": {
					  binary: 'C:/Program Files/Google/Chrome/Application/chrome.exe',
					  w3c: false
					
					} 
			
			},

			suites:
				{
				smoke:['spec1.js'],
				regression:['spec3.js']
				
				},

			onComplete : function()
			{
				browser.close();
				console.log("---CLOSED----");
			},

			
			
};
