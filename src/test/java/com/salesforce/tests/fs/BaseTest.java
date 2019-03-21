package com.salesforce.tests.fs;

import static org.junit.Assert.*;

import org.junit.Test;

import com.salesforce.tests.fs.domain.FileNode;

/**
 * BaseTest
 */
public abstract class BaseTest {
    
	@Test
    public void runTest(String[] expectedResults, String command1, String command2){
    	FileNode fileNode = new FileNode();
    	String[] results = new String[2];
		try {
			results[0] = CommandService.executeCommand(command1, fileNode);
			results[1] = CommandService.executeCommand(command2, fileNode);
		} catch (Exception e) {
			fail(e.getMessage());
		}

		assertArrayEquals(expectedResults, results);
    }
    
    public void runTest(String[] expectedResults, String command1, String command2, String command3){
    	FileNode fileNode = new FileNode();
    	String[] results = new String[3];
		try {
			results[0] = CommandService.executeCommand(command1, fileNode);
			results[1] = CommandService.executeCommand(command2, fileNode);
			results[2] = CommandService.executeCommand(command3, fileNode);
		} catch (Exception e) {
			fail(e.getMessage());
		}

		assertArrayEquals(expectedResults, results);
    }
    
    public void runTest(String[] expectedResults, String command1, String command2, String command3, String command4){
    	FileNode fileNode = new FileNode();
    	String[] results = new String[4];
		try {
			results[0] = CommandService.executeCommand(command1, fileNode);
			results[1] = CommandService.executeCommand(command2, fileNode);
			results[2] = CommandService.executeCommand(command3, fileNode);
			results[3] = CommandService.executeCommand(command4, fileNode);
		} catch (Exception e) {
			fail(e.getMessage());
		}

		assertArrayEquals(expectedResults, results);
    }
    
    public void runTest(String[] expectedResults, String command1, String command2, String command3, String command4, String command5){
    	FileNode fileNode = new FileNode();
    	String[] results = new String[5];
		try {
			results[0] = CommandService.executeCommand(command1, fileNode);
			results[1] = CommandService.executeCommand(command2, fileNode);
			results[2] = CommandService.executeCommand(command3, fileNode);
			results[3] = CommandService.executeCommand(command4, fileNode);
			results[4] = CommandService.executeCommand(command5, fileNode);
		} catch (Exception e) {
			fail(e.getMessage());
		}

		assertArrayEquals(expectedResults, results);
    }
    
    public void runTest(String[] expectedResults, String command1, String command2, String command3, 
    		String command4, String command5, String command6, String command7, String command8, 
    		String command9, String command10, String command11, String command12, String command13, 
    		String command14, String command15, String command16, String command17, String command18, 
    		String command19, String command20, String command21, String command22){
    	FileNode fileNode = new FileNode();
    	String[] results = new String[22];
		try {
			results[0] = CommandService.executeCommand(command1, fileNode);
			results[1] = CommandService.executeCommand(command2, fileNode);
			results[2] = CommandService.executeCommand(command3, fileNode);
			results[3] = CommandService.executeCommand(command4, fileNode);
			results[4] = CommandService.executeCommand(command5, fileNode);
			results[5] = CommandService.executeCommand(command6, fileNode);
			results[6] = CommandService.executeCommand(command7, fileNode);
			results[7] = CommandService.executeCommand(command8, fileNode);
			results[8] = CommandService.executeCommand(command9, fileNode);
			results[9] = CommandService.executeCommand(command10, fileNode);
			results[10] = CommandService.executeCommand(command11, fileNode);
			results[11] = CommandService.executeCommand(command12, fileNode);
			results[12] = CommandService.executeCommand(command13, fileNode);
			results[13] = CommandService.executeCommand(command14, fileNode);
			results[14] = CommandService.executeCommand(command15, fileNode);
			results[15] = CommandService.executeCommand(command16, fileNode);
			results[16] = CommandService.executeCommand(command17, fileNode);
			results[17] = CommandService.executeCommand(command18, fileNode);
			results[18] = CommandService.executeCommand(command19, fileNode);
			results[19] = CommandService.executeCommand(command20, fileNode);
			results[20] = CommandService.executeCommand(command21, fileNode);
			results[21] = CommandService.executeCommand(command22, fileNode);
		} catch (Exception e) {
			fail(e.getMessage());
		}

		assertArrayEquals(expectedResults, results);
    }
}