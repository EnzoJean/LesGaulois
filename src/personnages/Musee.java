package personnages;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophees = 0;
	
	public void donnerTrophees(Gaulois donateur, Equipement don) {
		Trophee nouveauTrophee = new Trophee(donateur, don);
		trophees[nbTrophees] = nouveauTrophee;
		nbTrophees++;
	}
	
}
