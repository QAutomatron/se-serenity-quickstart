# serenity-quickstart
Template project for QA Automation using Serenity. First version.

How to run:
`mvn clean integration-test serenity:aggregate`

for single test add key: `-Dit.test=TestName_Test` 

to select browser add key: `-Dwebdriver.driver=chrome`

for debug: `-DforkCount=0`
