package edu.orangecoastcollege.cs273.dtallcott.ocmusicevents;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Connects the list to the display. On click sends the title
 * and details for the concert to the EventDetailsActivity class.
 *
 * @author Devon Tallcott
 * @version 1.0
 *
 * Created on 9/21/17
 */
public class EventsListActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_events_list);

        //Define a built in list adapter for this activity
        setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MusicEvent.titles));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
        //use position in list to look up the array
        String title = MusicEvent.titles[position];
        String details = MusicEvent.details[position];

        //Create an intent to go to the details activity with title and details sent
        Intent detailsIntent = new Intent(this, EventDetailsActivity.class);
        detailsIntent.putExtra("title", title);
        detailsIntent.putExtra("details", details);
        startActivity(detailsIntent);
    }
}
