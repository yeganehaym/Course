package ir.plusteam.jalse7;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Ali on 9/4/2017.
 */

public class MyAdapter extends ArrayAdapter<Animal> {
    int resource;

    AdapterAction adapterAction;

    public  void SetEvents(AdapterAction adapterAction)
    {
        this.adapterAction=adapterAction;

    }
    public MyAdapter(Context context, int resource, List<Animal> objects) {
        super(context, resource, objects);
            this.resource=resource;

    }

    public class ViewHolder{
        ImageView imageView;
        TextView name;
        TextView cat;
        Button DeleteButton;

    }
    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder  viewHolder;
        if(convertView==null)
        {
            LayoutInflater layoutInflater= (LayoutInflater)
                    getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(resource,null);
            viewHolder=new ViewHolder();
            viewHolder.imageView= (ImageView) convertView.findViewById(R.id.picture);
            viewHolder.name= (TextView) convertView.findViewById(R.id.txtName);
            viewHolder.cat= (TextView) convertView.findViewById(R.id.cat);
            viewHolder.DeleteButton= (Button) convertView.findViewById(R.id.btnDelete);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder= (ViewHolder) convertView.getTag();
        }



       Animal animal=getItem(position);
        viewHolder.imageView.setImageResource(animal.Picture);
        viewHolder.name.setText(animal.getName());
        viewHolder.cat.setText(animal.getCategory());

        viewHolder.DeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapterAction.RemoveItem(getItemId(position));
            }
        });
        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    public interface  AdapterAction{
        void RemoveItem(long id);
    }
}
