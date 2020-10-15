package net.athziridiaz.miaudiolibro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Vector;

public class AdaptadorLibros extends RecyclerView.Adapter<AdaptadorLibros.ViewHolder> {


    private Vector<Libro> vectorLibros;
    private Context contexto;
    //referencia de xml y pasarlo a java
    private LayoutInflater inflador;

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setOnclickListener(View.OnClickListener onclickListener) {
        this.onclickListener = onclickListener;
    }

    private View.OnLongClickListener onLongClickListener;
    private View.OnClickListener onclickListener;

    //constructor para pasarle los parámetros que nosotros queremos mostrar
    //tiene que recibir un contexto y lo que queremos mostrar

    public AdaptadorLibros(Context contexto,
                           Vector<Libro> vectorLibros) {
        inflador = (LayoutInflater) contexto.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);

        this.vectorLibros = vectorLibros;
        this.contexto = contexto;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = inflador.inflate(R.layout.elemento_selector, null);

        v.setOnClickListener(this.onclickListener);
        v.setOnLongClickListener(this.onLongClickListener);

        return new ViewHolder(v);

    }

    //para enlazar lo del objeto vector con su diseño
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //obtener una instancia del vector para ver los valores
        Libro libro = vectorLibros.get(position);
        //asignar los valores de la colección al vector
        holder.portada.setImageResource(libro.recursoImagen);
        holder.titulo.setText(libro.titulo);
    }

    //sólo para ver los items del vector
    @Override
    public int getItemCount() {
        return vectorLibros.size();
    }

    //Creamos nuestro ViewHolder, con los tipos de elementos a modificar
    //dentro se define lo que va a traer mi layout
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView portada;
        public TextView titulo;


        //para recibir nuestro layout
        public ViewHolder(View itemView)
        {
            super(itemView);
            portada = (ImageView) itemView.findViewById(R.id.portada);
            portada.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            titulo = (TextView) itemView.findViewById(R.id.titulo);
        }
    }
}
