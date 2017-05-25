package reflection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class InorderSolver implements IMazeSolver{

	Set<pair> visited = new HashSet<pair> ();
	List<Direction> path = new ArrayList<Direction>();  

	Direction[] reverseDir = { Direction.DOWN, Direction.RIGHT, Direction.UP, Direction.LEFT};



	@Override
	public Direction advance(int px, int py, boolean[] neighborhood) {
		visited.add(new pair(px,py));
//		for(pair p : visited ){
//			System.out.println(p.x+" "+p.y);
//		}
		
		for(int i = 0 ; i < 4 ; i++){
			if(neighborhood[i]){
				pair neighCoords = new pair(px,py);
				Direction idir = Direction.fromInt(i);
				if(Direction.UP == idir){
					neighCoords.y--;
				}
				else if(Direction.DOWN == idir ){
					neighCoords.y++;
				}
				else if(Direction.RIGHT == idir ){
					neighCoords.x++;
				}
				else if(Direction.LEFT== idir ){
					neighCoords.x--;
				}

				if(!visited.contains(neighCoords)){
					path.add(idir);
					return idir;
				}
			}
		}

		//no direction available, backtrack
		if(path.size()>0){
			Direction last = path.remove(path.size()-1);
			return reverseDir[last.getValue()];
		}else
			return Direction.STOP;

	}




}
