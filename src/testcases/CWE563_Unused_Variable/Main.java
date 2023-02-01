package testcasesupport;

public class Main {

	public static void main(String[] args) {
		
		if(args.length != 0) {
		
			if(args[0].equals("-h") || args[0].equals("--help")) {
		
				System.err.println("To use this main, you can either run the program with no " +
				"command line arguments to run all test cases or you can specify one or more classes to test");
				System.err.println("For example:");
				System.err.println("java testcasesupport.Main testcases.CWE690_Unchecked_Return_Value_to_NULL_Pointer_Dereference.custom_function.CWE690_Unchecked_Return_Value_to_NULL_Pointer_Dereference__custom_function_01 testcases.CWE481_Assigning_instead_of_Comparing.bool.CWE481_Assigning_instead_of_Comparing__bool_01");
				System.exit(1);
			}
			
			/* User supplied some class names on the command line, just use those with introspection
			 *
			 * String classNames[] = { "CWE481_Assigning_instead_of_Comparing__boolean_01",
			 *		"CWE476_Null_Pointer_Dereference__getProperty_01" };
 			 * could read class names from command line or use
			 * http://sadun-util.sourceforge.net/api/org/sadun/util/
			 * ClassPackageExplorer.html
			 */

			for (String className : args) {

				try {
					
					/* String classNameWithPackage = "testcases." + className; */
					
					/* IO.writeLine("classNameWithPackage = " + classNameWithPackage); */

					Class<?> myClass = Class.forName(className);

					AbstractTestCase myObject = (AbstractTestCase) myClass
							.newInstance();

					myObject.runTest(className);

				} catch (Exception ex) {

					IO.writeLine("Could not run test for class " + className);
					ex.printStackTrace();

				}
				
				IO.writeLine(""); /* leave a blank line between classes */

			}

		} else {
		
			/* No command line args were used, we want to run every testcase */
			
			/* needed to separate these calls into other methods because
			   we were running into the size limit Java has for a single method */
			runTestCWE1();
			runTestCWE2();
			runTestCWE3();
			runTestCWE4();
			runTestCWE5();
			runTestCWE6();
			runTestCWE7();
			runTestCWE8();
			runTestCWE9();
		}			
	}

private static void runTestCWE1() {
/* BEGIN-AUTOGENERATED-JAVA-TESTS-1 */

			/* END-AUTOGENERATED-JAVA-TESTS-1 */
}

private static void runTestCWE2() {
/* BEGIN-AUTOGENERATED-JAVA-TESTS-2 */

			/* END-AUTOGENERATED-JAVA-TESTS-2 */
}

private static void runTestCWE3() {
/* BEGIN-AUTOGENERATED-JAVA-TESTS-3 */

			/* END-AUTOGENERATED-JAVA-TESTS-3 */
}

private static void runTestCWE4() {
/* BEGIN-AUTOGENERATED-JAVA-TESTS-4 */

			/* END-AUTOGENERATED-JAVA-TESTS-4 */
}

private static void runTestCWE5() {
/* BEGIN-AUTOGENERATED-JAVA-TESTS-5 */
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_int_01()).runTest("CWE563_Unused_Variable__unused_init_variable_int_01");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_int_02()).runTest("CWE563_Unused_Variable__unused_init_variable_int_02");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_int_03()).runTest("CWE563_Unused_Variable__unused_init_variable_int_03");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_int_04()).runTest("CWE563_Unused_Variable__unused_init_variable_int_04");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_int_05()).runTest("CWE563_Unused_Variable__unused_init_variable_int_05");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_int_06()).runTest("CWE563_Unused_Variable__unused_init_variable_int_06");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_int_07()).runTest("CWE563_Unused_Variable__unused_init_variable_int_07");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_int_08()).runTest("CWE563_Unused_Variable__unused_init_variable_int_08");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_int_09()).runTest("CWE563_Unused_Variable__unused_init_variable_int_09");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_int_10()).runTest("CWE563_Unused_Variable__unused_init_variable_int_10");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_int_11()).runTest("CWE563_Unused_Variable__unused_init_variable_int_11");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_int_13()).runTest("CWE563_Unused_Variable__unused_init_variable_int_13");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_int_14()).runTest("CWE563_Unused_Variable__unused_init_variable_int_14");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_int_15()).runTest("CWE563_Unused_Variable__unused_init_variable_int_15");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_int_16()).runTest("CWE563_Unused_Variable__unused_init_variable_int_16");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_int_17()).runTest("CWE563_Unused_Variable__unused_init_variable_int_17");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_int_81a()).runTest("CWE563_Unused_Variable__unused_init_variable_int_81a");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_long_01()).runTest("CWE563_Unused_Variable__unused_init_variable_long_01");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_long_02()).runTest("CWE563_Unused_Variable__unused_init_variable_long_02");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_long_03()).runTest("CWE563_Unused_Variable__unused_init_variable_long_03");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_long_04()).runTest("CWE563_Unused_Variable__unused_init_variable_long_04");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_long_05()).runTest("CWE563_Unused_Variable__unused_init_variable_long_05");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_long_06()).runTest("CWE563_Unused_Variable__unused_init_variable_long_06");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_long_07()).runTest("CWE563_Unused_Variable__unused_init_variable_long_07");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_long_08()).runTest("CWE563_Unused_Variable__unused_init_variable_long_08");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_long_09()).runTest("CWE563_Unused_Variable__unused_init_variable_long_09");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_long_10()).runTest("CWE563_Unused_Variable__unused_init_variable_long_10");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_long_11()).runTest("CWE563_Unused_Variable__unused_init_variable_long_11");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_long_13()).runTest("CWE563_Unused_Variable__unused_init_variable_long_13");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_long_14()).runTest("CWE563_Unused_Variable__unused_init_variable_long_14");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_long_15()).runTest("CWE563_Unused_Variable__unused_init_variable_long_15");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_long_16()).runTest("CWE563_Unused_Variable__unused_init_variable_long_16");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_long_17()).runTest("CWE563_Unused_Variable__unused_init_variable_long_17");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_long_81a()).runTest("CWE563_Unused_Variable__unused_init_variable_long_81a");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_StringBuilder_01()).runTest("CWE563_Unused_Variable__unused_init_variable_StringBuilder_01");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_StringBuilder_02()).runTest("CWE563_Unused_Variable__unused_init_variable_StringBuilder_02");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_StringBuilder_03()).runTest("CWE563_Unused_Variable__unused_init_variable_StringBuilder_03");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_StringBuilder_04()).runTest("CWE563_Unused_Variable__unused_init_variable_StringBuilder_04");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_StringBuilder_05()).runTest("CWE563_Unused_Variable__unused_init_variable_StringBuilder_05");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_StringBuilder_06()).runTest("CWE563_Unused_Variable__unused_init_variable_StringBuilder_06");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_StringBuilder_07()).runTest("CWE563_Unused_Variable__unused_init_variable_StringBuilder_07");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_StringBuilder_08()).runTest("CWE563_Unused_Variable__unused_init_variable_StringBuilder_08");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_StringBuilder_09()).runTest("CWE563_Unused_Variable__unused_init_variable_StringBuilder_09");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_StringBuilder_10()).runTest("CWE563_Unused_Variable__unused_init_variable_StringBuilder_10");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_StringBuilder_11()).runTest("CWE563_Unused_Variable__unused_init_variable_StringBuilder_11");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_StringBuilder_13()).runTest("CWE563_Unused_Variable__unused_init_variable_StringBuilder_13");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_StringBuilder_14()).runTest("CWE563_Unused_Variable__unused_init_variable_StringBuilder_14");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_StringBuilder_15()).runTest("CWE563_Unused_Variable__unused_init_variable_StringBuilder_15");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_StringBuilder_16()).runTest("CWE563_Unused_Variable__unused_init_variable_StringBuilder_16");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_StringBuilder_17()).runTest("CWE563_Unused_Variable__unused_init_variable_StringBuilder_17");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_StringBuilder_81a()).runTest("CWE563_Unused_Variable__unused_init_variable_StringBuilder_81a");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_String_01()).runTest("CWE563_Unused_Variable__unused_init_variable_String_01");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_String_02()).runTest("CWE563_Unused_Variable__unused_init_variable_String_02");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_String_03()).runTest("CWE563_Unused_Variable__unused_init_variable_String_03");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_String_04()).runTest("CWE563_Unused_Variable__unused_init_variable_String_04");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_String_05()).runTest("CWE563_Unused_Variable__unused_init_variable_String_05");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_String_06()).runTest("CWE563_Unused_Variable__unused_init_variable_String_06");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_String_07()).runTest("CWE563_Unused_Variable__unused_init_variable_String_07");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_String_08()).runTest("CWE563_Unused_Variable__unused_init_variable_String_08");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_String_09()).runTest("CWE563_Unused_Variable__unused_init_variable_String_09");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_String_10()).runTest("CWE563_Unused_Variable__unused_init_variable_String_10");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_String_11()).runTest("CWE563_Unused_Variable__unused_init_variable_String_11");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_String_13()).runTest("CWE563_Unused_Variable__unused_init_variable_String_13");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_String_14()).runTest("CWE563_Unused_Variable__unused_init_variable_String_14");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_String_15()).runTest("CWE563_Unused_Variable__unused_init_variable_String_15");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_String_16()).runTest("CWE563_Unused_Variable__unused_init_variable_String_16");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_String_17()).runTest("CWE563_Unused_Variable__unused_init_variable_String_17");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_init_variable_String_81a()).runTest("CWE563_Unused_Variable__unused_init_variable_String_81a");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_parameter_value_01()).runTest("CWE563_Unused_Variable__unused_parameter_value_01");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_parameter_variable_01()).runTest("CWE563_Unused_Variable__unused_parameter_variable_01");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_int_01()).runTest("CWE563_Unused_Variable__unused_uninit_variable_int_01");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_int_02()).runTest("CWE563_Unused_Variable__unused_uninit_variable_int_02");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_int_03()).runTest("CWE563_Unused_Variable__unused_uninit_variable_int_03");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_int_04()).runTest("CWE563_Unused_Variable__unused_uninit_variable_int_04");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_int_05()).runTest("CWE563_Unused_Variable__unused_uninit_variable_int_05");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_int_06()).runTest("CWE563_Unused_Variable__unused_uninit_variable_int_06");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_int_07()).runTest("CWE563_Unused_Variable__unused_uninit_variable_int_07");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_int_08()).runTest("CWE563_Unused_Variable__unused_uninit_variable_int_08");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_int_09()).runTest("CWE563_Unused_Variable__unused_uninit_variable_int_09");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_int_10()).runTest("CWE563_Unused_Variable__unused_uninit_variable_int_10");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_int_11()).runTest("CWE563_Unused_Variable__unused_uninit_variable_int_11");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_int_13()).runTest("CWE563_Unused_Variable__unused_uninit_variable_int_13");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_int_14()).runTest("CWE563_Unused_Variable__unused_uninit_variable_int_14");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_int_15()).runTest("CWE563_Unused_Variable__unused_uninit_variable_int_15");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_int_16()).runTest("CWE563_Unused_Variable__unused_uninit_variable_int_16");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_int_17()).runTest("CWE563_Unused_Variable__unused_uninit_variable_int_17");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_long_01()).runTest("CWE563_Unused_Variable__unused_uninit_variable_long_01");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_long_02()).runTest("CWE563_Unused_Variable__unused_uninit_variable_long_02");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_long_03()).runTest("CWE563_Unused_Variable__unused_uninit_variable_long_03");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_long_04()).runTest("CWE563_Unused_Variable__unused_uninit_variable_long_04");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_long_05()).runTest("CWE563_Unused_Variable__unused_uninit_variable_long_05");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_long_06()).runTest("CWE563_Unused_Variable__unused_uninit_variable_long_06");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_long_07()).runTest("CWE563_Unused_Variable__unused_uninit_variable_long_07");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_long_08()).runTest("CWE563_Unused_Variable__unused_uninit_variable_long_08");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_long_09()).runTest("CWE563_Unused_Variable__unused_uninit_variable_long_09");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_long_10()).runTest("CWE563_Unused_Variable__unused_uninit_variable_long_10");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_long_11()).runTest("CWE563_Unused_Variable__unused_uninit_variable_long_11");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_long_13()).runTest("CWE563_Unused_Variable__unused_uninit_variable_long_13");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_long_14()).runTest("CWE563_Unused_Variable__unused_uninit_variable_long_14");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_long_15()).runTest("CWE563_Unused_Variable__unused_uninit_variable_long_15");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_long_16()).runTest("CWE563_Unused_Variable__unused_uninit_variable_long_16");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_long_17()).runTest("CWE563_Unused_Variable__unused_uninit_variable_long_17");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_StringBuilder_01()).runTest("CWE563_Unused_Variable__unused_uninit_variable_StringBuilder_01");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_StringBuilder_02()).runTest("CWE563_Unused_Variable__unused_uninit_variable_StringBuilder_02");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_StringBuilder_03()).runTest("CWE563_Unused_Variable__unused_uninit_variable_StringBuilder_03");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_StringBuilder_04()).runTest("CWE563_Unused_Variable__unused_uninit_variable_StringBuilder_04");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_StringBuilder_05()).runTest("CWE563_Unused_Variable__unused_uninit_variable_StringBuilder_05");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_StringBuilder_06()).runTest("CWE563_Unused_Variable__unused_uninit_variable_StringBuilder_06");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_StringBuilder_07()).runTest("CWE563_Unused_Variable__unused_uninit_variable_StringBuilder_07");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_StringBuilder_08()).runTest("CWE563_Unused_Variable__unused_uninit_variable_StringBuilder_08");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_StringBuilder_09()).runTest("CWE563_Unused_Variable__unused_uninit_variable_StringBuilder_09");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_StringBuilder_10()).runTest("CWE563_Unused_Variable__unused_uninit_variable_StringBuilder_10");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_StringBuilder_11()).runTest("CWE563_Unused_Variable__unused_uninit_variable_StringBuilder_11");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_StringBuilder_13()).runTest("CWE563_Unused_Variable__unused_uninit_variable_StringBuilder_13");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_StringBuilder_14()).runTest("CWE563_Unused_Variable__unused_uninit_variable_StringBuilder_14");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_StringBuilder_15()).runTest("CWE563_Unused_Variable__unused_uninit_variable_StringBuilder_15");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_StringBuilder_16()).runTest("CWE563_Unused_Variable__unused_uninit_variable_StringBuilder_16");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_StringBuilder_17()).runTest("CWE563_Unused_Variable__unused_uninit_variable_StringBuilder_17");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_String_01()).runTest("CWE563_Unused_Variable__unused_uninit_variable_String_01");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_String_02()).runTest("CWE563_Unused_Variable__unused_uninit_variable_String_02");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_String_03()).runTest("CWE563_Unused_Variable__unused_uninit_variable_String_03");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_String_04()).runTest("CWE563_Unused_Variable__unused_uninit_variable_String_04");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_String_05()).runTest("CWE563_Unused_Variable__unused_uninit_variable_String_05");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_String_06()).runTest("CWE563_Unused_Variable__unused_uninit_variable_String_06");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_String_07()).runTest("CWE563_Unused_Variable__unused_uninit_variable_String_07");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_String_08()).runTest("CWE563_Unused_Variable__unused_uninit_variable_String_08");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_String_09()).runTest("CWE563_Unused_Variable__unused_uninit_variable_String_09");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_String_10()).runTest("CWE563_Unused_Variable__unused_uninit_variable_String_10");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_String_11()).runTest("CWE563_Unused_Variable__unused_uninit_variable_String_11");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_String_13()).runTest("CWE563_Unused_Variable__unused_uninit_variable_String_13");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_String_14()).runTest("CWE563_Unused_Variable__unused_uninit_variable_String_14");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_String_15()).runTest("CWE563_Unused_Variable__unused_uninit_variable_String_15");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_String_16()).runTest("CWE563_Unused_Variable__unused_uninit_variable_String_16");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_uninit_variable_String_17()).runTest("CWE563_Unused_Variable__unused_uninit_variable_String_17");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_int_01()).runTest("CWE563_Unused_Variable__unused_value_int_01");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_int_02()).runTest("CWE563_Unused_Variable__unused_value_int_02");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_int_03()).runTest("CWE563_Unused_Variable__unused_value_int_03");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_int_04()).runTest("CWE563_Unused_Variable__unused_value_int_04");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_int_05()).runTest("CWE563_Unused_Variable__unused_value_int_05");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_int_06()).runTest("CWE563_Unused_Variable__unused_value_int_06");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_int_07()).runTest("CWE563_Unused_Variable__unused_value_int_07");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_int_08()).runTest("CWE563_Unused_Variable__unused_value_int_08");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_int_09()).runTest("CWE563_Unused_Variable__unused_value_int_09");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_int_10()).runTest("CWE563_Unused_Variable__unused_value_int_10");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_int_11()).runTest("CWE563_Unused_Variable__unused_value_int_11");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_int_13()).runTest("CWE563_Unused_Variable__unused_value_int_13");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_int_14()).runTest("CWE563_Unused_Variable__unused_value_int_14");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_int_15()).runTest("CWE563_Unused_Variable__unused_value_int_15");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_int_16()).runTest("CWE563_Unused_Variable__unused_value_int_16");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_int_17()).runTest("CWE563_Unused_Variable__unused_value_int_17");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_int_81a()).runTest("CWE563_Unused_Variable__unused_value_int_81a");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_long_01()).runTest("CWE563_Unused_Variable__unused_value_long_01");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_long_02()).runTest("CWE563_Unused_Variable__unused_value_long_02");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_long_03()).runTest("CWE563_Unused_Variable__unused_value_long_03");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_long_04()).runTest("CWE563_Unused_Variable__unused_value_long_04");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_long_05()).runTest("CWE563_Unused_Variable__unused_value_long_05");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_long_06()).runTest("CWE563_Unused_Variable__unused_value_long_06");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_long_07()).runTest("CWE563_Unused_Variable__unused_value_long_07");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_long_08()).runTest("CWE563_Unused_Variable__unused_value_long_08");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_long_09()).runTest("CWE563_Unused_Variable__unused_value_long_09");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_long_10()).runTest("CWE563_Unused_Variable__unused_value_long_10");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_long_11()).runTest("CWE563_Unused_Variable__unused_value_long_11");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_long_13()).runTest("CWE563_Unused_Variable__unused_value_long_13");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_long_14()).runTest("CWE563_Unused_Variable__unused_value_long_14");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_long_15()).runTest("CWE563_Unused_Variable__unused_value_long_15");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_long_16()).runTest("CWE563_Unused_Variable__unused_value_long_16");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_long_17()).runTest("CWE563_Unused_Variable__unused_value_long_17");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_long_81a()).runTest("CWE563_Unused_Variable__unused_value_long_81a");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_StringBuilder_01()).runTest("CWE563_Unused_Variable__unused_value_StringBuilder_01");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_StringBuilder_02()).runTest("CWE563_Unused_Variable__unused_value_StringBuilder_02");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_StringBuilder_03()).runTest("CWE563_Unused_Variable__unused_value_StringBuilder_03");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_StringBuilder_04()).runTest("CWE563_Unused_Variable__unused_value_StringBuilder_04");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_StringBuilder_05()).runTest("CWE563_Unused_Variable__unused_value_StringBuilder_05");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_StringBuilder_06()).runTest("CWE563_Unused_Variable__unused_value_StringBuilder_06");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_StringBuilder_07()).runTest("CWE563_Unused_Variable__unused_value_StringBuilder_07");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_StringBuilder_08()).runTest("CWE563_Unused_Variable__unused_value_StringBuilder_08");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_StringBuilder_09()).runTest("CWE563_Unused_Variable__unused_value_StringBuilder_09");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_StringBuilder_10()).runTest("CWE563_Unused_Variable__unused_value_StringBuilder_10");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_StringBuilder_11()).runTest("CWE563_Unused_Variable__unused_value_StringBuilder_11");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_StringBuilder_13()).runTest("CWE563_Unused_Variable__unused_value_StringBuilder_13");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_StringBuilder_14()).runTest("CWE563_Unused_Variable__unused_value_StringBuilder_14");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_StringBuilder_15()).runTest("CWE563_Unused_Variable__unused_value_StringBuilder_15");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_StringBuilder_16()).runTest("CWE563_Unused_Variable__unused_value_StringBuilder_16");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_StringBuilder_17()).runTest("CWE563_Unused_Variable__unused_value_StringBuilder_17");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_StringBuilder_81a()).runTest("CWE563_Unused_Variable__unused_value_StringBuilder_81a");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_String_01()).runTest("CWE563_Unused_Variable__unused_value_String_01");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_String_02()).runTest("CWE563_Unused_Variable__unused_value_String_02");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_String_03()).runTest("CWE563_Unused_Variable__unused_value_String_03");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_String_04()).runTest("CWE563_Unused_Variable__unused_value_String_04");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_String_05()).runTest("CWE563_Unused_Variable__unused_value_String_05");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_String_06()).runTest("CWE563_Unused_Variable__unused_value_String_06");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_String_07()).runTest("CWE563_Unused_Variable__unused_value_String_07");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_String_08()).runTest("CWE563_Unused_Variable__unused_value_String_08");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_String_09()).runTest("CWE563_Unused_Variable__unused_value_String_09");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_String_10()).runTest("CWE563_Unused_Variable__unused_value_String_10");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_String_11()).runTest("CWE563_Unused_Variable__unused_value_String_11");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_String_13()).runTest("CWE563_Unused_Variable__unused_value_String_13");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_String_14()).runTest("CWE563_Unused_Variable__unused_value_String_14");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_String_15()).runTest("CWE563_Unused_Variable__unused_value_String_15");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_String_16()).runTest("CWE563_Unused_Variable__unused_value_String_16");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_String_17()).runTest("CWE563_Unused_Variable__unused_value_String_17");
			(new testcases.CWE563_Unused_Variable.CWE563_Unused_Variable__unused_value_String_81a()).runTest("CWE563_Unused_Variable__unused_value_String_81a");
			/* END-AUTOGENERATED-JAVA-TESTS-5 */
}

private static void runTestCWE6() {
/* BEGIN-AUTOGENERATED-JAVA-TESTS-6 */

			/* END-AUTOGENERATED-JAVA-TESTS-6 */
}

private static void runTestCWE7() {
/* BEGIN-AUTOGENERATED-JAVA-TESTS-7 */

			/* END-AUTOGENERATED-JAVA-TESTS-7 */
}

private static void runTestCWE8() {
/* BEGIN-AUTOGENERATED-JAVA-TESTS-8 */

			/* END-AUTOGENERATED-JAVA-TESTS-8 */
}

private static void runTestCWE9() {
/* BEGIN-AUTOGENERATED-JAVA-TESTS-9 */

			/* END-AUTOGENERATED-JAVA-TESTS-9 */
}
}