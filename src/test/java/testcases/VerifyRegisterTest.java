package testcases;

import commons.BaseSetup;
import commons.ExcelHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;
import ultilities.TestListener;

@Listeners(TestListener.class)
public class VerifyRegisterTest extends BaseSetup {
    private RegisterPage registerPage;
    private ExcelHelper excelHelper;

    @BeforeClass
    private void setUp () throws InterruptedException {
        initChromeDriver();
        HomePage homePage = new HomePage();
        registerPage = homePage.setupRegisterAccountPage();
    }

    @Test (description = "Verify that the sign in account  is success with correct firstname, lastname, email," +
            " password, confirm password")
    private void verifyRegisterAccountSuccess() throws InterruptedException {
        registerPage.registerAccount("Doe", "John", "johndoe123@gmail.com",
                "123456aA", "123456aA");
        Assert.assertTrue(registerPage.verifyRegisterAccount());
    }

    @Test(dataProvider= "testdata", description = "Verify that the register account when take the data from excel file.")
    private void verifyRegisterAccount(String firstName, String lastName, String email, String password,
                                       String confirmPassword) throws Exception {

        registerPage.registerAccount(firstName, lastName, email, password, confirmPassword);
        Assert.assertTrue(registerPage.verifyRegisterAccount());
        tearDown();
    }

    @DataProvider(name="testdata")
    private Object[][] testDataFeed() throws Exception {
        excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/java/resoures/TestData.xlsx",
                "RegisterAccountTestData");

        int rows = excelHelper.getRowCount(1);
        Object[][] credentials = new Object[rows][5];

        for(int i=0; i<rows; i++) {
            credentials[i][0] = excelHelper.getCellData("First Name" , i);
            credentials[i][1] = excelHelper.getCellData("Last Name" , i);
            credentials[i][2] = excelHelper.getCellData("Email" , i);
            credentials[i][3] = excelHelper.getCellData("Password" , i);
            credentials[i][4] = excelHelper.getCellData("Confirm Password" , i);
        }

        return credentials;
    }
}
