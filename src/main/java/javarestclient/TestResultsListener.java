package javarestclient;

import javarestclient.annotations.TransferToJira;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

/**
 * Listener for retrieving data about status of tests
 * Created by Voropai Dmytro
 */
public class TestResultsListener extends TestListenerAdapter{
//      For successful test
    @Override
    public void onTestSuccess(ITestResult result) {
        if(result.getStatus() == ITestResult.SUCCESS
                && result.getMethod().getConstructorOrMethod().getMethod().isAnnotationPresent(TransferToJira.class)){
            ZephyrRestClient.getInstance().createTestCaseFromListener(result);
        }
    }

    //  For unsuccessful test
    @Override
    public void onTestFailure(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE
                && result.getMethod().getConstructorOrMethod().getMethod().isAnnotationPresent(TransferToJira.class)){
            ZephyrRestClient.getInstance().createTestCaseFromListener(result);
        }

    }

    //For skipped test
    @Override
    public void onTestSkipped(ITestResult result) {
        if(result.getStatus() == ITestResult.SKIP
                && result.getMethod().getConstructorOrMethod().getMethod().isAnnotationPresent(TransferToJira.class)){
            ZephyrRestClient.getInstance().createTestCaseFromListener(result);
        }
    }
}
