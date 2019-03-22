package com.salesforce.tests.fs;

import com.salesforce.tests.fs.domain.CommandInput;
import com.salesforce.tests.fs.domain.FileTree;

public interface Command {

	public String execute(FileTree fileTree, CommandInput commandInput);
	
}
