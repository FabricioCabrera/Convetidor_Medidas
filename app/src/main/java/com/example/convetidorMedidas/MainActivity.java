package com.example.convetidorMedidas;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView resultado;
    private EditText cantidad;
    private Button convertir;
    Spinner comoboMedidas;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //obtenemos los datos de la vista
        resultado = findViewById(R.id.txtresultado);
        convertir = findViewById(R.id.bnconvertir);
        cantidad = findViewById(R.id.txtcantidad);
        comoboMedidas = (Spinner) findViewById(R.id.spinnerMedidas);

        //Creamos un adaptador
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Combo_medidas,R.layout.sppiner_item_medidas);
        comoboMedidas.setAdapter(adapter);

        //Damos la accion al boton
        convertir.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v == convertir){

            //verificamos si se ingresa datos en la variable cantidad
            if(cantidad.getText().toString().isEmpty()){
                cantidad.setError("Ingrese una cantidad");
                cantidad.requestFocus();
            }else {

                // Este formato es para dar dos decimales al resultado
                DecimalFormat formato1 = new DecimalFormat("0.000");

                double res = 0;
                double can = Double.parseDouble(cantidad.getText().toString());

                //Para verificar el texto de la selección de Combo_Medidas
                String seleccion = comoboMedidas.getSelectedItem().toString();

                //comparación de cada selected item del combo_Medidas
                if (seleccion.equals("Kilómetros")) {
                    res = (can * 0.001);
                    resultado.setText(String.valueOf(formato1.format(res)) + " Kilómetros");
                    resultado.setBackgroundColor(Color.parseColor("#9E9E9E"));
                }
                else if (seleccion.equals("Decímetros")) {
                    res = can * 100;
                    resultado.setText(String.valueOf(formato1.format(res)) + " Centímetros");
                    resultado.setBackgroundColor(Color.parseColor("#82E0AA"));
                }
                else if (seleccion.equals("Centímetros")) {
                    res = can * 1000;
                    resultado.setText(String.valueOf(formato1.format(res)) + " Centímetros");
                    resultado.setBackgroundColor(Color.parseColor("#82E0AA"));
                }
                else if (seleccion.equals("Milímetros")) {
                    res = can * 10000;
                    resultado.setText(String.valueOf(formato1.format(res)) + " Milímetros ");
                    resultado.setBackgroundColor(Color.parseColor("#7FB3D5"));
                }
                else if(seleccion.equals("Yarda")) {
                    res = can * 1.09361;
                    resultado.setText(String.valueOf(formato1.format(res)) + " Yarda");
                    resultado.setBackgroundColor(Color.parseColor("#28B463"));
                }
            }
        }
    }

}
