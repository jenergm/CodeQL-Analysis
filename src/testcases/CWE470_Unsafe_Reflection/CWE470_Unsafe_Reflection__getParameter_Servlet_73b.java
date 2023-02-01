/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE470_Unsafe_Reflection__getParameter_Servlet_73b.java
Label Definition File: CWE470_Unsafe_Reflection.label.xml
Template File: sources-sink-73b.tmpl.java
*/
/*
 * @description
 * CWE: 470 Use of Externally-Controlled Input to Select Classes or Code ('Unsafe Reflection')
 * BadSource: getParameter_Servlet Read data from a querystring using getParameter()
 * GoodSource: Set data to a hardcoded class name
 * Sinks:
 *    BadSink : Instantiate class named in data
 * Flow Variant: 73 Data flow: data passed in a LinkedList from one method to another in different source files in the same package
 *
 * */

package testcases.CWE470_Unsafe_Reflection;

import testcasesupport.*;
import java.util.LinkedList;

import javax.servlet.http.*;

public class CWE470_Unsafe_Reflection__getParameter_Servlet_73b
{

    public void bad_sink(LinkedList<String> data_linkedlist , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = data_linkedlist.remove(2);

        /* POTENTIAL FLAW: Instantiate object of class named in data (which may be from external input) */
        Class<?> c = Class.forName(data);
        Object instance = c.newInstance();

        IO.writeLine(instance.toString()); /* Use instance in some way */

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(LinkedList<String> data_linkedlist , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = data_linkedlist.remove(2);

        /* POTENTIAL FLAW: Instantiate object of class named in data (which may be from external input) */
        Class<?> c = Class.forName(data);
        Object instance = c.newInstance();

        IO.writeLine(instance.toString()); /* Use instance in some way */

    }

}
