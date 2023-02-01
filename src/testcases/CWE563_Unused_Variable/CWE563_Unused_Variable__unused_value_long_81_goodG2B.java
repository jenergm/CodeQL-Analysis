/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE563_Unused_Variable__unused_value_long_81_goodG2B.java
Label Definition File: CWE563_Unused_Variable__unused_value.label.xml
Template File: sources-sinks-81_goodG2B.tmpl.java
*/
/*
 * @description
 * CWE: 563 Unused Variable
 * BadSource:  Initialize data
 * GoodSource: Initialize and use data
 * Sinks:
 *    GoodSink: Use data
 *    BadSink : re-initialize and use data
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE563_Unused_Variable;

import testcasesupport.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.*;

public class CWE563_Unused_Variable__unused_value_long_81_goodG2B extends CWE563_Unused_Variable__unused_value_long_81_base
{

    public void action(Long data ) throws Throwable
    {

        /* POTENTIAL FLAW: Possibly over-write the initial value of data before using it */
        data = 10L;

        IO.writeLine("" + data);

    }

}
