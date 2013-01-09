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
	private static final int TARGET_HEIGHT = 800;
	private static final int TARGET_WIDTH = 600;

	private Paint paint; // Style pour le texte	
	private String text; // texte à afficher
	private Alien alien1;
	private Bitmap alien;
	private Object system;
	private RefreshHandler mRedrawHandler = new RefreshHandler();
	private long mMoveDelay = 600;
	private int RUNNING;
	private int mMode = RUNNING;
	private long mLastMove;



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




	void init(){

		update();	
		//alien = new Alien(null, 0, 0);
		paint = new Paint();
		paint.setStyle(Style.STROKE);
		paint.setColor(Color.YELLOW);
		paint.setTypeface(Typeface.SANS_SERIF);
		paint.setTextSize(36);
		paint.setTextAlign(Paint.Align.CENTER);
		text = "Texte";
		alien1 =loadImage (R.drawable.alien1);
	}










	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawRGB(0, 0, 0);
		canvas.drawRect(0, 0, TARGET_WIDTH-1, TARGET_HEIGHT-1, paint);
		if (text != null){
			canvas.drawText(text, canvas.getWidth()/2,canvas.getHeight()/2, paint);
			alien1.draw(canvas);

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



	public Alien loadImage(int res) {
		Drawable drawable = this.getContext().getResources().getDrawable(res);
		int x=drawable.getIntrinsicWidth();
		int y=drawable.getIntrinsicHeight();

		Bitmap bitmap = Bitmap.createBitmap(x, y, Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmap);

		drawable.setBounds(0, 0, x, y);
		drawable.draw(canvas);

		return  alien1;
	}
	;

	//compte a rebours


	public void update() {
		alien1.act();


		mRedrawHandler.sleep(40);
	}




	private void clearTiles() {
		// TODO Auto-generated method stub

	}


	class RefreshHandler extends Handler {

		@Override
		public void handleMessage(Message msg) {
			SpaceInvaderView.this.update();
			SpaceInvaderView.this.invalidate();
		}

		public void sleep(long delayMillis) {
			this.removeMessages(0);
			sendMessageDelayed(obtainMessage(0), delayMillis);
		}
	};

}
