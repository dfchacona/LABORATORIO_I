
public class Avión {
	
	public static void main(String[] args) {
	int [][] esquema= new int [9][7];
	String [][] pasajeros= new String [100][7];
	llenarEsquema(esquema);
        llenarEsquemaB(pasajeros);
	java.util.Scanner lectura= new java.util.Scanner (System.in);

	int i=0;
	int eleccion=0;
    do{
    	System.out.println("Digite:"
    			+ "\n1. Para esquema del avion"
    			+ "\n2. Para asignar un asiento (por disponiblilidad)"
    			+ "\n3. Para asignar un asiento (por numero de silla)"
    			+ "\n4. Para anular una reserva"
    			+ "\n5. Para ubicar a un pasajero"
    			+ "\n6. Para conocer la cantidad de asientos de ventana disponibles en clase economica"
    			+ "\n7. Para conocer la cantidad de sillas de clase ejecutiva ocupadas"
    			+ "\n8. Para ubicar una silla economica libre"
    			+ "\n9. Para conocer si hay 2 pasajeros con el mismo nombre en clase economica"
    			+ "\n0. Para finalizar el programa");
    eleccion = lectura.nextInt();
	switch (eleccion) {
        case 1: imprimirEsquema(esquema);  
                 break;
                 
        case 2:
        	   String b=lectura.nextLine();
        	   System.out.println("Nombre de pasajero: ");  
        	   pasajeros[i][0]=lectura.nextLine();
        	   System.out.println("Documento de pasajero : ");  
        	   pasajeros[i][1]=lectura.nextLine(); 
        	   System.out.println("¿Clase Ejecutiva(E) o Economica(C)?"); 
        	   pasajeros[i][2]=lectura.nextLine();
        	  
        	   if(pasajeros[i][2].equals("C")||pasajeros[i][2].equals("c")){
        		   esquema=asignarPasajeroEconomica(esquema, pasajeros, i);
        	
        	   }
        	   
        	   if(pasajeros[i][2].equals("E")||pasajeros[i][2].equals("e")){
        		   esquema=asignarPasajeroEjecutiva(esquema, pasajeros, i);
        	   }
        	   pasajeros[i][3]=Integer.toString(i);
        	   System.out.println("El numero del pasajero es: "+(Integer.parseInt(pasajeros[i][3])+1)
        	   		+ "\nEl asiento asignado es: "+pasajeros[i][6]);
        	   i++;
        	   
                break;
        case 3:
     	   String c=lectura.nextLine();
     	   System.out.println("Nombre de pasajero: ");  
     	   pasajeros[i][0]=lectura.nextLine();
     	   System.out.println("Documento de pasajero: ");  
     	   pasajeros[i][1]=lectura.nextLine(); 
     	   System.out.println("Numero de asiento");
     	   pasajeros[i][6]=lectura.nextLine();
     	   
     	   esquema=asignarPasajeroV(esquema, pasajeros, i, Integer.parseInt(pasajeros[i][6]) );
     	   
     	   pasajeros[i][3]=Integer.toString(i);
     	   System.out.println("El numero del pasajero es: "+(Integer.parseInt(pasajeros[i][3])+1)
     	   		+ "\nEl asiento asignado es: "+pasajeros[i][6]);
     	   i++;
     
             break;        
        case 4: 
        	System.out.println("Ingrese numero de pasajero"); 
     	    int numPasajero=lectura.nextInt();
        	anularReserva((numPasajero-1), pasajeros, esquema);
        	 break;
        case 5: 
        	System.out.println("Ingrese numero de documento del pasajero"); 
        	int docPasajero=lectura.nextInt();
        	String cedula=Integer.toString(docPasajero);
        	System.out.println("");
     	    System.out.println("El numero del asiento del pasajero es:"+ ubicarPasajero(pasajeros, cedula) );
     	   break;
        case 6:
        	 cantidadVentanas(esquema);
        	 break;
        case 7:
        	 sillasEjecutivas(esquema);
        	 break;	
        case 8:
        	 sillaEconomicaLibre(esquema);
        	 break;	
        case 9:
       	 nombrePasajero(pasajeros, i);
       	 	 break;        	 
        default: ;
                 break;
    	}
    }while (eleccion!=0);
	}	
    
	public static void llenarEsquema(int [][] esquema){
		int x=1;
		for (int i=0; i<9 ; i++) {
			for (int j = 0; j < 7; j++) {
				if(i<2&&(j==2||j==3||j==4)){
					esquema[i][j]=0;
				}else{
					if(j==3){
						esquema[i][j]=0;
					}else{
						esquema[i][j]=x;
						x++;
					}
				}
			}
		}
	}
	public static void llenarEsquemaB(String [][] esquema){
		int x=1;
		for (int i=0; i<100 ; i++) {
			for (int j = 0; j < 7; j++) {
				esquema[i][j]=("0");
				
					}
				
			
		
	}
        }
	public static void imprimirEsquema(int [][] esquema){
		for (int i=0; i<9 ; i++) {
			if(i==0||i==1){
				System.out.print("  ");
			}
		
			for (int j = 0; j < 7; j++) {
				
				if(esquema[i][j]==0){
					System.out.print(" - ");
				}else{
					System.out.print(esquema[i][j]+" ");
				}
			
			}
			System.out.println("");	
		}
	}
	
	public static int [][] asignarPasajeroEconomica(int [][] esquemaViejo, String [][] pasajero, int numeroPasajero){
		java.util.Scanner lectura= new java.util.Scanner (System.in);
		String tipoSilla; 
		int a=0, i=2;
		System.out.println("¿Ventana(V), pasillo(P) o centro(C)?");
		tipoSilla=lectura.nextLine();
		if(tipoSilla.equals("c")||tipoSilla.equals("C")){
			do {
				if(esquemaViejo[i][1]!=0){
					pasajero[numeroPasajero][6]=Integer.toString(esquemaViejo[i][1]);
					pasajero[numeroPasajero][4]=Integer.toString(i);
					pasajero[numeroPasajero][5]=Integer.toString(1);
					esquemaViejo[i][1]=0;
					
					a=1;
				}else{
					if(esquemaViejo[i][5]!=0){
						pasajero[numeroPasajero][6]=Integer.toString(esquemaViejo[i][5]);
						pasajero[numeroPasajero][4]=Integer.toString(i);
						pasajero[numeroPasajero][5]=Integer.toString(5);
						esquemaViejo[i][5]=0;
						a=1;
					
				}else{
					i++;
				}}
		}while(a==0);	
	}
		if(tipoSilla.equals("V")||tipoSilla.equals("v")){
			do {
				if(esquemaViejo[i][0]!=0){
					pasajero[numeroPasajero][6]=Integer.toString(esquemaViejo[i][0]);
					pasajero[numeroPasajero][4]=Integer.toString(i);
					pasajero[numeroPasajero][5]=Integer.toString(0);
					esquemaViejo[i][0]=0;
					a=1;
				}else{
					if(esquemaViejo[i][6]!=0){
						pasajero[numeroPasajero][6]=Integer.toString(esquemaViejo[i][6]);
						pasajero[numeroPasajero][4]=Integer.toString(i);
						pasajero[numeroPasajero][5]=Integer.toString(6);
						esquemaViejo[i][6]=0;
						a=1;
					
				}else{
					i++;
				}}
		}while(a==0);	
	}
		if(tipoSilla.equals("P")||tipoSilla.equals("p")){
			do {
				if(esquemaViejo[i][2]!=0){
					pasajero[numeroPasajero][6]=Integer.toString(esquemaViejo[i][2]);
					pasajero[numeroPasajero][4]=Integer.toString(i);
					pasajero[numeroPasajero][5]=Integer.toString(2);
					esquemaViejo[i][2]=0;
					a=1;
				}else{
					if(esquemaViejo[i][4]!=0){
						pasajero[numeroPasajero][6]=Integer.toString(esquemaViejo[i][4]);
						pasajero[numeroPasajero][4]=Integer.toString(i);
						pasajero[numeroPasajero][5]=Integer.toString(4);
						esquemaViejo[i][4]=0;
						a=1;
					
				}else{
					i++;
				}}
		}while(a==0);	
	}
		return esquemaViejo;
	
}
	public static int [][] asignarPasajeroV(int [][] esquemaViejo, String [][] pasajero, int numeroPasajero, int asiento){
		java.util.Scanner lectura= new java.util.Scanner (System.in);

		int a=0, j=0, i=2;
		do{
			if (esquemaViejo[i][j]==asiento){
				  a=1;	
				  pasajero[numeroPasajero][6]=Integer.toString(esquemaViejo[i][j]);
				  pasajero[numeroPasajero][4]=Integer.toString(i);
				  pasajero[numeroPasajero][5]=Integer.toString(j);
				  esquemaViejo[i][j]=0;
				  
			}
		j++;
		if(j==7){
			j=0;
			i++;
		}
		}while (a==0 || j==7 && i==9);
		if (a==0){
			System.out.println("Asiento Ocupado");
		}
		return esquemaViejo;

	
}
	public static int [][] asignarPasajeroEjecutiva(int [][] esquemaViejo, String [][] pasajero, int numeroPasajero){
		java.util.Scanner lectura= new java.util.Scanner (System.in);
		String tipoSilla; 
		int a=0, i=0;
		System.out.println("¿Ventana(V) o pasillo(P)?");
		tipoSilla=lectura.nextLine();
		if(tipoSilla.equals("V")||tipoSilla.equals("V")){
			do {
				if(esquemaViejo[i][0]!=0){
					pasajero[numeroPasajero][6]=Integer.toString(esquemaViejo[i][0]);
					pasajero[numeroPasajero][4]=Integer.toString(i);
					pasajero[numeroPasajero][5]=Integer.toString(0);
					esquemaViejo[i][0]=0;
					a=1;
				}else{
					if(esquemaViejo[i][6]!=0){
						pasajero[numeroPasajero][6]=Integer.toString(esquemaViejo[i][6]);
						pasajero[numeroPasajero][4]=Integer.toString(i);
						pasajero[numeroPasajero][5]=Integer.toString(6);
						esquemaViejo[i][6]=0;
						a=1;
					
				}else{
					i++;
				}}
		}while(a==0 && i<=1);	
	}

		if(tipoSilla.equals("P")||tipoSilla.equals("p")){
			do {
				if(esquemaViejo[i][1]!=0){
					pasajero[numeroPasajero][6]=Integer.toString(esquemaViejo[i][1]);
					pasajero[numeroPasajero][4]=Integer.toString(i);
					pasajero[numeroPasajero][5]=Integer.toString(1);
					esquemaViejo[i][1]=0; 
					a=1;
				}else{
					if(esquemaViejo[i][5]!=0){
						pasajero[numeroPasajero][6]=Integer.toString(esquemaViejo[i][5]);
						pasajero[numeroPasajero][4]=Integer.toString(i);
						pasajero[numeroPasajero][5]=Integer.toString(5);
						esquemaViejo[i][5]=0;
						a=1;
					
				}else{
					i++;
				}}
		}while(a==0 && i<=1);	
	}
		
		return esquemaViejo;
	
}	
	public static int [][] anularReserva(int numPasajero, String[][] pasajeros, int[][] esquema){
		esquema[Integer.parseInt(pasajeros[numPasajero][4])][Integer.parseInt(pasajeros[numPasajero][5])]=Integer.parseInt(pasajeros[numPasajero][6]);
		for(int i=0; i<7;i++){
		pasajeros[numPasajero][i]=("0");
	}
		System.out.println("RESERVA ANULADA");
		return esquema;
	}
	public static String ubicarPasajero (String [][] pasajeros, String cedula){
			
			for (int i=0; i<50; i++){
				if(pasajeros[i][1].equals(cedula)){
					String asientoPasajero=pasajeros[i][6];
					return asientoPasajero;
				}
			

	}
			return null;
}
	public static void cantidadVentanas(int [][] esquema){
			int ventanas=0;
			for(int i=2; i<9; i++ ){
			if(esquema[i][0]!=0){
			ventanas++;
			}
			if(esquema[i][6]!=0){
				ventanas++;
		    }
			
			}
			System.out.println("La cantidad de ventanas disponibles son: "+ventanas);
			
			
		}
	public static void sillasEjecutivas(int [][] esquema){
			int ocupadas=0;
			for(int i=0; i<2; i++ ){
				for(int j=0; j<7;j++){
			if(esquema[i][j]==0){
			ocupadas++;
			
		    }
			}
			}
			System.out.println("La cantidad de sillas ocupadas son: "+(ocupadas-6));
			
		}
	public static void sillaEconomicaLibre(int[][] esquema){
        int i=2, j=0, a=0, sillaDisponible=0;
        do{
        	if(esquema[i][j]!=0){
        		sillaDisponible=esquema[i][j];
        		a=1;
        		if(j==0||j==6){
        			System.out.println("La primera silla disponible en clase economica es: "+sillaDisponible+ " (Ventana)");	
        		}
        		if(j==1||j==5){
        			System.out.println("La primera silla disponible en clase economica es: "+sillaDisponible+ " (Centro)");	
        		}
        		if(j==2||j==4){
        			System.out.println("La primera silla disponible en clase economica es: "+sillaDisponible+" (Pasillo)");	
        		}
        	}else{
        		i++;
        		j++;
        	}
        }while(i<9 && j<7 && a==0);
			
		}
	public static void nombrePasajero(String [][] pasajeros, int numeroPasajeros){
		int i=0, j=0, a=0;
		do{
			
			if (pasajeros[i][0].equals(pasajeros[j][0]) && j!=i && pasajeros[i][0]!=("0") && pasajeros[i][3].equalsIgnoreCase("c")){
				  a=1;	
				  System.out.println("Si los hay"+" ( "+pasajeros[i][0]+" )");
			}
		j++;
                if (j==99){
                    j=0; 
                    i++;
                }
		
		}while (a==0 && j<100 && i<100);
		if (a==0){
			System.out.println("No los hay");
		}
	
			
		}
		
	}




