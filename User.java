import java.util.ArrayList;

public class User {
    private String nombre;
    private int nivel;
    private ArrayList<Problema> problemasCorrctos;
    private ArrayList<Problema> problemasIncorrctos;
    private Integer score;

    public User() {
        problemasCorrctos = new ArrayList<Problema>();
        problemasIncorrctos = new ArrayList<Problema>();
    }

    public User(String nombre, int nivel, Integer score) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.problemasCorrctos = new ArrayList<Problema>();
        this.problemasIncorrctos = new ArrayList<Problema>();
        this.score= score;
    }

    public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return this.nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public ArrayList<Problema> getProblemasCorrctos() {
        return this.problemasCorrctos;
    }

    public void addProblemasCorrctos(Problema problemasCorrctos) {
    	this.problemasCorrctos.add(problemasCorrctos) ;
    }
    public Integer totalCorrectos() {
    	return problemasCorrctos.size();
    }
    public void addProblemasIncorrctos(Problema problemasIncorrctos) {
    	this.problemasIncorrctos.add(problemasIncorrctos);
    	}
    public Integer totalIncorrctos() {
    	return problemasIncorrctos.size();
    }
    public User nombre(String nombre) {
        setNombre(nombre);
        return this;
    }
    public void limpiar() {
    	problemasCorrctos.clear();
    	problemasIncorrctos.clear();
    }
    public User nivel(int nivel) {
        setNivel(nivel);
        return this;
    }

    /*public User problemasCorrctos(ArrayList<Problema> problemasCorrctos) {
        setProblemasCorrctos(problemasCorrctos);
        return this;
    }*/

    public ArrayList<Problema> getProblemasIncorrctos() {
        return this.problemasIncorrctos;
    }

    public void setProblemasIncorrctos(ArrayList<Problema> problemasIncorrctos) {
        this.problemasIncorrctos = problemasIncorrctos;
    }
    
    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", nivel='" + getNivel() + "'" +
            ", problemasCorrctos='" + getProblemasCorrctos() + "'" +
            "}";
    }

    
}
