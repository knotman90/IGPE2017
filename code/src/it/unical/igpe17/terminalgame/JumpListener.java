package it.unical.igpe17.terminalgame;

import java.util.Scanner;

public class JumpListener implements Runnable{
	
	final GameGUI gameGUI;
	final Scanner s = new Scanner(System.in);
	public JumpListener(final GameGUI _gameGUI) {
		this.gameGUI = _gameGUI;
	}
	
	@Override
	public void run() {
		while(true){
			s.nextLine();
			gameGUI.getGame().getPlayer().jump();
		}
	}

}
