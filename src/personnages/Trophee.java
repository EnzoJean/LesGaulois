package personnages;

public class Trophee {
	private Gaulois gaulois;
	private Equipement equipement;
	
	public Trophee(Gaulois g, Equipement equipement) {
		this.gaulois = g;
		this.equipement = equipement;
	}
	
	public Gaulois getGaulois() {
		return gaulois;
	}
	
	public Equipement getEquipement() {
		return equipement;
	}
	
	public String donnerNom(Gaulois g) {
		return g.getNom();
	}
	
}
