package com.example.davide.iumex1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;


public class Form extends Activity {

    // valore minimo
    private static final int MINVALUE = 1;
    private static final int MAXVALUE = 100;

    // questo valore rappresenta il modello della mia applicazione
    int valueModel = 50;

    // mantengo un riferimento ai  controlli per fare l'update dell'interfaccia
    Button plusButton, minusButton, divideButton, multiplyButton;
    SeekBar seekBar;
    EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        text = (EditText) findViewById(R.id.editText);

        plusButton = (Button) findViewById(R.id.plusButton);
        minusButton = (Button) findViewById(R.id.minusButton);
        divideButton = (Button) findViewById(R.id.divideButton);
        multiplyButton = (Button) findViewById(R.id.multiplyButton);

        // aggiungo un handler all'evento click del bottone +
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateValue(valueModel + 1);
            }
        });

        // aggiungo un handler all'evento click del bottone -
        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateValue(valueModel -1);
            }
        });

        // aggiungo un handler all'evento click del bottone per dividere
        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateValue(valueModel / 4);
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateValue(valueModel * 2);
            }
        });


        // gestisco il cambio di valore della progress bar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    updateValue(seekBar.getProgress());
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                updateValue(seekBar.getProgress());
            }
        });


        this.updateValue(MAXVALUE / 2);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.form, menu);
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

    /**
     * Aggiorna lo stato dell'interfaccia in base ai valori
     * contenuti nel modello
     * @param newValue il nuovo valore da inserire nel modello
     */
    private void updateValue(int newValue){
        newValue = newValue > MAXVALUE ? MAXVALUE : newValue;
        newValue = newValue < MINVALUE ? MINVALUE : newValue;
        // ora siamo sicuri che newValue sia nel range
        this.valueModel = newValue;
        this.text.setText("" + valueModel);
        if(this.seekBar.getProgress() != valueModel - MINVALUE) {
            this.seekBar.setProgress(valueModel - MINVALUE);
        }

        // disabilito il click sul bottone della divisione nel caso il valore
        // che si otterrebbe dalla divisione fosse fuori dal range consentito

        if(newValue / 4 < MINVALUE){
            divideButton.setEnabled(false);
        }else{
            divideButton.setEnabled(true);
        }

        // disabilito il click sul bottone della moltiplicazione nel caso il valore
        // che si otterrebbe fosse fuori dal range consentito

        if(newValue * 2 > MAXVALUE){
            multiplyButton.setEnabled(false);
        }else{
            multiplyButton.setEnabled(true);
        }



    }


}
