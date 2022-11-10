import java.io.*;
import java.util.ArrayList;

public class Paseo {
    public static void main(String[] args) {
        Perro p1 = new Perro("Samara", "Rotwailer", 2, "Calle 31B N 22");
        Perro p2 = new Perro("Dax", "Cocker Spanish", 3, "Diag 25 - 30AAA5");
        Perro p3 = new Perro("Tobby", "Salchicha", 7, "Cra 20 # 20 EEE 69");
        Perro p4 = new Perro("Thara", "Doberman", 2, "Trans Sup 55A 20");

        ArrayList<Perro> lunes  = new ArrayList<Perro>();
        ArrayList<Perro> martes  = new ArrayList<Perro>();
        ArrayList<Perro> miercoles  = new ArrayList<Perro>();
        ArrayList<Perro> jueves  = new ArrayList<Perro>();
        ArrayList<Perro> viernes  = new ArrayList<Perro>();

        lunes.add(p1);
        miercoles.add(p1);
        viernes.add(p1);

        lunes.add(p2);
        martes.add(p2);
        miercoles.add(p2);
        jueves.add(p2);

        miercoles.add(p3);
        jueves.add(p3);
        viernes.add(p3);

        lunes.add(p4);
        martes.add(p4);
        miercoles.add(p4);
        jueves.add(p4);
        viernes.add(p4);

        try {
            FileOutputStream fil = new FileOutputStream("perros.dat");
            ObjectOutputStream archi = new ObjectOutputStream(fil);

            archi.writeObject(lunes);
            archi.writeObject(martes);
            archi.writeObject(miercoles);
            archi.writeObject(jueves);
            archi.writeObject(viernes);

            archi.close();

            FileInputStream filIn = new FileInputStream("perros.dat");
            ObjectInputStream archiIn = new ObjectInputStream(filIn);
            ArrayList<Perro> dia;

            for (int i=0; i < 5; i++){
                System.out.println("Este día: "+ (i+1));
                System.out.println("======================");
                dia = (ArrayList<Perro>) archiIn.readObject();
                for (Perro p: dia
                     ) {
                    System.out.println(p);
                }
            }
            archiIn.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
