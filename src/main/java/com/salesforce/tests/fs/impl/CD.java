package com.salesforce.tests.fs.impl;

import com.salesforce.tests.fs.Command;
import com.salesforce.tests.fs.domain.CommandInput;
import com.salesforce.tests.fs.domain.FileNode;
import com.salesforce.tests.fs.domain.FileTree;

public class CD implements Command {

	public String execute(FileTree fileTree, CommandInput commandInput) {
		
		FileNode fileNode = fileTree.getFileNode();
		Boolean founded = false;
		
		if(commandInput.getCommandParameter() != null){
			//Go to commandInput.getCommandParameter()
			if(fileNode.getChildren() != null){
				for(FileNode child : fileNode.getChildren() ){
					if(commandInput.getCommandParameter().equals(child.getName())){
						if(!child.getIsDirectory()){
							return commandInput.getCommandParameter() + " is not a directory";
						}
						fileTree.setFileNode(child);
						founded = true;
					}
				}
			}
			if(founded){
				return "Go to " + commandInput.getCommandParameter();
			} else {
				return commandInput.getCommandParameter() + " not founded";
			}
		} else {
			return "Wrong command";
		}
	}

}
