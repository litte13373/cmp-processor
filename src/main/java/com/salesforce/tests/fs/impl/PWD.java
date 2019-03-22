package com.salesforce.tests.fs.impl;

import java.util.ArrayList;
import java.util.List;

import com.salesforce.tests.fs.Command;
import com.salesforce.tests.fs.domain.CommandInput;
import com.salesforce.tests.fs.domain.FileNode;
import com.salesforce.tests.fs.domain.FileTree;

public class PWD implements Command{

	public String execute(FileTree fileTree, CommandInput commandInput) {
		FileNode fileNode = fileTree.getFileNode();
		
		StringBuilder sb = new StringBuilder();
		FileNode parentFileInfo = fileNode.getParent();
		List<String> filePath = new ArrayList<String>();
		
		if(fileNode.getName()==null){
			return "\\";
		} else {
			filePath.add(fileNode.getName());
			
			while (parentFileInfo != null && parentFileInfo.getName()!=null){
				filePath.add(parentFileInfo.getName());
				parentFileInfo = parentFileInfo.getParent();
			}
			for (int i = filePath.size(); i>0; i-- ){
				sb.append("\\");
				sb.append(filePath.get(i-1));
			}
			
			return sb.toString();
		} 
	}
}
