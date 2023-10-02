package personnages;

public class Gaulois {
	private String nom;
	private int effetPotion = 1;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
//	private String prendreParole() {
//		return "Le Gaulois " + nom + " : ";
//	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la"
//				+ " mâchoire de " + romain.getNom());
//		romain.recevoirCoup(effetPotion*force/3);
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la"
		+ " mâchoire de " + romain.getNom());
		Equipement[] trophee = romain.recevoirCoup((force / 3) *
		effetPotion);
		for (int i = 0; trophee != null && i < trophee.length; i++,
		nbTrophees++) {
			this.trophees[nbTrophees] = trophee[i];
		}
	}

	
	public int getForce() {
		return force;
	}
	
	public void setForce(int force) {
		this.force = force;
	}
	
	public int getEffetPotion() {
		return effetPotion;
	}
	
	public void boirePotion(int forcePotionABoire) {
		effetPotion = forcePotionABoire;
		parler("Merci Druide, je sens que ma force est "
				+ effetPotion + " fois décuplée.");
	}
	
	public void faireUneDonation(Musee musee) {
		int i = 0;
		String texte;
		if(trophees[i]!=null) {
			texte = "Je donne au musee tous mes trophees :";
		} else {
			texte = "Je n'ai pas de trophee à donner.";
		}
		while(trophees[i]!=null) {
			texte += "\n- " + trophees[i];
			musee.donnerTrophees(this, trophees[i]);
		}
		parler(texte);
	}
	
	
	
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix.getNom());
		System.out.println(asterix);
		asterix.parler("Bonjour!");
		Romain bob = new Romain("Bob", 5);
		asterix.boirePotion(7);
		asterix.frapper(bob);
	}


}
