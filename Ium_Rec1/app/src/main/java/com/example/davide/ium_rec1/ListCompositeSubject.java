package com.example.davide.ium_rec1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davide on 24/10/14.
 */
public class ListCompositeSubject implements ObservedObject.ObservedObjectListener{

    private List<ObservedObject.ObservedObjectListener> listeners;

    public ListCompositeSubject(){
        listeners = new ArrayList<ObservedObject.ObservedObjectListener>();
    }

    public void addListener(ObservedObject.ObservedObjectListener listener){
        listeners.add(listener);
    }

    public ObservedObject.ObservedObjectListener getListenerAt(int i){
        if(i >= 0 && i < listeners.size()){
            return listeners.get(i);
        }

        return null;
    }

    @Override
    public void onNameChanged(ObservedObject obj, String name){
        for(ObservedObject.ObservedObjectListener listener : listeners){
            listener.onNameChanged(obj, name);
        }
    }
}
