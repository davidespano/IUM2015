package com.example.davide.ium_rec1;

/**
 * Created by davide on 24/10/14.
 */
public class MultiSubject2 implements ObservedObject.ObservedObjectListener {
    @Override
    public void onNameChanged(ObservedObject obj, String name){
        System.out.println("[MultiSubject 2] ho ricevuto il nome: " + name);
    }
}
