package fr.dubois.space.invader;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

public abstract class Sprite {
	
	protected Bitmap bitmap;
	protected float x;
	protected float y;
	protected Paint paint;

	public Sprite(Bitmap bitmap,float x,float y) {
		this.bitmap = bitmap;
		this.x = x;
		this.y = y;
		paint = new Paint();
	}

	public void draw(Canvas canvas) {
		canvas.drawBitmap(bitmap, x, y, paint);
	}
	
	public RectF getBbox(){
		return new RectF(x,y,x+bitmap.getWidth()-1,y+bitmap.getHeight()-1); 
	}
	
	public abstract void act();

	
	


 /* sprite alien */
	
public void Alien(Bitmap bitmap,float x,float y) {
	this.bitmap = bitmap;
	this.x = x;
	this.y = y;
	paint = new Paint();  }

 }



/*fin sprite alien */
