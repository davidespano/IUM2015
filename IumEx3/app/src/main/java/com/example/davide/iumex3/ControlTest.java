package com.example.davide.iumex3;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class ControlTest extends Activity {

    Series<String> s = null;
    LineGraph graph = null;

    @Override
    protected void onCreate(Bundle saved) {
        super.onCreate(saved);
        setContentView(R.layout.activity_control_test);

        if(saved != null && saved.containsKey("series")){
            s = (Series) saved.get("series");
        }
        else{
            s = new Series<String>();
            for (int i = 0; i < 8; i++) {
                s.addElement("qualcosa " + i, Math.random() * 1000);
            }
        }
          graph = (LineGraph) findViewById(R.id.linegraph);
        graph.setSeries(s);
        graph.setSelectedIndex(2);
        graph.invalidate();


    }

    @Override
    protected void onSaveInstanceState(Bundle bundle){
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("series", s);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.control_test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.dark) {
            graph.setBackgroundColor(Color.BLACK);
            graph.setAxisColor(Color.WHITE);
            graph.setSeriesColor(Color.GREEN);
            graph.invalidate();
            return true;
        }

        if (id == R.id.light) {
            graph.setBackgroundColor(Color.WHITE);
            graph.setAxisColor(Color.BLACK);
            graph.setSeriesColor(Color.RED);
            graph.invalidate();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
