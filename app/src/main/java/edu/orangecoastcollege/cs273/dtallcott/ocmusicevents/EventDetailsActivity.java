package edu.orangecoastcollege.cs273.dtallcott.ocmusicevents;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Receives the intent from the EventsListActivity class and
 * connects it to the activity_event_details.xml. Also strips
 * spaces and adds  "jpeg" to get the correct image from assets.
 *
 * @author Devon Tallcott
 * @version 1.0
 *
 * Created on 9/21/17
 */
public class EventDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        //Get the data out of the intent
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String details = intent.getStringExtra("details");

        //Create references to the views
        TextView titleTextView = (TextView) findViewById(R.id.eventTitleTextView);
        TextView detailsTextView = (TextView) findViewById(R.id.eventDetailsTextView2);
        ImageView eventImageView = (ImageView) findViewById(R.id.eventImageView);

        titleTextView.setText(title);
        detailsTextView.setText(details);

        //use the asset manager to retrieve a file (image)
        AssetManager am = getAssets();
        String imageFileName = title.replace(" ", "") + ".jpeg";

        //use the asset manager to open a stream to the file name
        try
        {
            InputStream stream = am.open(imageFileName);
            Drawable image = Drawable.createFromStream(stream, title);
            eventImageView.setImageDrawable(image);
        }
        catch (IOException e)
        {
            Log.e("OC Music Events", "Error loading image: " + imageFileName, e);
        }
    }

    /**
     * Finishes the activity and sends it back to EventsListActivity.
     * @param v
     */
    public void goBackToList(View v)
    {
        this.finish();
    }
}


