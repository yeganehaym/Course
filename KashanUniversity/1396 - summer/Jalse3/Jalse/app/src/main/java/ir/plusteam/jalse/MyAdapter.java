package ir.plusteam.jalse;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import static ir.plusteam.jalse.R.id.txtPrice;

/**
 * Created by Ali on 8/21/2017.
 */

public class MyAdapter extends ArrayAdapter<Product> {

    int resource;
    Context context;

    public MyAdapter(Context context, int resource, List<Product> objects) {
        super(context, resource, objects);
        this.resource=resource;
        this.context=context;

    }

    public int getResource(){
        return resource;
    }

    public class ViewHolder{
        TextView txtPName;
        TextView txtPrice;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if(convertView==null)
        {
            LayoutInflater layoutInflater= (LayoutInflater)
                    getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(getResource(),null);
            viewHolder=new ViewHolder();
            viewHolder.txtPName=(TextView) convertView.findViewById(R.id.pname);
            viewHolder.txtPrice=(TextView) convertView.findViewById(R.id.price);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder= (ViewHolder) convertView.getTag();
        }

        Product product=getItem(position);
        viewHolder.txtPName.setText(product.getName());
        viewHolder.txtPrice.setText(product.getPrice() + "");
        return convertView;
    }
}
