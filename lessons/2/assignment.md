
#Assignment - Implementing a simple Collision System


Given the following interface which exposes a method `collide` which takes a non modifiable **Collidable** as parameter returns true if `caller` collides with the given `Collidable` parameter.

```java

public interface Collidable {
	
	public boolean collide(final Collidable c);
}

```

Create a class **Box** which implements `Collidable` and stores fiels describing a  2D box in space.
 
***
 Two boxes collides if they share some portion on the space. 
* This is a blurry definition, you have to come up with a more formal and mathematical description of what collision means.*

`Box` must also override the `toString` method from `Object` superclass.

The following image gives you a (big) hint on how to formalize collisions in two 2D. 
![alt text](images/collision.png "Collision detection in 2D")
Pink and blue boxes are colliding while green and blue are not for instance. 


Create a class Arena which stores information about a set of Collidable Objects and exposes a method with the following signatures. 
`Arena` also stores an array of `Collidable` which size (can be assumed) never exceed `1000`;

```java

	public void checkCollisions(){
	
	}
	
	@Override
	public String toString() {
	
	}
```

`checkCollisions` should check for all collision between all `Collidable` objects. On the event of a collision between two objects **A and B** it should print the following:


```java
	System.out.println("Collision: " +  A.toString() + " "+ B.toString());
```


`toString` takes care of drawing the Arena to standard output (console). Draw the boundaries of the Area using the plus `+`, character.
Boxes must be drawn using the point `.` character and corner using the `+` character.
You can always assume that Collidable Objects coordinates are never lower than `0` or greater than `99`.


In order to test out collision detection system you should also provide a init function which init boxes randomly (within arena boundaries) and a main which will execute a demo.
```java
	public static void main(String[] args) {
		Arena a = new Arena();
		a.initArena(10);
		//print the area on stdout
		System.out.println(a.toString());
		//check Collisions and print them on stdout
		a.checkCollisions();
	}
	
	//init arena should init boxes randomly.
	
	public void initArena(final int NO){
		Random r = new Random(System.currentTimeMillis());
		objects = new Box[NO];
		for(int i=0; i<NO; i++){
			//function that creates a random box
			Box br=createRandomBox(r,....);
			objects[i] =br;
		}
	}
```


```
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+                                                                                                  +
+                                                                                                  +
+                                                                                                  +
+                                                                                                  +
+                                                                                                  +
+                                                                                                  +
+                                                                                                  +
+                                                                                                  +
+                                                                                                  +
+                                                   +..................................+           +
+                                                   .                                  .           +
+                                                   .                                  .           +
+                                                   .                                  .           +
+                                                   .                                  .           +
+                                                   .                                  .           +
+                                                   .                                  .           +
+                                                   .                                  .           +
+                                                   .                                  .           +
+                                                   .                                  .           +
+                                                   .                                  .           +
+                                                   .                                  .           +
+                                                   .                                  .           +
+                                                   .                                  .           +
+                                                   .                                  .           +
+                                                   .                                  .           +
+                                                   .                                  .           +
+                                                   .                                  .           +
+                                                   .                                  .           +
+                                                   .                                  .           +
+                                                   .                                  .           +
+                                                   .                                  .           +
+                                                   .                                  .           +
+                                                   .                                  .           +
+                                                   .                                  .           +
+                                                   .                                  .           +
+                                                   .                                  .           +
+                                                   .                                  .           +
+                                                   .                                  .           +
+                                                   .                                  .           +
+                                                   .                                  .           +
+                                                   .                                  .           +
+                                                   .                                  .           +
+                                                   .                                  .           +
+                                                   .                                  .           +
+                                                   .                                  .           +
+                                                   .                                  .           +
+                                                   .                                  .           +
+                                                   .                                  .           +
+                                                   .       +....+                     .           +
+                                                   .       .    .                     .           +
+                                                   .       .    .                     .           +
+                                                   .       .    .                     .           +
+                                                   .       .    .                     .           +
+                                                   .       .    .                     .           +
+                                                   +..................................+           +
+                                                           .    .                                 +
+                                                           .    .                                 +
+                  +...........................................................+                   +
+                  .                                        +....+             .                   +
+                  .                                                           .                   +
+                  .                                                           .                   +
+                  .                                                           .                   +
+                  .                                                           .                   +
+                  .                                                           .                   +
+                  .                                                           .                   +
+                  .                                                           .                   +
+                  .                                                           .                   +
+                  .                                                           .                   +
+                  .                                                           .                   +
+                  .                                                           .                   +
+                  .                                                           .                   +
+                  +...........................................................+                   +
+                                                                                                  +
+                                                                                             +.+  +
+                                                                                             . .  +
+                                                                                             . .  +
+                                                                                             . .  +
+                                                                                             . .  +
+                                                                                             . .  +
+                                                                                             . .  +
+                                                                                             . .  +
+                                                                                             . .  +
+                +.................................................................+          . .  +
+                .                                                                 .          . .  +
+                .                                                                 .          +.+  +
+                .                                                                 .               +
+                +.................................................................+               +
+                                                                                                  +
+                                                                                                  +
+                                                                                                  +
+                                                                                                  +
+                                                                                                  +
+                                                                                                  +
+                                                                                                  +
+                                                                                                  +
+                                                                                                  +
+                                                                                                  +
+                                                                                                  +
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

Collision:  60:49-5:10  19:58-60:14
Collision:  60:49-5:10  52:10-35:45

```

##Final Remaks
What is the complexity of the `checkCollision`method? 
Do you think it can be used in a game? 
Can it be used in a game, even if the number of objects is, more than 1000?



# Solution

```java
//Collidable.java
public interface Collidable {
	
	public boolean collide(Collidable c);
}
```

```java
public class Box implements Collidable{

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
	
	@Override
	public boolean collide(Collidable c) {
		int AX,AY,BX,BY;
		if(c instanceof Box){
			Box bc = (Box)c;
			BX=bc.x+bc.w;
			BY=bc.y+bc.h;
			AX=x+w;
			AY=y+h;
			return !( (AX < bc.x) || (BX < x) || (AY < bc.y) || (BY < y) );
			
		}else
			throw new NotImplementedException();
				
	}

	
	@Override
	public String toString() {
		String s = " " +x+":" +y+"-"+w+":"+h;
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

```

```java
public class Arena {


	public final static int SIZE = 100;
	Box[] objects;
	
	char [][] arena = new char[SIZE][SIZE];

	
	public static void main(String[] args) {
		Arena a = new Arena();
		a.initArena();
		System.out.println(a.toString());
		a.checkCollisions();
	}
	public void initArena(){
		Random r = new Random(System.currentTimeMillis());
		int NO = 5;
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

	private void handleCollision(Collidable A, Collidable B) {
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

```
