package it.unical.igpe17.terminalgame;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GameGUI {

	int WIDTH, HEIGHT;

	boolean go =true;
	long frame =0;
	Game g;


	IDrawer pd = new BasicDrawer(); //player drawers
	ObstacleDrawer od = new ObstacleDrawer();
	List<IDrawer> osd; //obstacoles Drawers

	StringBuilder sb ;
	char[][] pixels;

	GameGUI(final int H , final int W){
		WIDTH = W;
		HEIGHT = H;
		pixels = new char[HEIGHT][WIDTH];
		sb = new StringBuilder();
		buildBorder();
		createGame();
	}


	void createGame(){
		g = new Game(HEIGHT,WIDTH);
	}


	private void wipeFrame(){
		sb.delete(0, sb.length());
		for(int i=0;i<pixels.length;i++)
			for(int j=0 ; j < pixels[i].length ; j++)
				pixels[i][j] = ' ';


	}
	private void buildBorder() {
		//		for(int i=0;i<HEIGHT;i++){
		//			pixels[i][0] = '|';
		//			pixels[i][WIDTH-1] = '|';
		//		}
		for(int i=0;i<WIDTH;i++){
			pixels[0][i] = '-';
			pixels[HEIGHT-1][i] = '_';
		}

	}
	
	
	private void write(final String s, final int start, final int cstart){
		for (int i = 0; i < s.length(); i++) {
			pixels[start][cstart + i]=s.charAt(i);
			
		}
	}
	
	void buildScore(){
		int rstart =GameConfig.SCORE_ROW;
		int cstart =GameConfig.SCORE_COL;
		write("SCORE:",rstart , cstart );
		cstart+=new String("SCORE:").length();
		
		int score = g.getPlayer().getPoints();
		int i=0;
		do{
			int d = score%10;
			score/=10;
			pixels[rstart][cstart+i]=(char)((int)'0'+d);
		}while(score>0);
	}

	void buildFrame(){
		wipeFrame();

		buildBorder();
		
		pd.draw(g.getPlayer(),HEIGHT, WIDTH, pixels);

		for (Iterator iterator = g.gameObjects.iterator(); iterator.hasNext();) {
			IGameObject gameobj = (IGameObject) iterator.next();
			if(gameobj instanceof Obstacle ){				
				od.draw(gameobj , HEIGHT, WIDTH, pixels);

			}

		}
		buildScore();
		

	}

	@Override
	public String toString() {


		for(int i=0;i<pixels.length;i++){
			for(int j=0 ; j < pixels[i].length ; j++){
				sb.append(pixels[i][j]);
			}
			sb.append("\n");
		}
		return sb.toString();

	}

void clrsc(){
	System.out.print("\033[H\033[2J");
	System.out.flush();
//	for(int i=0;i<WIDTH-1;i++){
//		for(int j=0;j<HEIGHT-1;j++){
//			System.out.println("\b");
//		}
//	}
}


	void mainLoop(){
		Scanner s = new Scanner(System.in);
		long start = System.currentTimeMillis();
		long end;
		
		//keyboard listener is being started
		Thread jt = new Thread(new JumpListener(this));
		jt.start();
		
		while(true){

			
			
			buildFrame();
			end = System.currentTimeMillis();
			double dt = end-start; 
			
			g.evolve(dt);
			clrsc();
			System.out.println(toString());
//			System.out.println(g.gameObjects.size());
//			System.out.println(g.getPlayer().toString());
			if(dt < GameConfig.MIN_RENDERING_TIME_MS )
				try {
					Thread.sleep((long) (GameConfig.MIN_RENDERING_TIME_MS-dt));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			start=end;
			

			frame++;
			
			if(frame>200000)
				break;
			
			if(g.isGameOver()){
				clrsc();
				System.out.println("GAME OVER!");
				System.exit(0);
			}
			

		}
	}


	public static void main(String[] args) {
		GameGUI g = new GameGUI(GameConfig.HEIGHT,GameConfig.WIDTH);
		g.mainLoop();
	}


	public Game getGame() {
		return g;
	}
}
