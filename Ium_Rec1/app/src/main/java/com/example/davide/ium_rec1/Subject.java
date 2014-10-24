package com.example.davide.ium_rec1;

/**
 * Created by davide on 17/10/14.
 */
public class Subject implements ObservedObject.ObservedObjectListener{

    private ObservedObject observedObject;

    public ObservedObject getObservedObject(){
        return this.observedObject;
    }

    public void setObservedObject(ObservedObject observedObject){
        this.observedObject = observedObject;
        // registro l'istanza corrente per ricevere le notifiche
        this.observedObject.setListener(this);
    }

    @Override
    public void onNameChanged(ObservedObject sender, String name) {
        // reagisco al cambio di stato di observedObject
        System.out.println("Nuovo valore del nome: " + name);
    }
}
