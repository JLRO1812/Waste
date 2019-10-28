package model;

public class Product {

	static final int MAXRESIDUES=10;
	private String name;
	private String id;
	private String description;
	
	private Residue resi[];
	/**
	 * 
	 * @param name
	 * @param id
	 * @param description
	 */
	public Product(String name, String id, String description) {
	
		this.name = name;
		this.id = id;
		this.description = description;
		resi=new Residue[MAXRESIDUES];
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public String toString() {
		return "PRODUCT\n Name: " + name + "\n Id: " + id + "\n Description: " + description+"\n";
	}
	/**
	 * 
	 * @param name
	 * @param id
	 * @param origin
	 * @param color
	 * @param descompositionTime
	 * @param suitableForComposting
	 * @return
	 */
	public String addResidue(String name, String id, String origin, String color, int descompositionTime, boolean suitableForComposting){
		int emptyPosition=emptyPosition();
		String reply="Residue cant be registered";
		if(emptyPosition!=-1) {
			resi[emptyPosition]=new Biodegradable(name, id, origin, color, descompositionTime, suitableForComposting);
			reply="the residue was registered successfully";
		}
		
		return reply;
	}
	/**
	 * 
	 * @param name
	 * @param id
	 * @param origin
	 * @param color
	 * @param descompositionTime
	 * @param type
	 * @param description
	 * @return
	 */
	public String addResidue(String name, String id, String origin, String color, int descompositionTime, String type, String description) {
		int emptyPosition=emptyPosition();
		String reply="Residue cant be registered";
		if(emptyPosition!=-1) {
			resi[emptyPosition]=new Recyclable(name, id, origin, color, descompositionTime, type, description);
			reply="the residue was registered successfully";
		}
		
		return reply;
	}
	/**
	 * 
	 * @param name
	 * @param id
	 * @param origin
	 * @param color
	 * @param descompositionTime
	 * @param tip
	 * @return
	 */
	public String addResidue(String name, String id, String origin, String color, int descompositionTime, String tip) {
		int emptyPosition=emptyPosition();
		String reply="Residue cant be registered";
		if(emptyPosition!=-1) {
			resi[emptyPosition]=new Inert(name, id, origin, color, descompositionTime, tip);
			reply="the residue was registered successfully";
		}
		
		return reply;
	}
	/**
	 * 
	 * @return
	 */
	//busca una posicion vacia en el arreglo de residuos
	public int emptyPosition() {
		int n=-1;
		boolean found=false;
		for(int i=0; i<resi.length && found==false; i++) {
			if(resi[i]==null) {
				n=i;
			}
		}
		return n;
	}
	/**
	 * 
	 * @param name
	 * @return
	 */
	//retorna un objeto residuo con el nombre puesto
	public Residue searchByName(String name) {
		Residue obj=null;
		boolean found=false;
		String n;
		for(int i=0; i<resi.length && found==false; i++) {
			if(resi[i]!=null) {
				n=resi[i].getName();
				if(n.equals(name)) {
					found=true;
					obj=resi[i];
				}
			}
		}
		return obj;
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	//Retarno un objeto residuo con el id puesto
	public Residue searchById(String id) {
		Residue obj=null;
		boolean found=false;
		String n;
		for(int i=0; i<resi.length && found==false; i++) {
			if(resi[i]!=null) {
				n=resi[i].getId();
				if(n.equals(id)) {
					found=true;
					obj=resi[i];
				}
			}
		}
		return obj;
	}
	/**
	 * 
	 * @return
	 */
	//Retorna todos los residuos biodegradables
	public String searchBio() {
		boolean foundFirst=false;
		String info="\n BIODEGRADABLES: \n";
		for(int i=0; i<resi.length; i++) {
			if(resi[i]!=null) {
				if(resi[i] instanceof Biodegradable) {
					foundFirst=true;
					info+=resi[i].toString();
				}
			}
		}
		if(foundFirst==false) {
			info+="Biodegradables not found \n";
		}
		
		return info;
	}
	/**
	 * 
	 * @return
	 */
	//Retorna todos los residuos Reciclables
	public String searchRecy() {
		boolean foundFirst=false;
		String info="\n RECYCLABLES: \n";
		for(int i=0; i<resi.length; i++) {
			if(resi[i]!=null) {
				if(resi[i] instanceof Recyclable) {
					foundFirst=true;
					info+=resi[i].toString();
				}
			}
		}
		if(foundFirst==false) {
			info+="Recyclables not found \n";
		}
		
		return info;
	}
	/**
	 * 
	 * @return
	 */
	//Retorna todos los residuos inertes
	public String searchInert() {
		boolean foundFirst=false;
		String info="\n INERTS: \n";
		for(int i=0; i<resi.length; i++) {
			if(resi[i]!=null) {
				if(resi[i] instanceof Inert) {
					foundFirst=true;
					info+=resi[i].toString();
				}
			}
		}
		if(foundFirst==false) {
			info+="Inerts not found \n";
		}
		
		return info;
	}
	/**
	 * 
	 * @return
	 */
	//cuenta la cantidad de residuos registrados
	public int countRegisteredResidues() {
		int n=0;
		for(int i=0; i<resi.length; i++) {
			if(resi[i]!=null)
				n+=1;
		}
		return n;
	}
	/**
	 * 
	 * @param n
	 * @return
	 */
	public Residue getResidueInPositionN(int n) {
		return resi[n];
	}
	
}