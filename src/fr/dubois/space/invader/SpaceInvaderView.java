package fr.dubois.space.invader;



import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;



import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class SpaceInvaderView extends View {
	
	// Dimensions souhaitées
	private static final int TARGET_HEIGHT = 1024;
	private static final int TARGET_WIDTH = 720;

	private Paint paint; // Style pour le texte	
	private String text; // texte à afficher

/*charles*/
	Alien alien ;
	
	public SpaceInvaderView(Context context) {
		super(context);
		init();
	}

	public SpaceInvaderView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public SpaceInvaderView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}



/*Charles*/
	void init (){

		paint = new Paint();
		paint.setStyle(Style.STROKE);
		paint.setColor(Color.YELLOW);
		paint.setTypeface(Typeface.SANS_SERIF);
		paint.setTextSize(36);
		paint.setTextAlign(Paint.Align.CENTER);
		text = "Texte";
		/*resetTile(6);
        loadTile(ALIEN1, r.getDrawable(R.drawable.alien1));
        loadTile(IC_LAUNCHER, r.getDrawable(R.drawable.ic_launcher));
        loadTile(MISSILE, r.getDrawable(R.drawable.missile));
        loadTile(MISSILE2, r.getDrawable(R.drawable.missile2));
        loadTile(SHIP, r.getDrawable(R.drawable.ship));*/
	}

 /* Romaric */       
		public  Bitmap loadimage (int key) {

		
		 Resources r = this.getContext().getResources();
		 Drawable drawable=r.getDrawable(key);
 	     int  y=drawable.getIntrinsicHeight();
	     int  x=drawable.getIntrinsicWidth();
         Bitmap bitmap = Bitmap.createBitmap(x, y, Bitmap.Config.ARGB_8888);
         Canvas canvas = new Canvas(bitmap);
         drawable.setBounds(0, 0, x, y);
         drawable.draw(canvas);
        
       return bitmap; 
    }





	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawRGB(0, 0, 0);
		canvas.drawRect(0, 0, TARGET_WIDTH-1, TARGET_HEIGHT-1, paint);
		alien.draw(canvas);
		if (text != null){
			canvas.drawText(text, canvas.getWidth()/2,canvas.getHeight()/2, paint);
		}
	}


	private int computeSize(int spec,int def){
		int mode = View.MeasureSpec.getMode(spec);
		if (mode == View.MeasureSpec.UNSPECIFIED) return def;
		int size = View.MeasureSpec.getSize(spec);
		if (mode == View.MeasureSpec.EXACTLY) {
			return size;
		}
		//		MeasureSpec.AT_MOST
		if (size < def ) return size;
		return def;
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int x = computeSize(widthMeasureSpec,TARGET_WIDTH);
		int y = computeSize(heightMeasureSpec,TARGET_HEIGHT);
		this.setMeasuredDimension(x,y);
	}

}
