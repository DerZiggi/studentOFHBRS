package org.hbrs.se1.ws26.exercises.uebung2;

public class ConcreteMember implements Member{

    private static int nextid = 101;

    private int id;

    public ConcreteMember(){
        this.id = nextid;
        nextid++;
    }

    public Integer getID(){
        return this.id;
    }

    @Override
    public String toString(){
        return "Member (ID = " + this.id + " )";
    }
}
