package es.android.examples;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

import es.android.json.JsonSearch;
import es.android.json.Location;

public class AndroidMapas extends MapActivity {

	private MapView mapa = null;
	private MapController controlMapa = null;

	private EditText texto = null;
	JsonSearch search = null;

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mapa);

		// Obtenemos una referencia al control MapView
		mapa = (MapView) findViewById(R.id.mapa);

		// Mostramos los controles de zoom sobre el mapa
		mapa.setBuiltInZoomControls(true);

		mapa.setSatellite(true);

		controlMapa = mapa.getController();

		texto = (EditText) findViewById(R.id.TxtSearch);

		search = new JsonSearch();

		Button boton1 = (Button) findViewById(R.id.BtnSearch);

		boton1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub

				String textoTX = texto.getText().toString();

				if (textoTX != null && !textoTX.equalsIgnoreCase("")) {
					Location location = search.getSearch(texto.getText()
							.toString());

					if (location != null) {
						/* Creamos la localizacion desde la cadena introducida */
						GeoPoint loc = new GeoPoint((int) (location
								.getLatitud() * 1e6), (int) (location
								.getLongitud() * 1e6));
						controlMapa.animateTo(loc);
						
						int zoomActual = mapa.getZoomLevel();
						 
				        for(int i=zoomActual; i<10; i++)
				            controlMapa.zoomIn();
					}
				}
			}
		});

	}

}
