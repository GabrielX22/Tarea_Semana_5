package com.example.tareasemana5;

public class Preguntas {
    String preg;
    String correcta;
    String opcion1,opcion2,opcion3;

    public Preguntas(String preg,String correcta,String opcion1,String opcion2,String opcion3){
        this.preg = preg;
        this.opcion1 = opcion1;
        this.opcion2 = opcion2;
        this.opcion3 = opcion3;
        this.correcta = correcta;
    }

    public String getPreg(){ return preg;}
    public void setPreg(String preg){this.preg = preg;}

    public String getOpcion1(){ return opcion1;}
    public void setOpcion1(String opcion1){this.opcion1 = opcion1;}

    public String getOpcion2(){ return opcion2;}
    public void setOpcion2(String opcion2){this.opcion2 = opcion2;}

    public String getOpcion3(){ return opcion3;}
    public void setOpcion3(String opcion3){this.opcion3 = opcion3;}

    public String getCorrecta(){ return correcta;}
    public void setCorrecta(String correcta){this.preg = correcta;}

}
