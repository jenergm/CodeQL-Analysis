/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE477_Obsolete_Functions__Date_parse_19.java
Label Definition File: CWE477_Obsolete_Functions.label.xml
Template File: point-flaw-19.tmpl.java
*/
/*
* @description
* CWE: 477 Use of Obsolete Functions
* Sinks: Date_parse
*    GoodSink: Use of preferred java.text.DateFormat.parse(String)
*    BadSink : Use of deprecated java.util.Date.parse(String) method
* Flow Variant: 19 Control flow: Dead code after an if(true) return
*
* */

package testcases.CWE477_Obsolete_Functions;

import testcasesupport.*;

public class CWE477_Obsolete_Functions__Date_parse_19 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        {

            /* FLAW: Use of deprecated Date.parse(String) method */
            long unixDate = java.util.Date.parse("2010-07-13 10:41:00");

            IO.writeLine(unixDate); /* Use unixDate */

        }
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            /* FIX: Use preferred DateFormat.parse(String) method */
            java.util.Date d = java.text.DateFormat.getInstance().parse("2010-07-13 10:41:00");

            IO.writeLine(d.toString()); /* Use d */

        }
    }

    public void good() throws Throwable
    {
        good1();
    }

    /* good1() reverses the GoodSinkBody and the BadSinkBody so that the BadSinkBody never runs */
    private void good1() throws Throwable
    {
        {

            /* FIX: Use preferred DateFormat.parse(String) method */
            java.util.Date d = java.text.DateFormat.getInstance().parse("2010-07-13 10:41:00");

            IO.writeLine(d.toString()); /* Use d */

        }
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            /* FLAW: Use of deprecated Date.parse(String) method */
            long unixDate = java.util.Date.parse("2010-07-13 10:41:00");

            IO.writeLine(unixDate); /* Use unixDate */

        }
    }

    /* Below is the main(). It is only used when building this testcase on
       its own for testing or for building a binary to use in testing binary
       analysis tools. It is not used when compiling all the testcases as one
       application, which is how source code analysis tools are tested. */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }

}

