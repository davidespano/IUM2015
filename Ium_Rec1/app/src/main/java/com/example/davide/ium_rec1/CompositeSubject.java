package com.example.davide.ium_rec1;

/**
 * Created by davide on 24/10/14.
 */
public class CompositeSubject implements ObservedObject.ObservedObjectListener{

    private MultiSubject1 sub1;
    private MultiSubject2 sub2;



    @Override
    public void onNameChanged(ObservedObject obj, String name){
        if(sub1 != null){
            sub1.onNameChanged(obj, name);
        }
        if(sub2 != null){
            sub2.onNameChanged(obj, name);
        }
    }

    public MultiSubject1 getSub1() {
        return sub1;
    }

    public void setSub1(MultiSubject1 sub1) {
        this.sub1 = sub1;
    }

    public MultiSubject2 getSub2() {
        return sub2;
    }

    public void setSub2(MultiSubject2 sub2) {
        this.sub2 = sub2;
    }
}
