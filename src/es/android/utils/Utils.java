package es.android.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.WindowManager;
import android.content.Context;
import android.os.Build;
import android.util.Log;

public class Utils {
	
	
	public static Object deserializeObject(byte[] paramArrayOfByte) {
		Object localObject = null;

		try {
			ObjectInputStream localObjectInputStream = new ObjectInputStream(
					new ByteArrayInputStream(paramArrayOfByte));
			localObject = localObjectInputStream.readObject();
			localObjectInputStream.close();
			return localObject;
		} catch (ClassNotFoundException localClassNotFoundException) {
			Log.e("Utils", "deserializeObject class not found error",
					localClassNotFoundException);
		} catch (IOException localIOException) {
			Log.e("Utils", "deserializeObject io error", localIOException);
		}

		return localObject;
	}

	public static byte[] serializeObject(Object paramObject) {

		byte[] arrayOfByte = null;
		try {
			ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
			ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(
					localByteArrayOutputStream);
			localObjectOutputStream.writeObject(paramObject);
			localObjectOutputStream.close();
			arrayOfByte = localByteArrayOutputStream.toByteArray();
		} catch (IOException localIOException) {

			Log.e("Utils", "serializeObject error" + localIOException);
		}
		return arrayOfByte;
	}

	public static String getAndroidSDKVersion() {
		return Integer.toString(Build.VERSION.SDK_INT);
	}

	public static String getCarrierName() {
		return Build.BRAND;
	}

	
	public static String getHandsetOSNameForXLITrackHeader() {
		StringBuilder localStringBuilder = new StringBuilder();
		localStringBuilder.append("Android OS/");
		localStringBuilder.append(getAndroidSDKVersion());
		return localStringBuilder.toString();
	}

	public static String capitaliseFirstLetter(String paramString) {
		return paramString.substring(0, 1).toUpperCase()
				+ paramString.substring(1);
	}

	public static void copyStream(InputStream paramInputStream,
			OutputStream paramOutputStream) {
		try {
			byte[] arrayOfByte = new byte[1024];
			while (true) {
				int i = paramInputStream.read(arrayOfByte, 0, 1024);
				if (i == -1)
					break;
				paramOutputStream.write(arrayOfByte, 0, i);
			}
		} catch (Exception localException) {
		}
	}

	public static int getScreenHeight(Context paramContext) {
		return ((WindowManager) paramContext.getSystemService("window"))
				.getDefaultDisplay().getHeight();
	}

	public static int getScreenWidth(Context paramContext) {
		return ((WindowManager) paramContext.getSystemService("window"))
				.getDefaultDisplay().getWidth();
	}

	public static String getStringFormatDate(Date paramDate) {
		return new SimpleDateFormat("E d MMM yyyy", Locale.getDefault())
				.format(paramDate);
	}

	public static String getStringFormatDateFirstLetterCapitalise(Date paramDate) {
		return capitaliseFirstLetter(new SimpleDateFormat("E d MMM yyyy",
				Locale.getDefault()).format(paramDate));
	}

	public static boolean isNetworkAvailable(Context paramContext) {

		try {
			NetworkInfo info = ((ConnectivityManager) paramContext
					.getSystemService("connectivity")).getActiveNetworkInfo();

			return info.isConnectedOrConnecting();
		}

		catch (Exception exp) {
			return false;
		}

	}

}
