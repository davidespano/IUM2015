package com.example.davide.ium_rec2;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class StudentForm extends Activity {

    private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_form);

        student = new Student();
        Button saveButton = (Button) this.findViewById(R.id.saveButton);


        // gestione del click sul bottone
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StudentForm.this.updateStudentData();

            }
        });

        // gestione del bottone invio da tastiera (se non avete una
        // tastiera fisica non servirà a molto, ma è giusto un esempio...)
        saveButton.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                // gestisco solo la pressione del tasto invio
                if(keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    StudentForm.this.updateStudentData();
                }
                return true;
            }
        });
    }

    /**
     * Questo metodo aggiorna lo stato dello studente a partire dai
     * valori inseriti dall'utente nell'interfaccia.
     *
     * Può essere richiamato da più event handler che richiedano
     * la sincronizzazione fra interfaccia ed oggetto Student
     * (nel nostro esempio il click del bottone e la pressione del tasto
     * invio da tastiera sul bottone stesso)
     */
    public void updateStudentData(){

        // N.B. Alla fine dell'update dell'oggetto, andrebbe
        // mostrato un messaggio di conferma all'utente.
        // potete provare a programmarlo per esercizio

        EditText nameText = (EditText) this.findViewById(R.id.nameText);
        this.student.setName(nameText.getText().toString());

        EditText surnameText = (EditText) this.findViewById(R.id.surnameText);
        this.student.setSurname(surnameText.getText().toString());

        EditText ageText = (EditText) this.findViewById(R.id.ageText);
        try {
            this.student.setAge(Integer.parseInt(ageText.getText().toString()));
        }catch (NumberFormatException e){
            // Andrebbe visualizzato un errore
        }

        EditText studentIdText = (EditText) this.findViewById(R.id.studentIdText);
        try {
            this.student.setStudentId(Integer.parseInt(studentIdText.getText().toString()));
        }catch(NumberFormatException e){
            // Andrebbe visualizzato un errore
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.student_form, menu);
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
