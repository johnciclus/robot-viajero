package robotviajero;

/**
 * @author Jhon Garavito
 */
public class Arista {
    private int id=0;
    private Vertice v1=new Vertice();
    private Vertice v2=new Vertice();
    private float costo=0;
    public Arista(int idArg, Vertice v1Arg, Vertice v2Arg, float costoArg){
        id=idArg;
        v1=v1Arg;
        v2=v2Arg;
        costo=costoArg;
    }
    public int obtId(){
        return id;
    }
    public Vertice obtCuidad1(){
        return v1;
    }
    public Vertice obtCuidad2(){
        return v2;
    }
    public float obtCosto(){
        return costo;
    }
}
