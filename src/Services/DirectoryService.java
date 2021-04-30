package Services;

import java.io.File;

import Folder.Directory;

public class DirectoryService {

	public static Directory fileDirectory = new Directory ();

	public static void printFiles(){

		//    	fileDirectory.fillFiles();

		if (fileDirectory.isKhali()) {

			System.out.println("No Files to show!");
		}else {

			System.out.println("List of Files:");

			for(File page: getFileDirectory().getfiles()) {

				System.out.println(page.getName());
			}

		}
	}

	public static Directory getFileDirectory() {
		return fileDirectory;
	}

	public static void setFileDirectory(Directory fileDirectory) {
		DirectoryService.fileDirectory = fileDirectory;
	}


}
