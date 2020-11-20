// Gabriel Martinez Murillo
// Aplicacion del perro, ampliada con icono de la aplicacion y con  boton para cambiar de imagen.
//19-11-20
package com.perrete.votoperro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Visor extends Activity implements View.OnClickListener {

    private TextView nombre;
    private RadioGroup opiniones;
    private Button enviar;
    ImageView contenedor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor);
        //iniciar elementos de la aplicacion
        nombre = (TextView)findViewById(R.id.image_name);
        opiniones =(RadioGroup)findViewById(R.id.opiniones_group);
        enviar = (Button)findViewById(R.id.send_button);
        contenedor=(ImageView)findViewById(R.id.imageView);
        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.EXTRA_NOMBRE);
        nombre.setText(name);
        enviar.setOnClickListener(this);


    }
    //metodo para obtener la opinion y enviarla a otra actividad
    public void onClick(View v){
        RadioButton currentRadio = (RadioButton) findViewById(opiniones.getCheckedRadioButtonId());
        String opinion = currentRadio.getText().toString();
        Intent databack = new Intent();
        databack.putExtra("opinion",opinion);
        setResult(RESULT_OK,databack);
        finish();
    }
    //metodo para cambiar de imagen
    public void cambio(View v){
        contenedor.setImageResource(R.drawable.perro2);

    }
}
