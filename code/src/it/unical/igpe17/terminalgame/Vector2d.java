package it.unical.igpe17.terminalgame;
public  class Vector2d {

		public static Vector2d ZERO = new Vector2d(0, 0);
	
	    private  double x;
	    private  double y;

	    
	    @Override
	    public String toString() {
	    String s= "["+x+" "+y+"]";
	    return s;
	    }
	    public Vector2d(double x, double y){
	        this.x = x;
	        this.y = y;
	        
	    }

	    public Vector2d approx(){
	   
	    	return new Vector2d(Math.rint(x), Math.rint(y));
	    }
	    public Vector2d minus(Vector2d s) {
	        return new Vector2d(x - s.x, y - s.y);
	    }
	    
	    public Vector2d add(Vector2d s) {
	        return new Vector2d(x + s.x, y + s.y);
	    }
	    
	    public Vector2d scale(final double scalefactor) {
	        return new Vector2d(x * scalefactor, y * scalefactor);
	    }

	    public double dot(Vector2d o) {
	        return x * o.x + y * o.y ;
	    }

	    public double abs() {
	        return Math.sqrt(x * x + y * y );
	    }
	    
	    public Vector2d normalize(){
	    	double abs=this.abs();
	    	return new Vector2d(x/abs, y/abs);
	    }

		public double getX() {
			return x;
		}

	    public double getY() {
			return y;
		}

		/**
		 * @param x the x to set
		 */
		public void setX(double x) {
			this.x = x;
		}

		/**
		 * @param y the y to set
		 */
		public void setY(double y) {
			this.y = y;
		}


	}
	
	

