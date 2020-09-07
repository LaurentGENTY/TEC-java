package tec;
import java.io.*;

public class CollecteFichier implements Collecte {

    File file = new File("Data.txt");
    int numArret = 0;
    int nbEntree = 0;
    int nbSortie = 0;
    String debut_d_ecriture = "0 0 ";


    @Override
    public void uneEntree(){
        nbEntree += 1;
        String a_ecrire = debut_d_ecriture + nbEntree + "\n          " ;
        BufferedWriter writer;
        try{
            writer = new BufferedWriter(new FileWriter(file));
            //System.out.println("Salut");
            System.out.println(debut_d_ecriture);
            writer.write(a_ecrire);
            writer.close();
        }catch(IOException io){System.out.println("Erreur de lecture du fichier");}
    }

    @Override
    public void uneSortie(){
        nbSortie += 1;
    }

    @Override
    public void changerArret(){

        numArret += 1;
        String deb = lecture_fichier();
        debut_d_ecriture = deb + numArret + " " + nbSortie + " ";
        String a_ecrire = debut_d_ecriture + "0\n     ";
        BufferedWriter writer;
        try{
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(a_ecrire);
            writer.close();
        }catch(IOException io){System.out.println("Erreur de lecture du fichier");}
        nbEntree = 0;
        nbSortie = 0;
    }

    public void initialise(){
        try{
            file.createNewFile();
        }catch(IOException io){System.out.println("Erreur de création du fichier de stockage de données");}
        String a_ecrire = "0 0 0\n    ";
        BufferedWriter writer;
        try{
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(a_ecrire);
            writer.close();
        }catch(IOException io){System.out.println("Erreur de lecture du fichier");}
    }

    public void print_data(){
        System.out.println("Va voir le fichier c*****\n");
    }

    private boolean String lecture_fichier(){
        String st;
        String to_ret = "";
        BufferedReader br;
        try{
        br = new BufferedReader(new FileReader(file));
        st = br.readLine();
        while (st != null){
            to_ret += st;
            //System.out.println(st);
            st=br.readLine();
        }
        br.close();
        }catch(IOException io){System.out.println("Erreur de lecture du fichier");}
        return to_ret;
    }
}
