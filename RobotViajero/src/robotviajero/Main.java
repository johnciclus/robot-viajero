package robotviajero;

/**
 * @author Jhon Garavito
 */
public class Main {

    public static void main(String[] args) {
        GrafoCiudades Colombia=new GrafoCiudades();
        /*Colombia.agreCiudad("Bucaramanga", 0.0f, 0.0f);              //Primer ejemplo con Ciudades
        Colombia.agreCiudad("Santa Marta", 4.0f, 5.0f);
        Colombia.agreCiudad("Leticia", -3.0f, -7.0f);
        Colombia.agreCiudad("Bogota", -4.0f, 5.0f);
        Colombia.agreRuta("Bucaramanga","Santa Marta", 5);            //Se puede agregar rutas por nombre (Se debe escribir identicamente)
        Colombia.agreRuta(0, 2, 2);                                   //O tambien se pueden agregar rutas por identificacion Cuidad
        Colombia.agreRuta(0, 3, 3);
        Colombia.agreRuta(1, 2, 1);
        Colombia.agreRuta(1, 3, 7);
        Colombia.agreRuta(2, 3, 6);
        System.out.println("Distancia ciudades 0-1: "+Colombia.distCiudades(0,1));
        System.out.println("Distancia ciudades 0-2: "+Colombia.distCiudades(0,2));
        System.out.println("Distancia ciudades 0-3: "+Colombia.distCiudades(0,3));
        System.out.println("Distancia ciudades 1-2: "+Colombia.distCiudades(1,2));*/
        Colombia.agreCiudad("A", 0.0f, 0.0f);
        Colombia.agreCiudad("B", 0.0f, 7.0f);
        Colombia.agreCiudad("C", 4.0f, 0.0f);
        Colombia.agreCiudad("D", 7.0f, 5.0f);
        Colombia.agreCiudad("E", 13.0f, 10.0f);
        Colombia.agreCiudad("F", 10.0f, -5.0f);
        Colombia.agreCiudad("G", 17.0f, 1.0f);
        Colombia.agreCiudad("H", 25.0f, 1.0f);
        Colombia.agreCiudad("I", 24.0f, 7.0f);
        Colombia.agreCiudad("J", 32.0f, 3.0f);
        Colombia.agreRuta("A", "B", 7.0f);
        Colombia.agreRuta("A", "C", 4.0f);
        Colombia.agreRuta("B", "D", 8.0f);
        Colombia.agreRuta("B", "E", 14.0f);
        Colombia.agreRuta("C", "D", 6.0f);
        Colombia.agreRuta("C", "F", 8.0f);
        Colombia.agreRuta("D", "E", 8.0f);
        Colombia.agreRuta("D", "G", 11.0f);
        Colombia.agreRuta("E", "I", 12.0f);
        Colombia.agreRuta("F", "G", 10.0f);
        Colombia.agreRuta("G", "H", 8.0f);
        Colombia.agreRuta("I", "J", 9.0f);
        System.out.println("Distancia ciudades A-B: "+Colombia.distCiudades(0,1));
        System.out.println("Distancia ciudades A-C: "+Colombia.distCiudades(0,2));
        System.out.println("Distancia ciudades B-D: "+Colombia.distCiudades(1,3));
        System.out.println("Distancia ciudades B-E: "+Colombia.distCiudades(1,4));
        System.out.println("Distancia ciudades C-D: "+Colombia.distCiudades(2,3));
        System.out.println("Distancia ciudades C-F: "+Colombia.distCiudades(2,5));
        System.out.println("Distancia ciudades D-E: "+Colombia.distCiudades(3,4));
        System.out.println("Distancia ciudades D-G: "+Colombia.distCiudades(3,6));
        System.out.println("Distancia ciudades E-I: "+Colombia.distCiudades(4,8));
        System.out.println("Distancia ciudades F-G: "+Colombia.distCiudades(5,6));
        System.out.println("Distancia ciudades G-H: "+Colombia.distCiudades(6,7));
        System.out.println("Distancia ciudades I-J: "+Colombia.distCiudades(8,9));
        System.out.println(Colombia.detMejorReco(0, 6));
    }
}
