/*
@description This abstract class is meant to be used by testcases that have a flaw
outside of good or bad function.  These flaws are part of the class.  For an 
example, see CWE 580.

*/

package testcasesupport;

public abstract class AbstractTestCaseClassIssue extends AbstractTestCaseBase implements Cloneable {
	
	protected AbstractTestCaseClassIssueBad bo; // ..._bad object, set by subclasses
	
	protected AbstractTestCaseClassIssueGood g1o; // ..._good1 object, set by subclasses
	
	public void runTest(String classname) {

		IO.writeLine("Starting tests for Class " + classname);

		try {
			g1o.good();
	
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

			bo.bad();
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
	
} // class
