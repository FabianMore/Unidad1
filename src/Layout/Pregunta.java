package Layout;

public class Pregunta {
    private String pregunta;
    private String [] respuesta;
    private int indiceCorrecto;

    public Pregunta(String pregunta,
                    String[] respuesta, int indiceCorrecto){

        this.pregunta = pregunta;
        this.respuesta = respuesta.clone();
        this.indiceCorrecto = indiceCorrecto;
    }

    public String getPregunta(){
        return this.pregunta;
    }
    public String[ ] getRespuesta(){
        return this.respuesta;
    }
    public int getIndiceCorrecto(){
        return  this.indiceCorrecto;
    }
}
