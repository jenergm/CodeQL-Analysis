/*
@description This abstract class is the base for the majority of 
test cases that are not Servlet or class based issue and have both
a "bad" and "good" function.

*/

package testcasesupport;

public abstract class AbstractTestCase extends AbstractTestCaseBase {

	public abstract void bad() throws Throwable;

	public abstract void good() throws Throwable;
	
	public void runTest(String classname) {

		IO.writeLine("Starting tests for Class " + classname);

		try {
			good();
	
			IO.writeLine("Completed good() for Class " + classname);
			
		} catch (Throwable t) {

			IO.writeLine("Caught a throwable from good() for Class "
					+ classname);

			IO.writeLine("Throwable's message = " + t.getMessage());
			
			StackTraceElement stes[] = t.getStackTrace();

			IO.writeLine("Stack trace below");

			for (StackTraceElement ste : stes) {

				IO.writeLine(ste.toString());

			} 

		} 

		try {

			bad();
			IO.writeLine("Completed bad() for Class " + classname);

		} catch (Throwable t) {

			IO.writeLine("Caught a throwable from bad() for Class "
					+ classname);

			IO.writeLine("Throwable's message = " + t.getMessage());
			
			StackTraceElement stes[] = t.getStackTrace();

			IO.writeLine("Stack trace below");

			for (StackTraceElement ste : stes) {

				IO.writeLine(ste.toString());

			} 

		} 

	} // runTest

}
