package com.salesforce.tests.fs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.salesforce.tests.fs.domain.CommandInput;
import com.salesforce.tests.fs.impl.CD;
import com.salesforce.tests.fs.impl.LS;
import com.salesforce.tests.fs.impl.MKDIR;
import com.salesforce.tests.fs.impl.PWD;
import com.salesforce.tests.fs.impl.TOUCH;

/**
 * Place holder for your unit tests
 */
public class YourUnitTest extends BaseTest{

    @Test
    public void CommandFactoryTest(){
		try {
			Command cd = CommandFactory.getCommandExecutor("CD");
			assert(cd instanceof CD);
        
			Command ls = CommandFactory.getCommandExecutor("LS");
			assert(ls instanceof LS);
        
			Command mkdir = CommandFactory.getCommandExecutor("MKDIR");
			assert(mkdir instanceof MKDIR);
        
			Command pwd = CommandFactory.getCommandExecutor("PWD");
			assert(pwd instanceof PWD);
        
			Command touch =  CommandFactory.getCommandExecutor("TOUCH");
			assert(touch instanceof TOUCH);
        
			CommandFactory.getCommandExecutor("Another Command");
		} catch (Exception e) {
			assertEquals("Unknown Command Another Command", e.getMessage());
		}
    }
    
    @Test
    public void CommandServiceGetCommandInputTest(){
    	try {
    		CommandInput commandInput = CommandService.getCommandInput("MKDIR");
    		assertNull(commandInput.getCommandParameter());
    		assertNull(commandInput.getCommandOptions());
    		
    		CommandInput commandInput1 = CommandService.getCommandInput("MKDIR ");
    		assertEquals("MKDIR", commandInput1.getCommandName());
    		assertNull(commandInput1.getCommandParameter());
    		assertNull(commandInput1.getCommandOptions());
    		
    		CommandInput commandInput2 = CommandService.getCommandInput("MKDIR child");
    		assertEquals("MKDIR", commandInput2.getCommandName());
    		assertEquals("child", commandInput2.getCommandParameter());
    		assertNull(commandInput2.getCommandOptions());
    		
    		CommandInput commandInput3 = CommandService.getCommandInput("MKDIR child -r");
    		assertEquals("MKDIR", commandInput3.getCommandName());
    		assertEquals("child", commandInput3.getCommandParameter());
    		List<String> resultList = new ArrayList<String>();
    		resultList.add("-r");
    		assertEquals(resultList, commandInput3.getCommandOptions());
    		assertEquals(1, commandInput3.getCommandOptions().size());
    		
    		CommandInput commandInput4 = CommandService.getCommandInput("LS -r -d");
    		assertEquals("LS", commandInput4.getCommandName());
    		assertNull(commandInput4.getCommandParameter());
    		List<String> resultList1 = new ArrayList<String>();
    		resultList1.add("-r");
    		resultList1.add("-d");
    		assertEquals(resultList1, commandInput4.getCommandOptions());
    		assertEquals(2, commandInput4.getCommandOptions().size());
    		
    		CommandInput commandInput5 = CommandService.getCommandInput("MKDIR child -r -d");
    		assertEquals("MKDIR", commandInput5.getCommandName());
    		assertEquals("child", commandInput5.getCommandParameter());
    		List<String> resultList2 = new ArrayList<String>();
    		resultList2.add("-r");
    		resultList2.add("-d");
    		assertEquals(resultList2, commandInput5.getCommandOptions());
    		assertEquals(2, commandInput5.getCommandOptions().size());
    		
		} catch (Exception e) {
			fail(e.getMessage());
		}
    }
        
    @Test
    public void CommandCDTest(){
    	try {
			String[] expectedResults = {"child Created", "child", "Go to child", ""};
			runTest(expectedResults, "MKDIR child", "LS", "CD child", "LS");
		} catch (Exception e) {
			fail(e.getMessage());
		}
    }
    
    @Test
    public void CommandLSTest(){
    	String[] expectedResults = {"child Created", "secondChild Created", "thirdChild Created", "child\nsecondChild\nthirdChild"};
		runTest(expectedResults, "MKDIR child", "MKDIR secondChild", "TOUCH thirdChild", "LS");
    }
    
    @Test
    public void CommandMKDIRTest(){
		try {
			String[] expectedResults = {"", "child Created", "child"};
			runTest(expectedResults, "LS", "MKDIR child", "LS");			
		} catch (Exception e) {
			fail(e.getMessage());
		}
    }
    
    @Test
    public void CommandPWDTest(){
    	String[] expectedResults = {"child Created", "Go to child", "secondChild Created", "Go to secondChild", "\\child\\secondChild"};
		runTest(expectedResults, "MKDIR child", "CD child", "MKDIR secondChild", "CD secondChild", "PWD");
		
		String[] expectedResults1 = {"", "\\"};
		runTest(expectedResults1, "LS", "PWD");
    }
    
    @Test
    public void CommandTOUCHTest(){
    	String[] expectedResults = {"child Created", "Go to child", "secondChild Created", "secondChild", "\\child"};
		runTest(expectedResults, "MKDIR child", "CD child", "TOUCH secondChild", "LS", "PWD");
    }
}
