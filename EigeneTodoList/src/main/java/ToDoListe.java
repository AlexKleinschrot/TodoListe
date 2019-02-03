import java.util.ArrayList;
import java.io.*;
import java.nio.file.Paths;
import java.nio.file.*;
import java.lang.*;
import java.util.Collections;
import java.util.Comparator;


public class ToDoListe extends ArrayList<ToDo> {

    private int anzahl;

    /**
     * Fügt eine To do Objekt an das Ende der Liste hinzu.
     *
     * @param td das To do Objekt
     */
    @Override
    public boolean add(ToDo td) {
        if (td == null) {
            throw new NullPointerException();
        }
        return super.add(td);
    }

    /**
     * Entfernt das To do Objekt in der Liste.
     *
     * @param td das To do Objekt
     */
    @Override
    public boolean remove(Object td) {
        if (this.isEmpty()) {
            throw new RuntimeException();
        }
        if (td instanceof ToDo) {
            return super.remove(td);
        }
        return false;
    }

    /**
     * Gibt die Anzahl offener Einträge zurück
     * @return Anzahl offener Einträge
     */
    public int anzahlOffenerEintraege() {

        if (this.isEmpty()) {
            return 0;
        }

        for (int i = 0; i < this.size(); i++) {

            if (this.get(i).getStatus() == "Offen") {
                anzahl++;
            }
        }
        return anzahl;
    }

    /**
     * Sortiert die To do Liste nach Priorität
     */
    public void sort() {
        Collections.sort(this, new Comparator<ToDo>() {
            @Override
            public int compare(ToDo toDo1, ToDo toDo2) {
                if (toDo1.getPrioritaet() == toDo2.getPrioritaet()) {
                    return toDo1.getName().compareTo(toDo2.getName());
                } else {
                    return toDo1.getPrioritaet().compareTo(toDo2.getPrioritaet());
                }
            }
        });
    }


    /**
     * Speichert die To do Liste in eine Datei
     * @param file Datei in der die Liste gespeichert wird
     */
    public void speicherListeInDatei(File file){
        if(file.exists()==true){
            //System.out.println("Ueberscheibe existierende Datei "+file.toString());
        }
        BufferedWriter bw=null;
        try {
            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);

            for(int i=0; i<this.size(); i++){

                if(this.get(i)==null){
                    bw.write("");
                    bw.flush();
                }
                if(this.get(i)!=null){

                    bw.write(this.get(i).getName()+"-"+this.get(i).getPrioritaet()+"\r\n");
                    bw.flush();
                }
            }
            bw.flush();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        finally{
            try{
                if(bw!=null){bw.close();}
            }
            catch(IOException ioex){}
        }


    }


    /**
     * Gibt den Pfad der Datei zurück
     * In den Klammern nach get bitte Dateipfad angeben / = ,
     * @return Pfad der Datei
     */
    private static File getFile() {
        Path path=Paths.get("C:","Users","timkl","IdeaProjects","A1","ToDoListe.txt");

        return path.toFile();
    }

    /**
     * Speichert die To do Liste in einer Datei ab
     */
    public void speicherListeInDatei(){
        File file=getFile() ;
        speicherListeInDatei(file);
    }

    /**
     * Liest To do Liste aus der Datei
     * @param file Datei, in der die Liste gespeichert werden soll
     * @throws IOException wenn die Datei nicht existiert
     */
    public void liesToDoListeAusDatei(File file)throws IOException{
        if(file.exists()==false) {
            throw new IOException("Datei '"+file+"' existiert nicht!");
        }
        BufferedReader br=null;
        try {
            FileReader fr=new FileReader(file);
            br=new BufferedReader(fr);

            String strZeile=br.readLine();
            for(int i=0;i<200;i++){
                if(strZeile==null){
                    break;
                }

                String[] parts = strZeile.split("-");
                String part1 = parts[0];
                String part2 = parts[1];

                ToDo todo = new ToDo(part1, ToDo.Prioritaet.valueOf(part2));
                this.add(todo);
                strZeile=br.readLine();

            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        finally{
            try{  if(br!=null){br.close();} }
            catch(IOException ioex){}
        }
    }


    /**
     * Liest To do Liste aus der Datei
     * @throws IOException wenn die Datei nicht existiert
     */
    void liesToDoListeAusDatei()throws IOException{
        File file=getFile() ;
        liesToDoListeAusDatei(file);
    }




}
