package testcases;

import commons.BaseSetup;
import commons.ExcelHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SignInPage;

public class VerifySignInTest extends BaseSetup {

    private SignInPage signInPage;
    private ExcelHelper excelHelper;

    @BeforeClass
    private void setUp () throws InterruptedException {
        initChromeDriver();
    }

    @Test(dataProvider="testdata")
    public void SignIn (String email, String password) throws Exception {

        MainPage mainPage = new MainPage();
        signInPage = mainPage.LaunchingSignInPage();
        signInPage.signIn(email, password);
        signInPage.verifySignIn();
    }

    @Test
    public void SignInSuccess () throws Exception {

        MainPage mainPage = new MainPage();
        signInPage = mainPage.LaunchingSignInPage();
        signInPage.signIn("hloan975@gmail.com", "123456aA");
        signInPage.verifySignIn();
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
