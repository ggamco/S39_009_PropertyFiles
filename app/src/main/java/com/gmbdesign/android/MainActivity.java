package com.gmbdesign.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.Properties;

/**
 * Tenemos que crear una carpeta assets al mismo nivel que res o java. Vista desde Project.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instanciamos un objeto properties
        Properties properties = new Properties();

        try {
            //1º cargar el archivo
            properties.load(getAssets().open("mifile.properties"));

            //2º recuperamos la propiedad alumnos_online
            String clave = properties.getProperty("alumnos_online");

            Log.e("TAG", "El valor recuperado es: " + clave);
        } catch (IOException e) {
            Log.e("TAG", "No se puedo abrir el archivo properties");
            e.printStackTrace();
        }

    }
}
