package reflection;

public class ReverseOrderSolver extends InorderSolver{
	
	
	public Direction advance(int px, int py, boolean[] neighborhood) {
		visited.add(new pair(px,py));
//		for(pair p : visited ){
//			System.out.println(p.x+" "+p.y);
//		}
		
		for(int i = 3 ; i >=0  ; i--){
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
		
		
	};

}
