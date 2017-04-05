#Interfacce Grafice e Programmazione ad Eventi - IGPE

---

##Collision System Assignment Solution

A good representation for the `Box` could be

`(r,c,h,w) ` where (r,c) represents the coordinates of the upper left corner and `h` and `w` the height and width, respectively.
- two double precision variables for the upper left corner

The  idea behind the collides methods is the following:
- Think when two boxes **do not collide**. It's easier.
- Two boxes then collide when it's false that they do not collide.

If `AX` is the right coordinate  along x directrion of the `A` and `BX` is the right  coordinate along x direction of `B` then
 and AY and BY the botton coordinate along the `y` direction then two boxes do not collide if:
 
 - `B.x` is at right of `AX` 

```java
++++++++++++++++++++
+                  +
+                  +
+                  +
+                  +
+                  +
+                  +
+                  +
+                  +
+                  +
+                  +
+                  +
+                  +
+ +...+      +...+ +
+ .   .      .   . +
+ . A .      .B  . +
+ .   .      .   . +
+ +...+      .   . +
+            +...+ +
++++++++++++++++++++
  ^   ^      ^   ^
  |   |      |   |
 A.x  AX    B.x  BX
```

- `A.x` is at right of `BX` 



```java
++++++++++++++++++++
+                  +
+                  +
+                  +
+                  +
+                  +
+                  +
+                  +
+                  +
+                  +
+                  +
+                  +
+                  +
+ +...+      +...+ +
+ .   .      .   . +
+ . B .      .A  . +
+ .   .      .   . +
+ +...+      .   . +
+            +...+ +
++++++++++++++++++++
  ^   ^      ^   ^
  |   |      |   |
 B.x  BX    A.x  AX
```
 - Same reasoning hold for the `y` direction.
```java
++++++++++++++++++++
+                  +
+                  +
+                  +
+        +.+       + <---A.y
+        .A.       +
+        . .       +
+        +.+       + <---AY
+                  +
+                  +
+          +....+  + <--- B.y
+          .    .  +
+          .    .  +
+          .    .  +
+          .  B .  +
+          .    .  +
+          .    .  +
+          .    .  +
+          +....+  + <--- BY
++++++++++++++++++++
```

 If none of this condition is true then there is a collision!
 `return !( (AX < bc.x) || (BX < x) || (AY < bc.y) || (BY < y) );`
 
 Using Boleean algebra law it translates to (remember? `!(A OR B)` = `!A AND !B`):
 `return ( (AX >= bc.x) && (BX >= x) && (AY >= bc.y) && (BY >= y) );`

```
  01234567890123456789
 0+++++++++++++++++++++
 1+     |  |         +
 2+     |  |         +
 3+     |  |         +
 4+     |  |         +
 5+     |  |         +
 6+     |  |         +
 7+________+........++
 8+     |  .        .+
 9+     |  .    A   .+
 0+_____+..........+.+
 1+     .  .       ..+
 2+     .  +........++
 3+     .          . +
 4+     .    B     . +
 5+     .          . +
 6+     +..........+ +
 7+                  +
 8+                  +
  ++++++++++++++++++++
```
##Examples
```
A.x=9	B.x=6
A.y=7	B.y=10
AX=18	BX=17
AY=12	BY=16

AX>=B.x is true! 18>=6
BX>=A.x is true! 17>=9
AY>=B.y is true! 12>=10
BY>=A.y is true! 16>=7 
We have a collision here!
```


```
++++++++++++++++++++
+                  +
+                  +
+                  +
+   +.....+        +
+   .     .        +
+   .     .        +
+   +.....+        +
+                  +
+                  +
+                  +
+                  +
+                  +
+                  +
+                  +
+     +....+       +
+     .    .       +
+     +....+       +
+                  +
++++++++++++++++++++
```
```
A.x=2	B.x=6
A.y=4	B.y=15
AX=8	BX=11
AY=7	BY=17

AX>=B.x is true! 8>=6
BX>=A.x is true! 11>=2
Intersect along x axis
BY>=A.y is true! 17>=4 
AY>=B.y is **false**! 7>=15 is false
No Collision
```
 

```java
public class Box implements ICollidable{
	/**
		Coordinate of the upper left corner
	*/
	private int x;
	private int y;
	
	// width
	private int w;
	//height
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
	public boolean collide(ICollidable c)  {
	//AX,AY right and bottom coordinates

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
		String s = " " +x+":" +y+"-"+w+":"+h;
		return s;
		
	}
	//getters and setters
	
```

##CheckCollision
The check Collision method is super easy to implement. Check all possible pair of Box in the Area for collision making sure you donìt check two pair two times!

```java
	public void checkCollisions(){
		for(int i=0; i < objects.length ; i++ ){
			for(int j=i+1; j < objects.length ; j++ ){
				if(objects[i].collide(objects[j])){
					handleCollision(objects[i],objects[j]);
				}
			}
		}

```

Complexity is quadratic in the number of boxes. Be aware that is it not only $O(n^2)$ but also $\Omega(N^2)$! This means that even the best case is quadratic which makes the complexity of the method $\Theta(N^2)$!


##Collision System Assignment Dos and Don'ts
### Write documentation!  
- How could you even think that a work peer is able to **understand** code you wrote which is not documented well?

```java
public class Box implements ICollidable {
	
	Pair sx, dx;
	
	public Box (int x1, int y1, int x2, int y2){
		if (x1 > x2 && y1 < y2){
			sx = new Pair (x2, y1);
			dx = new Pair (x1, y2);
		}
		
		else if (x1 > x2 && y1 > y2){
			sx = new Pair (x2, y2);
			dx = new Pair (x1, y1);
		}
		
		else if (x1 < x2 && y1 < y2){
			sx = new Pair (x1, y1);
			dx = new Pair (x2, y2);
		}
		
		else{
			sx = new Pair (x1, y2);
			dx = new Pair (x2, y1);
		}
	}
	
```
- What the Pair sx and dx mean?

The following is much better!
```java
public class Box implements ICollidable{

	private int x_corner_sx; // x coordinate of an imaginary matrix that is in Arena
	private int y_corner_sx; // y coordinate of an imaginary matrix that is in Arena
	private int base; // the length of the Box's base
	private int height; // the length of the Box's height
	
	// check with a mathematical model if two ICollidable have some parts in common
	public boolean collide(ICollidable c1){
		if(c1 instanceof Box){
		Box c=(Box)c1;
		if(((x_corner_sx>=c.x_corner_sx && x_corner_sx<c.x_corner_sx+c.base) || (c.x_corner_sx>=x_corner_sx && c.x_corner_sx<x_corner_sx+base))
				&&((y_corner_sx>=c.y_corner_sx && y_corner_sx<c.y_corner_sx+c.height) ||(c.y_corner_sx>=y_corner_sx && c.y_corner_sx<y_corner_sx+height)))
			return true;
		}
		return false;
	}
	
```

###Check all points inside a Box
```java
@Override
	public boolean collide(ICollidable c) {
		Box b=new Box();
		if(c instanceof Box)
			b=(Box)c;
		for(int i=b.NO.getX();i<=b.SO.getX();i++)
			for(int j=b.NO.getY();j<=b.NE.getY();j++)
				if(i == b.NO.getX() || i==b.SO.getX() || j==b.NO.getY() || j==b.NE.getY()){
					Punto p=new Punto(i,j);
					if(p.getX()>=this.NO.getX() && p.getX()<=this.SE.getX() && p.getY()>=this.NO.getY() && p.getY()<=this.SE.getY()){
						System.out.println("Collision: " +  this.toString() + " "+ b.toString());
						return true;						
					}
					
				}
		return false;
	}
```

This method checks all points inside a Box! Has itself a complexity of $Box.WIDHT \times Box.HEIGHT$ making the check collision overall complexity $O(n^2 \times SIZE^2)$

###Using an Hashset or TreeSet
A simple plain array was enough! 

```java
public class Arena {
	
	Set<Box> boxes;
	
	Arena (int parameter)
	{
		boxes = new TreeSet<Box>();
```