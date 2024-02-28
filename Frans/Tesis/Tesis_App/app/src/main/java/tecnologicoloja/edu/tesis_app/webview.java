package tecnologicoloja.edu.tesis_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class webview extends AppCompatActivity {

    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        //Inicializar la barra de herramientas
        Toolbar myToolBar = (Toolbar) findViewById(R.id.toolbar);
        //Incorpora la barra de herramientas
        setSupportActionBar(myToolBar);

        /* Este código configura un WebView en una actividad de Android, habilita JavaScript en el WebView
         y establece un WebViewClient personalizado para controlar la navegación dentro del WebView. */
        myWebView = findViewById(R.id.webview);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                // Esta función manejará la carga de URLs dentro del WebView
                return false;
            }
        });

        /*Este código verifica si se proporciona una URL a través de un Intent y,
        si es así, carga esa URL en un WebView para mostrar la página web
        correspondiente en la actividad de Android.*/
        // Obtener la URL del Intent
        String url = getIntent().getStringExtra("url");
        if (url != null) {
            // Cargar la URL en el WebView
            myWebView.loadUrl(url);
        }

    }

    //Menú

    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.overflow, menu);
        //return super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.overflow, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();

        //creamos las condicionales

        if (item.getItemId() == R.id.item1){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        } else if (id == R.id.item2) {
            Intent i = new Intent(this, info.class);
            startActivity(i);
        }else if (id == R.id.item3) {
            finishAffinity();
        }
        //return super.onOptionsItemSelected(item);
        return true;
    }
}
