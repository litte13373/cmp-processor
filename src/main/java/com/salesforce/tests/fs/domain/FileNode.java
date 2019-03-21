package com.salesforce.tests.fs.domain;

import java.util.List;

public class FileNode {
	
	private String name;
	private List<FileNode> children;
	private FileNode parent;
	private Boolean isDirectory;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<FileNode> getChildren() {
		return children;
	}
	public void setChildren(List<FileNode> children) {
		this.children = children;
	}
	public FileNode getParent() {
		return parent;
	}
	public void setParent(FileNode parent) {
		this.parent = parent;
	}
	public Boolean getIsDirectory() {
		return isDirectory;
	}
	public void setIsDirectory(Boolean isDirectory) {
		this.isDirectory = isDirectory;
	}
	
}
