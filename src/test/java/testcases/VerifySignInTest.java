package testcases;

import commons.BaseSetup;
import commons.ExcelHelper;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignInPage;
import ultilites.TestListener;

@Listeners(TestListener.class)
public class VerifySignInTest extends BaseSetup {

    private SignInPage signInPage;
    private ExcelHelper excelHelper;

    private void setUp () throws InterruptedException {
        initChromeDriver();
    }


    @Test(dataProvider="testdata", description = "Verify that the sign in account when take the data from excel file.")
    public void SignIn (String email, String password) throws Exception {
        setUp();
        HomePage homePage = new HomePage();
        signInPage = homePage.setupSignInPage();
        signInPage.signIn(email, password);
        Assert.assertTrue(signInPage.verifySignIn());
        tearDown();
    }

    @Test (description = "Verify that the sign in account  is success with correct email and password")
    public void verifySignInSuccess() throws Exception {
        setUp();
        HomePage homePage = new HomePage();
        signInPage = homePage.setupSignInPage();
       signInPage.signIn("hloan975@gmail.com", "123456aA");
    //    signInPage.signIn("jackcris123@gmail.com", "123456aA");
        Assert.assertTrue(signInPage.verifySignIn());
    }

    @DataProvider(name="testdata")
    private Object[][] TestDataFeed() throws Exception {
        excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/java/resoures/TestData.xlsx",
                "SignInTestData");

        int rows = excelHelper.getRowCount(0);

        Object[][] credentials = new Object[rows][2];

        for(int i=0; i<rows; i++)
        {
            credentials[i][0] = excelHelper.getCellData("Email" , i);
            credentials[i][1] = excelHelper.getCellData("Password" , i);
        }

        return credentials;
    }

}
