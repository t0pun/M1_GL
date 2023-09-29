public class Main {

	public static void main(String[] args){

        /*__________ORDERED DICO TEST_________*/

		IDictionary dico = new OrderedDico();

        String key1 = "CHENINI";
        String value1 = "Ayoub";

        //test méthode isempty
        if(dico.isEmpty()){
            System.out.println("Le dico est vide");
        }else{
            System.out.println("Le dico n'est pas vide");
        }

        //test methode put
        try {
            dico.put(key1, value1);
            System.out.println("la pair a été ajouté");
        } catch (Exception e){
            System.out.println("Message d'erreur : "+e);
        }

        //test size
        System.out.println("Le dico est de taille : "+dico.size());

        //test containsKey
        if(dico.containsKey("CHENINI")){
            System.out.println("La clé est contenu");
        }

        if(dico.isEmpty()){
            System.out.println("Le dico est vide");
        }else{
            System.out.println("Le dico n'est pas vide");
	    }

        /*__________SORTED DICO TEST_________*/

        System.out.println("__________SORTED DICO TEST_________");

        SortedDico sorted_dico = new SortedDico();

        try{
            sorted_dico.put(5,"a");
            sorted_dico.put(4,"b");
            sorted_dico.put(3,"c");
            sorted_dico.put(2,"d");
            sorted_dico.put(1,"e");
            sorted_dico.put(0,"f");
        }catch (Exception e){
            System.out.println("Message d'erreur : "+e);
        }

        try {
            System.out.println(sorted_dico.indexOf(0));
        }catch (Exception e){
            System.out.println("Message d'erreur : "+e);
        }

    }
}