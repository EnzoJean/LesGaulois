package personnages;

public enum Equipement {
	CASQUE("casque"), BOUCLIER("bouclier");
	
	private String nom;
	
	private Equipement(String name) {
		this.nom = name;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}

