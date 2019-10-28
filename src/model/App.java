package model;

public class App {

	private Product pro[];
	
	public App(int n) {
		pro=new Product[n];
	}
	/**
	 * 
	 * @param name
	 * @param id
	 * @param description
	 * @return
	 */
	public String addProduct(String name, String id, String description) {
		int emptyPosition=emptyPosition();
		String reply="Product cant be registered";
		if(emptyPosition!=-1 && theNameAlreadyExists(name)==false && theIdAlreadyExists(id)==false) {
			pro[emptyPosition]=new Product(name, id, description);
			reply="the product was registered successfully";
		}
		return reply;
	}
	/**
	 * 
	 * @param pname
	 * @return
	 */
	public boolean theNameAlreadyExists(String pname) {
		boolean exist=false;
		if(productByName(pname)!=null) {
			exist=true;
		}
		
		return exist;
	}
	/**
	 * 
	 * @param pId
	 * @return
	 */
	public boolean theIdAlreadyExists(String pId) {
		boolean exist=false;
		if(productById(pId)!=null) {
			exist=true;
		}
		
		return exist;
	}
	/**
	 * 
	 * @return
	 */
	//busca una posicion vacia en el arreglo de residuos
	public int emptyPosition() {
			int n=-1;
			boolean found=false;
			for(int i=0; i<pro.length && found==false; i++) {
				if(pro[i]==null) {
					n=i;
				}
			}
			return n;
		}
	/**
	 * 
	 * @param pname
	 * @return
	 */
	//busca un producto por el nombre
	public Product productByName(String pname) {
		boolean found=false;
		Product obj=null;
		for(int i=0; i<pro.length && found==false; i++) {
			if(pro[i]!=null) {
				if((pro[i].getName()).equals(pname)) {
				found=true;
				obj=pro[i];
				}
			}
		}
		return obj;
	}
	/**
	 * 
	 * @param pname
	 * @return
	 */
	public int productPositionByName(String pname) {
		boolean found=false;
		int n=-1;
		for(int i=0; i<pro.length && found==false; i++) {
			if(pro[i]!=null) {
				if((pro[i].getName()).equals(pname)) {
				found=true;
				n=i;
				}
			}
		}
		return n;
	}
	/**
	 * 
	 * @param pId
	 * @return
	 */
	//busca un producto por el id
	public Product productById(String pId) {
			boolean found=false;
			Product obj=null;
			for(int i=0; i<pro.length && found==false; i++) {
				if(pro[i]!=null) {
					if((pro[i].getId()).equals(pId)) {
					found=true;
					obj=pro[i];
					}
				}
			}
			return obj;
		}
	/**
	 * 
	 * @return
	 */
	//muestra los productos registrados
	public String showRegisteredProducts() {
		String info="";
		boolean found=false;
		for(int i=0; i<pro.length; i++) {
			if(pro[i]!=null) {
				info+=pro[i].toString();
				found=true;
			}
		}
		if(found==false) {
			info="No products registered";
		}
		return info;
	}
	/**
	 * 
	 * @return
	 */
	//genera el reporte de todos los reciduos
	public String report() {
		String infoBio="";
		String infoRecy="";
		String infoInert="";
		String info;
		boolean found=false;
		
		for(int i=0; i<pro.length; i++) {
			if(pro[i]!=null) {
				found=true;
				if((pro[i].searchBio()).equals("not found")) {
				}
				else
					infoBio+="Product: ("+pro[i].getName()+"): \n "+pro[i].searchBio()+"\n";
			}
		}
		
		for(int i=0; i<pro.length; i++) {
			if(pro[i]!=null) {
				found=true;
				if((pro[i].searchRecy()).equals("not found")) {
				}
				else 
					infoRecy+="Product: ("+pro[i].getName()+"): \n "+pro[i].searchRecy()+"\n";
			}
		}
		
		for(int i=0; i<pro.length; i++) {
			if(pro[i]!=null) {
				found=true;
				if((pro[i].searchInert()).equals("not found")) {
				}
				else
					infoInert+="Product: ("+pro[i].getName()+"): \n "+pro[i].searchInert()+"\n";

			}
		}
		
		info=infoBio+infoRecy+infoInert;
		
		if(found==false) {
			info="Products not found";
		}
			
		return info;
	}
	/**
	 * 
	 * @param pname
	 * @return
	 */
	//muestra la info de un residuo dependiendo el nombre
	public String residueInfoName(String pname) {
		String info="Not found";
		boolean found=false;
		for(int i=0; i<pro.length && found==false; i++) {
			if(pro[i]!=null) {
				if(pro[i].searchByName(pname)!=null) {
					Residue obj=pro[i].searchByName(pname);
					info=obj.toString()+"\n and its product is: \n"+pro[i].toString();
					found=true;
				}
			}
		}
		return info;
	}
	/**
	 * 
	 * @param pId
	 * @return
	 */
	//muestra la info de un residuo dependiendo el id	
	public String residueInfoId(String pId) {
		String info="Not found";
		boolean found=false;
		for(int i=0; i<pro.length && found==false; i++) {
			if(pro[i]!=null) {
				if(pro[i].searchById(pId)!=null) {
					Residue obj=pro[i].searchById(pId);
					info=obj.toString();
					found=true;
				}
			}
		}
		return info;
	}
	/**
	 * 
	 * @param pId
	 * @return
	 */
	//muestra la info de un residuo dependiendo de el id del producto
	public String residueInfoIdProduct(String pId) {
		String info="Not found";
		Product obj=productById(pId);
		if(obj!=null) {
			info=obj.searchBio()+obj.searchRecy()+obj.searchInert();
		}
		return info;
	}
	/**
	 * 
	 * @param pname
	 * @return
	 */
	//permite conocer si un reciduo es aprovechable
	public String isItUsable(String pname) {
		String reply="it is not";
		boolean yes=false;
		boolean found=false;
		
		for(int i=0; i<pro.length && found==false; i++) {
			if(pro[i]!=null) {
				if(pro[i].searchByName(pname)!=null) {
					found=true;
					if(pro[i].searchByName(pname) instanceof Biodegradable) {
						yes = ((Biodegradable)pro[i].searchByName(pname)).isItUsable();
					}
					else {
						if(pro[i].searchByName(pname) instanceof Biodegradable) {
							yes = ((Recyclable)pro[i].searchByName(pname)).isItUsable();
						}
					}
				}
			}
		}
		
		if(yes==true)
			reply="Yes, it is";
		else {
			if(found==false) {
				reply="notFound";
			}
		}
		
		return reply;
	}
	/**
	 * 
	 * @param pname
	 * @return
	 */
	//Calcula el nivel de nocividad de un residuo dependiendo el nombre
	public String calculateHarmfulness(String pname) {
		double harmfulness=0;
		boolean found=false;
		String reply="Not found";
		for(int i=0; i<pro.length && found==false; i++) {
			if(pro[i]!=null) {
				if(pro[i].searchByName(pname)!=null) {
					harmfulness=(pro[i].searchByName(pname)).calculateHarmfulness();
					found=true;
					reply=harmfulness+"";
				}
			}
		}
		return reply;
	}
	/**
	 * 
	 * @return
	 */
	//Retorna un string con la informacion de la nocividad de los residuos de forma de el mas nocivo al menos nocivo;
	public String harmfulnessReport() {
		String info="";
		int n=0;
		for(int i=0; i<pro.length; i++) {
			if(pro[i]!=null) {
				n+=pro[i].countRegisteredResidues();
			}
		}
		if(n!=0) {
		
			Residue res[]=new Residue[n];
			int auxN=0;
			for (int i=0; i<pro.length; i++) {
				for(int j=0; j<Product.MAXRESIDUES; j++) {
					if(pro[i]!=null) {
						if(pro[i].getResidueInPositionN(j)!=null) {
							res[auxN]=pro[i].getResidueInPositionN(j);
							auxN+=1;
						}
						
					}
				}
			}
			Residue aux=null;
			for(int i=0; i<n-1; i++) {
				for(int j=0; j<n-1; j++) {
					if(res[j].calculateHarmfulness()>res[j+1].calculateHarmfulness()) {
						aux=res[j];
						res[j]=res[j+1];
						res[j+1]=aux;
					}
				}
			}
			
			for(int i=n-1; i>=0; i--) {
				info+=res[i].toString()+" and HARMFULNESS is: "+res[i].calculateHarmfulness()+"\n";
			}
		}
		else
			info="ERROR, Residues not found";
		
		return info;
	}
	/**
	 * 
	 * @param productPosition
	 * @param name
	 * @param id
	 * @param origin
	 * @param color
	 * @param descompositionTime
	 * @param suitableForComposting
	 * @return
	 */
	//añade un residuo
	public String addResidue(int productPosition, String name, String id, String origin, String color, int descompositionTime, boolean suitableForComposting) {
		String reply="Residue cant be registered";
		if(residueInfoId(id).equals("Not found") && residueInfoName(name).equals("Not found")) {
			reply=(pro[productPosition]).addResidue(name, id, origin, color, descompositionTime, suitableForComposting);
		}
		
		return reply;
	}
	/**
	 * 
	 * @param productPosition
	 * @param name
	 * @param id
	 * @param origin
	 * @param color
	 * @param descompositionTime
	 * @param type
	 * @param description
	 * @return
	 */
	public String addResidue(int productPosition, String name, String id, String origin, String color, int descompositionTime, String type,String description) {
		String reply="Residue cant be registered";
		if(residueInfoId(id).equals("Not found") && residueInfoName(name).equals("Not found")) {
			reply=(pro[productPosition]).addResidue(name, id, origin, color, descompositionTime, type, description);
		}

		return reply;
	}
	/**
	 * 
	 * @param productPosition
	 * @param name
	 * @param id
	 * @param origin
	 * @param color
	 * @param descompositionTime
	 * @param tip
	 * @return
	 */
	public String addResidue(int productPosition, String name, String id, String origin, String color, int descompositionTime, String tip) {
		String reply="Residue cant be registered";
		if(residueInfoId(id).equals("Not found") && residueInfoName(name).equals("Not found")) {
		reply=(pro[productPosition]).addResidue(name, id, origin, color, descompositionTime, tip);
		} 
		
		return reply;
	}
	
}