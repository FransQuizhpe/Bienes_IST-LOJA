package tecnologicoloja.edu.tesis_app;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;

import android.os.Bundle;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializar la barra de herramientas
        Toolbar myToolBar = (Toolbar) findViewById(R.id.toolbar);
        //Incorpora la barra de herramientas
        setSupportActionBar(myToolBar);

    }

    //Este método botonqr configura el escáner de código QR utilizando la biblioteca ZXing
    public void botonqr(View v){
        IntentIntegrator integrador = new IntentIntegrator(MainActivity.this); // Aquí se crea una instancia de la clase IntentIntegrator, que es parte de la biblioteca ZXing para escaneo de códigos de barras y QR en Android.
        integrador.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES); // Se establece el formato para todos los tipos de códigos. En este caso, se desea escanear todos los tipos de códigos, incluidos los códigos QR.
        integrador.setPrompt("Lector QR - Bienes y Activos ISTL"); //  Se establece un mensaje de texto que se mostrará como una indicación al usuario mientras realiza el escaneo.
        integrador.setCameraId(0);// Inicializa la camara Trasera
        integrador.setBeepEnabled(true); // Se habilita un tono de sonido que se reproducirá cuando se escanee un código.
        integrador.setBarcodeImageEnabled(true); //Se habilita la captura de la imagen del código QR escaneado.
        integrador.initiateScan(); //Una vez que se escanea el código, se procesa en la aplicación.

    }

    //Este método procesa el resultado obtenido del escaneo de un código QR, verifica si es una URL válida y
    //luego inicia una actividad para mostrar esa URL en un WebView.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() != null) {
                String qrContent = result.getContents();
                // Verificar si el contenido es una URL
                if (Patterns.WEB_URL.matcher(qrContent).matches()) {
                    // Si es una URL, iniciar WebViewActivity y pasar la URL como extra en el Intent
                    Intent intent = new Intent(MainActivity.this, webview.class);
                    intent.putExtra("url", qrContent);
                    startActivity(intent);
                } else {
                    // Si no es una URL válida, mostrar un mensaje de error
                    Toast.makeText(this, "El código QR no contiene una URL válida", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    //Menú

    /*Crea el menú de opciones de la actividad a partir de un archivo de recursos XML
    y devuelve true para indicar que el proceso se realizó correctamente.*/
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.overflow, menu);
        //return super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.overflow, menu);
        return true;
    }
    /*Este método maneja las acciones cuando el usuario selecciona
    un elemento del menú de opciones en la barra de acciones.*/
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        //creamos las condicionales
        if (item.getItemId() == R.id.item1){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        } else if (id == R.id.item2) {
            Intent i = new Intent(this, info.class);
            startActivity(i);
        } else if (id == R.id.item3) {
            finishAffinity();
        }
        return true;
    }
}





/*
/////////////////////////////////
android:usesCleartextTraffic="true" pegar en el manifiesto -- redes no seguras http
/////////////////////////////////
android:networkSecurityConfig="@xml/network_security_config" -- todas las redes https y http

Crear Archivo: net work_security_config.xml en la carpeta xml de res

codigo para ese archivo:

<?xml version="1.0" encoding="utf-8"?>
<network-security-config>
    <domain-config cleartextTrafficPermitted="true">
        <!-- Permitir tráfico no seguro para todos los dominios -->
        <domain includeSubdomains="true">192.168.0.100</domain>
        <!-- Permitir tráfico seguro para todos los dominios -->
        <domain-config cleartextTrafficPermitted="true">
            <domain includeSubdomains="true">example.com</domain>
        </domain-config>
    </domain-config>
</network-security-config>

 */