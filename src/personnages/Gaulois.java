package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "� " + texte + "�");
	}
	
	private String prendreParole() {
		return "Le Gaulois " + nom + " : ";
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la"
				+ " m�choire de " + romain.getNom());
		romain.recevoirCoup(effetPotion*force/3);
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
				+ effetPotion + " fois d�cupl�e.");
	}
	
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Ast�rix", 8);
		System.out.println(asterix.getNom());
		System.out.println(asterix);
		asterix.parler("Bonjour!");
		Romain bob = new Romain("Bob", 5);
		asterix.boirePotion(7);
		asterix.frapper(bob);
	}


}
