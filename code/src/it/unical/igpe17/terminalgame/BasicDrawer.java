package it.unical.igpe17.terminalgame;

public class BasicDrawer implements IDrawer{

	char c='.';
	
	@Override
	public void draw(IGameObject p, int H, int W, char[][] pixels) {
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
}
