package com.example.ragger.friendsr;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class SinglesOverview extends AppCompatActivity {

    ListView list;
    String[] singleNames;
    String[] singleFullNames;
    String[] singleDescription;
    int[] singlePreviewImages = {R.drawable.chandlerpreview, R.drawable.joeypreview, R.drawable.monicapreview,
            R.drawable.phoebepreview, R.drawable.rachelpreview, R.drawable.rosspreview};
    int[] singleImages = {R.drawable.chandler, R.drawable.joey, R.drawable.monica,
            R.drawable.phoebe, R.drawable.rachel, R.drawable.ross};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singles_overview);

        // get resources from xml files
        Resources res = getResources();
        singleNames = res.getStringArray(R.array.single_names);
        singleFullNames = res.getStringArray(R.array.single_full_names);
        singleDescription = res.getStringArray(R.array.single_details);
        list = (ListView) findViewById(R.id.lvList);

        // Use adapter object to instantiate list entries
        CustomAdapter adapter = new CustomAdapter(this, singlePreviewImages, singleNames);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent details = new Intent(SinglesOverview.this, SingleDetails.class);
                details.putExtra("portrait", singleImages[position]);
                details.putExtra("description", singleDescription[position]);
                details.putExtra("fullName", singleFullNames[position]);
                startActivity(details);
            }
        });

    }
}

class CustomAdapter extends ArrayAdapter<String> {

    Context context;
    int[] images;
    String[] names;

    CustomAdapter(Context c, int[] images, String[] names){
        super(c, R.layout.layout_single_entry, R.id.tvName, names);
        this.context = c;
        this.images = images;
        this.names = names;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // get the entry layout and objects
        View entry = inflater.inflate(R.layout.layout_single_entry, parent, false);
        ImageView ivPreview = (ImageView) entry.findViewById(R.id.ivPreview);
        TextView  tvName = (TextView) entry.findViewById(R.id.tvName);

        // set the objects in the entry
        ivPreview.setImageResource(images[position]);
        tvName.setText(names[position]);

        return entry;
    }
}
