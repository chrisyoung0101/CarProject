package com.user;

import java.io.File;

public class DeleteFileTest {

	public static void main(String[] args) {
		
		String path = "/Users/chrisyoung/Documents/carText/testDelete.txt/";
		
		File deleteFile = new File(path);
		//delete() method returns a boolean
		if(deleteFile.delete()) {
			System.out.println(deleteFile + " DELETED");
		} else {
			
			System.out.println("NOT DELETED");
			
		}
		

	}

}
