package com.salesforce.tests.fs;

import com.salesforce.tests.fs.impl.CD;
import com.salesforce.tests.fs.impl.LS;
import com.salesforce.tests.fs.impl.MKDIR;
import com.salesforce.tests.fs.impl.PWD;
import com.salesforce.tests.fs.impl.QUIT;
import com.salesforce.tests.fs.impl.TOUCH;

public class CommandFactory {
	
	public static Command getCommandExecutor(String command) throws Exception{
		
		if("PWD".equalsIgnoreCase(command)){
			return new PWD();
		} else if("LS".equalsIgnoreCase(command)){
			return new LS();
		} else if("CD".equalsIgnoreCase(command)){
			return new CD();
		} else if("MKDIR".equalsIgnoreCase(command)){
			return new MKDIR();
		} else if("TOUCH".equalsIgnoreCase(command)){
			return new TOUCH();
		} else if("QUIT".equalsIgnoreCase(command)){
			return new QUIT();
		} else {
			throw new Exception("Unknown Command " + command);
		}
	}
}
