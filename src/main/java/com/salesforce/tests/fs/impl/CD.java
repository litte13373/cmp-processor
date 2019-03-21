package com.salesforce.tests.fs.impl;

import com.salesforce.tests.fs.Command;
import com.salesforce.tests.fs.domain.CommandInput;
import com.salesforce.tests.fs.domain.FileNode;

public class CD implements Command {

	public String execute(FileNode fileNode, CommandInput commandInput) {
		
		if(commandInput.getCommandParameter() != null){
			//Go to commandInput.getCommandParameter()
			if(fileNode.getChildren() != null){
				for(FileNode child : fileNode.getChildren() ){
					if(commandInput.getCommandParameter().equals(child.getName()) && child.getIsDirectory()){
						fileNode = child;
						return "Go to file" + commandInput.getCommandParameter();
					}
				}
			}

		}
		
		return "Wrong command";
	}

}
