package Utils;

import Managers.PageManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomerTestListener implements ITestListener {

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveFailureScreenShot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestStart(ITestResult result) {
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    }

    @Override
    public void onTestFailure(ITestResult result) {
        saveFailureScreenShot(PageManager.getDriver());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        saveFailureScreenShot(PageManager.getDriver());

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        saveFailureScreenShot(PageManager.getDriver());
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        saveFailureScreenShot(PageManager.getDriver());
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
    }
}
