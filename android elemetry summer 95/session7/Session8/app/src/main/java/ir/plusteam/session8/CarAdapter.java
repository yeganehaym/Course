package ir.plusteam.session8;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ali on 8/31/2016.
 */
public class CarAdapter extends ArrayAdapter<Car> {

    Context context;
    public CarAdapter(Context context, int resource, List<Car> objects) {
        super(context, resource, objects);
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder=null;
        if(convertView==null)
        {
            Log.d("ali","null");
            LayoutInflater inflater=
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=
                    inflater.inflate(android.R.layout.simple_list_item_2,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.textView1=(TextView)convertView.findViewById(android.R.id.text1);
            viewHolder.textView2=(TextView)convertView.findViewById(android.R.id.text2);
            convertView.setTag(viewHolder);
        }
        else
        {
            Log.d("ali","not null");
            viewHolder= (ViewHolder) convertView.getTag();
        }

        viewHolder.textView1.setText(getItem(position).getName());
        viewHolder.textView2.setText(getItem(position).getCompanyName());
        return convertView;
    }
    public class ViewHolder
    {
        TextView textView1;
        TextView textView2;

    }
}
