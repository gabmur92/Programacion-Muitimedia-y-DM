// Gabriel Martinez Murillo
// Aplicacion del perro, ampliada con icono de la aplicacion y con  boton para cambiar de imagen.
//19-11-20
package com.perrete.votoperro;

import android.app.Activity;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
    public final static int OPINION_REQUEST_CODE = 1;
    public final static String EXTRA_NOMBRE = "com.perrete.votoperro.NOMBRE";
    private Button Bmostrar;
    private TextView opinion_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Bmostrar = (Button)findViewById(R.id.Bmostrar);
        opinion_text = (TextView)findViewById(R.id.opinion_text);
        Bmostrar.setOnClickListener(this);

    }
    //metodo para que la hacer clic ene lboton pase a otra actividad
    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.Bmostrar:{
                Intent intent = new Intent(this, Visor.class);
                intent.putExtra(EXTRA_NOMBRE, "perro.jpg");
                startActivityForResult(intent,OPINION_REQUEST_CODE);
                break;
            }
        }
    }
    //metodo para mostrar resultado
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == OPINION_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                String result=data.getStringExtra("opinion");
                opinion_text.setText("Tu opinion fué "+result);

            }
        }
    }
}
