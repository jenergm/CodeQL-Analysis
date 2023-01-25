/*
 * @description This abstract class is the base for test cases that only have a "bad" function.

 * */

package testcasesupport;

public abstract class AbstractTestCaseBadOnly extends AbstractTestCaseBase {

	public abstract void bad() throws Throwable;
	
	public void runTest(String classname) {

		IO.writeLine("Starting tests for Class " + classname);

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
