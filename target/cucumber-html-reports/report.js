$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/Login.feature");
formatter.feature({
  "name": "Demo1",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Perform login process successfully",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Click on login button in the home page",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "Once",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});