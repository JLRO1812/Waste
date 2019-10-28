package model;

public class Inert extends Residue{

	//Atributo
	private String tip;
	/**
	 * 
	 * @param name
	 * @param id
	 * @param origin
	 * @param color
	 * @param descompositionTime
	 * @param tip
	 */
	public Inert(String name, String id, String origin, String color, int descompositionTime, String tip) {
		super(name, id, origin, color, descompositionTime);
		this.tip = tip;
	}

	public String getTip() {
		return tip;
	}

	@Override
	public String toString() {
		return super.toString()+"\n its Inert \n And the tip to reduce its use is: " + tip+"\n";
	}
}