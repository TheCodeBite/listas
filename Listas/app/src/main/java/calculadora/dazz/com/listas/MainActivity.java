package calculadora.dazz.com.listas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    ArrayList<String> datos = new ArrayList<>();
    ArrayList<String> temp_datos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datos.add("Chiapas");
        datos.add("Veracruz");

        Button agregar = (Button)findViewById(R.id.btn_add);
        final TextView txt_texto = (TextView)findViewById(R.id.add_texto);

        lista = (ListView) findViewById(R.id.lvlista);
        final ListaController listacontoller = new ListaController(MainActivity.this, datos);
        lista.setAdapter(listacontoller);

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!txt_texto.getText().toString().isEmpty()){
                    temp_datos = listacontoller.getLista();
                    temp_datos.add(txt_texto.getText().toString());
                    listacontoller.setLista(temp_datos);
                    lista.setAdapter(listacontoller);
                    txt_texto.setText("");
                    Toast mensaje =  Toast.makeText(getApplicationContext(),"Dato Insertado",Toast.LENGTH_SHORT);
                    mensaje.show();
                }else{
                    Toast mensaje =  Toast.makeText(getApplicationContext(),"Inserte Texto",Toast.LENGTH_SHORT);
                    mensaje.show();
                }


            }
        });


    }

    public ListView getLista() {
        return lista;
    }
}
