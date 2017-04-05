package it.unical.igpe17.terminalgame;

public abstract class AbstractGameObject implements IGameObject{
	
	protected Vector2d position;
	protected Vector2d size;
	protected Vector2d velocity 	= new Vector2d(0.0, 0.0);	
	protected Vector2d force 		= GameConfig.GRAVITY;
	
	public String toString() {
		String s ="[";
		s+=" pos: "+position.toString();
		s+=" vel: "+velocity.toString();
		s+=" for: "+force.toString();
		s+="]";
		return s;
	}
	
	public AbstractGameObject(Vector2d _position, Vector2d _size) {
		this.position = _position;
		this.size = _size;
	}
	
	void applyGravity(final double dt){
		if(getForce().getY() < GameConfig.GRAVITY.getY())
			setForce(getForce().add(GameConfig.GRAVITY));
		
	
		
		

//		if(position.getY()+size.getY() < GameConfig.HEIGHT )
//			setForce(getForce().add(GameConfig.GRAVITY));
//			
//		else if((int)(position.getY()+size.getY()+1) >= GameConfig.HEIGHT ){
//			System.out.println("pos "+position.getY());
//			Vector2d f =getForce();
//			f.setY(0.0);
//			setForce(f);
//			Vector2d nv = new Vector2d(getVelocity().getX(), 0);
//			setVelocity(nv);
//		}
	}
	
	
	private Vector2d computeNewVelocity(Vector2d vel, Vector2d force,
			double dt) {
		
			return vel.add(force.scale(dt));
	}
	private Vector2d computeNewPosition(Vector2d position2, Vector2d velocity2,
			double dt) {
		return position2.add(velocity2.scale(dt));
	}
	
	@Override
	public void move(final double dt) {
		applyGravity(dt);
		
	//	Vector2d newVelocity = computeNewVelocity(getVelocity(), getForce(), dt);
		setVelocity(
				getVelocity().add(
						getForce().scale(dt)
								)
					);
		
		if((int)(position.getY()+size.getY()) >= GameConfig.HEIGHT && velocity.getY()>0){
			Vector2d nv = new Vector2d(getVelocity().getX(), 0);
			setVelocity(nv);
		}
		
		//Vector2d newPosition = computeNewPosition(getPosition(),getVelocity(),dt);
		
		setPosition(getPosition().add(getVelocity().scale(dt)));
		if(getPosition().getY()+getSize().getY() >= GameConfig.HEIGHT)
			getPosition().setY((int)GameConfig.HEIGHT-getSize().getY());
	
	}
	


	

	@Override
	public Vector2d getPosition() {
		return position;
	}

	@Override
	public Vector2d getVelocity() {
		return velocity;
	}
	
	@Override
	public void setPosition(Vector2d pos) {
		position = pos;
		
	}

	@Override
	public Vector2d getForce() {
		return force;
	}

	@Override
	public void setVelocity(Vector2d _vel) {
		this.velocity = _vel;
		
	}

	@Override
	public void setForce(Vector2d _force) {
		this.force = _force;
		
	}
	
	@Override
	public Vector2d getSize() {
		return size;
	}

	@Override
	public void setSize(Vector2d _size) {
		this.size = _size;
		
	}
	
	

}
