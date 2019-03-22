package com.salesforce.tests.fs;

import static org.junit.Assert.*;

import org.junit.Test;

import com.salesforce.tests.fs.domain.FileNode;
import com.salesforce.tests.fs.domain.FileTree;

/**
 * BaseTest
 */
public abstract class BaseTest {
    
    public void runTest(String[] expectedResults, String command1, String command2){
		FileTree fileTree = new FileTree();
    	fileTree.setFileNode(new FileNode());
    	String[] results = new String[2];
		try {
			results[0] = CommandService.executeCommand(command1, fileTree);
			results[1] = CommandService.executeCommand(command2, fileTree);
		} catch (Exception e) {
			fail(e.getMessage());
		}

		assertArrayEquals(expectedResults, results);
    }
    
    public void runTest(String[] expectedResults, String command1, String command2, String command3){
		try {
			FileTree fileTree = new FileTree();
	    	fileTree.setFileNode(new FileNode());
	    	String[] results = new String[3];
	    	
			results[0] = CommandService.executeCommand(command1, fileTree);
			results[1] = CommandService.executeCommand(command2, fileTree);
			results[2] = CommandService.executeCommand(command3, fileTree);
			assertArrayEquals(expectedResults, results);
		} catch (Exception e) {
			fail(e.getMessage());
		}
    }
    
    public void runTest(String[] expectedResults, String command1, String command2, String command3, String command4){
    	FileTree fileTree = new FileTree();
    	fileTree.setFileNode(new FileNode());
    	String[] results = new String[4];
		try {
			results[0] = CommandService.executeCommand(command1, fileTree);
			results[1] = CommandService.executeCommand(command2, fileTree);
			results[2] = CommandService.executeCommand(command3, fileTree);
			results[3] = CommandService.executeCommand(command4, fileTree);
			assertArrayEquals(expectedResults, results);
		} catch (Exception e) {
			fail(e.getMessage());
		}
    }
    
    public void runTest(String[] expectedResults, String command1, String command2, String command3, String command4, String command5){
    	FileTree fileTree = new FileTree();
    	fileTree.setFileNode(new FileNode());
    	String[] results = new String[5];
		try {
			results[0] = CommandService.executeCommand(command1, fileTree);
			results[1] = CommandService.executeCommand(command2, fileTree);
			results[2] = CommandService.executeCommand(command3, fileTree);
			results[3] = CommandService.executeCommand(command4, fileTree);
			results[4] = CommandService.executeCommand(command5, fileTree);
			assertArrayEquals(expectedResults, results);
		} catch (Exception e) {
			fail(e.getMessage());
		}
    }
    
    public void runTest(String[] expectedResults, String command1, String command2, String command3, 
    		String command4, String command5, String command6, String command7, String command8, 
    		String command9, String command10, String command11, String command12, String command13, 
    		String command14, String command15, String command16, String command17, String command18, 
    		String command19, String command20, String command21, String command22){
    	FileTree fileTree = new FileTree();
    	fileTree.setFileNode(new FileNode());
    	String[] results = new String[22];
		try {
			results[0] = CommandService.executeCommand(command1, fileTree);
			results[1] = CommandService.executeCommand(command2, fileTree);
			results[2] = CommandService.executeCommand(command3, fileTree);
			results[3] = CommandService.executeCommand(command4, fileTree);
			results[4] = CommandService.executeCommand(command5, fileTree);
			results[5] = CommandService.executeCommand(command6, fileTree);
			results[6] = CommandService.executeCommand(command7, fileTree);
			results[7] = CommandService.executeCommand(command8, fileTree);
			results[8] = CommandService.executeCommand(command9, fileTree);
			results[9] = CommandService.executeCommand(command10, fileTree);
			results[10] = CommandService.executeCommand(command11, fileTree);
			results[11] = CommandService.executeCommand(command12, fileTree);
			results[12] = CommandService.executeCommand(command13, fileTree);
			results[13] = CommandService.executeCommand(command14, fileTree);
			results[14] = CommandService.executeCommand(command15, fileTree);
			results[15] = CommandService.executeCommand(command16, fileTree);
			results[16] = CommandService.executeCommand(command17, fileTree);
			results[17] = CommandService.executeCommand(command18, fileTree);
			results[18] = CommandService.executeCommand(command19, fileTree);
			results[19] = CommandService.executeCommand(command20, fileTree);
			results[20] = CommandService.executeCommand(command21, fileTree);
			results[21] = CommandService.executeCommand(command22, fileTree);
			assertArrayEquals(expectedResults, results);
		} catch (Exception e) {
			fail(e.getMessage());
		}
    }
}