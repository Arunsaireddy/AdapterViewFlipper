package com.aruns.adapterviewflipper;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
AdapterViewFlipper adapterViewFlipper;
int[] images={R.drawable.car2,R.drawable.car4,R.drawable.car5,R.drawable.car6};
String[] names={"car1","car2","car3","car4"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapterViewFlipper=findViewById(R.id.adapterview);
        CustomAdapter customAdapter=new CustomAdapter(getApplicationContext(),names,images);
        adapterViewFlipper.setAdapter(customAdapter);
        adapterViewFlipper.setFlipInterval(2600);
        adapterViewFlipper.setAutoStart(true);

    }
}
class CustomAdapter extends BaseAdapter
{       Context context;
        String[] names;
        int[] images1;
        LayoutInflater layoutInflater;

    public CustomAdapter(Context applicationContext, String[] names, int[] images) {
            this.context=applicationContext;
            this.names=names;
            this.images1=images;
            layoutInflater=(LayoutInflater.from(applicationContext));

    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       convertView=layoutInflater.inflate(R.layout.list_items,null);
        TextView name=(TextView)convertView.findViewById(R.id.txt);
        ImageView imageView=(ImageView)convertView.findViewById(R.id.img);
        name.setText(names[position]);
        imageView.setImageResource(images1[position]);
        return convertView;

    }
}