package com.salesforce.tests.fs;

import java.util.Scanner;

import com.salesforce.tests.fs.domain.FileNode;
import com.salesforce.tests.fs.domain.FileTree;

public class Main {
  public static void main(String[] args){
      Scanner scanner = new Scanner(System.in);
      String input = "";
      String result = "";
      FileTree fileTree = new FileTree();
      fileTree.setFileNode(new FileNode());
      
      while (!input.equals("quit")){
        input = scanner.nextLine();
		try {
			result = CommandService.executeCommand(input, fileTree);
			System.out.println(result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
      }
      scanner.close();
  }    
}  
