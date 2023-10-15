package testcases;

import commons.BaseSetup;
import commons.ExcelHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import pages.RegisterPage;

public class VerifyRegisterTest extends BaseSetup {

    private RegisterPage registerPage;
    private ExcelHelper excelHelper;

    @BeforeClass
    private void setUp () throws InterruptedException {
        initChromeDriver();
    }

    private void RegisterAccount (){

    }

    private void RegisterAccountSuccess(){

    }

    @DataProvider(name="testdata")
    private Object[][] TestDataFeed() throws Exception {
        excelHelper = new ExcelHelper();

        excelHelper.setExcelFile("src/test/java/resoures/TestData.xlsx",
                "RegisterAccountTestData");

        int rows = excelHelper.getRowCount(0);

        Object[][] credentials = new Object[rows][2];

        for(int i=0; i<rows; i++)
        {
            credentials[i][0] = excelHelper.getCellData("First Name" , i);
            credentials[i][1] = excelHelper.getCellData("Last Name" , i);
            credentials[i][2] = excelHelper.getCellData("Email" , i);
            credentials[i][3] = excelHelper.getCellData("Password" , i);
            credentials[i][4] = excelHelper.getCellData("Confirm Password" , i);
        }

        return credentials;
    }

}
