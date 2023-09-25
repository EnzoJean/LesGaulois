package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement;
	

	public Romain(String nom, int force) {
		assert (force > 0);
		this.nom = nom;
		this.force = force;
		equipements = new Equipement[2];
		this.nbEquipement = 0;
		
	}

	public String getNom() {
		return nom;
	}

	public int getForce() {
		return force;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + " »");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert (force > 0);
		int forceDepart = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		assert (force < forceDepart);
	}

	public void sEquiper(Equipement equip) {
		switch(nbEquipement) {
			case 2:
				System.out.println("Le soldat "+ nom +
						" est déjà bien protégé !");
				break;
			case 1:
				if (equip == equipements[0]) {
					System.out.println("Le soldat "+ nom +
							" possède déjà un "+equip+" !");
				} else {
					System.out.println("Le soldat "+ nom +
							" s’équipe avec un "+ equip);
					equipements[nbEquipement] = equip;
					nbEquipement++;
				}
				break;
			default:
				System.out.println("Le soldat "+ nom +
						" s’équipe avec un "+ equip);
				equipements[nbEquipement] = equip;
				nbEquipement++;
				break;
		}
	}
	
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.parler("Bonjour!");
		minus.recevoirCoup(10);
		for (Equipement equipement : Equipement.values()) {
			System.out.println(equipement);
		}
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}