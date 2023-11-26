package pages;

import commons.BaseSetup;
import commons.MessageHelper;
import commons.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import ultilities.Log;

public class AccountPage extends BaseSetup {
    private ValidateHelper validateHelper;
    private By errorNumberPhoneMassage = By.id("telephone-error");
    private By errorStreetAddressMassage = By.id("street_1-error");
    private By errorRegionMassage = By.id("region_id-error");
    private By errorCityMassage = By.id("city-error");
    private By errorZipCodeMassage = By.id("zip-error");
    private By addressBookLink = By.xpath("//*[@id=\"block-collapsible-nav\"]/ul/li[6]/a");
    private By phoneNumberInput = By.id("telephone");
    private By streetAddressInput = By.id("street_1");
    private By regionDropdown = By.id("region_id");
    private By cityInput = By.id("city");
    private By zipCodeInput = By.id("zip");
    private By saveAddressBtn = By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button");
    private By createAddressMessage  = By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div");
    public AccountPage() {
        validateHelper = new ValidateHelper(driver);
    }

    public void setAddress (String phoneNumber, String streetAddress, String region, String city, String zipCode) throws InterruptedException {
        Thread.sleep(1000);
        validateHelper.clickElement(addressBookLink);
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("scroll(0,500)");
        Thread.sleep(1000);
        validateHelper.setText(phoneNumberInput, phoneNumber);
        Thread.sleep(1000);
        validateHelper.setText(streetAddressInput, streetAddress);
        Thread.sleep(1000);
        validateHelper.selectOptionByText(regionDropdown, region);
        Thread.sleep(1000);
        validateHelper.setText(cityInput, city);
        Thread.sleep(1000);
        validateHelper.setText(zipCodeInput, zipCode);
        Thread.sleep(1000);
        validateHelper.clickElement(saveAddressBtn);
        Thread.sleep(1000);
    }

    public boolean verifySetAddress (){
        if (validateHelper.checkFindElement(createAddressMessage)){
            Log.info(MessageHelper.savedAddressMessage);
            return true;
        }

        if (validateHelper.checkFindElement(errorNumberPhoneMassage)){
            Log.error(validateHelper.getText(errorNumberPhoneMassage));
        }

        if (validateHelper.checkFindElement(errorStreetAddressMassage)){
            Log.error(validateHelper.getText(errorStreetAddressMassage));
        }

        if (validateHelper.checkFindElement(errorRegionMassage)){
            Log.error(validateHelper.getText(errorRegionMassage));
        }

        if (validateHelper.checkFindElement(errorCityMassage)){
            Log.error(validateHelper.getText(errorCityMassage));
        }

        if (validateHelper.checkFindElement(errorZipCodeMassage)){
            Log.error(validateHelper.getText(errorZipCodeMassage));
        }

        return false;
    }
}
