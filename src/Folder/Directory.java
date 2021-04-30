package Folder;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;

public class Directory {

	public static final String loc="src/UserStoredFiles/";

	private ArrayList<File> folder = new ArrayList<File>();

	Path path = FileSystems.getDefault().getPath(loc).toAbsolutePath(); 

	File file = path.toFile();

	public static String getLoc() {
		return loc;
	}

	public ArrayList<File> fillFiles(){

		File[] directoryFiles= file.listFiles();
		folder.clear();

		for(int i=0; i<directoryFiles.length; i++) {

			if (directoryFiles[i].isFile()) {
				folder.add(directoryFiles[i]);
			}
		}

		Collections.sort(folder);
		return folder;
	}


	public ArrayList<File> getfiles(){

		fillFiles();
		return folder;
	}

	public void print() {

		System.out.println("Existing Files:");
		folder.forEach(Panna -> System.out.println(Panna)); //Used Lambda Expression
	}

	public boolean isKhali() {
		String [] Panne = file.list();
		return Panne.length==0;
	}
}
