package model;

public class Biodegradable extends Residue implements Usable{

	private boolean suitableForComposting;
	/**
	 * 
	 * @param name
	 * @param id
	 * @param origin
	 * @param color
	 * @param descompositionTime
	 * @param suitableForComposting
	 */
	public Biodegradable(String name, String id, String origin, String color, int descompositionTime, boolean suitableForComposting) {
		super(name, id, origin, color, descompositionTime);
		this.suitableForComposting = suitableForComposting;
	}

	@Override
	public String toString() {
		return super.toString()+"\n its Biodegradable and suitable for composting its: " + suitableForComposting+"\n";
	}

	public double calculateHarmfulnessPercentage() {
		double harmufulness;
		if (suitableForComposting==true) {
			harmufulness=super.calculateHarmfulnessPercentage()-0.01;
		}
		else
			harmufulness=super.calculateHarmfulnessPercentage();
		
		return harmufulness;
	} 

	public boolean isItUsable() {
		boolean reply;
		if(suitableForComposting)
			reply=true;
		else
			reply=false;
		
		return reply;
	}
}