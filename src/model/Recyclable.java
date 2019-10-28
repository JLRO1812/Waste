package model;

public class Recyclable extends Residue implements Usable{

	private String type;
	private String description;
	/**
	 * 
	 * @param name
	 * @param id
	 * @param origin
	 * @param color
	 * @param descompositionTime
	 * @param type
	 * @param description
	 */
	public Recyclable(String name, String id, String origin, String color, int descompositionTime, String type,
			String description) {
		super(name, id, origin, color, descompositionTime);
		this.type = type;
		this.description = description;
	}
	/**
	 * 
	 * @return
	 */
	public String getType() {
		return type;
	}
	/**
	 * 
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return super.toString()+"\n its Recyclable \n Type: " + type + "\n Description: " + description+"\n";
	}
	
	public double calculateHarmfulnessPercentage() {
		return super.calculateHarmfulnessPercentage()-0.02;
	}
	
	public boolean isItUsable() {
		boolean usable;
		if (description!=null)
			usable=true;
		else
			usable=false;
		
		return usable;
	}	
}