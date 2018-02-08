package listenerspacage;


import org.testng.*;

public class CustomListener3 implements ISuiteListener {


    @Override
    public void onStart(ISuite iSuite) {
        System.out.println("onStart: before suite starts");
    }

    @Override
    public void onFinish(ISuite iSuite) {
        System.out.println("onFinish: after suite completes");
    }
}
