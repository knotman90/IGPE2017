package it.unical.igpe17.terminalgame;

public class ObstacleDrawer implements IDrawer{

	char c = '+';

	final String[] s =
		{"░░░░░░███████ ]▄▄▄▄▄▄▄▄▃"
			,"     ▂▄▅█████████▅▄▃▂   "
			,"   I██████████████████]."
			,"     ◥⊙▲⊙▲⊙▲⊙▲⊙▲⊙▲⊙◤    "}; 

	char[][] tank = new char[s.length][s[0].length()];



	public ObstacleDrawer() {
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s[i].length(); j++) {
				tank[i][j]=s[i].charAt(s[i].length()-j-1);

			}

		}
	}
	void drawTank(IGameObject p, int H, int W, char[][] pixels){
		for (int i = 0; i < tank.length; i++) {
			for (int j = 0; j < tank[i].length; j++) {
				int pi,pj;
				pi=(int) (Math.min(i+p.getPosition().getY(),H-1));
				pj=(int) (j+p.getPosition().getX());
				if(IDrawer.isVisible(pj, pi, W, H))
					pixels[pi][pj] = tank[i][j];
			}
		}
	}

	void drawAsRectangle(IGameObject p, int H, int W, char[][] pixels){
		int starty = (int) p.getPosition().getY() ;
		int endy = (int) Math.min(p.getPosition().getY()+p.getSize().getY(), H);

		int startx = (int) p.getPosition().getX() ;
		int endx = (int) Math.min(p.getPosition().getX()+p.getSize().getX(), W);

		for (int j = starty; j < endy; j++) {
			for(int i=startx ;  i < endx ; i++){
				if(IDrawer.isVisible(i, j, W, H))
					pixels[j][i] = c;

			}
		}
	}


	@Override
	public void draw(IGameObject p, int H, int W, char[][] pixels) {
		drawTank(p,H,W,pixels);




	}

}
