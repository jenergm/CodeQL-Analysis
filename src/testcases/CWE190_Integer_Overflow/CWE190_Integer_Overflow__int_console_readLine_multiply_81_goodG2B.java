/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__int_console_readLine_multiply_81_goodG2B.java
Label Definition File: CWE190_Integer_Overflow__int.label.xml
Template File: sources-sinks-81_goodG2B.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: console_readLine Read data from the console using readLine
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: multiply
 *    GoodSink: Ensure there will not be an overflow before multiplying data by 2
 *    BadSink : If data is positive, multiply by 2, which can cause an overflow
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE190_Integer_Overflow;

import testcasesupport.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.*;
import javax.servlet.http.*;

public class CWE190_Integer_Overflow__int_console_readLine_multiply_81_goodG2B extends CWE190_Integer_Overflow__int_console_readLine_multiply_81_base
{

    public void action(int data ) throws Throwable
    {

        if(data > 0)   /* ensure we won't have an underflow */
        {
            /* POTENTIAL FLAW: if (data*2) > Integer.MAX_VALUE, this will overflow */
            int result = (int)(data * 2);
            IO.writeLine("result: " + result);
        }

    }

}
