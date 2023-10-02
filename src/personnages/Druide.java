package personnages;

import java.util.Random;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion;
	
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide "+ nom+ " et ma potion"
				+ " peut aller d'une force "
				+ effetPotionMin+ " à " + effetPotionMax + " . ");
		this.forcePotion = 1;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« "+ texte + "»");
	}

	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}

	public int preparerPotion() {
		Random random = new Random();
		int forcePotionPreparee;
		do {
			forcePotionPreparee = random.nextInt(effetPotionMax) + 1;
		} while(forcePotionPreparee < effetPotionMin);
		forcePotion = forcePotionPreparee;
		if(forcePotionPreparee > 7) {
			parler("J'ai préparé une super potion de force");
			return forcePotionPreparee;
		} else {
			parler("Je n'ai pas trouvé tous les ingrédients,"
					+ " ma potion est seulement de force "+forcePotionPreparee);
			return forcePotionPreparee;
		}
	}
	
	public void booster(Gaulois gaulois) {
		if(gaulois.getNom() == "Obélix") {
			parler(" Non, Obélix !... Tu n’auras pas"
					+ " de potion magique !");
			return;
		}else {
			gaulois.boirePotion(preparerPotion());
		}
	}
	
	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix", 5, 10);
		panoramix.preparerPotion();
	}

	public int getForcePotion() {
		return forcePotion;
	}
}
