> <font color="#019901">Не следует заставлять тестировщиков тестировать быстрее. Что может быть хуже испуганных, усталых, цинично настроенных тестировщиков?</font>
# :woman_technologist:Test automation project for  [Moscow Thermal Automation Plant (MZTA)](https://www.mzta.ru/) company.
> - MZTA is a Russian manufacturer of devices for managing technological processes and engineering systems
> - MZTA provides a full range of engineering services for the implementation of automation and dispatching systems
> - MZTA conducts regular training courses on the use of products manufactured by PTK Komega and PTK Kontar
## :pretzel: Table of contents
- [Tools and technologies](#hammer_and_wrench-tools-and-technologies)
- [List of implemented tests](#bookmark_tabs-list-of-implemented-tests)
- [Running autotests from the terminal](#desktop_computer-running-autotests-from-the-terminal)
- [Сборка в Jenkins](#-сборка-в-jenkins)
- [Пример Allure-отчета](#-пример-allure-отчета)
- [Уведомления в Telegram с использованием бота](#-уведомления-в-telegram-с-использованием-бота)
- [Видео примера запуска тестов в Selenoid](#-видео-примера-запуска-теста-в-selenoid)

## :hammer_and_wrench: Tools and technologies

| IntelliJ IDEA | Java | Selenide | Selenoid  | Allure Report |  Allure TestOps | Gradle | JUnit5 | GitHub | Jenkins| Telegram | Jira |
|:---------:|:---------:|:---------:|:---------:|:---------:|:---------:|:---------:|:---------:|:---------:|:---------:|:---------:|:---------:|
| <img width="90%" title="IntelliJ IDEA" src="media/logotypes/Intelij_IDEA.svg"> | <img width="100%" title="Java" src="media/logotypes/Java.svg"> | <img width="90%" title="Selenide" src="media/logotypes/Selenide.svg"> | <img width="80%" title="Selenoid" src="media/logotypes/Selenoid.svg"> |<img width="100%" title="Allure Report" src="media/logotypes/Allure_Report.svg"> |<img width="60%" title="Allure TestOps" src="media/logotypes/AllureTestOps.svg"> |<img width="90%" title="Gradle" src="media/logotypes/Gradle.svg"> |<img width="90%" title="JUnit5" src="media/logotypes/JUnit5.svg"> |<img width="90%" title="GitHub" src="media/logotypes/GitHub.svg"> |<img width="90%" title="Jenkins" src="media/logotypes/Jenkins.svg"> |<img width="80%" title="Telegram" src="media/logotypes/Telegram.svg">|<img width="80%" title="Jira" src="media/logotypes/Jira.svg">|
- To create autotests in this project the <code>[Java](https://www.java.com/)</code> language was used.
- <code>[Gradle](https://gradle.org/)</code> was used as an automatic build system.  
- Frameworks <code>[JUnit5](https://junit.org/junit5/)</code> and <code>[Selenide](https://selenide.org/)</code> for automated testing of web applications have been applied.
- Browsers were launched via <code>[Selenoid](https://aerokube.com/selenoid/)</code>.
- To run tests remotely a job was implemented in <code>[Jenkins](https://jenkins.autotests.cloud/job/MaryPimenova-VacancyProjectUnit14/)</code> with the creation of an <code>[Allure-report](https://jenkins.autotests.cloud/job/MaryPimenova-VacancyProjectUnit14/7/allure/)</code> and sending the results to <code>Telegram</code> using special Telegram bot.
- Integrations with с <code>[Allure TestOps](https://allure.autotests.cloud/project/2434/dashboards)</code> and <code>[Jira](https://jira.autotests.cloud/browse/HOMEWORK-720)</code> were implemented.

## :bookmark_tabs: List of implemented tests
#### ✓ List of realized automatic tests
- [x] Checking for the presence of the main menu items of the site
- [x] Checking drop-down of the list elements in the main menu
- [x] Checking for the presence of correct page titles when navigating through menu items
- [x] Checking shopping cart filling
- [x] Checking downloading files from the web-site
- [x] Checking searching for the production by its arcticle or name
- [x] Checking fulfilling of the registration form with valid/invalid data
#### ✓ List of realized manual tests
- [x] Verification of filling the "Callback" form
- [x] Verification of filling the "Write a letter" form
- [x] Сhecking the content of articles in the News section
## :desktop_computer: Running autotests from the terminal
Lauching tests on a ***remote server*** using Jenkins and Selenoid (login and password are required for authorization) can be done using the following command from the terminal:
```bash  
gradle clean remote
```
___
Running the following command in the IDE terminal will run the tests remotely in Selenoid taking into account the specified ***parameters***:
```bash  
gradle clean remote -Dbase_url=https://www.mzta.ru -Dselenoid_url=https://selenoid.autotests.cloud/wd/hub -Dselenoid_login_password=user1:1234  -Dbrowser=chrome:100.0 -Dbrowser_size=1920x1080
```
If you do not specify any parameters, then the test will run with the default values that we set above.

