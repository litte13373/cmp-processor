package com.salesforce.tests.fs.impl;

import com.salesforce.tests.fs.Command;
import com.salesforce.tests.fs.domain.CommandInput;
import com.salesforce.tests.fs.domain.FileTree;

public class QUIT implements Command {

	public String execute(FileTree fileTree, CommandInput commandInput) {
		return "";
	}

}
