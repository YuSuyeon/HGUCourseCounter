package edu.handong.analysis.utils;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {
	
	public static ArrayList<String> getLines(String file, boolean removeHeader) {

		ArrayList<String> lines = new ArrayList<String>();
			
		try {
			Scanner inputStream = new Scanner(new File(file));
			lines.add(inputStream.nextLine());
				
			while(inputStream.hasNextLine()) {
				lines.add(inputStream.nextLine());
			}
			inputStream.close();
		}  catch (FileNotFoundException e) {
			System.out.println ("The file path does not exist. Please check your CLI argument!");
			System.exit (0);
		}
		
		if(removeHeader)
			lines.remove(0);
		
		return lines;
	}
	
	public static void writeAFile(ArrayList<String> lines, String targetFileName) {
		
		try {
			File file = new File(targetFileName);
			FileOutputStream fos = new FileOutputStream(file);
			DataOutputStream dos = new DataOutputStream(fos);
			
			for(String line:lines) {
				dos.write((line+"\n").getBytes());
			}
			dos.close();
			fos.close();
		} catch (IOException e) {
			System.out.println("Error: " + e);
		} 
		
	}

}
