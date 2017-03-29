package it.unical.igpe17.terminalgame;

public interface IDrawer {
	
	void  draw(IGameObject obj, final int H, final int W, char[][] pixels);
	public static boolean isVisible(final int x, final int y, final int W, final int H){
		return (x >=0 && x< W && y >=0 && y<H);
	}

}
