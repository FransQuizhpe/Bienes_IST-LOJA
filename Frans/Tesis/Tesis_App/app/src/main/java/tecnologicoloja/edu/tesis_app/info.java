package tecnologicoloja.edu.tesis_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        //Inicializar la barra de herramientas
        Toolbar myToolBar = (Toolbar) findViewById(R.id.toolbar);
        //Incorpora la barra de herramientas
        setSupportActionBar(myToolBar);
    }

    //Menu

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