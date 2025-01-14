package web.service;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.util.ArrayList;

@XmlRootElement
public class Hotel {
	
	private String nom;
    private Adresse adresse;
    private int etoiles;
    private ArrayList<Chambre> chambres = new ArrayList<>();

    public Hotel(){
        this.nom = "Hotel";
        this.adresse = new Adresse();
        this.etoiles = 0;
    }
    public Hotel(String nom, Adresse adresse, int etoiles) {
        this.nom = nom;
        this.adresse = adresse;
        this.etoiles = etoiles;
    }

    public ArrayList<Chambre> getChambres() {
        return chambres;
    }

    public Chambre getChambre(int i){
        return this.chambres.get(i);
    }

    public void setChambres(ArrayList<Chambre> chambres) {
        this.chambres = chambres;
    }

    public void addChambre(Chambre chambre){
        for(Chambre current_chambre : chambres){
            if(current_chambre.getNumero()==chambre.getNumero()){
                System.out.println("Le numéro de chambre existe déjà");
                return;
            }
        }
        this.chambres.add(chambre);
        System.out.println("Chambre ajouter avec succes.");
    }

    public int getEtoiles() {
        return etoiles;
    }

    public void setEtoiles(int etoiles) {
        this.etoiles = etoiles;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public ArrayList<Chambre> chambreDisponible(Client client, String debutS, String finS,int nombre_lits){
        LocalDate debut = LocalDate.parse(debutS);
        LocalDate fin = LocalDate.parse(finS);
        ArrayList<Chambre> liste_chambre= new ArrayList<Chambre>();
        for(Chambre current_chambre : chambres){
            if(current_chambre.estDisponible(debutS, finS) && current_chambre.getLits()==nombre_lits){
                liste_chambre.add(current_chambre);
            }
        }
        return liste_chambre;
    }

    public int reserver(int numero_Chambre, Client client, String debutS, String finS){
        Chambre chambre = this.getChambre(numero_Chambre);
        if(chambre.estDisponible(debutS,finS)) {
            Reservation reservation_client = new Reservation(client, this, debutS, finS, chambre);
            chambre.addReservation(reservation_client);
            System.out.println("Chambre réserver avec succès.");
            return 1;
        }else{
            System.out.println("Chambre non disponible à cette date.");
            return 0;
        }

    }
}
