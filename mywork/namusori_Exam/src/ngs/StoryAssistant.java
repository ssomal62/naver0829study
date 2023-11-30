package ngs;

import ngs.ui.menu.ClubMenu;

public class StoryAssistant {
	
	private void startStory() {
		ClubMenu clubmenu = new ClubMenu();
		clubmenu.show();
	}

	public static void main(String[] args) {
		StoryAssistant assiatant = new StoryAssistant();
		
		assiatant.startStory();
		
	}

}
