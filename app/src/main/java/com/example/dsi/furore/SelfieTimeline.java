package com.example.dsi.furore;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.etsy.android.grid.StaggeredGridView;
import com.etsy.android.grid.util.DynamicHeightImageView;

public class SelfieTimeline extends ActionBarActivity {

    StaggeredGridView gridView;
    int drawables[] = {R.drawable.art, R.drawable.dance, R.drawable.game, R.drawable.art, R.drawable.dance, R.drawable.game,
            R.drawable.art, R.drawable.dance, R.drawable.game, R.drawable.art, R.drawable.dance, R.drawable.game};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selfie_timeline);
        gridView = (StaggeredGridView) findViewById(R.id.grid_view);
        gridView.setAdapter(new GridViewAdapter());
    }

    public class GridViewAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return drawables.length;
        }

        @Override
        public Object getItem(int position) {
            return drawables[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = getLayoutInflater();
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.single_image_view, parent, false);
            }
            DynamicHeightImageView iv = (DynamicHeightImageView) convertView.findViewById(R.id.imageView);
            TextView textView = (TextView) convertView.findViewById(R.id.imageText);
            textView.setText("this is random text");
            iv.setImageResource(drawables[position]);

            return convertView;
        }
    }

/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_selfie_timeline, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
