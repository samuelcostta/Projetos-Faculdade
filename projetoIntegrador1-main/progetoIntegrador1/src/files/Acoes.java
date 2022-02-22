package files;

public class Acoes {
	
	public static String[][] interditaArea(String matriz[][], double peca, double sessao, double area){
		int linha=0, fim=0;
		if(sessao==0) {
			fim=153;
		}
		else if(sessao==2) {
			linha+=51;
		}
		else if(sessao==3) {
			linha+=102;
		}
		if(area==1) {
			fim=linha+5;
		}
		else if(area==2) {
			linha+=5;
			fim=linha+20;
		}
		else if(area==3) {
			linha+=25;
			fim=linha+10;
		}
		else if(area==4) {
			linha+=35;
			fim=linha+6;
		}
		else if(area==5) {
			linha+=41;
			fim=linha+10;
		}
		if(sessao==0) {
			fim=153;
		}
		else if(area==0) {
			fim=linha+51;
		}
		for(int i=linha;i<fim;i++) {
			for(int i2=0;i2<5;i2++) {
				matriz[i][i2]="1";
			}
		}
		return matriz;
	}

	public static String[][] incluiCPFNaMatriz(String matriz[][], double compra, double sessao, double area, String CPF){
		System.out.println("\nCompra realizada com sucesso! O localizador da compra será o CPF:"+Imprime.imprimeCPF(CPF));
		int linha=0, coluna=0;
		linha=(int) Math.floor((compra-1)/5);
		coluna=(int) ((compra-1)%5); //exemplo: compra do assento 40 do balcão nobre. Coluna=(40-1)%5=4 
		if (sessao==2) {
			linha+=51;
		}
		if (sessao==3) {
			linha+=102;
		}
		if (area==2) {
			linha+=5;
		}
		if (area==3) {
			linha+=25;
		}
		if (area==4) {
			linha+=35;
		}
		if (area==5) {
			linha+=41;
		}
		matriz[linha][coluna]=CPF;

		return matriz;
	}

	public static String[][] preencheMatriz(String matriz[][]){
		for(int i=0;i<153;i++) {
			for (int i2=0;i2<5;i2++) {
				matriz[i][i2]="";
			}
		}
		return matriz;
	}

}
