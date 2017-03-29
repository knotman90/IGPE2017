package it.unical.igpe17.terminalgame;

public class PlayerDrawer implements IDrawer{


	char c = '.';

	int f = 0;

	char penguin[][] = {
			{' ',' ',' ','_','_',' ',' ',' '},
			{' ',' ','(','_','_','\\','_',' '},
			{'-','{','{','_','(','|','0',')'},
			{' ',' ','(','_','_','/','`',' '}
	};

	char penguin2[][] = {
			{' ',' ',' ','_','_',' ',' ',' '},
			{' ',' ','(','_','_','\\','_',' '},
			{'-','{','{','_','(','|','8',')'},
			{' ',' ','(','_','_','/','`',' '}
	};
	

final String[] ss={
 "\\/```\\/████████████```██"
,"  ( x x )████████████     "
,"  == ^ == ████████████    "    
,"  \\ 0 / ████████████     "
,"      ████     ████       "
,"       WW       WW        "
,"       ''       ''        "};

final String[] ss2={
		 "__```__=============   \" "
		,"  ( o o )============```  "
		,"  == ^ == ============    "    
		,"  \\ - / ============     "
		,"      ====     ====       "
		,"       ||       ||        "
		,"       ''       ''        "};

	
	
char[][] pp;
char[][] pp1;
char[][] pp2;
	public PlayerDrawer() {
		pp1 =  new char[ss.length][ss[4].length()];
		pp2 =  new char[ss.length][ss[4].length()];
		for (int i = 0; i < ss.length; i++) {
			for (int j = 0; j < ss[i].length(); j++) {
				System.out.println(ss.length+" "+ss[0].length());
				pp1[i][j]=ss[i].charAt(ss[i].length()-j-1);
						
			}
			
		}
		for (int i = 0; i < ss2.length; i++) {
			for (int j = 0; j < ss2[i].length(); j++) {
				System.out.println(ss2.length+" "+ss2[0].length());
				pp2[i][j]=ss2[i].charAt(ss2[i].length()-j-1);
						
			}
			
		}
		pp=pp2;
		
	}
	
	void drawAsRectangle(IGameObject p, int H, int W, char[][] pixels){
		//draw as a rectangle


		int starty = (int) p.getPosition().getY() ;
		int endy = (int) Math.min(p.getPosition().getY()+p.getSize().getY(), H);

		int startx = (int) p.getPosition().getX() ;
		int endx = (int) Math.min(p.getPosition().getX()+p.getSize().getX(), W);



		for (int j = starty; j < endy; j++) {
			for(int i=startx ;  i < endx ; i++){
				if(IDrawer.isVisible(j, i, W, H))
					pixels[j][i] = c;

			}
		}


	}
	@Override
	public void draw(IGameObject p, int H, int W, char[][] pixels) {
		
		f++;
		if(p.getPosition().getY()
				+p.getSize().getY()< H-1){
			pp=pp1;
		}else
			pp=pp2;
		for (int i = 0; i < pp.length; i++) {
			for (int j = 0; j < pp
					[i].length; j++) {
				//if(IDrawer.isVisible(j, i, W, H))
					pixels[(int) (Math.min(i+p.getPosition().getY(),H-1))]
							[(int) (j+p.getPosition().getX())] = pp[i][j];


			}


		}
	}

}
