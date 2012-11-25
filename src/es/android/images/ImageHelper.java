package es.android.images;

import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;

public class ImageHelper {

	/*
	 * Retorna una imagen a un tamaño determinado
	 */
	public static Bitmap getResizedBitmap(Bitmap paramBitmap, int paramInt1,
			int paramInt2) {
		int i = paramBitmap.getWidth();
		int j = paramBitmap.getHeight();
		float f1 = paramInt2 / i;
		float f2 = paramInt1 / j;
		Matrix localMatrix = new Matrix();
		localMatrix.postScale(f1, f2);
		return Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, false);
	}

	public static Bitmap getRoundedCornerBitmap(Bitmap paramBitmap, int paramInt) {
		Bitmap localBitmap1 = Bitmap.createBitmap(paramBitmap.getWidth(),
				paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);

		Canvas localCanvas = new Canvas(localBitmap1);

		Paint localPaint1 = new Paint();

		Rect localRect = new Rect(0, 0, paramBitmap.getWidth(),
				paramBitmap.getHeight());

		RectF localRectF = new RectF(localRect);

		float f = paramInt;
		localPaint1.setAntiAlias(true);
		localCanvas.drawARGB(0, 0, 0, 0);
		localPaint1.setColor(-12434878);
		localCanvas.drawRoundRect(localRectF, f, f, localPaint1);
		localPaint1.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
		localCanvas.drawBitmap(paramBitmap, localRect, localRect, localPaint1);
		paramBitmap.recycle();
		BlurMaskFilter localBlurMaskFilter = new BlurMaskFilter(5.0F,
				BlurMaskFilter.Blur.OUTER);
		Paint localPaint2 = new Paint();
		localPaint2.setColor(-65536);
		localPaint2.setMaskFilter(localBlurMaskFilter);
		int[] arrayOfInt = new int[2];
		Bitmap localBitmap2 = localBitmap1
				.extractAlpha(localPaint2, arrayOfInt);
		Bitmap localBitmap3 = localBitmap2.copy(Bitmap.Config.ARGB_8888, true);
		localBitmap2.recycle();
		new Canvas(localBitmap3).drawBitmap(localBitmap1, -arrayOfInt[0],
				-arrayOfInt[1], null);
		return localBitmap3;
	}
}
