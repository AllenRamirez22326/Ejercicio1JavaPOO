import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Retroalimentacion {
    public int evaluarNivel(User usuario){
    
        float correctasRelativas = usuario.getProblemasCorrctos().size()/(usuario.getProblemasCorrctos().size()+usuario.getProblemasIncorrctos().size());
        if(correctasRelativas>0.8){
            return usuario.getNivel()+1;
        }
        else if (correctasRelativas<0.2){
            return usuario.getNivel()-1;
        }
        else;
            return usuario.getNivel();

    }

    public String evaluarCategoria(User usuario, boolean mejor){
        if (mejor){
            ArrayList<String> categorias = new ArrayList<String>();
            for (Problema problema : usuario.getProblemasCorrctos()) {
                categorias.add(problema.getTipo());
            }
            HashSet<String> setCategorias = new HashSet<String>(categorias);
            String[][] cuenta = new String[categorias.size()][2];
            int cont =0;
            for (String categoria : setCategorias) {
                cuenta[cont][0] = categoria;
                cuenta[cont][1] = String.valueOf(Collections.frequency(categorias, categoria));
                cont++;
            }

            
            ArrayList<Integer> frecuencias = new ArrayList<Integer>();
            for (String[] frec : cuenta) {
                frecuencias.add(Integer.parseInt(frec[1]));
                
            }
            Collections.sort(frecuencias);

            String categoriaMasFrecuente = "";

            for (String[] i : cuenta) {
               if (Integer.parseInt(i[1]) == frecuencias.get(frecuencias.size()-1)){
                categoriaMasFrecuente = i[0];
               }
            }

            return categoriaMasFrecuente;    
        }
        else {
            ArrayList<String> categorias = new ArrayList<String>();
            for (Problema problema : usuario.getProblemasIncorrctos()) {
                categorias.add(problema.getTipo());
            }
            HashSet<String> setCategorias = new HashSet<String>(categorias);
            String[][] cuenta = new String[categorias.size()][2];
            int cont =0;
            for (String categoria : setCategorias) {
                cuenta[cont][0] = categoria;
                cuenta[cont][1] = String.valueOf(Collections.frequency(categorias, categoria));
                cont++;
            }

            
            ArrayList<Integer> frecuencias = new ArrayList<Integer>();
            for (String[] frec : cuenta) {
                frecuencias.add(Integer.parseInt(frec[1]));
                
            }
            Collections.sort(frecuencias);

            String categoriaMasFrecuente = "";

            for (String[] i : cuenta) {
               if (Integer.parseInt(i[1]) == frecuencias.get(frecuencias.size()-1)){
                categoriaMasFrecuente = i[0];
               }
            }
            return categoriaMasFrecuente;  
        }
    }

}
