package com.salesforce.tests.fs;

import java.util.*;

import com.salesforce.tests.fs.domain.CommandInput;
import com.salesforce.tests.fs.domain.FileNode;

public class Main {
  public static void main(String[] args){
      Scanner scanner = new Scanner(System.in);
      String input = "";
      String result = "";
      FileNode fileInfo = new FileNode();
      
      while (!input.equals("quit")){
        input = scanner.nextLine();
		try {
			result = CommandService.executeCommand(input, fileInfo);
		} catch (IllegalArgumentException e) {
			result = "Unknown Command";	
		} catch (Exception e) {
			result = e.getMessage();	
		}
      }
      System.out.println(result);
  }    
}  
