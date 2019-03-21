package com.salesforce.tests.fs.impl;

import com.salesforce.tests.fs.Command;
import com.salesforce.tests.fs.domain.CommandInput;
import com.salesforce.tests.fs.domain.FileNode;

public class TOUCH implements Command {

	public String execute(FileNode fileNode, CommandInput commandInput) {
		if(commandInput.getCommandParameter() != null){
			FileNode childFileNode = new FileNode();
			childFileNode.setName(commandInput.getCommandParameter());
			childFileNode.setParent(fileNode);
			childFileNode.setIsDirectory(false);
			fileNode.getChildren().add(fileNode);
			return commandInput.getCommandParameter() + " Created";
		} else {
			return "Missing Parameter";
		}
	}

}
