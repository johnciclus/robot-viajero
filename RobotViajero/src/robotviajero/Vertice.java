package robotviajero;

/**
 * @author Jhon Garavito
 */
public class Vertice {
    private int id=0;
    private float x=0,y=0;
    private String nombre=new String();
    public Vertice(){
        id=0;
        x=0;
        y=0;
        nombre="";
    }
    public Vertice(int idArg, String nomArg, float xArg, float yArg){
        id=idArg;
        x=xArg;
        y=yArg;
        nombre=nomArg;
    }
    public int obtId(){
        return id;
    }
    public float obtX(){
        return x;
    }
    public float obtY(){
        return y;
    }
    public String obtNombre(){
        return nombre;
    }
}
