package tec;
import java.util.*;
public class CollecteTableau implements Collecte {

    ArrayList<int[]> tab = new ArrayList<int[]>();
    int numArret = 0;
    int ENTREE = 1;
    int SORTIE = 2;
    int indice_tableau = 0;

    @Override
    public void uneEntree(){
        tab.get(indice_tableau)[ENTREE] += 1;
    }

    @Override
    public void uneSortie(){
        tab.get(indice_tableau)[SORTIE] += 1;
    }

    @Override
    public void changerArret(){
        this.numArret += 1;
        this.indice_tableau += 1;
        this.initialise();
        /*if(tab.length-1<indice_tableau){
            int agrandissement = tab.length*2;
            int[][] copy_to = new int[agrandissement][3];
            System.arraycopy(copy_to,0,tab,0,tab.length*2);
            tab = copy_to;
        }*/
    }

    public void print_data(){
        for(int[] t : tab ){
            System.out.println(t[0]);
            System.out.println(t[1]);
            System.out.println(t[2]);
            System.out.println("\n");
        }
    }

    public void initialise(){
        int[] sous_tableau = new int[3];
        sous_tableau[0] = numArret;
        sous_tableau[ENTREE] = 0;
        sous_tableau[SORTIE] = 0;
        tab.add(sous_tableau);
    }

    public String toString() {
        String toret = "";
        for(int[] p : tab){
            toret += p[ENTREE]+" utilisateurs sont entrés et " +p[SORTIE] +" utilisateur sont sortis à l'arrêt numéro " + p[0] +"\n";
        }
        return toret;
    }
}
