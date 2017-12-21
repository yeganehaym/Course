package com.google.myapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by ali on 12/7/2017.
 */

public class AnimalAdapter extends ArrayAdapter<DbAnimal> {

    Context context;
    int resource;

    public AnimalAdapter(@NonNull Context context, int resource, @NonNull List<DbAnimal> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
    }
    public interface Events{
        void OnClickImage(int pos);
    }
    private Events events;

    public void SetOnEventsListener(Events events)
    {
        this.events=events;
    }
    public  Context GetMyContext(){
        return context;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        return GetRow(position,convertView,parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return GetRow(position,convertView,parent);
    }

    private View GetRow(final int position, View convertView, ViewGroup parent)
    {
        ViewHolder viewHolder;
        Log.d("adapter",getItem(position).getName() +":"+ position);
        if(convertView==null)
        {
            Log.d("adapter","convert view is null");
            LayoutInflater layoutInflater=(LayoutInflater)
                    getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(resource,null);
            viewHolder=new ViewHolder();
            viewHolder.Title=
                    (TextView) convertView.findViewById(R.id.text);
            viewHolder.Color=
                    (TextView) convertView.findViewById(R.id.myColor);

            viewHolder.imageView= (ImageView) convertView.findViewById(R.id.img);

            convertView.setTag(viewHolder);
        }
        else{
            Log.d("adapter","viewHolder");
            viewHolder= (ViewHolder) convertView.getTag();
        }

        final DbAnimal animal=getItem(position);
        viewHolder.Title.setText(animal.getName());
        viewHolder.Color.setText(animal.getColor());

        Drawable drawable=getContext().getResources().getDrawable(animal.getPictrue());
        viewHolder.imageView.setImageDrawable(drawable);
        viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                events.OnClickImage(position);
            }
        });
        return  convertView;
    }

    private class ViewHolder{
        TextView Title;
        ImageView imageView;
        TextView Color;
    }

}
