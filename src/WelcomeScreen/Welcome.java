package WelcomeScreen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import Services.DirectoryService;
import Services.ScreenService;

public class Welcome implements Screen {

	private String welcomeTopic = "Welcome To LockMe.com";

	private String companyname= "Powered By: LOCKERS Pvt. Ltd. ";

	private String developerDetails= "Developer: Darakhshan Naiyer";

	private ArrayList<String> options = new ArrayList<>();

	// Created Welcome Screen Method below

	public Welcome() { 

		options.add("1. Show Files");
		options.add("2. File Option Menu");
		options.add("3. Exit Menu");

	}

	// Method for print Name

	public void detail() {

		System.out.println(welcomeTopic);
		System.out.println(companyname);
		System.out.println(developerDetails);
		System.out.println("\n");
		Show();
	}


	@Override
	public void Show() {

		//		Welcome();

		System.out.println("Main Menu");
		for (String S: options) {
			System.out.println(S);

		}
	}

	@Override
	public void NavigateOption(int option) {
		// TODO Auto-generated method stub

		switch (option) {

		case 1:                              //Show Files in Directory
			this.ShowFiles();
			this.Show();
			break;

		case 2:
			ScreenService.setCurrentscreen(ScreenService.fileoptions);
			ScreenService.getCurrentscreen().Show();
			ScreenService.getCurrentscreen().GetUserInput();
			this.Show();
			break;

			//		case 3:
			//			System.out.println("Exited App!");
			//			break;

		default:
			System.out.println("Invalid Option!\nChoose a valid option");
			break;
		}
	}

	@Override
	public void GetUserInput() {
		int selectedOption=0;
		//        System.out.println("ABC"+selectedOption);
		//        System.out.println("Will not enter while loop"+this.getOption());

		while ((selectedOption=this.getOption())!=3) {
			this.NavigateOption(selectedOption);
			//        	System.out.println("Inside GetUserInput "+selectedOption);
		}
	}                          


	public void ShowFiles() {

		DirectoryService.printFiles();
	}

	private int getOption(){

		Scanner sc = new Scanner(System.in);

		int returnOption=0;

		try{
			returnOption=sc.nextInt();
			//			System.out.println(returnOption);
		}
		catch(InputMismatchException Ex){}

		return returnOption;
	}

}
