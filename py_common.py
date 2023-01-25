#! /usr/bin/env/python 3.0
#
# Contains common functions necessary for various python testcase scripts.
#

import os, re, csv, datetime, subprocess, glob, sys, time, shutil

engine_signature = "/* TEMPLATE GENERATED TESTCASE FILE"
def is_generated_file(fullfilepath):
	"""
	Determines if the first line of a file contains the autogenerated signature string.
	"""
	with open(fullfilepath, 'r') as f:
		firstline = f.readline()
		if firstline.strip() == engine_signature:
		        return True
	return False

def find_files_in_dir(directory, regex, silent=True):
	"""
	Finds files that match a regex in a certain directory.  (recursively, case-insensitive)
	Can pass an optional argument of silent=False to print filenames that did not match the regex.
	"""
	matching_files = []
	for root, dirs, files in os.walk(directory):
		for name in files:
			result = re.search(regex, name, re.IGNORECASE)
			if result != None:
				matching_files.append(os.path.realpath(os.path.join(root, name)))
			else:
				if not silent:
					print("Skipped file (did not match regex): ", name)

		# don't enumerate files in .svn dirs
		if '.svn' in dirs:
			dirs.remove('.svn')

	return matching_files

def find_directories_in_dir(directory, regex, silent=True):
	"""
	Finds directories that match a regex in a certain directory (recursively, case-insensitive)
	Can pass an optional argument of silent=False to print filenames that did not match the regex.
	"""
	matching_directories = []
	for root, dirs, files in os.walk(directory):
		# don't enumerate dirs in .svn dirs
		if '.svn' in dirs:
			dirs.remove('.svn')

		for name in dirs:
			result = re.search(regex, name, re.IGNORECASE)
			if result != None:
				matching_directories.append(os.path.realpath(os.path.join(root, name)))
			else:
				if not silent:
					print("Skipped dir (did not match regex): ", name)

	return matching_directories

def find_all_files_in_dir_nr(directory):
	"""
	Finds all files (non-directories) in a directory.  This function is not recursive.
	"""
	files = os.listdir(directory)

	# append base dir
	files = list(map(lambda x: os.path.join(directory, x), files))

	# make sure each path is a file (and not a directory)
	files = list(filter(lambda x: os.path.isfile(x), files))

	return files

def find_testcase_functional_variants_in_dir(dir):
	func_vars = []
	
	# filter the list of test cases to the baseline test cases so that we can
	# iterate over this list without worrying about duplicate functional variants
	baseline_testcases = find_files_in_dir(dir, get_baseline_functional_variant_regex())
	
	for btc in baseline_testcases:
		btc_file_name = os.path.basename(btc)
		result = re.search(get_testcase_filename_regex(), btc_file_name, re.IGNORECASE)

		if result != None:
			func_vars.append(result.group('functional_variant_name'))
		else:
			print('Could not determine the functional variant in ' + btc_file_name)
			exit(1)

	return func_vars
	
def open_file_and_get_contents(file):
	"""
	Returns the entire contents of a file as one large string.
	"""
	with open(file, 'r') as f:
		try:
			content = f.read()
			return content
		except UnicodeDecodeError as error:
			print("\n\n")
			print(error)
			print("Weird char in ", file)
			print("\n")
			return None;

def open_file_and_get_lines(file):
	"""
	Returns the file as a list of lines
	"""
	with open(file, 'r') as f:
		try:
			lines = f.readlines()
			return lines
		except UnicodeDecodeError as error:
			print("\n\n")
			print(error)
			print("Weird char in ", file)
			print("\n")
			return None;

def write_file(filename, contents):
	"""
	Write contents to file.
	"""
	with open(filename, 'w') as f:
		f.write(contents)

def read_csv(filename):
	"""
	Reads a csv.
	"""
	raw_records = []
	with open(filename, 'r') as f:
		reader = csv.reader(f, dialect='excel')
		for row in reader:
			raw_records.append(row)
	
	return raw_records

def read_csv_with_header(filename):
	"""
	Reads a csv and returns the header along with the records.
	"""
	raw_records = read_csv(filename)

	header = raw_records.pop(0)

	return header, raw_records

def write_csv(filename, records):
	"""
	Writes a list to a csv.
	"""
	with open(filename, 'w', newline='') as f:
		writer = csv.writer(f, dialect='excel')
		for r in records:
			writer.writerow(r)

def transform_csv(input_file, output_file, header_fx=None, row_fx=None):
	"""
	Transforms a csv using streaming technique.  Calls a header function that
	allows the caller to modify the header; also calls a row function that
	allows the caller to modify each row in csv.

	Allows the caller to pass arbitrary arguments between the header fx
	and row fx.

	The header function should look like (at a minimum):
		def header_fx(header):
			data = "data to share with row_fx"
			return header, data

	The row function declaration should look like (at a minimum):
		def row_fx(orig_header, new_header, row, data):
			return row

	"""

	with open(input_file, 'r', newline='') as fi:
		reader = csv.reader(fi, dialect='excel')
		orig_header = next(reader)

		if header_fx == None:
			new_header, data = orig_header, None
		else:
			new_header, data = header_fx(orig_header)

		with open(output_file, 'w', newline='') as fo:
			writer = csv.writer(fo, dialect='excel')
			writer.writerow(new_header)

			for row in reader:

				if row_fx == None:
					pass
				else:
					row = row_fx(orig_header, new_header, row, data)

				writer.writerow(row)
	
	return output_file

def get_c_good_fx_counting_regex():
	"""
	This is not used to figure out ALL C good functions.  This regex is a way of counting
	how many non-flawed constructs we have per testcase.
	"""
	return "good(\d+|G2B|B2G|G2B\d+|B2G\d+)"

def get_java_good_fx_counting_regex():
	"""
	This is not used to figure out ALL Java good functions.  This regex is a way of counting
	how many non-flawed constructs we have per testcase.
	"""
	return "good(\d+|G2B|B2G|G2B\d+|B2G\d+)"

def get_testcase_filename_regex():
	"""
	This regex matches primary and secondary test case files.
	Matches must be performed case-insensitive. (re.IGNORECASE)

	If you change this regex, update the C# common library regex.
	If you change this regex, update the primary testcase filename regex.
	"""

	return "^cwe" + \
		"(?P<cwe_number>\d+)" + \
		"_" + \
		"(?P<cwe_name>.*)" + \
		"__" + \
		"(?P<functional_variant_name>.*)" + \
		"_" + \
		"(?P<flow_variant_id>\d+)" + \
		"_?" + \
		"(?P<subfile_id>[a-z]{1}|(bad)|(good(\d)+)|(base)|(goodB2G)|(goodG2B))?" + \
		"\." + \
		"(?P<extension>c|cpp|java|h)$"

def get_primary_testcase_filename_regex():
	"""
	This regex matches only primary test case files.
	Matches must be performed case-insensitive. (re.IGNORECASE)

	The "(?!8[12]_bad)" is a "negative lookahead" so that we don't 
	get the 81_bad or 82_bad file as the primary since those flow 
	variants also have an "a" file (which is the primary file)
	
	The "(?!CWE580.*01_bad.java)" prevents getting the _bad file for 
	CWE580 since it also has an "a" file.
	"""

	return "^(?!CWE580.*01_bad.java)" + \
		"cwe" + \
		"(?P<cwe_number>\d+)" + \
		"_" + \
		"(?P<cwe_name>.*)" + \
		"__" + \
		"(?P<functional_variant_name>.*)" + \
		"_" + \
		"(?!8[12]_bad)" + \
		"(?P<flow_variant_id>\d+)" + \
		"_?" + \
		"(?P<subfile_id>a|(_bad))?" + \
		"\." + \
		"(?P<extension>c|cpp|java)$"
		
def get_baseline_functional_variant_regex():
	"""
	This regex matches only baseline test case files
	and can be used to calculate the number of functional variants.
	Matches must be performed case-insensitive. (re.IGNORECASE)

	The "(?!CWE580.*01_bad.java)" prevents getting the _bad file for 
	CWE580 since it also has an "a" file.
	"""
	
	return "^(?!CWE580.*01_bad.java)CWE\d+.*_01((a)|(_?bad)|)\.(c|cpp|java)?$"

def get_functionname_c_regex():
	"""
	Used to get the "simple" function name for c functions.
	"""
	return "^(CWE|cwe)(?P<cwe_number>\d+)_(?P<cwe_name>.*)__(?P<function_variant>.*)_(?P<flow_variant>\d+)(?P<subfile_id>[a-z]*)_(?P<function_name>[^.]*)$"
	
def get_cwe_id_regex():
	"""
	Used to get the CWE ID from a test case file or path name
	"""
	return "(CWE\d+)_"

def get_timestamp():
	"""
	Returns a timestamp of the form YYYY-MM-DD.
	"""
	date = datetime.date.today()
	return str(date)

def map_weakness_classes(file):
	"""
	Reads the weakness class csv file.  Allows a cwe to be part of multiple weakness classes.
	"""
	header, records = read_csv_with_header(file)

	dict = {}

	for record in records:
		cwe = record[header.index("CWEID")]
		wclass = record[header.index("Weakness Class")]
		if cwe in dict.keys():
			dict[cwe].append(wclass)
			# may want to error here instead
			print("Warning: CWE is assigned to more than 1 category")
		else:
			dict[cwe] = [wclass]

	return dict

def print_with_timestamp(contents):
	"""
	Print a string with the timestamp at the beginning of the line.
	"""
	print("[" + time.ctime(None) + "] " + contents)
	
def run_commands(commands, use_shell=False):
	"""
	Runs a command as if it were run in the command prompt.  If you need to use commands such as
	"cd, dir, etc", set use_shell to True.
	"""
	command = " && ".join(commands)
	
	# Not using print_with_timestamp() here since we want to capture the time for the time diff
	time_started = time.time()
	print("[" + time.ctime(time_started) + "] Started command: \"" + command + "\"")
	sys.stdout.flush()
	
	subprocess.check_call(command, shell=use_shell, stderr=sys.stderr, stdout=sys.stdout)
	
	# Not using print_with_timestamp() here since we want to capture the time for the time diff
	time_ended = time.time()
	print("[" + time.ctime(time_ended) + "] Finished command: \"" + command + "\"")
	
	elapsed_seconds = time_ended-time_started
	print_with_timestamp("Command \"" + command + "\" took " + str(elapsed_seconds) + " seconds to complete.")

def run_analysis(glob_needle, run_analysis_fx):
	"""
	Helper method to run an analysis using a tool.  Takes a glob string to search
	for and a function pointer.
	"""

	time_started = time.time()

	# find all the files
	files = glob.glob(glob_needle)

	# run all the files using the function pointer
	for file in files:

		# change into directory with the file
		dir = os.path.dirname(file)
		os.chdir(dir)

		# run the the file
		file = os.path.basename(file)
		run_analysis_fx(file)

		# return to original working directory
		os.chdir(sys.path[0])
	
	time_ended = time.time()

	print("Started: " + time.ctime(time_started))
	print("Ended: " + time.ctime(time_ended))

	elapsed_seconds = time_ended-time_started
	print("Elapsed time (in seconds): " + str(elapsed_seconds))

def break_up_filename(file_name):
	"""
	Looks for various parts of the filename to place into the new columns.
	"""

	cwe_num = ''
	cwe_name = ''
	fx_var = ''
	flow_var = ''
	subfile = ''
	lang = ''

	result = re.search(get_testcase_filename_regex(), file_name, re.IGNORECASE)

	if result == None:

		# use blank values
		print("Warning! file \"" + file_name + "\" is not going to be parsed into parts! (blank values will be used)", file_name)
	else:
		# its a normal testcase file
		cwe_num = result.group('cwe_number')
		cwe_name = result.group('cwe_name')
		fx_var = result.group('functional_variant_name')
		flow_var = result.group('flow_variant_id')
		subfile = result.group('subfile_id')
		lang = result.group('extension')

	parts = {}
	parts["testcase_cwe_number"] = cwe_num
	parts["testcase_cwe_name"] = cwe_name
	parts["testcase_function_variant"] = fx_var
	parts["testcase_flow_variant"] = flow_var
	parts["testcase_subfile_id"] = subfile
	parts["testcase_language"] = lang

	return parts

def break_up_cpp_function_name(function_name):
	"""
	Looks for various parts of the function name to place into the simplified function name
	"""

	result = re.search(get_functionname_c_regex(), function_name, re.IGNORECASE)

	if result == None:
		# Just use the original
		return function_name
	else:
		# Use the "simplified" portion
		return result.group("function_name")

def concatenate_csvs(input_directory, output_file):
	"""
	Combines multiple CSV files into a single CSV file.
	"""
	
	with open(output_file, 'w', newline='') as f:
		writer = csv.writer(f, dialect='excel')
		need_header = True
		
		for file in find_files_in_dir(input_directory, ".*?\.csv$"):
			header, records = read_csv_with_header(file)
			if need_header:
				writer.writerow(header)
				need_header = False
			for record in records:
				writer.writerow(record)

def generate_unique_finding_ids(input_csv, output_csv):
	"""
	Modifies CSV so that each number in the finding_id column is unique
	"""
	
	with open(input_csv, 'r', newline='') as fi:
		reader = csv.reader(fi, dialect='excel')
		header = next(reader)
		
		if 'finding_id' in header:
			finding_id_index = header.index('finding_id')
		else:
			print('finding_id does not exist in CSV header')
			exit()

		with open(output_csv, 'w', newline='') as fo:
			writer = csv.writer(fo, dialect='excel')
			writer.writerow(header)

			unique_id = 1
			for row in reader:

				row[finding_id_index] = unique_id
				writer.writerow(row)
				unique_id = unique_id + 1

unique_id_count = 1
def add_unique_finding_ids(orig_header, new_header, row, data):
	"""
	Modifies CSV row so that each number in the finding_id column is unique
	Call this from transform_csv
	
	For example: transform_csv(input_file, output_file, header_fx=None, row_fx=add_unique_finding_id)
	"""
	global unique_id_count
	finding_id_index = orig_header.index('finding_id')
	row[finding_id_index] = unique_id_count
	
	unique_id_count += 1
	
	return row
	
def encode_language(input_lang):
	"""
	Checks the input language to ensure invalid file name/path characters do
	not exist in the language as it is often used to generate output file names
	in our scripts.
	
	We currently only analyze C, C++, Java, C#, and .NET code, so if a new
	language other than those listed is added we may need to review this helper
	function.
	"""
	
	encoded_lang = input_lang.replace("+", "p") # for C++
	encoded_lang = encoded_lang.replace("/", "_") # for C/C++
	encoded_lang = encoded_lang.replace("\\", "_") # for C\C++
	encoded_lang = encoded_lang.replace("#", "sharp") # for C#
	
	return encoded_lang

def move_testcase_to_split_directories(dir, functional_variants, testcase_files):
	count = 1
	for func_var in functional_variants:
		# Create a new directory for each functional variant, but make sure the
		# single digit directories start with a leading zero
		if count < 10:
			func_var_dir = os.path.join(dir, '0' + str(count))
		else: 
			func_var_dir = os.path.join(dir, str(count))
		os.mkdir(func_var_dir)
		
		# filter the list of test cases for this funcitonal variant
		func_var_regex = "__" + func_var + "_\d\d"
		func_var_testcase_files = filter(lambda x: re.search(func_var_regex, x, re.IGNORECASE) != None, testcase_files)
		
		# Copy the files for this functional variant to the new directory
		# and remove the file from the CWE root directory
		print_with_timestamp("Moving the test cases for the following functional variant \"" + func_var + "\"")
		for testcase_file in func_var_testcase_files:
			shutil.copy(testcase_file, func_var_dir)
			os.unlink(testcase_file)
		
		count = count + 1
