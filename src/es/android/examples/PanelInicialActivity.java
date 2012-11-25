package es.android.examples;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import es.android.cache.Cache;
import es.android.soap.SoapWeather;
import es.android.soap.Weather;
import es.android.utils.ImageUtils;
import es.android.utils.Utils;
import es.android.xml.beans.Noticia;
import es.android.xml.dom.RssParserDom;
import es.android.xml.saxxml.RssParserSax;
import es.android.xml.saxxml.RssParserSax2;
import android.app.ListActivity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.Spanned;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class PanelInicialActivity extends ListActivity {

	static final int EXIT_DIALOG = 1;
	static final int PROGRESS_DIALOG = 2;

	//List<Noticia> noticias;
	List<Weather> weather;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.main);

		

			//RssParserDom parser = new RssParserDom("http://www.emvs.es/_layouts/listfeed.aspx?List=a741713c-cd3a-4926-9127-b917f3e8e548&View=58cf19b8-ea1c-4538-8a02-5ff98d43344e");

			weather = SoapWeather.getInformation();
					
			//noticias = parser.parse();
		
		
		setListAdapter(new SimpleArrayAdapter(this));

		ListView lv = getListView();

		lv.setTextFilterEnabled(true);

		registerForContextMenu(lv);

	}

	SimpleArrayAdapter adapter = null;

	class SimpleArrayAdapter extends ArrayAdapter {
		Context context = null;

		public SimpleArrayAdapter(Context c) {
			super(c, R.layout.list_item, weather);
			context = c;
		}

		public View getView(int pos, View convertView, ViewGroup parent) {

			ViewHolder holder = null;
			if (convertView == null
					|| !(convertView.getTag() instanceof ViewHolder)) {
				LayoutInflater mInflater = LayoutInflater.from(context);
				convertView = mInflater.inflate(R.layout.list_item, null);
				// Creates a ViewHolder and store references to the two children
				// views we want to bind data to.
				holder = new ViewHolder();
				holder.estat = (ImageView) convertView.findViewById(R.id.estat);
				holder.direccio = (TextView) convertView
						.findViewById(R.id.direccio);
				convertView.setTag(holder);
			} else {
				// Get the ViewHolder back to get fast access to the TextView
				// and the ImageView.
				holder = (ViewHolder) convertView.getTag();
			}

			Weather noticia = weather.get(pos);

			Spanned texto = Html.fromHtml(noticia.getDescription().toString(),
					getImageHTML(), null);

			
			new ImageUtils(1).downloadImage(context, noticia.getPictureURL(),holder.estat,null);
			
			holder.direccio.setText(texto);

			return convertView;
		}

		private class ViewHolder {
			ImageView estat;
			TextView direccio;
		}
	}

	public ImageGetter getImageHTML() {
		ImageGetter ig = new ImageGetter() {
			public Drawable getDrawable(String source) {
				try {
					Drawable d = Drawable.createFromStream(
							new URL(source).openStream(), "src name");
					d.setBounds(0, 0, d.getIntrinsicWidth(),
							d.getIntrinsicHeight());
					return d;
				} catch (IOException e) {
					Log.v("IOException", e.getMessage());
					return null;
				}
			}
		};
		return ig;
	}
}