package gov.cms.qrda.validator.model;
/*
Copyright (c) 2016+, ESAC, Inc.
All rights reserved.

Redistribution and use in source and binary forms, with or without modification, 
are permitted provided that the following conditions are met:

 * Redistributions of source code must retain the above copyright notice, this 
   list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, 
   this list of conditions and the following disclaimer in the documentation 
   and/or other materials provided with the distribution.
 * Neither the name of HL7 nor the names of its contributors may be used to 
   endorse or promote products derived from this software without specific 
   prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
POSSIBILITY OF SUCH DAMAGE.

*/

import java.util.ArrayList;

/**
 * The TestCase class represents a QRDA test file resident on the QRDA file repository defined in the 
 * QRDA_HOME/qrda file space.
 * 
 * A TestCase object holds the name of the test file along with the name of the schematron file to use as
 * the validator, and the the name of the resulting report file.
 * 
 * TestCase extends the FileSpec class, which holds the file information of the test case file.
 * 
 * A ValidationSuite contains a list of TestCase objects. When the ValidationService runs the validation on a 
 * validation suite object, it applies the schematron specified in the suite to each of the TestCase files in that list.
 * 
 * @author dandonahue
 *
 */
public class TestCase extends FileSpec {

	private String schematronFilename = null;           // The filename of the schematron to use to validate this test file.
	private String validationReportFilename = null;     // The filename of the validation report generated during the validation process
	private String validationReportPath = null;         // The full canonical path to the report file on the server's filespace.
	private ArrayList<Failure> errors = null;           // The list of failure objects generated during validation
	private ArrayList<String> statusText = new ArrayList<String>();  // A list of informational text populated as the validation processs progresses.
	
	private Integer errorCount = 0;      // The number of crtical errors found in the errors list, above.
	private Integer warningCount = 0;    // The number of non-critical warnings in the errors list, above.

	
	public TestCase(String schematron, String schematronType, String testFile, String filenamePostfix) {
		super(testFile, "", schematronType);   // Set up the test file information
		schematronFilename = schematron;
		// Generate a unique name for the validation report. (The filenamePostfix is expected to be a formatted timestamp to insure uniqueness.)
		validationReportFilename = getFilename().substring(0,getFilename().lastIndexOf(".")) + "_" + filenamePostfix + ".svrlt";
	}
	
	public String getSchematronFilename() {
		return schematronFilename;
	}
	
	public void setSchematronFilename(String val) {
		schematronFilename = val;
	}
	
	
	public String getValidationReportFilename() {
		return validationReportFilename;
	}
	
	public void setValidationReportFilename(String val) {
		validationReportFilename = val;
	}
	
	public ArrayList<Failure> getErrors() {
		return errors;
	}
	
	public void setErrors(ArrayList<Failure> val) {
		errors = val;
	}
	
	public ArrayList<String> getStatusText() {
		return statusText;
	}
	
	public void addStatusText(String txt) {
		statusText.add(txt);
	}

	
	public Integer getErrorCount() {
		return errorCount;
	}
	
	public void setErrorCount(Integer val) {
		errorCount = val;
	}
	
	public Integer getWarningCount() {
		return warningCount;
	}
	
	public void setWarningCount(Integer val) {
		warningCount = val;
	}
	
	public String getValidationReportPath() {
		return validationReportPath;
	}
	
	public void setValidationReportPath(String val) {
		validationReportPath = val;
	}
}
