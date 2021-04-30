package WelcomeScreen;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Folder.Directory;
import Services.ScreenService;

public class FileOptions implements Screen {

	private Directory dir= new Directory();

	private ArrayList<String> options = new ArrayList<>();

	public FileOptions() {

		options.add("1. Add a File");
		options.add("2. Delete a File");
		options.add("3. Search a File");
		options.add("4. Go back to Main Menu");
	}


	@Override
	public void Show() {

		//		FileOptions();

		//		System.out.println("Sysout Fileoptions");

		for (String S: options) {
			System.out.println(S);
		}
	}


	@Override
	public void GetUserInput() {
		int selectedOption=0;
		while ((selectedOption=this.getOption())!=4) {
			this.NavigateOption(selectedOption);
		}
	} 


	private int getOption() {

		Scanner sc= new Scanner(System.in);

		int returnOption=0;
        try {
		returnOption=sc.nextInt();
        }
        
        catch(InputMismatchException Ex){}
        
		return returnOption;
	}


	@Override
	public void NavigateOption(int option) {
		switch (option) {

		case 1:                              //Show Files in Directory
			this.AddFile();
			this.Show();
			break;

		case 2:
			this.DeleteFile();
			this.Show();
			break;

		case 3:
			this.SearchFile();
			this.Show();
			break;


		default:
			System.out.println("Invalid Option!\nChoose a valid option");
			break;
		}

	}

	private String getInputString() {

		Scanner sc= new Scanner(System.in);

		return(sc.next());
	}

	public void SearchFile() {

		if (dir.isKhali()) {
			System.out.println("Directory is Empty!");
		}else {

			Boolean Found = false;
			System.out.println("Please Enter the File Name You are looking for..");

			String fileName=this.getInputString();
			System.out.println("You are searching for File Named:" +fileName);

			ArrayList<File> files = dir.getfiles(); 

			for(int i=0; i<files.size(); i++ ) {
				if(files.get(i).getName().equals(fileName)) {
					System.out.println("Found: "+fileName);
					Found= true;
				}
			}


			if(Found==false) {
				System.out.println("File Not Found!");
			}

		}

	}

	public void DeleteFile() {

		if (dir.isKhali()) {
			System.out.println("There is no file to delete!");
		}else {
			System.out.println("Please enter the name of file you want to delete");

			String fileName= this.getInputString();
			System.out.println("You are Deleting a File Named:"+fileName);

			Path path = FileSystems.getDefault().getPath(Directory.loc +fileName).toAbsolutePath();

			File file= path.toFile();

			if(file.delete()){
				System.out.println("File Deleted!:" +file.getName());
				dir.getfiles().remove(file);

			}else{
				System.out.println("Failed to delete File!"+fileName+"\n File Not Found!");
			}
		}
	}



	public void AddFile() {
		System.out.println("Please Enter the File Name");

		String fileName= this.getInputString();
		System.out.println("You are Adding a File Named:"+fileName);

		try {
			Path path = FileSystems.getDefault().getPath(Directory.loc +fileName).toAbsolutePath();

			File file= new File(dir.getLoc() +fileName);

			if(file.createNewFile()){
				System.out.println("File Created:" +file.getName());
				dir.getfiles().add(file);

			}else{
				System.out.println("File Already Exist!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}






