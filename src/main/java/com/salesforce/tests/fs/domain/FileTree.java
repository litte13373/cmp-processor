package com.salesforce.tests.fs.domain;

public class FileTree {

	private FileNode fileNode;

	public FileNode getFileNode() {
		return fileNode;
	}

	public void setFileNode(FileNode fileNode) {
		this.fileNode = fileNode;
	}
	
	public boolean childNameExists(String childName){
		boolean founded = false;
		for(FileNode fn : fileNode.getChildren()){
			if(fn.getName().equals(childName)){
				founded = true;
			}
		}
		return founded;
	}

	public void createNode(String nodeName, boolean isDirectory) {
		FileNode childFileNode = new FileNode();
		childFileNode.setName(nodeName);
		childFileNode.setParent(fileNode);
		childFileNode.setIsDirectory(isDirectory);
		fileNode.getChildren().add(childFileNode);
	}
	
}
