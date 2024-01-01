package Day1;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class Listners implements ITestListener{
  

@Override
public void onTestStart(ITestResult result) {
	System.out.println("start"+ result.getName());
	// TODO Auto-generated method stub
	
}

@Override
public void onTestSuccess(ITestResult result) {
	System.out.println("sucess"+ result.getName());
	// TODO Auto-generated method stub
	
}

@Override
public void onTestFailure(ITestResult result) {
	// TODO Auto-generated method stub
	
}

@Override
public void onTestSkipped(ITestResult result) {
	// TODO Auto-generated method stub
	
}

@Override
public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	// TODO Auto-generated method stub
	
}

@Override
public void onStart(ITestContext context) {
	// TODO Auto-generated method stub
	
}

@Override
public void onFinish(ITestContext context) {
	// TODO Auto-generated method stub
	
}
}
