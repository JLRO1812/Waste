package model;

public abstract class Residue {

	static final String OIND="industrial";
	static final String ODOM="domiciliary";
	static final String OCON="building";
	static final String OMUN="municipal";
	static final String OHOS="hospitals";
	
	private String name;
	private String id;
	private String origin;
	private String color;
	private int descompositionTime;
	/**
	 * 
	 * @param name
	 * @param id
	 * @param origin
	 * @param color
	 * @param descompositionTime
	 */
	public Residue(String name, String id, String origin, String color, int descompositionTime) {
		this.name = name;
		this.id = id;
		this.origin = origin;
		this.color = color;
		this.descompositionTime = descompositionTime;
	}
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @return
	 */
	public String getId() {
		return id;
	}
	/**
	 * 
	 * @return
	 */
	public String getOrigin() {
		return origin;
	}
	/**
	 * 
	 * @return
	 */
	public String getColor() {
		return color;
	}
	/**
	 * 
	 * @return
	 */
	public int getDescompositionTime() {
		return descompositionTime;
	}
	
	public String toString() {
		return "RESIDUE \n Name: " + name + "\n Id: " + id + "\n Origin: " + origin + "\n Color: " + color
				+ "\n DescompositionTime: " + descompositionTime;
	}
	/**
	 * 
	 * @return
	 */
	//calcula el nivel de nocividad de un residuo
	public double calculateHarmfulnessPercentage() {
		double percentage=0;
			
		if (origin.equals(OCON)) {
			percentage=0.08;
		}
			
		if(origin.equals(OIND)) {
			percentage=0.1;
		}
			
		if(origin.equals(ODOM)) {
			percentage=0.05;
		}
			
		if(origin.equals(OMUN)) {
			percentage=0.12;
		}
			
		if(origin.equals(OHOS)) {
			percentage=0.15;
		}
			
		return percentage;
			
	}
	/**
	 * 
	 * @return
	 */
	public double calculateHarmfulness() {
		return calculateHarmfulnessPercentage()*descompositionTime;
	}
}