package collisions;

import java.util.Random;

public class Arena {


	public final static int SIZE = 20;
	private Box[] objects;
	
	char [][] arena = new char[SIZE][SIZE];

	
	public static void main(String[] args) {
		Arena a = new Arena();
		a.initArena();
		System.out.println(a.toString());
		a.checkCollisions();
	}
	public void initArena(){
		Random r = new Random(System.currentTimeMillis());
		int NO = 2;
		objects = new Box[NO];
		for(int i=0; i<NO; i++){
			int x,y,w,h;
			x=r.nextInt(SIZE-2);
			y=r.nextInt(SIZE-2);
			w=2+r.nextInt(SIZE-x-2);
			h=2+r.nextInt(SIZE-y-2);
			objects[i] = new Box(x, y, w, h);
		}
	}
	
	public void checkCollisions(){
		for(int i=0; i < objects.length ; i++ ){
			for(int j=i+1; j < objects.length ; j++ ){
				if(objects[i].collide(objects[j])){
					handleCollision(objects[i],objects[j]);
				}
			}
		}

	}

	private void handleCollision(ICollidable A, ICollidable B) {
		System.out.println("Collision: " +  A.toString()+ " "+ B.toString());

	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<SIZE; i++){
			for(int j=0;j<SIZE; j++){
				arena[i][j]=' ';
				}
			}
		for(int i=0;i<SIZE; i++){
			arena[0][i] =  '+';
			arena[SIZE-1][i] =  '+';
			arena[i][0] = '+';
			arena[i][SIZE-1]='+';
		}
		char cc = '.';
		char ccc = '.';
		for(Box c : objects){
			arena[c.getY()][c.getX()]='+';
			for(int i=c.getX()+1 ; i<c.getX()+c.getW() ; i++)
				arena[c.getY()][i] = (i&1)==0?cc : ccc;
			
			arena[c.getY()+c.getH()][c.getX()]='+';
			for(int i=c.getX() + 1 ; i<c.getX()+c.getW() ; i++)
				arena[c.getY()+c.getH()][i] = cc;
			
			arena[c.getY()][c.getX()+c.getW()] = '+';
			for(int j=c.getY()+1 ; j<c.getY()+c.getH(); j++)
				arena[j][c.getX()] = cc;
			
			arena[c.getY()+c.getH()][c.getX()+c.getW()] = '+';
			for(int j=c.getY()+1 ; j<c.getY()+c.getH(); j++)
				arena[j][c.getX()+c.getW()] = cc;
				
			
		}
		
		for(int i=0;i<SIZE; i++){
			for(int j=0;j<SIZE; j++){
				
				sb.append(arena[i][j]);		
					
			}
			sb.append("\n");
		}
		return sb.toString();
		
	}
}
