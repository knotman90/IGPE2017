package reflection;

import java.util.Random;

public class Maze {

	boolean[][] M;
	final int opx,opy;

	int px,py;
	int tx,ty;
	protected final int SIZE;
	private final float load;

	Maze(int SIZE_, int _px, int _py, float _load){
		this.SIZE = SIZE_;
		load = _load;
		this.px =  this.opx = _px;
		this.py =  this.opy = _py;
		initMaze();
	}

	void initMaze(){

		if(M==null){
			M = new boolean[SIZE][SIZE];

			Random r  = new Random(System.currentTimeMillis());
			tx =r.nextInt(SIZE);
			ty =r.nextInt(SIZE);
			for(int i = 0 ; i< SIZE ; i++){
				for (int j = 0; j < SIZE; j++) {
					if(r.nextFloat() <= load)
						M[i][j]=false;
					else
						M[i][j]=true;

				}
			}

			M[px][py] = true;
			M[tx][ty] = true;
		}else{
			//simply restore player coordinate
			px = opx;
			py = opy;
			
		}
	}

	void printMaze(){

		System.out.println();
		for(int i = 0 ; i< SIZE ; i++){
			for (int j = 0; j < SIZE; j++) {
				System.out.format("+---");
			}
			System.out.println();
			for (int j = 0; j < SIZE; j++) {
				if(i==py && j==px)
					System.out.format("| Q ");
				else if(ty==i && tx ==j)
					System.out.format("| T ");
				else if(!M[i][j])
					System.out.format("| X ");
				else
					System.out.format("|   ");
			}
			System.out.println("|");
		}
		for (int j = 0; j < SIZE; j++) {
			System.out.format("+---");
		}
		System.out.println();
	}

	public boolean isSolved(){
		return px == tx && py == ty;
	}


	public int getpx() {
		return px;
	}
	public int getpy() {
		return py;
	}
	public boolean[] getNeighborhood() {
		boolean[] neigh = new boolean[4];
		neigh[0] = (py-1) >=0 && M[py-1][px];
		neigh[1] = (px-1) >=0 && M[py][px-1];
		neigh[2] = (py+1) < SIZE && M[py+1][px];
		neigh[3] = (px+1) <SIZE && M[py][px+1];
		return neigh;
	}

	public void move(Direction d) {
		switch (d) {
		case UP:
			py--;
			break;
		case RIGHT:
			px++;
			break;
		case DOWN:
			py++;
			break;
		case LEFT:
			px--;
			break;


		}

	}

}
