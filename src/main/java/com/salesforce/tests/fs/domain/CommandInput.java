package com.salesforce.tests.fs.domain;

import java.util.List;

public class CommandInput {

	private String commandName;
	private String commandParameter;
	private List<String> commandOptions;

	public String getCommandName() {
		return commandName;
	}
	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}
	public String getCommandParameter() {
		return commandParameter;
	}
	public void setCommandParameter(String commandParameter) {
		this.commandParameter = commandParameter;
	}
	public List<String> getCommandOptions() {
		return commandOptions;
	}
	public void setCommandOptions(List<String> commandOptions) {
		this.commandOptions = commandOptions;
	}
	
}
