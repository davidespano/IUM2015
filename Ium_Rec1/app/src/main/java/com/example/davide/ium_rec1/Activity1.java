package com.example.davide.ium_rec1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class Activity1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1);

        // Parte 1
        {
            ObservedObject myObject = new ObservedObject();
            Subject mySubject = new Subject();

            // l'oggetto osservato da mySubject &egrave;
            // myObject
            mySubject.setObservedObject(myObject);

            // cambio lo stato di myObject
            myObject.setName("Pippo");
        }

        // Parte 2

        {
            ObservedObject myObject = new ObservedObject();
            ObservedObject myObject2 = new ObservedObject();

            Subject2 mySubject = new Subject2();

            mySubject.setObj1(myObject);
            mySubject.setObj2(myObject2);

            // cambio lo stato di myObject
            myObject.setName("Davide");
            myObject2.setName("Spano");
        }


        {
            ObservedObject myObject = new ObservedObject();
            ObservedObject myObject2 = new ObservedObject();

            Subject3 mySubject = new Subject3();

            mySubject.setObj1(myObject);
            mySubject.setObj2(myObject2);

            // cambio lo stato di myObject
            myObject.setName("Pinco");
            myObject2.setName("Pallino");
        }

        // Parte 4
        {
            ObservedObject myObject = new ObservedObject();

            MultiSubject1 sub1 = new MultiSubject1();
            MultiSubject2 sub2 = new MultiSubject2();

            CompositeSubject composite = new CompositeSubject();
            composite.setSub1(sub1);
            composite.setSub2(sub2);

            myObject.setListener(composite);

            // cambio lo stato di myObject
            myObject.setName("Pinco");
        }

        // Parte 5
        {
            ObservedObject myObject = new ObservedObject();

            MultiSubject1 sub1 = new MultiSubject1();
            MultiSubject2 sub2 = new MultiSubject2();

            ListCompositeSubject composite = new ListCompositeSubject();
            composite.addListener(sub1);
            composite.addListener(sub2);

            myObject.setListener(composite);

            // cambio lo stato di myObject
            myObject.setName("Pinco");
        }



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
