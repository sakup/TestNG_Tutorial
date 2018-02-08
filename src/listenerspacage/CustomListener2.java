package listenerspacage;


import org.testng.*;

public class CustomListener2 implements ITestListener {


    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("onTestStart -> Test Name" + iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("onTestSuccess -> Test Name" + iTestResult.getName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("onTestFailure -> Test Name" + iTestResult.getName());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("onTestSkipped -> Test Name" + iTestResult.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("onStart -> Test Name" + iTestContext.getName());
        ITestNGMethod methods[] = iTestContext.getAllTestMethods();
        System.out.println("These methods will be executed in this test tsg:");
        for (ITestNGMethod method : methods) {
            System.out.println(method.getMethodName());
        }
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("onFinish -> Test Name" + iTestContext.getName());

    }
}
