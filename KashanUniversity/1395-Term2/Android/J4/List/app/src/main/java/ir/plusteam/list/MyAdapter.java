package ir.plusteam.list;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ali on 4/10/2017.
 */

public class MyAdapter extends ArrayAdapter<String> {
    int resource1;

    public MyAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
        this.resource1=resource;

    }

    public class  ViewHolder{
        TextView tv;
        TextView tv2;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if(convertView==null)
        {
            //daryafte inflater az system android
            LayoutInflater v= (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=v.inflate(resource1,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.tv=(TextView) convertView.findViewById(R.id.txt);
            viewHolder.tv2=(TextView) convertView.findViewById(R.id.txt2);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder= (ViewHolder) convertView.getTag();

        }



        if(position%2==0)
        {
            convertView.setBackgroundColor(
                    getContext().getResources().getColor
                            (android.R.color.holo_blue_bright));
        }
        else
        {
            convertView.setBackgroundColor(
                    getContext().getResources().getColor
                            (android.R.color.holo_red_dark));
        }
        viewHolder.tv.setText(getItem(position));
        viewHolder.tv2.setText(getItem(position)+"2");

        if(position==0)
        {

            viewHolder.tv.setVisibility(View.INVISIBLE);
            viewHolder.tv2.setVisibility(View.INVISIBLE);
        }
        return convertView;


    }
}
