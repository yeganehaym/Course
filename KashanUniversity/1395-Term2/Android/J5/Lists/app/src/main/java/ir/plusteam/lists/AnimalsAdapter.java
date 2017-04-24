package ir.plusteam.lists;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ali on 4/17/2017.
 */

public class AnimalsAdapter extends ArrayAdapter<Animal> {

    int resource;

    public AnimalsAdapter(Context context, int resource, List<Animal> objects) {
        super(context, resource, objects);
        this.resource=resource;

    }

    public class ViewHolder{
        TextView textView;
        ImageView imageView;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if(convertView==null)
        {
            LayoutInflater layoutInflater= (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(resource,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.imageView= (ImageView) convertView.findViewById(R.id.myimage);
            viewHolder.textView=(TextView)convertView.findViewById(R.id.mytext);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder= (ViewHolder) convertView.getTag();
        }


        viewHolder.textView.setText(getItem(position).Name);
        viewHolder.imageView.setBackgroundDrawable(
                getContext().getResources().getDrawable(getItem(position).Image)
        );

        return convertView;
    }


}
