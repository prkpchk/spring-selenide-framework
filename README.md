# PROJECT NOT FINISHED YET...
## Automated UI and API tests framework template
### Java 21, maven, Spring Boot 3, Selenide, TestNG, Allure

----
## About

The goal of this project is to create a framework for autotests that supports mobile and web testing, API testing and parallel tests execution using the capabilities of Spring Boot

----
### - [1. How to run tests](#1-how-to-run-tests)
### - [2. Allure reports](#2-allure-reports)
### - [3. Test annotations](#3-test-annotations)
### - [4. Environment variables](#4-environment-variables)
### - [5. Selenium Grid Setup](#5-selenium-grid-setup)

----
### 1. How to run Tests
#### You can run tests simply debugging each one from IDE or using following maven commands:
- to run XML suite(resources/suites) using suite path(or few separated with ",") in command:
```bash
mvn test -Dsurefire.suiteXmlFiles=src/test/resources/suites/ParallelPageDataSuite.xml -Dspring.profiles.active=chrome
```

- to run test class using class name(or few separated with ",") in command:

```bash
mvn test -Dtest=SampleTest -Dspring.profiles.active=chrome
```

- to run one test(or few separated with ",") in command:

```bash
mvn test -Dtest=SampleTest#SampleTest2 -Dspring.profiles.active=chrome
```

#### Use spring profiles for each run to define which browser/platform will be used in tests. Currently supported browsers/platforms are defined under:
`spring-selenide-framework/java/base/driver
`
----

### 2. Allure reports
#### To see Allure results use following commands
- Opens new browser tab with results in default browser:

```bash
mvn allure:serve -pl spring-selenide-framework
```

- Generates allure report in "target" folder:

```bash
mvn allure:report -pl spring-selenide-framework
```

----

### 3. Test annotations
- @Test(description = "Test name") - description parameter is test name in Allure reports and case name in TestRail
- @AllureId("id") - id of test case in TestRail
- @Links({"ID-1", "ID-2"}) - defects for test case in Jira

----

### 4. Environment variables

Some tests need environment variables to be set.
Here is list of environment variables with definitions:


| Variable              |               Required               |                                Value                                 |
|-----------------------|:------------------------------------:|:--------------------------------------------------------------------:| 
| BROWSER               |                  -                   |                    chrome(by default) or firefox                     |
| ENV                   |               Required               |                       development, integration                       |

----

### 5. Selenium grid setup:

1. From project root execute following command to create docker network:
```bash
docker network create grid
```

to remove:
```bash
docker network rm grid
```

2. Run selenium hub (image will be pulled automatically if it doesn't exist):

```bash
docker run -d -p 4442-4444:4442-4444 --net grid --name selenium-hub selenium/hub:latest
```

After that you can find your selenium grid instance on http://localhost:4444/ui

3. Run any browser on created hub with following commands :
- chrome
```bash
docker run -d --net grid -e SE_NODE_MAX_SESSIONS=5 -e SE_NODE_SESSION_TIMEOUT=60 -e SE_EVENT_BUS_HOST=selenium-hub --shm-size="2g" -e SE_EVENT_BUS_PUBLISH_PORT=4442 -e SE_EVENT_BUS_SUBSCRIBE_PORT=4443 selenium/node-chrome:latest
```
- firefox
```bash
docker run -d --net grid -e SE_NODE_MAX_SESSIONS=5 -e SE_NODE_SESSION_TIMEOUT=60 -e SE_EVENT_BUS_HOST=selenium-hub --shm-size="2g" -e SE_EVENT_BUS_PUBLISH_PORT=4442 -e SE_EVENT_BUS_SUBSCRIBE_PORT=4443 selenium/node-firefox:latest
```
- edge
```bash
docker run -d --net grid -e SE_NODE_MAX_SESSIONS=5 -e SE_NODE_SESSION_TIMEOUT=60 -e SE_EVENT_BUS_HOST=selenium-hub --shm-size="2g" -e SE_EVENT_BUS_PUBLISH_PORT=4442 -e SE_EVENT_BUS_SUBSCRIBE_PORT=4443 selenium/node-edge:latest
```





































