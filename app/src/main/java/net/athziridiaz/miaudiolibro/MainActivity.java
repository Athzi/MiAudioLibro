package net.athziridiaz.miaudiolibro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    /*RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*se instancia el recycler view de la clase activity main
        recyclerView = findViewById(R.id.recyclerView);

        layoutManager = new GridLayoutManager(this,2);

        recyclerView.setLayoutManager(layoutManager);
        //creamos un adaptador para que se vea cada uno de los libros
        AdaptadorLibros adaptadorLibros =
                new AdaptadorLibros(this , Libro.ejemploLibros());

        recyclerView.setAdapter(adaptadorLibros);
        */

        SelectorFragment selectorFragment
                = new SelectorFragment();

        if ( findViewById(R.id.contenedor_pequeno) != null &&
            getSupportFragmentManager().findFragmentById(R.id.contenedor_pequeno) == null
            ){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contenedor_pequeno,
                            selectorFragment).commit();
        }

    }

    public void mostrarDetalle(int index){
        FragmentManager fragmentManager = getSupportFragmentManager();
        if(fragmentManager.findFragmentById(R.id.detalle_fragment)!=null){
            DetalleFragment fragment =(DetalleFragment)fragmentManager.findFragmentById(R.id.detalle_fragment);
            fragment.ponInfoLibro(index);
        }else{
            DetalleFragment detalleFragment =new DetalleFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(DetalleFragment.ARG_ID_LIBRO, index);
            detalleFragment.setArguments(bundle);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentManager.beginTransaction().replace(R.id.contenedor_pequeno
                    , detalleFragment).addToBackStack(null).commit();
        }

    }

}