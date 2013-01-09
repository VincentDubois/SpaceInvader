package fr.dubois.space.invader;

import android.graphics.Bitmap;

public class Alien extends Sprite {

	public Alien(Bitmap bitmap, float x, float y) {
		super(bitmap, x, y);
		// TODO Auto-generated consthehructor stub
	}

	@Override
	public void act() {
		int x = 0;
		// TODO Auto-generated method stub
		this.x = x+5;
		this.x = x-5;
	}

}

