package com.salesforce.tests.fs;

import java.util.ArrayList;
import java.util.List;

import com.salesforce.tests.fs.domain.CommandInput;
import com.salesforce.tests.fs.domain.FileTree;

public class CommandService {
	
	public static String executeCommand(String input, FileTree fileTree) throws Exception{
		CommandInput commandInput = CommandService.getCommandInput(input);
		Command commandExecutor = CommandFactory.getCommandExecutor(commandInput.getCommandName());
		return commandExecutor.execute(fileTree, commandInput);
	}

	public static CommandInput getCommandInput(String commandValue) throws Exception{
		String[] commandInfo = commandValue.split(" ");
		CommandInput commandInput = new CommandInput();
		if(commandInfo.length > 0){
			String commandName = commandInfo[0];
			Command command = CommandFactory.getCommandExecutor(commandName);
			if(command==null){
				throw new Exception("Unknown Command " + commandName);
			}
			commandInput.setCommandName(commandName);
			
			if(commandInfo.length > 1){ 
				if(commandInfo[1].startsWith("-")){
					commandInput.setCommandOptions(getCommandOptions(commandInfo, 1));
				} else {
					commandInput.setCommandParameter(commandInfo[1]);
					if(commandInfo.length > 2){
						commandInput.setCommandOptions(getCommandOptions(commandInfo, 2));	
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
