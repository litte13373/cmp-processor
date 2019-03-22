package com.salesforce.tests.fs.impl;

import com.salesforce.tests.fs.Command;
import com.salesforce.tests.fs.domain.CommandInput;
import com.salesforce.tests.fs.domain.FileNode;
import com.salesforce.tests.fs.domain.FileTree;

public class TOUCH implements Command {

	public String execute(FileTree fileTree, CommandInput commandInput) {
		
		if(commandInput.getCommandParameter() == null){
			return "Missing Parameter";
		}
		
		if (fileTree.childNameExists(commandInput.getCommandParameter())){
			return commandInput.getCommandParameter() + " already exists";
		}
		
		fileTree.createNode(commandInput.getCommandParameter(), false);
		
		return commandInput.getCommandParameter() + " Created";
		 
	}

}
