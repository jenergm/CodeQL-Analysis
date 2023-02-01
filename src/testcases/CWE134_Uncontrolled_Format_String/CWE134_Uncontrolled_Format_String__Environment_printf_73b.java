/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE134_Uncontrolled_Format_String__Environment_printf_73b.java
Label Definition File: CWE134_Uncontrolled_Format_String.label.xml
Template File: sources-sinks-73b.tmpl.java
*/
/*
 * @description
 * CWE: 134 Uncontrolled Format String
 * BadSource: Environment Read data from an environment variable
 * GoodSource: A hardcoded string
 * Sinks: printf
 *    GoodSink: dynamic printf format with string defined
 *    BadSink : dynamic printf without validation
 * Flow Variant: 73 Data flow: data passed in a LinkedList from one method to another in different source files in the same package
 *
 * */

package testcases.CWE134_Uncontrolled_Format_String;

import testcasesupport.*;
import java.util.LinkedList;

public class CWE134_Uncontrolled_Format_String__Environment_printf_73b
{

    public void bad_sink(LinkedList<String> data_linkedlist ) throws Throwable
    {
        String data = data_linkedlist.remove(2);

        if (data != null)
        {
            /* POTENTIAL FLAW: uncontrolled string formatting */
            System.out.printf(data);
        }

    }

    /* goodG2B() - use GoodSource and BadSink */
    public void goodG2B_sink(LinkedList<String> data_linkedlist ) throws Throwable
    {
        String data = data_linkedlist.remove(2);

        if (data != null)
        {
            /* POTENTIAL FLAW: uncontrolled string formatting */
            System.out.printf(data);
        }

    }

    /* goodB2G() - use BadSource and GoodSink */
    public void goodB2G_sink(LinkedList<String> data_linkedlist ) throws Throwable
    {
        String data = data_linkedlist.remove(2);

        if (data != null)
        {
            /* FIX: explicitly defined string formatting */
            System.out.printf("%s%n", data);
        }

    }
}
