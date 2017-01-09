package it.unical.it.igpe2017.arkanoid.core.utils;
public  class Vector2d {

	    private final double x;
	    private final double y;

	    public Vector2d(double x, double y){
	        this.x = x;
	        this.y = y;
	        
	    }

	    public Vector2d minus(Vector2d s) {
	        return new Vector2d(x - s.x, y - s.y);
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


	}
	
	

