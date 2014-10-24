package com.example.davide.iumex2;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;


public class IumPerson extends Activity {

    // l'oggetto Persona da modificare
    Person person;

    EditText birthText, nameText, surnameText;
    Button saveButton;
    DatePickerFragment datePickerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ium_person);

        person = new Person();
        datePickerFragment = new DatePickerFragment();

        // aggiorniamo l'interfaccia in base ai dati della persona
        updateUIfromPerson();

        EditText birthText = (EditText) this.findViewById(R.id.birthText);
        birthText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerFragment.show(getFragmentManager(), "datePicker");
            }
        });

        nameText = (EditText) this.findViewById(R.id.nameText);
        surnameText = (EditText) this.findViewById(R.id.surnameText);
    }


    /**
     * Questo metodo legge i dati inseriti dall'utente nell'interfaccia e li copia
     * all'interno dell'oggetto Person
     *
     * Nel caso ci sia qualche campo che manca o errato, ne modifica lo stato
     */
    private void updatePerson(){

    }

    private void updateUIfromPerson(){
        this.nameText.setText(this.person.getName());
        this.surnameText.setText(this.person.getSurname());
        this.datePickerFragment.setDate(this.person.getBirthDate());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ium_person, menu);
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
