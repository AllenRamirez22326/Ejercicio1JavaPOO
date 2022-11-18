import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *Función: Este es el controlador del juego. Se encargará de seleccionar un problema al azar dada una dificultad, generar la lista de problemas,
 * chequear la respuesta, llevar el contador del jugador.
 * @author NITRO 5
 */
public class Juego{
    private ArrayList<Problema> problemasf;
    private int pregunta;
    private int dificultad;
    private Integer vidas;
    public Juego(){
        problemasf= new ArrayList<Problema>();
        pregunta=0;
        vidas=3;
    }

    public void generarLista(String archivo){
    String path = archivo;
    String line = "";
    try (BufferedReader buff = new BufferedReader(new FileReader(path))) {
        while((line = buff.readLine()) != null){
            String[] a = line.split(",");
            problemasf.add(new Problema(a[0], a[1], Integer.parseInt(a[2]), a[3], a[4]));         
        }
    } catch (IOException e) {
        
        e.printStackTrace();
    }
    }
    public void reiniciar() {
    	vidas=3;
    }
    public Integer getVidas() {
		return vidas;
	}

	public void setVidas(Integer vidas) {
		this.vidas = vidas;
	}
	public void quitarVida() {
		vidas-=1;
	}
	//Tomando en cuenta el nivel del susuario elige problemas de ese nivel o menor para presentarle al usuario
    public Problema seleccionarProblema(int nivel){
        ArrayList<Problema> posiblesProblemas = new ArrayList<Problema>();
        for (Problema problema : problemasf) {
            if (problema.getGrado() <= nivel){
                posiblesProblemas.add(problema);
            }
        }
        Random random= new Random();
        int r= random.nextInt(posiblesProblemas.size());
        return posiblesProblemas.get(r);
    }

    //Determina si la respuesta del usuario está correcta, devuelve true en ese caso o false en el caso contrario
    public boolean correcto(String solucion, Problema problema){
        if (solucion.equals(problema.getSolucion())){
            return true;
        }
        else{
            return false;
        }
    }


    public ArrayList<Problema> getProblemasf() {
        return this.problemasf;
    }

    public void setProblemasf(ArrayList<Problema> problemasf) {
        this.problemasf = problemasf;
    }

    public int getDificultad() {
        return dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }
    
    public int getPregunta() {
        return pregunta;
    }

    public void setPregunta(int pregunta) {
        this.pregunta = pregunta;
    }
    
}

