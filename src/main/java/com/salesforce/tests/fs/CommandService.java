package com.salesforce.tests.fs;

import java.util.ArrayList;
import java.util.List;

import com.salesforce.tests.fs.domain.CommandType;
import com.salesforce.tests.fs.domain.CommandInput;
import com.salesforce.tests.fs.domain.FileNode;

public class CommandService {
	
	public static String executeCommand(String input, FileNode fileNode) throws Exception{
		CommandInput commandInput = CommandService.getCommandInput(input);
		Command commandExecutor = CommandFactory.getCommandExecutor(input);
		return commandExecutor.execute(fileNode, commandInput);
	}

	public static CommandInput getCommandInput(String commandValue) throws Exception{
		String[] commandInfo = commandValue.split(" ");
		CommandInput commandInput = new CommandInput();
		if(commandInfo.length > 0){
			CommandType command = CommandType.valueOf(commandInfo[0]);
			commandInput.setCommandName(command.name());
			
			if(commandInfo.length > 1){ 
				if(commandInfo[1].startsWith("-")){
					commandInput.setCommandOptions(getCommandOptions(commandInfo, 1));
				} else {
					commandInput.setCommandParameter(commandInfo[1]);
					if(commandInfo.length > 2){
						commandInput.setCommandOptions(getCommandOptions(commandInfo, 1));	
					}
				}
			} 
			return commandInput;
		} else {
			throw new Exception("Unknown Command");
		}
	}
	
	private static List<String> getCommandOptions(String[] commandInfo, int index) throws Exception{
		List<String> commandOptions = new ArrayList<String>();
		for(int i = index; i < commandInfo.length; i++){
			if(commandInfo[i].startsWith("-")){
				commandOptions.add(commandInfo[i]);	
			} else {
				throw new Exception("Unknown Command");
			}
		}
		return commandOptions;
	}
}
