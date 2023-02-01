/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE506_Embedded_Malicious_Code__base64_encoded_payload_17.java
Label Definition File: CWE506_Embedded_Malicious_Code.label.xml
Template File: point-flaw-17.tmpl.java
*/
/*
* @description
* CWE: 506 Embedded Malicious Code
* Sinks: base64_encoded_payload
*    GoodSink: Use a plaintext command
*    BadSink : Use a base64 encoded payload in an attempt to hide the command
* Flow Variant: 17 Control flow: for loops
*
* */

package testcases.CWE506_Embedded_Malicious_Code;

import testcasesupport.*;

import java.io.*;
import java.util.logging.Level;

import org.apache.commons.codec.binary.Base64;

public class CWE506_Embedded_Malicious_Code__base64_encoded_payload_17 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        for(int for_index_j = 0; for_index_j < 1; for_index_j++)
        {
            /* FLAW: encoded "calc.exe" */
            String encodedPayload = "Y2FsYy5leGU=";
            try
            {
                Runtime.getRuntime().exec(new String(Base64.decodeBase64(encodedPayload), "UTF-8"));
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "Error executing command", e);
            }
        }

        for(int for_index_k = 0; for_index_k < 0; for_index_k++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: plaintext command */
            String decodedPayload = "calc.exe";
            try
            {
                Runtime.getRuntime().exec(decodedPayload);
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "Error executing command", e);
            }
        }
    }

    /* good1() change the conditions on the while statements */
    private void good1() throws Throwable
    {
        for(int for_index_j = 0; for_index_j < 0; for_index_j++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FLAW: encoded "calc.exe" */
            String encodedPayload = "Y2FsYy5leGU=";
            try
            {
                Runtime.getRuntime().exec(new String(Base64.decodeBase64(encodedPayload), "UTF-8"));
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "Error executing command", e);
            }
        }

        for(int for_index_k = 0; for_index_k < 1; for_index_k++)
        {
            /* FIX: plaintext command */
            String decodedPayload = "calc.exe";
            try
            {
                Runtime.getRuntime().exec(decodedPayload);
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "Error executing command", e);
            }
        }
    }

    public void good() throws Throwable
    {
        good1();
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
