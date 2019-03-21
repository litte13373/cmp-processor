package com.salesforce.tests.fs.impl;

import com.salesforce.tests.fs.Command;
import com.salesforce.tests.fs.domain.CommandInput;
import com.salesforce.tests.fs.domain.FileNode;

public class LS implements Command {

	public String execute(FileNode fileNode, CommandInput commandInput) {
		
		if(fileNode.getChildren() != null){
			StringBuilder sb = new StringBuilder();
			for(FileNode child : fileNode.getChildren()){
				sb.append(child.getName());
				sb.append("\n");
			}
			return sb.toString();
		} else {
			return "";
		}
		
	}

}
