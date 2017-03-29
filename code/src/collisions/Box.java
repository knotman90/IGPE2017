package collisions;



public class Box implements ICollidable{

	private int x;
	private int y;
	//size along columns
	private int w;
	//size along rows
	private int h;
	public Box(final int _x, final int _y, final int _w, final int _h) {
		if(_w <=0 || _h <=0)
			throw new IllegalArgumentException("Box cannot have negative or zero size in any dimension");
		x=_x;
		y=_y;
		w=_w;
		h=_h;
	}
	
	/**
	 * AABB algorithm
	 * ref: 
	 */
	@Override
	public boolean collide(ICollidable c)  {
		int AX,AY,BX,BY;
		if(c instanceof Box){
			Box bc = (Box)c;
			BX=bc.x+bc.w;
			BY=bc.y+bc.h;
			AX=x+w;
			AY=y+h;
			return !( (AX < bc.x) || (BX < x) || (AY < bc.y) || (BY < y) );
		}
		return false;			
	}

	
	@Override
	public String toString() {
		String s = x+":" +y+"-"+w+":"+h;
		return s;
		
	}
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the w
	 */
	public int getW() {
		return w;
	}

	/**
	 * @param w the w to set
	 */
	public void setW(int w) {
		this.w = w;
	}

	/**
	 * @return the h
	 */
	public int getH() {
		return h;
	}

	/**
	 * @param h the h to set
	 */
	public void setH(int h) {
		this.h = h;
	}
	
	

}
