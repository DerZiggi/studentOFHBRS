package org.hbrs.se1.ws26.exercises.uebung2;

import java.util.ArrayList;
import java.util.List;

public class Container {

    private List<Member> members = new ArrayList<>();

    public Container(){
    }

    public int size(){
        return members.size();
    }

    public void addMember(Member member) throws ContainerException {
        int memberid = member.getID();

        for(int i = 0; i < this.members.size(); i++){
            if(members.get(i).getID() == memberid){
                throw new ContainerException("Das Member-Objekt mit der ID " + memberid + " ist bereits vorhanden!");
            }
        }
        members.add(member);
    }

    /*
    Eine Exception anstatt einem dummy Rückgabewert zu verwenden hat folgende Vorteile:
    1. Fehler müssen zwingend abgefangen werden und ein Weiterarbeiten mit diesen Fehlern wird so ausgeschlossen.
    2. Das Abfangen von Fehlern wird leichter gemacht. Sie müssen nicht mit if-Abfragen überprüft werden.
    3. Bei verschachtelten Funktionen muss der Fehler nicht mit returns weiter hoch gereicht werden, sondern kann
    propagiert werden.
     */
    public String deleteMember(int id){
        for(int i = 0; i < this.members.size(); i++){
            if(members.get(i).getID() == id){
                members.remove(i);
                return "Das Member-Objekt mit der ID " + id + " wurde entfernt!";
            }
        }
        return "Es konnte kein Member-Objekt mit der ID " + id + " entfernt werden!";
    }

    public void dump(){
        for(int i = 0; i < this.members.size(); i++){
            System.out.println(members.get(i).toString());
        }
    }
}
