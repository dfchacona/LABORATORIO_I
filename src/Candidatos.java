public class Candidatos {
	
	public static void main (String [] args){
		int candidatos, municipios; 
		java.util.Scanner lectura= new java.util.Scanner (System.in);
		System.out.println("Ingrese el numero de municipios");
		municipios = lectura.nextInt();
		System.out.println("Ingrese el numero de candidatos");
		candidatos = lectura.nextInt();
		int MCandidatos [][]= new int [candidatos][municipios];
		
		MCandidatos=llenarMatriz(candidatos, municipios);
		imprimirMatriz(MCandidatos, candidatos, municipios);
		int totalVotos=totalVotos(MCandidatos, candidatos, municipios);
	
		System.out.println("\nTotal votos: "+totalVotos);
		porcentajes(MCandidatos, totalVotos, candidatos, municipios);
		int [] vectorGanador=ganador(MCandidatos, totalVotos, candidatos, municipios);
		if(vectorGanador[1]<=50){
			System.out.println("\nEl candidato ganador es: "+ vectorGanador[2]+" con un total de "+ vectorGanador[0]+" votos, lo que representa el "+ vectorGanador[1]+"%\n");
			int [] vectorGanadorB=ganadorAuxiliar(MCandidatos, vectorGanador, totalVotos, candidatos, municipios);
			System.out.println("\nComo el porcentaje es inferior a 50 debe realizarse segunda vuelta");
			System.out.println("Quien lo enfrentara en segunda vuelta es el candidato: "+ vectorGanadorB[2]+" con un total de "+ vectorGanadorB[0]+" votos, lo que representa el "+ vectorGanadorB[1]+"%\n");
		}else{
		System.out.println("\nEl candidato ganador es: "+ vectorGanador[2]+" con un total de "+ vectorGanador[0]+" votos, lo que representa el "+ vectorGanador[1]+"%\n");
	}
		System.out.println("El orden de los candidatos es: ");
		System.out.println("1º el candidato numero "+vectorGanador[2]+" con "+vectorGanador[0]+" votos");
		totalVotos= vectorGanador[0];
		for(int i=2; i<=candidatos;i++){
			int[] VectorGanadorB = ordenCandidatos(MCandidatos,totalVotos,candidatos,municipios);
			System.out.println("\n"+i+"º el candidato numero "+VectorGanadorB[2]+" con "+VectorGanadorB[0]+" votos");
			totalVotos=VectorGanadorB[0];
		}
		
		
	}



public static int [][] llenarMatriz(int a, int b){
	int MCandidatos [][]= new int [a][b];
	java.util.Scanner lectura= new java.util.Scanner (System.in);
	for (int i=0; i<a; i++){
		for (int j=0; j<b; j++){
			System.out.println("Ingrese la cantidad de votos del Candidato "+ (i+1)+" en el Municipio "+ (j+1)+": ");
			MCandidatos[i][j]=lectura.nextInt();	
		}
		}
	return MCandidatos; 
	}

public static void imprimirMatriz (int Matriz [][], int a, int b){
	System.out.print("             ");
	for (int i=1; i<=a; i++){
		System.out.print("Candidato "+(i)+"   ");
	}
	
	System.out.println("");
	
	for (int i=0; i<b; i++){
		
		for (int j=0; j<a; j++){
			if(j==0){
				System.out.print("Municipio "+(i+1)+"	");
			}
			System.out.print(Matriz[j][i]+"	       ");
		

		}
		System.out.println("");
	
	}	
	
}

public static int totalVotos(int Matriz [][], int a, int b){
  int totalVotos = 0;
	for (int i=0; i<b; i++){
		for (int j=0; j<a; j++){
				totalVotos=totalVotos+Matriz[j][i];
		}
        }
	
	return totalVotos;
	
	
}

public static void porcentajes(int Matriz [][],int tot,  int a, int b){
	int votosXcandidato = 0;
	for (int i=0; i<a; i++){
	
		for (int j=0; j<b; j++){
				votosXcandidato=votosXcandidato+Matriz[i][j];
				if(j+1==b){
					System.out.println("\nLa cantidad de votos del candidato "+ (i+1)+" es: "+votosXcandidato+" Y el porcentaje es: "+ ((votosXcandidato*100)/tot)+"%");
				}
		}
		
		votosXcandidato=0;
        }

}

public static int[] ganador (int Matriz [][],int tot,  int a, int b){
	int votosXcandidato=0;
	int  VectorB []= new int [3];
	int  VectorA []= new int [3];
	for (int i=0; i<a; i++){
		
		for (int j=0; j<b; j++){
			 votosXcandidato = votosXcandidato+Matriz[i][j];
		}
		VectorA [0]=votosXcandidato;
		VectorA [1]=(votosXcandidato*100/tot);
		VectorA [2]=(i+1);
		if (VectorA [0]> VectorB[0]){
			VectorB[0]=VectorA[0];
			VectorB[1]=VectorA[1];
			VectorB[2]=VectorA[2];
		}
    votosXcandidato=0;	
	}
	
	return VectorB;
	
}

public static int[] ganadorAuxiliar (int Matriz [][],int VectorG[],int tot,  int a, int b){
	int votosXcandidato=0;
	int  VectorB []= new int [3];
	int  VectorA []= new int [3];
	for (int i=0; i<a; i++){
		
		for (int j=0; j<b; j++){
			 votosXcandidato = votosXcandidato+Matriz[i][j];
		}
		VectorA [0]=votosXcandidato;
		VectorA [1]=(votosXcandidato*100/tot);
		VectorA [2]=(i+1);
		if (VectorA [0]>=VectorB[0] && VectorA[0]!=VectorG[0]){
			VectorB[0]=VectorA[0];
			VectorB[1]=VectorA[1];
			VectorB[2]=VectorA[2];
		
		}
    votosXcandidato=0;	
	}
	
	return VectorB;
	
}

public static int [] ordenCandidatos(int Matriz [][],int tot,  int a, int b){
	int votosXcandidato=0;
	int  VectorB []= new int [3];
	int  VectorA []= new int [3];
	for (int i=0; i<a; i++){
		
		for (int j=0; j<b; j++){
			 votosXcandidato = votosXcandidato+Matriz[i][j];
		}
		VectorA [0]=votosXcandidato;
		VectorA [2]=(i+1);
		if (VectorA [0]>=VectorB[0]&& VectorA[0]<tot){
			VectorB[0]=VectorA[0];
			VectorB[2]=VectorA[2];
		
		}
    votosXcandidato=0;	
	}
	
	return VectorB;
	
}
}





