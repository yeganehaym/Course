package ir.plusteam.session6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;


public class AnimalAdapter extends ArrayAdapter<Animal> {
    Context context;
    List<Animal> animals;

    int resource;
    public AnimalAdapter(Context context, int resource, List<Animal> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        animals=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater= (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=inflater.inflate(resource,parent,false);
        ImageView imageButton= (ImageView) v.findViewById(R.id.myimage);
        TextView name= (TextView) v.findViewById(R.id.name);
        TextView type= (TextView) v.findViewById(R.id.type);

        Animal animal=getItem(position);
        name.setText(getItem(position).Name);

        String t="";
        switch (getItem(position).Type)
        {
            case Reptile:
                t="Khazande";
                break;
            case Birds:
                t="parandegan";
                break;
            case Mamal:
                t="pestandaran";
                break;
            default:
                t="abzyan";
                break;
        }
        type.setText(t);
        imageButton.setBackgroundDrawable(context.getResources()
                .getDrawable(getItem(position).Image));
        return v;

    }
}
