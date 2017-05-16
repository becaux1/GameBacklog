package rubenjuandavid.gamebacklog;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

        //ATRIBUTOS
        public static final int INSERT_CODE=0;
    public static final int EDIT_CODE=1;
    public static final int RESUMEN_CODE=2;

    public static String TITULO="titulo";
    public static String AUTOR="autor";
    public static String RESUMEN="resumen";
    public static String GENERO="genero";
    public static final String POSICION="posicion";

    public ListView lv;
    public ArrayList<Libro> modelo;
    public ArrayAdapter<Libro> adapter;
    public int pos=-1;
    Libro l;

    ListaFragment lf = null;
    NoSeleccionadoFragment nsf = null;
    ResumenFragment rf = null;
    FormFragment ff = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instancia fragment
        lf=new ListaFragment();
        this.l= new Libro("", "");

        //Carga fragment en el container
        FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.contenedor_lista, lf);
        if(grande()){
            //Se carga el layout_large
            nsf= new NoSeleccionadoFragment();
            transaction.add(R.id.contenedor_resumen,nsf);

        }else{
            //Se carga layout
        }

        transaction.commit();
    }//onCreate
}//MainActivity
