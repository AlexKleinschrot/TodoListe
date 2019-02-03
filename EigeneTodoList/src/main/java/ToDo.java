package hsrm.test.todolist;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class ToDo{

    @GeneratedValue
    @Id
    private Long _id;
    private String state;
    private String title ;
    public enum Prioritaet{High,Medium,Low};
    private Prioritaet _prioritaet;

    public ToDo(String name, Prioritaet prioritaet){
        title=name;
        state="Offen";
        _prioritaet=prioritaet;
    }
    public ToDo(Long id, String name, Prioritaet prioritaet){
        _id=id;
        title=name;
        state="Offen";
        _prioritaet=prioritaet;
    }

    public Prioritaet getPrioritaet(){return _prioritaet;}
    public String getStatus(){
        return state;
    }

    public String getName(){
        return title;
    }


    public Prioritaet setPrioHigh(){
        _prioritaet= Prioritaet.High;
        return _prioritaet;
    }

    public Prioritaet setPrioMedium(){
        _prioritaet= Prioritaet.Medium;
        return _prioritaet;
    }

    public Prioritaet setPrioLow(){
        _prioritaet= Prioritaet.Low;
        return _prioritaet;
    }

    public String setStatusOffen(){
        if(this.state=="Beendet"){
            return state;
        }
        state="Offen";

       return state;
    }

    public String setStatusinArbeit(){
        state="In Arbeit";

        return state;
    }



    public String setStatusBeendet(){
        state="Beendet";

        return state;
    }


}
