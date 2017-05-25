package reflection;


class pair {
	pair(int _x,int _y){
		x = _x;
		y = _y;
	}
	public int x,y;

	@Override
	public boolean equals(Object obj1) {
		pair obj = (pair)obj1;
		return x==obj.x && y == obj.y;
	}

	@Override
	public int hashCode() {
		int result = x;
		result = 31 * result + y;
		return result;

	}
}