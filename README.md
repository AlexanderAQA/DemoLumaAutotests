# Project settings

After cloning the repo on local machine: <br>
1. Go to *File -> Project Structure*
2. Go to the *Project* and for *SDK* field choose *Java 11* (need to be downloaded)
3. Click *Apply*

# Launch using Maven with InelliJ IDEA plugin

1. Open *Maven*
2. Open up *DemoSoftwareAutotests* -> *Lifecycle*
3. Click *clean*
4. Click *test*

# Generating allure-report
After launching tests using maven: <br>

1. Open *Maven*
2. Open up *DemoSoftwareAutotests* -> *Plugins* -> *allure*
3. Click *allure:report*

The report will be generated in `target/site/allure-maven-plugin/index.html`

# Driver settings

All driver setting implements in *Driver.java*. <br>
Path `src/main/java/com/softwaretestingboard/magento/app/helpers/Driver.java`