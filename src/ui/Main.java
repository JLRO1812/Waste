package ui;

import java.util.Scanner;

import model.App;

public class Main {
	
	private App app;
	private Scanner scanNum;
	private Scanner scanLec;
	
	public static void main(String [] args){
		Main main=new Main();
		main.menu();
	}
	
	public Main() {
		scanNum=new Scanner(System.in);
		scanLec=new Scanner(System.in);
		System.out.println("How many products do you want your app to store?");
		app=new App(scanNum.nextInt());
	}
	
	public void menu() {
		int option=0;
		System.out.println("Welcome to the residue app");
		System.out.println("choose your option");
		while(option!=10) {
			System.out.println("1. for add product");
			System.out.println("2. for add residue");
			System.out.println("3. for show the all registered products");
			System.out.println("4. for show the report of all recidues");
			System.out.println("5. for show the information of a residue depending on the name entered ");
			System.out.println("6. for show the information of the residues related to the product that depends on the id entered");
			System.out.println("7. for calculate if a residue is usable");
			System.out.println("8. for calculate harmful effect of a residue");
			System.out.println("9. for generate a report of waste depending on its harmful effect");
			System.out.println("10. for exit");
			option=scanNum.nextInt();
			switch(option) {
			case 1:addProduct();
					break;
			case 2:checkProduct();
					break;
			case 3:System.out.println(app.showRegisteredProducts());
					break;
			case 4:System.out.println(app.report());
					break;
			case 5:System.out.println(app.residueInfoName(askForName()));
					break;
			case 6:residuesByIdProduct();
					break;
			case 7:System.out.println(app.isItUsable(askForName()));
					break;
			case 8:System.out.println(app.calculateHarmfulness(askForName()));
					break;
			case 9:System.out.println(app.harmfulnessReport());
					break;
			}
		}
	}

	//complete
	public void addProduct() {
		System.out.println("Type the name");
		String name=scanLec.nextLine();
		name=name.toLowerCase();
		System.out.println("Type the id");
		String id=scanLec.nextLine();
		id=id.toLowerCase();
		System.out.println("Type a description");
		String description=scanLec.nextLine();
		description=description.toLowerCase();
		String reply=app.addProduct(name, id, description);
		System.out.println(reply);
	}
	/**
	 * 
	 * @param name
	 * @return
	 */
	public String addProductWithName(String name) {
		System.out.println("Do you want to change the name you entered before?");
		String answer=scanLec.nextLine();
		answer=answer.toLowerCase();
		if(answer.equals("yes")) {
			name=scanLec.nextLine();
			name=name.toLowerCase();
		}
		System.out.println("Type id");
		String id=scanLec.nextLine();
		id=id.toLowerCase();
		System.out.println("Type description");
		String description=scanLec.nextLine();
		description=description.toLowerCase();
		String reply=app.addProduct(name, id, description);
		System.out.println(reply);
		
		return name;
	}

	public void checkProduct() {
		System.out.println("What product is associated with the waste to be registered? Type the name");
		String nameProduct=scanLec.nextLine();
		nameProduct=nameProduct.toLowerCase();
		if(app.theNameAlreadyExists(nameProduct)==true) {
			addResidue(nameProduct);
		}
		else {
			System.out.println("The product has not been registered, do you want to register it?");
			String answer=scanLec.nextLine();
			answer=answer.toLowerCase();
			if(answer.equals("yes")) {
				nameProduct=addProductWithName(nameProduct);
				addResidue(nameProduct);
			}
		}
	}
	/**
	 * 
	 * @param nameProduct
	 */
	public void addResidue(String nameProduct) {
		
		int option=0;
		while (option!=1 && option!=2 && option!=3 && option!=4) {
			System.out.println("What type of waste will you add?");
			System.out.println("1. biodegradable");
			System.out.println("2. recyclable");
			System.out.println("3. inert");
			System.out.println("4. Cancel");
			option=scanNum.nextInt();
			switch(option) {
			case 1:addResidueBio(nameProduct);
					break;
			case 2:addResidueRec(nameProduct);
					break;
			case 3:addResidueIne(nameProduct);
					break;
			default: System.out.println("Option no valid");
			}
		}
		
	}
	/**
	 * 
	 * @param nameProduct
	 */
	public void addResidueBio(String nameProduct) {
		System.out.println("Remember that the names of the residue and their id are unique");
		System.out.println("Type name");
		String name=scanLec.nextLine();
		name=name.toLowerCase();
		System.out.println("Type id");
		String id=scanLec.nextLine();
		id=id.toLowerCase();
		int option1=0;
		String origin="";
		while(option1!=1 && option1!=2 && option1!=3 && option1!=4 && option1!=5) {
			System.out.println("Choose the origin");
			System.out.println("1 industrial");
			System.out.println("2 building");
			System.out.println("3 hospitals");
			System.out.println("4 municipal");
			System.out.println("5 domiciliary");
			option1=scanNum.nextInt();
			switch(option1) {
			case 1:origin="industrial";
					break;
			case 2:origin="building";
					break;
			case 3:origin="hospitals";
					break;
			case 4:origin="municipal";
					break;
			case 5:origin="domiciliary";
					break;
			default: System.out.println("Option not valid");
			
			}
		}
		System.out.println("Type color");
		String color=scanLec.nextLine();
		color=color.toLowerCase();
		System.out.println("Type descomposition time in days. Example: 1, 2 ,3 ...");
		int descompositionTime=scanNum.nextInt();
		System.out.println("is suitable for compostin? yes or no");
		String answer=scanLec.nextLine();
		answer=answer.toLowerCase();
		boolean suitableForComposting;
		if(answer.equals("yes"))
			suitableForComposting=true;
		else
			suitableForComposting=false;
		String reply=app.addResidue(app.productPositionByName(nameProduct), name, id, origin, color, descompositionTime, suitableForComposting);
		System.out.println(reply);
		
	}
	/**
	 * 
	 * @param nameProduct
	 */
	public void addResidueRec(String nameProduct) {
		System.out.println("Remember that the names of the residue and their id are unique");
		System.out.println("Type name");
		String name=scanLec.nextLine();
		name=name.toLowerCase();
		System.out.println("Type id");
		String id=scanLec.nextLine();
		id=id.toLowerCase();
		int option1=0;
		String origin="";
		while(option1!=1 && option1!=2 && option1!=3 && option1!=4 && option1!=5) {
			System.out.println("Choose the origin");
			System.out.println("1 industrial");
			System.out.println("2 building");
			System.out.println("3 hospitals");
			System.out.println("4 municipal");
			System.out.println("5 domiciliary");
			option1=scanNum.nextInt();
			switch(option1) {
			case 1:origin="industrial";
					break;
			case 2:origin="building";
					break;
			case 3:origin="hospitals";
					break;
			case 4:origin="municipal";
					break;
			case 5:origin="domiciliary";
					break;
			default: System.out.println("Option not valid");
			
			}
		}
		System.out.println("Type color");
		String color=scanLec.nextLine();
		color=color.toLowerCase();
		System.out.println("Type descomposition time in days. Example: 1, 2 ,3 ...");
		int descompositionTime=scanNum.nextInt();
		int option=0;
		String type="";
		while(option!=1 && option!=2 && option!=3) {
			System.out.println("choose the type");
			System.out.println("1 glass");
			System.out.println("2 plastic");
			System.out.println("3 metal");
			option=scanNum.nextInt();
			switch(option) {
			case 1:type="glass";
					break;
			case 2:type="plastic";
					break;
			case 3:type="metal";
					break;
			default: System.out.println("Option not valid");
			}
		}
		System.out.println("You want add description? yes or no");
		String description;
		String answer=scanLec.nextLine();
		answer=answer.toLowerCase();
		if(answer.equals("yes")) {
			description=scanLec.nextLine();
		}
		else
			description=null;
		
		String reply=app.addResidue(app.productPositionByName(nameProduct), name, id, origin, color, descompositionTime, type, description);
		System.out.println(reply);
		
	}
	/**
	 * 
	 * @param nameProduct
	 */
	public void addResidueIne(String nameProduct) {
		System.out.println("Remember that the names of the residue and their id are unique");
		System.out.println("Type name");
		String name=scanLec.nextLine();
		name=name.toLowerCase();
		System.out.println("Type id");
		String id=scanLec.nextLine();
		id=id.toLowerCase();
		int option1=0;
		String origin="";
		while(option1!=1 && option1!=2 && option1!=3 && option1!=4 && option1!=5) {
			System.out.println("Choose the origin");
			System.out.println("1 industrial");
			System.out.println("2 building");
			System.out.println("3 hospitals");
			System.out.println("4 municipal");
			System.out.println("5 domiciliary");
			option1=scanNum.nextInt();
			switch(option1) {
			case 1:origin="industrial";
					break;
			case 2:origin="building";
					break;
			case 3:origin="hospitals";
					break;
			case 4:origin="municipal";
					break;
			case 5:origin="domiciliary";
					break;
			default: System.out.println("Option not valid");
			
			}
		}
		System.out.println("Type color");
		String color=scanLec.nextLine();
		color=color.toLowerCase();
		System.out.println("Type descomposition time in days. Example: 1, 2 ,3 ...");
		int descompositionTime=scanNum.nextInt();
		System.out.println("enter a tip to reduce its use");
		String tip=scanLec.nextLine();
		String reply=app.addResidue(app.productPositionByName(nameProduct), name, id, origin, color, descompositionTime, tip);
		System.out.println(reply);
	}
	/**
	 * 
	 * @return
	 */
	public String askForName() {
		System.out.println("Write the name of the residue that you want search");
		String name=scanLec.nextLine();
		return name;
	}

	public void residuesByIdProduct() {
		System.out.println("Write the id of the product");
		String id=scanLec.nextLine();
		String info="Product cant be found";
		if(app.productById(id)!=null) {
			info=(app.productById(id)).toString()+(app.productById(id)).searchBio()+(app.productById(id)).searchInert()+(app.productById(id)).searchRecy();
		}
		
		System.out.println(info);
	}
}