package calculadora.dazz.com.listas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListaController extends BaseAdapter {

    private static LayoutInflater inflater = null;

    Context contexto;
    ArrayList<String> lista;

    public ListaController(Context contexto, ArrayList<String> lista) {
        this.contexto = contexto;
        this.lista = lista;

        inflater = (LayoutInflater) contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final View vista_externet = inflater.inflate(R.layout.activity_main,null);
        final View vista = inflater.inflate(R.layout.lista, null);

        final Button eliminar = (Button)vista.findViewById(R.id.btn_eliminar),
                editar =(Button) vista.findViewById(R.id.editar),
                guardar = (Button) vista.findViewById(R.id.guardar);

        final TextView texto = (TextView) vista.findViewById(R.id.texto);
        texto.setEnabled(false);
        guardar.setEnabled(false);


        texto.setText(lista.get(position));

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto.setEnabled(true);
                guardar.setEnabled(true);
                editar.setEnabled(false);
                eliminar.setEnabled(false);
            }
        });

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminar.setEnabled(true);
                editar.setEnabled(true);
                guardar.setEnabled(false);
                texto.setEnabled(false);
                editar_texto(position,texto.getText().toString());
            }
        });


        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Eliminar_texto(position);
            }
        });

        return vista;
    }

    public void editar_texto(int id, String texto){
        lista.set(id,texto);
    }

    public void Eliminar_texto(int id){
        lista.remove(id);
    }

    public ArrayList<String> getLista() {
        return lista;
    }

    public void setLista(ArrayList<String> lista) {
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


}
