package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois;
	
	
	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.nbVillageois = 0;
		villageois = new Gaulois[nbVillageoisMaximum];
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois nouveauVillageois) {
		if(nbVillageois < villageois.length) {
			villageois[nbVillageois] = nouveauVillageois;
			nbVillageois++;
		}
	}
	
	public Gaulois trouverHabitant(int numero) {
		return villageois[numero];
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le village du chef "
				+ "Abraracourcix vivent les légendaires gaulois :");
		for (int i = 0; i < nbVillageois; i++) {
			System.out.println("- " + villageois[i].getNom());
		}
	}
	
	public static void main(String[] args) {
		Village village;
		village = new Village("Village des Irréductibles", 30);
		Gaulois abraracourcix;
		abraracourcix = new Gaulois("Abraracourcix", 6);
		village.ajouterHabitant(abraracourcix);
		Gaulois asterix;
		asterix = new Gaulois("Astérix", 8);
		village.ajouterHabitant(asterix);
		Gaulois obelix;
		obelix = new Gaulois("Obélix", 25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
		
	}
}
