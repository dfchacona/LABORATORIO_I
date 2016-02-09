/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dieguischa
 */
public class Parqueadero {
    public static void main (String [] args){
        int i=0, eleccion=1; 
        int [][] esquema= new int [4][21];
        String[][] carros= new String [80][7];
        java.util.Scanner lectura= new java.util.Scanner (System.in);
        llenarEsquema(esquema);
        llenarEsquemaB(carros);
        
    do{
    	System.out.println("Digite:"
    			+ "\n1. Para esquema del parqueadero"
    			+ "\n2. Para ingreso de un carro"
    			+ "\n3. Para salida de un carro"
    			+ "\n4. Para obtener el dinero recolectado en el día ");
        eleccion = lectura.nextInt();
	switch (eleccion) {
        case 1: imprimirEsquema(esquema);  
                 break;
                 
        case 2: 
                String b=lectura.nextLine();
                System.out.println("Ingrese Placa del carro");
                String Placa=lectura.nextLine();
                carros[i][0]= Placa; 
                System.out.println("Ingrese Hora de ingreso");
                String HoraI=lectura.nextLine();
                carros[i][1]= HoraI;
                asignarCupo(esquema, carros,i);
                i++;
        	   
                break;
        case 3:; 
            String c=lectura.nextLine();
            System.out.println("Ingrese Placa del carro");
            String PlacaS=lectura.nextLine();
            salida(esquema, carros, PlacaS);  
                 break;       	 
        default: ;
                 break;
    	}
    }while (eleccion!=0);
    }    
       

    public static void llenarEsquema(int [][] esquema){
	int x=1;
	for (int i=0; i<4 ; i++) {
            for (int j = 0; j < 21; j++) {
		esquema[i][j]=x;
		x++;
            }
	}
    }            
        public static void llenarEsquemaB(String [][] esquema){
	int x=1;
	for (int i=0; i<80 ; i++) {
            for (int j = 0; j < 4; j++) {
		esquema[i][j]=("0");
	
            }
	}
    }   
    public static void imprimirEsquema(int [][] esquema){
        for (int i=0; i<4 ; i++) {
            for (int j = 0; j < 21; j++) {
                if(esquema[i][j]==0){
		System.out.print(" - ");
		}else{
                    System.out.print(esquema[i][j]+" ");
		}
            }
	System.out.println("");	
        }
    }
    
    public static int [][] asignarCupo(int [][] esquema, String [][] carros, int numCarro ){
	java.util.Scanner lectura= new java.util.Scanner (System.in);
	String tipoSilla; 
	int a=0;
        int j=0, i=0;
        do{
            if(esquema[i][j]!=0){
                System.out.println("Parquee en el espacio: "+ esquema[i][j]);
                carros [numCarro][4]=Integer.toString(i);
                carros [numCarro][5]=Integer.toString(j);
                carros [numCarro][6]=Integer.toString(esquema[i][j]);
                esquema[i][j]=0;
		a=1;
		}else{
		if (j==20){
                    j=0;
                    i++;
                }    
                j++;
                
	}}while(a==0 && i<4 && j<21);
        
        if(esquema[3][20]==0){
            System.out.println("No hay cupo");
        }
	
		
		return esquema;
	
}
    public static void salida(int [][]esquema, String [][] carros, String Placa){
        java.util.Scanner lectura= new java.util.Scanner (System.in);
        System.out.println("Ingrese hora de salida");
        int HoraS= lectura.nextInt();
        
        
            for (int j = 0; j < 80; j++) {
		if (carros[j][0].equals(Placa)){
                    
                    int HoraI=Integer.parseInt(carros[j][1]);
                    int HorasT=HoraS-HoraI;
                    String Costo= Integer.toString(HorasT*2000);
                    carros[j][3]=Costo; 
                    System.out.println(Costo);
                    esquema=reestablecerCupo(j, carros, esquema);
                }
      
    } 
    }
public static int [][] reestablecerCupo(int fila, String[][] carros, int[][] esquema){
		esquema[Integer.parseInt(carros[fila][4])][Integer.parseInt(carros[fila][5])]=Integer.parseInt(carros[fila][6]);
		for(int i=0; i<7;i++){
		carros[fila][i]=("0");
	}
		return esquema;
	}    
}
