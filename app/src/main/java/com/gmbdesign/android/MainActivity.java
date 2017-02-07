package com.gmbdesign.android;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
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

            //Recuperamos la ruta de almacenamiento interno del dispositivo
            String ruta = Environment.getExternalStorageDirectory().getPath();
            String rutaLocal = properties.getProperty("ruta_local");

            Log.e("RUTA", "La ruta de almacenamiento es: " + ruta + rutaLocal);

            File file = new File(ruta + rutaLocal);

            if(!file.exists()){
                file.createNewFile();
                Log.d("TAG", "Se ha creado el directorio");
            } else {
                Log.d("TAG", "El fichero ya existe");
            }


        } catch (IOException e) {
            Log.e("TAG", "No se puedo abrir el archivo properties");
            e.printStackTrace();
        }

    }
}
