package robotviajero;
import java.util.ArrayList;

/**
 * @author Jhon Garavito
 */
public class GrafoCiudades {
    private ArrayList<Vertice> verArray;
    private ArrayList<Arista> ariArray;
    private ArrayList<Vertice> abiertos;
    private ArrayList<Vertice> cerrados;
    public GrafoCiudades(){
        verArray = new ArrayList<Vertice>();
        ariArray = new ArrayList<Arista>();
    }
    public void agreCiudad(String nomArg, float xArg, float yArg){
        verArray.add(new Vertice(verArray.size()+1,nomArg,xArg,yArg));
    }
    public void agreRuta(int idC1, int idC2, float costoArg){
        ariArray.add(new Arista(ariArray.size()+1,verArray.get(idC1),verArray.get(idC2),costoArg));
    }
    public void agreRuta(String nomC1, String nomC2, float costoArg){
        int idC1Tmp=busIndCiu(nomC1);
        int idC2Tmp=busIndCiu(nomC2);
        agreRuta(idC1Tmp, idC2Tmp, costoArg);
    }
    public int busIndCiu(String nomCui){
        int indTmp=-1;
        for(int i=0;i<verArray.size();i++){
            if(verArray.get(i).obtNombre().equals(nomCui)){
                indTmp=i;
                i=verArray.size();
            }
        }
        return indTmp;
    }
    public float distCiudades(int idC1, int idC2){
        Vertice verC1Tmp=verArray.get(idC1);
        Vertice verC2Tmp=verArray.get(idC2);
        return (float) Math.sqrt(Math.pow(verC1Tmp.obtX()-verC2Tmp.obtX(),2)+Math.pow(verC1Tmp.obtY()-verC2Tmp.obtY(),2));
    }
    public float distCiudades(String nomC1, String nomC2){
        int idC1Tmp=busIndCiu(nomC1);
        int idC2Tmp=busIndCiu(nomC2);
        return distCiudades(idC1Tmp,idC2Tmp);
    }
    public String detMejorReco(int idC1, int idC2){
        abiertos=new ArrayList<Vertice>();
        cerrados=new ArrayList<Vertice>();
        Vertice verC1Tmp=verArray.get(idC1);
        Vertice verC2Tmp=verArray.get(idC2);
        String resultado="";
        abiertos.add(verC1Tmp);
        System.out.println("Busqued del mejor camino:");
        do{
            if(abiertos.isEmpty()){
                resultado="No se ha encontrado el camino";
                break;
            }
            cerrados.add(funcEval(abiertos,verC2Tmp));
            System.out.println("Nodo: "+cerrados.get(cerrados.size()-1).obtNombre());
            if(cerrados.get(cerrados.size()-1)==verC2Tmp){
                resultado="Se ha encontrado el camino";
            }
            abiertos=expandir(cerrados.get(cerrados.size()-1));
        }while(cerrados.get(cerrados.size()-1)!=verC2Tmp);
        
        return resultado+", Cantidad cerrados: "+cerrados.size()+", Cantidad abiertos: "+abiertos.size();
    }
    public String detMejorReco(String nomC1, String nomC2){
        return "";
    }
    public ArrayList<Vertice> expandir(Vertice verExp){
        ArrayList<Vertice> sucExp=new ArrayList<Vertice>();
        Arista ariTmp;
        for(int i=0;i<ariArray.size();i++){
            ariTmp=ariArray.get(i);
            if(ariTmp.obtCuidad1().equals(verExp)){
                if(!abiertos.contains(ariTmp.obtCuidad2())&&!cerrados.contains(ariTmp.obtCuidad2())){
                    sucExp.add(ariTmp.obtCuidad2());
                }
            }
            if(ariTmp.obtCuidad2().equals(verExp)){
                if(!abiertos.contains(ariTmp.obtCuidad1())&&!cerrados.contains(ariTmp.obtCuidad1())){
                    sucExp.add(ariTmp.obtCuidad1());
                }
            }
        }
        return sucExp;
    }
    public Vertice funcEval(ArrayList<Vertice> abiertos, Vertice verC2Tmp) {
        Vertice verTmp;
        int indMenor=0;
        float fAnt=0.0f, cosAnt=0.0f;
        float fAct=0.0f, cosAct=0.0f;
        for(int i=0;i<abiertos.size();i++){
            verTmp=abiertos.get(i);
            if(cerrados.size()>0){
                cosAct=obtRuta(cerrados.get(cerrados.size()-1),verTmp).obtCosto();
                cosAnt=obtRuta(cerrados.get(cerrados.size()-1),abiertos.get(indMenor)).obtCosto();
            }
            fAct=distCiudades(verTmp.obtId(),verC2Tmp.obtId())+cosAct;
            fAnt=distCiudades(abiertos.get(indMenor).obtId(),verC2Tmp.obtId())+cosAnt;
            if(fAct<fAnt){
                indMenor=i;
            }    
        }
        return abiertos.get(indMenor);
    }
    public Arista obtRuta(Vertice ciu1, Vertice ciu2){
        int ind=-1;
        for(int i=0;i<ariArray.size();i++){
            if(ariArray.get(i).obtCuidad1().equals(ciu1)&&ariArray.get(i).obtCuidad2().equals(ciu2)){
                ind=i;
                i=ariArray.size();
            }
            else if(ariArray.get(i).obtCuidad1().equals(ciu2)&&ariArray.get(i).obtCuidad2().equals(ciu1)){
                ind=i;
                i=ariArray.size();
            }
        }
        return ariArray.get(ind);
    }
}
