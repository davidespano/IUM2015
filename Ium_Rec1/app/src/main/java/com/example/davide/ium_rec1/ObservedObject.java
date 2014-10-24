package com.example.davide.ium_rec1;

/**
 * Created by davide on 17/10/14.
 */
public class ObservedObject {

    // questa variabile descrive lo stato interno
    // dell'oggetto da osservare
    private String name;

    // rappresento il mio soggetto come una istanza
    // di una classe che implementa ObservedObjectListener
    private ObservedObjectListener listener;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;

        // qui inviata la notifica
        if(listener != null){
            listener.onNameChanged(this, this.name);
        }
    }

    public ObservedObjectListener getListener(){
        return listener;
    }

    /**
     * Questo &egrave; il metodo chiamato dal soggetto
     * per registrarsi e ricevere le notifiche sul cambio
     * di stato di un ObservedObject
     * @param listener
     */
    public void setListener(ObservedObjectListener listener){
        this.listener = listener;
    }



    public interface ObservedObjectListener{

        public void onNameChanged(ObservedObject sender, String name);
    }

}
