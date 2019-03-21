package com.salesforce.tests.fs.impl;

import java.util.ArrayList;
import java.util.List;

import com.salesforce.tests.fs.Command;
import com.salesforce.tests.fs.domain.CommandInput;
import com.salesforce.tests.fs.domain.FileNode;

public class PWD implements Command{

	public String execute(FileNode fileNode, CommandInput commandInput) {
		
		StringBuilder sb = new StringBuilder();
		FileNode parentFileInfo = fileNode.getParent();
		List<String> filePath = new ArrayList<String>();
		
		if(fileNode.getName()==null){
			return "\\";
		} else {
			filePath.add(fileNode.getName());
			
			while (parentFileInfo != null){
				filePath.add(parentFileInfo.getName());
				parentFileInfo = parentFileInfo.getParent();
			}
			for (int i = filePath.size(); i>0; i-- ){
				sb.append("/");
				sb.append(filePath.get(i));
			}
			
			return sb.toString();
		} 
	}
}
