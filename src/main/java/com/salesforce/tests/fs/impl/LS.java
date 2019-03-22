package com.salesforce.tests.fs.impl;

import com.salesforce.tests.fs.Command;
import com.salesforce.tests.fs.domain.CommandInput;
import com.salesforce.tests.fs.domain.FileNode;
import com.salesforce.tests.fs.domain.FileTree;

public class LS implements Command {

	public String execute(FileTree fileTree, CommandInput commandInput) {
		FileNode fileNode = fileTree.getFileNode();
		
		if(fileNode.getChildren() != null){
			StringBuilder sb = new StringBuilder();
			for(FileNode child : fileNode.getChildren()){
				sb.append(child.getName());
				if(fileNode.getChildren().indexOf(child) != fileNode.getChildren().size()-1){
					sb.append("\n");	
				}
				
			}
			return sb.toString();
		} else {
			return "";
		}
		
	}

}
