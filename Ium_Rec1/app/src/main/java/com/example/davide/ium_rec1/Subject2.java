package com.example.davide.ium_rec1;

/**
 * Created by davide on 17/10/14.
 */
public class Subject2 {

    // primo oggetto osservato
    private ObservedObject obj1;

    //secondo oggetto osservato
    private ObservedObject obj2;


    public ObservedObject getObj1() {
        return obj1;
    }

    public void setObj1(ObservedObject obj1) {
        this.obj1 = obj1;
        // collego obj1 con una istanza della classe Listener1
        Listener1 listener1 = new Listener1();
        obj1.setListener(listener1);
    }

    public ObservedObject getObj2() {
        return obj2;
    }

    public void setObj2(ObservedObject obj2) {
        this.obj2 = obj2;
        // collego obj2 con una istanza della classe Listener2
        Listener2 listener2 = new Listener2();
        obj2.setListener(listener2);
    }

    public class Listener1 implements ObservedObject.ObservedObjectListener{
        @Override
        public void onNameChanged(ObservedObject sender, String name) {
            System.out.println("Cambiato valore nell'oggetto 1: "+ name );
        }
    }

    public class Listener2 implements ObservedObject.ObservedObjectListener{
        @Override
        public void onNameChanged(ObservedObject sender, String name) {
            System.out.println("Cambiato valore nell'oggetto 2: "+ name );
        }
    }
}
