package Services;

import WelcomeScreen.FileOptions;
import WelcomeScreen.Screen;
import WelcomeScreen.Welcome;

public class ScreenService {
      
	public static Welcome welcome= new Welcome();
	public static FileOptions fileoptions= new FileOptions(); //
	
	public static Screen currentscreen= welcome;

	public static Screen getCurrentscreen() {
		return currentscreen;
	}

	public static void setCurrentscreen(Screen currentscreen) {
		ScreenService.currentscreen = currentscreen;
	}
	
	
}
