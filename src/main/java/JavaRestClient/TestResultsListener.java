package JavaRestClient;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

/**
 * Listener for retreiving data about status of tests
 * Created by Voropai Dmytro on 14/01/2017.
 */
public class TestResultsListener extends TestListenerAdapter{
    //  For successful test
    @Override
    public void onTestSuccess(ITestResult result) {

    }
    //  For unsuccessful test
    @Override
    public void onTestFailure(ITestResult result) {

    }
    //For skipped test
    @Override
    public void onTestSkipped(ITestResult result) {

    }
}
