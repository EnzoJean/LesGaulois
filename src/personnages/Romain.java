package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement;
	
	

	public Romain(String nom, int force) {
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
		System.out.println(prendreParole() + "� " + texte + " �");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

//	public void recevoirCoup(int forceCoup) {
//		assert (force > 0);
//		int forceDepart = force;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("A�e");
//		} else {
//			parler("J'abandonne...");
//		}
//		assert (force < forceDepart);
//	}

	public void sEquiper(Equipement equip) {
		String soldat = "Le soldat ";
		switch(nbEquipement) {
			case 2:
				System.out.println(soldat + nom +
						" est d�j� bien prot�g� !");
				break;
			case 1:
				if (equip == equipements[0]) {
					System.out.println(soldat + nom +
							" poss�de d�j� un "+equip+" !");
				} else {
					System.out.println(soldat + nom +
							" s��quipe avec un "+ equip);
					equipements[nbEquipement] = equip;
					nbEquipement++;
				}
				break;
			default:
				System.out.println(soldat + nom +
						" s��quipe avec un "+ equip);
				equipements[nbEquipement] = equip;
				nbEquipement++;
				break;
		}
	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		if (force > 0) {
			parler("A�e");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		assert force < oldForce;
		return equipementEjecte;
	}
	
	private int calculResistanceEquipement(int forceCoup) {
		String texte;
		texte = "Ma force est de " + this.force + ", et la force du "
		+ "coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace � mon �quipement sa "
			+ "force est diminu�e de ";
			for (int i = 0; i < nbEquipement; i++) {
				if ((equipements[i] != null &&
					equipements[i].equals(Equipement.BOUCLIER))) {
						resistanceEquipement += 8;
					} else {
						System.out.println("Equipement casque");
						resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		if (forceCoup <= 0) {
			return 1;
		} else {
			return forceCoup;
		}
	}
		


	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'�quipement de " + nom
		+ " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {	
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
			return equipementEjecte;
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