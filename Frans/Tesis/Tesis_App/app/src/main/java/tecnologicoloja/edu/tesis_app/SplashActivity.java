package tecnologicoloja.edu.tesis_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    //Establece la duración del Splash
    private static final int SPLASH_DURATION = 2800; // 2.8 Segundos de duración


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);  // Inicia la Actividad de la ventana Principal (MainActivity)
                finish();               // Cierra la actividad SplashActivity
            }
        }, SPLASH_DURATION);

    }
}

