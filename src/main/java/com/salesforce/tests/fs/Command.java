package com.salesforce.tests.fs;

import com.salesforce.tests.fs.domain.CommandInput;
import com.salesforce.tests.fs.domain.FileNode;

public interface Command {

	public String execute(FileNode fileInfo, CommandInput commandInput);
	
}
