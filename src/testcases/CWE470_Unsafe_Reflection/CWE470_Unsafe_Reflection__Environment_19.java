/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE470_Unsafe_Reflection__Environment_19.java
Label Definition File: CWE470_Unsafe_Reflection.label.xml
Template File: sources-sink-19.tmpl.java
*/
/*
* @description
* CWE: 470 Use of Externally-Controlled Input to Select Classes or Code ('Unsafe Reflection')
* BadSource: Environment Read data from an environment variable
* GoodSource: Set data to a hardcoded class name
* BadSink:  Instantiate class named in data
* Flow Variant: 19 Control flow: Dead code after an if(true) return
*
* */

package testcases.CWE470_Unsafe_Reflection;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE470_Unsafe_Reflection__Environment_19 extends AbstractTestCase
{

    /* uses badsource and badsink */
    public void bad() throws Throwable
    {
        String data;
        {

            /* get environment variable ADD */
            /* POTENTIAL FLAW: Read data from an environment variable */
            data = System.getenv("ADD");

            /* POTENTIAL FLAW: Instantiate object of class named in data (which may be from external input) */
            Class<?> c = Class.forName(data);
            Object instance = c.newInstance();

            IO.writeLine(instance.toString()); /* Use instance in some way */

        }

        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.
		  We need the "if(true)" because the Java Language Spec requires that
		  unreachable code generate a compiler error */

        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            /* FIX: Use a hardcoded class name */
            data = "Testing.test";

            /* POTENTIAL FLAW: Instantiate object of class named in data (which may be from external input) */
            Class<?> c = Class.forName(data);
            Object instance = c.newInstance();

            IO.writeLine(instance.toString()); /* Use instance in some way */

        }
    }

    /* goodG2B() - use goodsource and badsink by moving BadSource and BadSink to after return */
    private void goodG2B() throws Throwable
    {
        String data;
        {

            /* FIX: Use a hardcoded class name */
            data = "Testing.test";

            /* POTENTIAL FLAW: Instantiate object of class named in data (which may be from external input) */
            Class<?> c = Class.forName(data);
            Object instance = c.newInstance();

            IO.writeLine(instance.toString()); /* Use instance in some way */

        }

        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.
		  We need the "if(true)" because the Java Language Spec requires that
		  unreachable code generate a compiler error */

        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            /* get environment variable ADD */
            /* POTENTIAL FLAW: Read data from an environment variable */
            data = System.getenv("ADD");

            /* POTENTIAL FLAW: Instantiate object of class named in data (which may be from external input) */
            Class<?> c = Class.forName(data);
            Object instance = c.newInstance();

            IO.writeLine(instance.toString()); /* Use instance in some way */

        }
    }

    public void good() throws Throwable
    {
        goodG2B();
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
