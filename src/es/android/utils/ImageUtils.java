package es.android.utils;

import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.widget.ImageView;

public class ImageUtils {

	public static final int CONNECTIONTIMEOUT = 45000;
	public static final int SOCKETBUFFERSIZE = 8192;
	public static final boolean REDIRECTING = true;
	public static final HttpParams HTTP_PARAMS;
	public static final ThreadSafeClientConnManager HTTP_CONNECTION_MANAGER;
	private final DefaultHttpClient localHttpClient = new DefaultHttpClient(
			HTTP_CONNECTION_MANAGER, HTTP_PARAMS);

	/* Imagenes a descargar */
	private final HashMap<String, Boolean> mPendingDownloads = new HashMap();
	private final int loadingResourceId;
	private static final HashMap<String, Bitmap> sHardBitmapCache;

	static {
		BasicHttpParams localBasicHttpParams = new BasicHttpParams();

		HttpConnectionParams.setStaleCheckingEnabled(localBasicHttpParams,
				false);
		HttpConnectionParams.setConnectionTimeout(localBasicHttpParams,
				CONNECTIONTIMEOUT);
		HttpConnectionParams.setSoTimeout(localBasicHttpParams,
				CONNECTIONTIMEOUT);
		HttpConnectionParams.setSocketBufferSize(localBasicHttpParams,
				SOCKETBUFFERSIZE);
		HttpClientParams.setRedirecting(localBasicHttpParams, REDIRECTING);
		HTTP_PARAMS = localBasicHttpParams;
		SchemeRegistry localSchemeRegistry = new SchemeRegistry();
		localSchemeRegistry.register(new Scheme("http", PlainSocketFactory
				.getSocketFactory(), 80));
		localSchemeRegistry.register(new Scheme("https", SSLSocketFactory
				.getSocketFactory(), 443));

		HTTP_CONNECTION_MANAGER = new ThreadSafeClientConnManager(
				localBasicHttpParams, localSchemeRegistry);

		sHardBitmapCache = new LinkedHashMap(50, 0.75F, true);

	}

	public ImageUtils(int resourceID) {
		this.loadingResourceId = resourceID;
	}

	private void addBitmapToCache(String paramString, Bitmap paramBitmap) {
		if (paramBitmap != null)
			synchronized (sHardBitmapCache) {
				sHardBitmapCache.put(paramString, paramBitmap);
			}
	}

	private Bitmap getBitmapFromCache(String paramString) {
		Bitmap localObject2;
		synchronized (sHardBitmapCache) {

			localObject2 = (Bitmap) sHardBitmapCache.get(paramString);

			if (localObject2 != null) {
				sHardBitmapCache.remove(paramString);
				sHardBitmapCache.put(paramString, localObject2);
			}
		}

		return localObject2;

	}

	
	private void forceDownload(Context paramContext, Uri uri,
			ImageView iv, String name)
	{
		
		 if (name == null)
		      iv.setImageDrawable(null);
		
		BitMapNetworkDownload downloadNetwork = new BitMapNetworkDownload(paramContext, uri, iv);
		iv.setImageDrawable(new DownloadedDrawable(downloadNetwork));
		
		
		downloadNetwork.execute(name);

		
	}
	
	
	public void downloadImage(Context paramContext, String uriString,
			ImageView iv, String name) {

		Uri uri = Uri.parse(uriString);
		if (name == null)
			name = uri.getLastPathSegment();

		Bitmap localBitmap = getBitmapFromCache(name);

		if (localBitmap == null) {
						
			forceDownload(paramContext, uri, iv, name);
			
			iv.setImageResource(this.loadingResourceId);
		} else {
			iv.setImageBitmap(localBitmap);
		}

	}

	public Bitmap getUrlImage(Context context, String name, Uri uri) {

		Bitmap map = null;

		try {

			/* 1º Creamos el url a pedir */
			HttpGet localHttpGet = new HttpGet(uri.toString());

			/* 2º leemos el fichero */
			InputStream localInputStream = new BufferedHttpEntity(
					localHttpClient.execute(localHttpGet).getEntity())
					.getContent();

			map = BitmapFactory.decodeStream(localInputStream);

			/* Cerramos el input stream */
			localInputStream.close();

		} catch (Exception excp) {

		}

		return map;
	}

	private Boolean deleteUrlFromPendingDownloads(String paramString) {
		return (Boolean) this.mPendingDownloads.remove(paramString);
	}

	private Boolean addUrlToPendingDownloads(String paramString) {
		return (Boolean) this.mPendingDownloads.put(paramString, Boolean.TRUE);
	}

	public void clearCache() {

		this.mPendingDownloads.clear();
	}

	/* Hilo asincrono para descarga */
	class BitMapNetworkDownload extends AsyncTask<String, Void, Bitmap> {
		private final WeakReference<ImageView> imageViewReference;
		private Context mContext;
		private String mName;
		private Uri mUri;

		public BitMapNetworkDownload(Context context, Uri uri, ImageView iv) {
			this.imageViewReference = new WeakReference(iv);
			this.mContext = context;
			this.mUri = uri;
		}

		@Override
		protected Bitmap doInBackground(String... params) {

			this.mName = params[0];

			return ImageUtils.this.getUrlImage(mContext, mName, mUri);
		}

		protected void onPostExecute(Bitmap paramBitmap) {

			if (isCancelled())
				paramBitmap = null;

			ImageUtils.this.addBitmapToCache(this.mName, paramBitmap);

			if (this.imageViewReference != null) {
				ImageView localImageView = (ImageView) this.imageViewReference
						.get();

				if (paramBitmap != null)
					localImageView.setImageBitmap(paramBitmap);
			}

		}

		protected void onPreExecute() {
			if (this.imageViewReference != null)
				((ImageView) this.imageViewReference.get())
						.setImageResource(ImageUtils.this.loadingResourceId);
			super.onPreExecute();
		}

	}
	
	 class DownloadedDrawable extends ColorDrawable
	  {
	    private final WeakReference<ImageUtils.BitMapNetworkDownload> bitmapDownloaderTaskReference;

	    public DownloadedDrawable(ImageUtils.BitMapNetworkDownload arg2)
	    {
	      super();
	      this.bitmapDownloaderTaskReference = new WeakReference<ImageUtils.BitMapNetworkDownload>(arg2);
	    }

	    public ImageUtils.BitMapNetworkDownload getBitmapDownloaderTask()
	    {
	      return (ImageUtils.BitMapNetworkDownload)this.bitmapDownloaderTaskReference.get();
	    }
	  }
}
