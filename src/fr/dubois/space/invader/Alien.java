/* création de l'Alien :Charles Romaric Marine  */



package fr.dubois.space.invader;

import android.graphics.Bitmap;

public class Alien extends Sprite {
	private boolean direction;

	public Alien(Bitmap bitmap, float x, float y) {
		super(bitmap, x, y);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void act() {
		// TODO Auto-generated method stub		
	/* Charles 10/12/2012 */
		if (direction)
	if ( x>= 600)direction = false;
	else x= x-60;
}
{
	if(x<= 0)direction = false;
	else x= x+60;
}
}
