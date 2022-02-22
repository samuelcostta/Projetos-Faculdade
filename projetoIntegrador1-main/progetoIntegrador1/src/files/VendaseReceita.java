package files;

import java.text.DecimalFormat;

public class VendaseReceita {
	
	//Menu
	
	public static void imprimeVendasReceita(double menu3, String hamlet[][], String fera[][], String romeu[][], DecimalFormat df) {
		if (menu3==1) {
			System.out.println(Colors.BLACK_BOLD+"\nEstatíticas de vendas\n"+Colors.RESET);
			vendaPorPeca(hamlet,fera,romeu);
			System.out.println();
			vendaPorSessao(hamlet,fera,romeu);
			System.out.println();
		}
		if(menu3==2) {
			System.out.println(Colors.BLACK_BOLD+"\nEstatíticas de receita\n"+Colors.RESET);
			lucroPorPeca(hamlet,fera,romeu, df);
			System.out.println();
			lucroPorSessao(hamlet,fera,romeu, df);
			System.out.println();
			lucroPorArea(hamlet,fera,romeu, df);
			System.out.println();
			imprimeReceitaTotal(hamlet, fera, romeu, df);
			System.out.println();
		}
	}
	
	//Vendas
	
	public static void vendaPorPeca(String hamlet[][], String fera[][], String romeu[][]) {
		int i, i2, cHamlet=0, cFera=0, cRomeu=0;

		for (i=0;i<153;i++) {
			for (i2=0;i2<5;i2++) {
				if(hamlet[i][i2].length()>4) {
					cHamlet++;
				}
				if(fera[i][i2].length()>4) {
					cFera++;
				}
				if(romeu[i][i2].length()>4) {
					cRomeu++;
				}
			}
		}
		if(cHamlet>cFera&&cHamlet>cRomeu) {
			System.out.println("A peça "+Imprime.imprimePeca(1)+" vendeu mais ingressos: "+cHamlet);
			if(cFera>cRomeu) {
				System.out.println("A peça "+Imprime.imprimePeca(3)+" vendeu menos ingressos: "+cRomeu);
			}
			else if(cRomeu>cFera) {
				System.out.println("A peça "+Imprime.imprimePeca(2)+" vendeu menos ingressos: "+cFera);
			}
			else {
				System.out.println("As peças "+Imprime.imprimePeca(2)+" e "+Imprime.imprimePeca(3)+" venderam menos ingressos: "+cFera);
			}
		}
		else if(cFera>cHamlet&&cFera>cRomeu) {
			System.out.println("A peça "+Imprime.imprimePeca(2)+" vendeu mais ingressos: "+cFera);
			if(cHamlet>cRomeu) {
				System.out.println("A peça "+Imprime.imprimePeca(3)+" vendeu menos ingressos: "+cRomeu);
			}
			else if(cRomeu>cHamlet) {
				System.out.println("A peça "+Imprime.imprimePeca(1)+" vendeu menos ingressos: "+cHamlet);
			}
			else {
				System.out.println("As peças "+Imprime.imprimePeca(1)+" e "+Imprime.imprimePeca(3)+" venderam menos ingressos: "+cRomeu);
			}
		}
		else if(cRomeu>cFera&&cRomeu>cHamlet) {
			System.out.println("A peça "+Imprime.imprimePeca(3)+" vendeu mais ingressos: "+cRomeu);
			if(cHamlet>cFera) {
				System.out.println("A peça "+Imprime.imprimePeca(2)+" vendeu menos ingressos: "+cFera);
			}
			else if(cHamlet<cFera) {
				System.out.println("A peça "+Imprime.imprimePeca(1)+" vendeu menos ingressos: "+cHamlet);
			}
			else {
				System.out.println("As peças "+Imprime.imprimePeca(1)+" e "+Imprime.imprimePeca(2)+" venderam menos ingressos: "+cHamlet);
			}
		}
		else if(cRomeu==cFera&&cRomeu>cHamlet) {
			System.out.println("As peças "+Imprime.imprimePeca(2)+" e "+Imprime.imprimePeca(3)+" venderam mais ingressos: "+cRomeu);
			System.out.println("A peça "+Imprime.imprimePeca(1)+" vendeu menos ingresso: "+cHamlet);
		}
		else if(cRomeu==cHamlet&&cRomeu>cFera) {
			System.out.println("As peças "+Imprime.imprimePeca(1)+" e "+Imprime.imprimePeca(3)+" venderam mais ingressos: "+cHamlet);
			System.out.println("A peça "+Imprime.imprimePeca(2)+" vendeu menos ingressos: "+cFera);
		}
		else if(cFera==cHamlet&&cFera>cRomeu) {
			System.out.println("As peças "+Imprime.imprimePeca(1)+" e "+Imprime.imprimePeca(2)+" venderam mais ingressos: "+cHamlet);
			System.out.println("A peça "+Imprime.imprimePeca(3)+" vendeu menos ingressos: "+cRomeu);
		}
		else if(cFera==cHamlet&&cFera==cRomeu) {
			System.out.println("As peças "+Imprime.imprimePeca(1)+", "+Imprime.imprimePeca(2)+" e "+Imprime.imprimePeca(3)+" venderam o mesmo número de ingressos: "+cHamlet);
		}

	}
	
	public static void vendaPorSessao(String hamlet[][], String fera[][], String romeu[][]) {
		int i, i2, manha=0, tarde=0, noite=0;

		for (i=0;i<153;i++) {
			for (i2=0;i2<5;i2++) {
				if(i<51) {
					if(hamlet[i][i2].length()>4) {
						manha++;
					}
					if(fera[i][i2].length()>4) {
						manha++;
					}
					if(romeu[i][i2].length()>4) {
						manha++;
					}
				}
				else if(i<102) {
					if(hamlet[i][i2].length()>4) {
						tarde++;
					}
					if(fera[i][i2].length()>4) {
						tarde++;
					}
					if(romeu[i][i2].length()>4) {
						tarde++;
					}
				}
				else {
					if(hamlet[i][i2].length()>4) {
						noite++;
					}
					if(fera[i][i2].length()>4) {
						noite++;
					}
					if(romeu[i][i2].length()>4) {
						noite++;
					}
				}
			}
		}
		if(manha>tarde&&manha>noite) {
			System.out.println("As peças venderam mais ingressos no período matutino: "+manha);
			if(tarde>noite) {
				System.out.println("As peças venderam menos ingressos no período noturno: "+noite);
			}
			else if(noite>tarde) {
				System.out.println("As peças venderam menos ingressos no período vespertino: "+tarde);
			}
			else {
				System.out.println("As peças noturnas e vespertinas venderam menos ingressos: "+tarde);
			}
		}
		else if(tarde>manha&&tarde>noite) {
			System.out.println("As peças venderam mais ingressos no período vespertino: "+tarde);
			if(manha>noite) {
				System.out.println("As peças venderam menos ingressos no período noturno: "+noite);
			}
			else if(noite>manha) {
				System.out.println("As peças venderam menos ingressos no período matutino: "+manha);
			}
			else {
				System.out.println("As peças noturnas e matutinas venderam menos ingressos: "+noite);
			}
		}
		else if(noite>tarde&&noite>manha) {
			System.out.println("As peças venderam mais ingressos no período noturno: "+noite);
			if(manha>tarde) {
				System.out.println("As peças venderam menos ingressos no período vespertino: "+tarde);
			}
			else if(manha<tarde) {
				System.out.println("As peças venderam menos ingressos no período matutino: "+manha);
			}
			else {
				System.out.println("As peças matutinas e vespertinas venderam menos ingressos: "+tarde);
			}
		}
		else if(noite==tarde&&noite>manha) {
			System.out.println("As peças vespertinas e noturnas venderam mais ingressos: "+tarde);
			System.out.println("As peças venderam menos ingressos no período matutino: "+manha);
		}
		else if(noite==manha&&noite>tarde) {
			System.out.println("As peças matutinas e noturnas venderam mais ingressos: "+manha);
			System.out.println("As peças venderam menos ingressos no período vespertino: "+tarde);
		}
		else if(tarde==manha&&tarde>noite) {
			System.out.println("As peças matutinas e vespertinas venderam mais ingressos: "+manha);
			System.out.println("As peças venderam menos ingressos no período noturno: "+noite);
		}
		else if(tarde==manha&&tarde==noite) {
			System.out.println("As peças matutinas, vespertinas e noturnas venderam o mesmo número de ingressos: "+manha);
		}
	}
	
	//Receita
		
	public static void imprimeReceitaTotal(String hamlet[][], String fera[][], String romeu[][], DecimalFormat df) {
		double soma=0;

		for(int i=0;i<153;i++) {
			for(int i2=0;i2<5;i2++) {
				if(hamlet[i][i2].length()>4) {
					if(i<=4){
						soma+=40; 
					}
					else if(i<=24) {
						soma+=60; 
					}
					else if (i<=34) {
						soma+=80; 		
					}
					else if (i<=40) {
						soma+=120; 	
					}
					else if (i<=50) {
						soma+=250; 	
					}
					else if(i<=55) {
						soma+=40;
					}
					else if(i<=75) {
						soma+=60;
					}
					else if(i<=85) {
						soma+=80;
					}
					else if(i<=91) {
						soma+=120;
					}
					else if(i<=101) {
						soma+=250;
					}
					else if(i<=106) {
						soma+=40;
					}
					else if(i<=126) {
						soma+=60;
					}
					else if(i<=136) {
						soma+=80;
					}
					else if(i<=142) {
						soma+=120;
					}
					else if(i<=152) {
						soma+=250;
					}
				}
				if(fera[i][i2].length()>4) {
					if(i<=4){
						soma+=40; 
					}
					else if(i<=24) {
						soma+=60; 
					}
					else if (i<=34) {
						soma+=80; 		
					}
					else if (i<=40) {
						soma+=120; 	
					}
					else if (i<=50) {
						soma+=250; 	
					}
					else if(i<=55) {
						soma+=40;
					}
					else if(i<=75) {
						soma+=60;
					}
					else if(i<=85) {
						soma+=80;
					}
					else if(i<=91) {
						soma+=120;
					}
					else if(i<=101) {
						soma+=250;
					}
					else if(i<=106) {
						soma+=40;
					}
					else if(i<=126) {
						soma+=60;
					}
					else if(i<=136) {
						soma+=80;
					}
					else if(i<=142) {
						soma+=120;
					}
					else if(i<=152) {
						soma+=250;
					}
				}
				if(romeu[i][i2].length()>4) {
					if(i<=4){
						soma+=40; 
					}
					else if(i<=24) {
						soma+=60; 
					}
					else if (i<=34) {
						soma+=80; 		
					}
					else if (i<=40) {
						soma+=120; 	
					}
					else if (i<=50) {
						soma+=250; 	
					}
					else if(i<=55) {
						soma+=40;
					}
					else if(i<=75) {
						soma+=60;
					}
					else if(i<=85) {
						soma+=80;
					}
					else if(i<=91) {
						soma+=120;
					}
					else if(i<=101) {
						soma+=250;
					}
					else if(i<=106) {
						soma+=40;
					}
					else if(i<=126) {
						soma+=60;
					}
					else if(i<=136) {
						soma+=80;
					}
					else if(i<=142) {
						soma+=120;
					}
					else if(i<=152) {
						soma+=250;
					}
				}

			}
		}

		System.out.println("A receita de todos os ingressos vendidos é: "+df.format(soma));
	}// end receita total
	
	public static void lucroPorArea(String hamlet[][], String fera[][], String romeu[][], DecimalFormat df) {
		int i, i2; 
		double area1=0, area2=0, area3=0, area4=0, area5=0;

		for (i=0;i<153;i++) {
			for (i2=0;i2<5;i2++) {
				if(hamlet[i][i2].length()>4) {
					if(i<=4){
						area1+=40; 
					}
					else if(i<=24) {
						area2+=60; 
					}
					else if (i<=34) {
						area3+=80; 		
					}
					else if (i<=40) {
						area4+=120; 	
					}
					else if (i<=50) {
						area5+=250; 	
					}
					else if(i<=55) {
						area1+=40;
					}
					else if(i<=75) {
						area2+=60;
					}
					else if(i<=85) {
						area3+=80;
					}
					else if(i<=91) {
						area4+=120;
					}
					else if(i<=101) {
						area5+=250;
					}
					else if(i<=106) {
						area1+=40;
					}
					else if(i<=126) {
						area2+=60;
					}
					else if(i<=136) {
						area3+=80;
					}
					else if(i<=142) {
						area4+=120;
					}
					else if(i<=152) {
						area5+=250;
					}
				}
				if(fera[i][i2].length()>4) {
					if(i<=4){
						area1+=40; 
					}
					else if(i<=24) {
						area2+=60; 
					}
					else if (i<=34) {
						area3+=80; 		
					}
					else if (i<=40) {
						area4+=120; 	
					}
					else if (i<=50) {
						area5+=250; 	
					}
					else if(i<=55) {
						area1+=40;
					}
					else if(i<=75) {
						area2+=60;
					}
					else if(i<=85) {
						area3+=80;
					}
					else if(i<=91) {
						area4+=120;
					}
					else if(i<=101) {
						area5+=250;
					}
					else if(i<=106) {
						area1+=40;
					}
					else if(i<=126) {
						area2+=60;
					}
					else if(i<=136) {
						area3+=80;
					}
					else if(i<=142) {
						area4+=120;
					}
					else if(i<=152) {
						area5+=250;
					}
				}
				if(romeu[i][i2].length()>4) {
					if(i<=4){
						area1+=40; 
					}
					else if(i<=24) {
						area2+=60; 
					}
					else if (i<=34) {
						area3+=80; 		
					}
					else if (i<=40) {
						area4+=120; 	
					}
					else if (i<=50) {
						area5+=250; 	
					}
					else if(i<=55) {
						area1+=40;
					}
					else if(i<=75) {
						area2+=60;
					}
					else if(i<=85) {
						area3+=80;
					}
					else if(i<=91) {
						area4+=120;
					}
					else if(i<=101) {
						area5+=250;
					}
					else if(i<=106) {
						area1+=40;
					}
					else if(i<=126) {
						area2+=60;
					}
					else if(i<=136) {
						area3+=80;
					}
					else if(i<=142) {
						area4+=120;
					}
					else if(i<=152) {
						area5+=250;
					}
				}
			}
		}

		if(area1==area2&&area1==area3&&area1==area4&&area1==area5) {
			System.out.println("Todas as áreas tiveram o mesmo lucro: "+df.format(area5));
		}
		else if(area1>area2&&area1>area3&&area1>area4&&area1>area5) {
			System.out.println("A platéia A teve o maior lucro entre as áreas: "+df.format(area1));
		}	
		else if(area2>area1&&area2>area3&&area2>area4&&area2>area5) {
			System.out.println("Platéia B teve o maior lucro entre as áreas: "+df.format(area2));
		}
		else if(area3>area1&&area3>area2&&area3>area4&&area3>area5) {
			System.out.println("Camarote teve o maior lucro entre as áreas: "+df.format(area3));
		}
		else if(area4>area1&&area4>area2&&area4>area3&&area4>area5) {
			System.out.println("Frisa teve o maior lucro entre as áreas: "+df.format(area4));
		}
		else if(area5>area1&&area5>area2&&area5>area3&&area5>area4) {
			System.out.println("Balcão nobre teve o maior lucro entre as áreas: "+df.format(area5));
		}
		else if(area1==area2&&area1>area3&&area1>area4&&area1>area5) {
			System.out.println("Platéia A e platéia B tiveram o maior lucro entre as áreas: "+df.format(area1));
		}
		else if(area1==area3&&area1>area2&&area1>area4&&area1>area5) {
			System.out.println("Platéia A e camarote tiveram o maior lucro entre as áreas: "+df.format(area1));
		}
		else if(area1==area4&&area1>area2&&area1>area3&&area1>area5) {
			System.out.println("Platéia A e frisa tiveram o maior lucro entre as áreas: "+df.format(area1));
		}
		else if(area1==area5&&area1>area2&&area1>area3&&area1>area4) {
			System.out.println("Platéia A e balcão nobre tiveram o maior lucro entre as áreas: "+df.format(area1));
		}
		else if(area2==area3&&area2>area1&&area2>area4&&area2>area5) {
			System.out.println("Platéia B e camarote tiveram o maior lucro entre as áreas: "+df.format(area2));
		}
		else if(area2==area4&&area2>area1&&area2>area3&&area2>area5) {
			System.out.println("Platéia B e frisa tiveram o maior lucro entre as áreas: "+df.format(area2));
		}
		else if(area2==area5&&area2>area1&&area2>area3&&area2>area4) {
			System.out.println("Platéia B e balcão nobre tiveram o maior lucro entre as áreas: "+df.format(area2));
		}
		else if(area3==area4&&area3>area1&&area3>area2&&area3>area5) {
			System.out.println("Camarote e frisa tiveram o maior lucro entre as áreas: "+df.format(area3));
		}
		else if(area3==area5&&area3>area1&&area3>area2&&area3>area4) {
			System.out.println("Camarote e balcão nobre tiveram o maior lucro entre as áreas: "+df.format(area3));
		}
		else if(area4==area5&&area4>area1&&area4>area2&&area4>area3) {
			System.out.println("Frisa e balcão nobre tiveram o maior lucro entre as áreas: "+df.format(area4));
		}
		//fim combinação 2 maiores
		else if(area1==area2&&area1==area3&&area1>area4&&area1>area5) {
			System.out.println("Platéia A, platéia B e camarote tiveram o maior lucro entre as áreas: "+df.format(area1));
		}
		else if(area1==area2&&area1==area4&&area1>area3&&area1>area5) {
			System.out.println("Platéia A, platéia B e frisa tiveram o maior lucro entre as áreas: "+df.format(area1));
		}
		else if(area1==area2&&area1==area5&&area1>area3&&area1>area4) {
			System.out.println("Platéia A, platéia B e balcão nobre tiveram o maior lucro entre as áreas: "+df.format(area1));
		}
		else if(area1==area3&&area1==area4&&area1>area2&&area1>area5) {
			System.out.println("Platéia A, camarote e frisa tiveram o maior lucro entre as áreas: "+df.format(area1));
		}
		else if(area1==area3&&area1==area5&&area1>area2&&area1>area4) {
			System.out.println("Platéia A, camarote e balcão nobre tiveram o maior lucro entre as áreas: "+df.format(area1));
		}
		else if(area1==area4&&area1==area5&&area1>area2&&area1>area3) {
			System.out.println("Platéia A, frisa e balcão nobre tiveram o maior lucro entre as áreas: "+df.format(area1));
		}
		else if(area2==area3&&area2==area4&&area2>area1&&area2>area5) {
			System.out.println("Platéia B, camarote e frisa tiveram o maior lucro entre as áreas: "+df.format(area2));
		}
		else if(area2==area3&&area2==area5&&area2>area1&&area2>area4) {
			System.out.println("Platéia B, camarote e balcão nobre tiveram o maior lucro entre as áreas: "+df.format(area2));
		}
		else if(area2==area4&&area2==area5&&area2>area1&&area2>area3) {
			System.out.println("Platéia B, frisa e balcão nobre tiveram o maior lucro entre as áreas: "+df.format(area2));
		}
		else if(area3==area4&&area3==area5&&area3>area1&&area3>area2) {
			System.out.println("Camarote, frisa e balcão nobre tiveram o maior lucro entre as áreas: "+df.format(area3));
		}
		//fim da combinação de 3 maiores
		else if(area1==area2&&area1==area3&&area1==area4&&area1>area5) {
			System.out.println("Platéia A, platéia B, camarote e frisa tiveram o maior lucro entre as áreas: "+df.format(area1));
		}
		else if(area1==area2&&area1==area3&&area1==area5&&area1>area4) {
			System.out.println("Platéia A, platéia B, camarote e balcão nobre tiveram o maior lucro entre as áreas: "+df.format(area1));
		}
		else if(area1==area4&&area1==area3&&area1==area5&&area1>area2) {
			System.out.println("Platéia A, camarote, frisa e balcão nobre tiveram o maior lucro entre as áreas: "+df.format(area1));
		}
		else if(area1==area2&&area1==area4&&area1==area5&&area1>area3) {
			System.out.println("Platéia A, platéia B, frisa e balcão nobre tiveram o maior lucro entre as áreas: "+df.format(area1));
		}
		else if(area2==area3&&area2==area4&&area2==area5&&area2>area1) {
			System.out.println("Platéia B, camarote, frisa e balcão nobre tiveram o maior lucro entre as áreas: "+df.format(area2));
		}

		//Menores:

		if(area1<area2&&area1<area3&&area1<area4&&area1<area5) {
			System.out.println("A platéia A teve o menor lucro entre as áreas: "+df.format(area1));
		}	
		else if(area2<area1&&area2<area3&&area2<area4&&area2<area5) {
			System.out.println("Platéia B teve o menor lucro entre as áreas: "+df.format(area2));
		}
		else if(area3<area1&&area3<area2&&area3<area4&&area3<area5) {
			System.out.println("Camarote teve o menor lucro entre as áreas: "+df.format(area3));
		}
		else if(area4<area1&&area4<area2&&area4<area3&&area4<area5) {
			System.out.println("Frisa teve o menor lucro entre as áreas: "+df.format(area4));
		}
		else if(area5<area1&&area5<area2&&area5<area3&&area5<area4) {
			System.out.println("Balcão nobre teve o menor lucro entre as áreas: "+df.format(area5));
		}
		else if(area1==area2&&area1<area3&&area1<area4&&area1<area5) {
			System.out.println("Platéia A e platéia B tiveram o menor lucro entre as áreas: "+df.format(area1));
		}
		else if(area1==area3&&area1<area2&&area1<area4&&area1<area5) {
			System.out.println("Platéia A e camarote tiveram o menor lucro entre as áreas: "+df.format(area1));
		}
		else if(area1==area4&&area1<area2&&area1<area3&&area1<area5) {
			System.out.println("Platéia A e frisa tiveram o menor lucro entre as áreas: "+df.format(area1));
		}
		else if(area1==area5&&area1<area2&&area1<area3&&area1<area4) {
			System.out.println("Platéia A e balcão nobre tiveram o menor lucro entre as áreas: "+df.format(area1));
		}
		else if(area2==area3&&area2<area1&&area2<area4&&area2<area5) {
			System.out.println("Platéia B e camarote tiveram o menor lucro entre as áreas: "+df.format(area2));
		}
		else if(area2==area4&&area2<area1&&area2<area3&&area2<area5) {
			System.out.println("Platéia B e frisa tiveram o menor lucro entre as áreas: "+df.format(area2));
		}
		else if(area2==area5&&area2<area1&&area2<area3&&area2<area4) {
			System.out.println("Platéia B e balcão nobre tiveram o menor lucro entre as áreas: "+df.format(area2));
		}
		else if(area3==area4&&area3<area1&&area3<area2&&area3<area5) {
			System.out.println("Camarote e frisa tiveram o menor lucro entre as áreas: "+df.format(area3));
		}
		else if(area3==area5&&area3<area1&&area3<area2&&area3<area4) {
			System.out.println("Camarote e balcão nobre tiveram o menor lucro entre as áreas: "+df.format(area3));
		}
		else if(area4==area5&&area4<area1&&area4<area2&&area4<area3) {
			System.out.println("Frisa e balcão nobre tiveram o menor lucro entre as áreas: "+df.format(area4));
		}
		//fim combinação 2 menores
		else if(area1==area2&&area1==area3&&area1<area4&&area1<area5) {
			System.out.println("Platéia A, platéia B e camarote tiveram o menor lucro entre as áreas: "+df.format(area1));
		}
		else if(area1==area2&&area1==area4&&area1<area3&&area1<area5) {
			System.out.println("Platéia A, platéia B e frisa tiveram o menor lucro entre as áreas: "+df.format(area1));
		}
		else if(area1==area2&&area1==area5&&area1<area3&&area1<area4) {
			System.out.println("Platéia A, platéia B e balcão nobre tiveram o menor lucro entre as áreas: "+df.format(area1));
		}
		else if(area1==area3&&area1==area4&&area1<area2&&area1<area5) {
			System.out.println("Platéia A, camarote e frisa tiveram o menor lucro entre as áreas: "+df.format(area1));
		}
		else if(area1==area3&&area1==area5&&area1<area2&&area1<area4) {
			System.out.println("Platéia A, camarote e balcão nobre tiveram o menor lucro entre as áreas: "+df.format(area1));
		}
		else if(area1==area4&&area1==area5&&area1<area2&&area1<area3) {
			System.out.println("Platéia A, frisa e balcão nobre tiveram o menor lucro entre as áreas: "+df.format(area1));
		}
		else if(area2==area3&&area2==area4&&area2<area1&&area2<area5) {
			System.out.println("Platéia B, camarote e frisa tiveram o menor lucro entre as áreas: "+df.format(area2));
		}
		else if(area2==area3&&area2==area5&&area2<area1&&area2<area4) {
			System.out.println("Platéia B, camarote e balcão nobre tiveram o menor lucro entre as áreas: "+df.format(area2));
		}
		else if(area2==area4&&area2==area5&&area2<area1&&area2<area3) {
			System.out.println("Platéia B, frisa e balcão nobre tiveram o menor lucro entre as áreas: "+df.format(area2));
		}
		else if(area3==area4&&area3==area5&&area3<area1&&area3<area2) {
			System.out.println("Camarote, frisa e balcão nobre tiveram o menor lucro entre as áreas: "+df.format(area3));
		}
		//fim da combinação de 3 menores
		else if(area1==area2&&area1==area3&&area1==area4&&area1<area5) {
			System.out.println("Platéia A, platéia B, camarote e frisa tiveram o menor lucro entre as áreas: "+df.format(area1));
		}
		else if(area1==area2&&area1==area3&&area1==area5&&area1<area4) {
			System.out.println("Platéia A, platéia B, camarote e balcão nobre tiveram o menor lucro entre as áreas: "+df.format(area1));
		}
		else if(area1==area4&&area1==area3&&area1==area5&&area1<area2) {
			System.out.println("Platéia A, camarote, frisa e balcão nobre tiveram o menor lucro entre as áreas: "+df.format(area1));
		}
		else if(area1==area2&&area1==area4&&area1==area5&&area1<area3) {
			System.out.println("Platéia A, platéia B, frisa e balcão nobre tiveram o menor lucro entre as áreas: "+df.format(area1));
		}
		else if(area2==area3&&area2==area4&&area2==area5&&area2<area1) {
			System.out.println("Platéia B, camarote, frisa e balcão nobre tiveram o menor lucro entre as áreas: "+df.format(area2));
		}
	}

	public static void lucroPorPeca(String hamlet[][], String fera[][], String romeu[][], DecimalFormat df) {
		int i, i2; 
		double somaH=0, somaF=0, somaR=0;

		for (i=0;i<153;i++) {
			for (i2=0;i2<5;i2++) {
				if(hamlet[i][i2].length()>4) {
					if(i<=4){
						somaH+=40; 
					}
					else if(i<=24) {
						somaH+=60; 
					}
					else if (i<=34) {
						somaH+=80; 		
					}
					else if (i<=40) {
						somaH+=120; 	
					}
					else if (i<=50) {
						somaH+=250; 	
					}
					else if(i<=55) {
						somaH+=40;
					}
					else if(i<=75) {
						somaH+=60;
					}
					else if(i<=85) {
						somaH+=80;
					}
					else if(i<=91) {
						somaH+=120;
					}
					else if(i<=101) {
						somaH+=250;
					}
					else if(i<=106) {
						somaH+=40;
					}
					else if(i<=126) {
						somaH+=60;
					}
					else if(i<=136) {
						somaH+=80;
					}
					else if(i<=142) {
						somaH+=120;
					}
					else if(i<=152) {
						somaH+=250;
					}
				}
				if(fera[i][i2].length()>4) {
					if(i<=4){
						somaF+=40; 
					}
					else if(i<=24) {
						somaF+=60; 
					}
					else if (i<=34) {
						somaF+=80; 		
					}
					else if (i<=40) {
						somaF+=120; 	
					}
					else if (i<=50) {
						somaF+=250; 	
					}
					else if(i<=55) {
						somaF+=40;
					}
					else if(i<=75) {
						somaF+=60;
					}
					else if(i<=85) {
						somaF+=80;
					}
					else if(i<=91) {
						somaF+=120;
					}
					else if(i<=101) {
						somaF+=250;
					}
					else if(i<=106) {
						somaF+=40;
					}
					else if(i<=126) {
						somaF+=60;
					}
					else if(i<=136) {
						somaF+=80;
					}
					else if(i<=142) {
						somaF+=120;
					}
					else if(i<=152) {
						somaF+=250;
					}
				}
				if(romeu[i][i2].length()>4) {
					if(i<=4){
						somaR+=40; 
					}
					else if(i<=24) {
						somaR+=60; 
					}
					else if (i<=34) {
						somaR+=80; 		
					}
					else if (i<=40) {
						somaR+=120; 	
					}
					else if (i<=50) {
						somaR+=250; 	
					}
					else if(i<=55) {
						somaR+=40;
					}
					else if(i<=75) {
						somaR+=60;
					}
					else if(i<=85) {
						somaR+=80;
					}
					else if(i<=91) {
						somaR+=120;
					}
					else if(i<=101) {
						somaR+=250;
					}
					else if(i<=106) {
						somaR+=40;
					}
					else if(i<=126) {
						somaR+=60;
					}
					else if(i<=136) {
						somaR+=80;
					}
					else if(i<=142) {
						somaR+=120;
					}
					else if(i<=152) {
						somaR+=250;
					}
				}
			}
		}

		if(somaH>somaF&&somaH>somaR) {
			System.out.println("A peça "+Imprime.imprimePeca(1)+" foi a mais lucrativa: "+df.format(somaH));
			if(somaF>somaR) {
				System.out.println("A peça "+Imprime.imprimePeca(3)+" foi a menos lucrativa: "+df.format(somaR));
			}
			else if(somaR>somaF) {
				System.out.println("A peça "+Imprime.imprimePeca(2)+" foi a menos lucrativa: "+df.format(somaF));
			}
			else {
				System.out.println("As peças "+Imprime.imprimePeca(2)+" e "+Imprime.imprimePeca(3)+" foram as menos lucrativas: "+df.format(somaF));
			}
		}
		else if(somaF>somaH&&somaF>somaR) {
			System.out.println("A peça "+Imprime.imprimePeca(2)+" foi a mais lucrativa: "+df.format(somaF));
			if(somaH>somaR) {
				System.out.println("A peça "+Imprime.imprimePeca(3)+" foi a menos lucrativa: "+df.format(somaR));
			}
			else if(somaR>somaH) {
				System.out.println("A peça "+Imprime.imprimePeca(1)+" foi a menos lucrativa: "+df.format(somaH));
			}
			else {
				System.out.println("As peças "+Imprime.imprimePeca(1)+" e "+Imprime.imprimePeca(3)+" foram as menos lucrativas: "+df.format(somaR));
			}
		}
		else if(somaR>somaF&&somaR>somaH) {
			System.out.println("A peça "+Imprime.imprimePeca(3)+" foi a mais lucrativa: "+df.format(somaR));
			if(somaH>somaF) {
				System.out.println("A peça "+Imprime.imprimePeca(2)+" foi a menos lucrativa: "+df.format(somaF));
			}
			else if(somaH<somaF) {
				System.out.println("A peça "+Imprime.imprimePeca(1)+" foi a menos lucrativa: "+df.format(somaH));
			}
			else {
				System.out.println("As peças "+Imprime.imprimePeca(1)+" e "+Imprime.imprimePeca(2)+" foram as menos lucrativas: "+df.format(somaH));
			}
		}
		else if(somaR==somaF&&somaR>somaH) {
			System.out.println("As peças "+Imprime.imprimePeca(2)+" e "+Imprime.imprimePeca(3)+" foram as mais lucrativas: "+df.format(somaR));
			System.out.println("A peça "+Imprime.imprimePeca(1)+" foi a menos lucrativa: "+somaH);
		}
		else if(somaR==somaH&&somaR>somaF) {
			System.out.println("As peças "+Imprime.imprimePeca(1)+" e "+Imprime.imprimePeca(3)+" foram as mais lucrativas: "+df.format(somaH));
			System.out.println("A peça "+Imprime.imprimePeca(2)+" foi a menos lucrativa: "+df.format(somaF));
		}
		else if(somaF==somaH&&somaF>somaR) {
			System.out.println("As peças "+Imprime.imprimePeca(1)+" e "+Imprime.imprimePeca(2)+" foram as mais lucrativas: "+df.format(somaH));
			System.out.println("A peça "+Imprime.imprimePeca(3)+" foi a menos lucrativa: "+df.format(somaR));
		}
		else if(somaF==somaH&&somaF==somaR) {
			System.out.println("As peças "+Imprime.imprimePeca(1)+", "+Imprime.imprimePeca(2)+" e "+Imprime.imprimePeca(3)+" tiveram o mesmo lucro: "+df.format(somaH));
		}
	}

	public static void lucroPorSessao(String hamlet[][], String fera[][], String romeu[][], DecimalFormat df) {
		int i, i2;
		double lucroManha=0, lucroTarde=0, lucroNoite=0;

		for (i=0;i<153;i++) {
			for (i2=0;i2<5;i2++) {
				if(i<51) {
					if(hamlet[i][i2].length()>4) {
						if(i<=4){
							lucroManha+=40;
						}
						else if(i<=24) {
							lucroManha+=60;
						}
						else if (i<=34) {
							lucroManha+=80;	
						}
						else if (i<=40) {
							lucroManha+=120;	
						}
						else if (i<=50) {
							lucroManha+=250;	
						}
					}
					if(fera[i][i2].length()>4) {
						if(i<=4){
							lucroManha+=40;
						}
						else if(i<=24) {
							lucroManha+=60;
						}
						else if (i<=34) {
							lucroManha+=80;	
						}
						else if (i<=40) {
							lucroManha+=120;	
						}
						else if (i<=50) {
							lucroManha+=250;	
						}
					}
					if(romeu[i][i2].length()>4) {
						if(i<=4){
							lucroManha+=40;
						}
						else if(i<=24) {
							lucroManha+=60;
						}
						else if (i<=34) {
							lucroManha+=80;	
						}
						else if (i<=40) {
							lucroManha+=120;	
						}
						else if (i<=50) {
							lucroManha+=250;	
						}
					}
				}

				else if(i<102) {
					if(hamlet[i][i2].length()>4) {
						if(i<=55) {
							lucroTarde+=40;
						}
						else if(i<=75) {
							lucroTarde+=60;
						}
						else if(i<=85) {
							lucroTarde+=80;
						}
						else if(i<=91) {
							lucroTarde+=120; 
						}
						else if(i<=101) {
							lucroTarde+=250;
						}
					}
					if(fera[i][i2].length()>4) {
						if(i<=55) {
							lucroTarde+=40;
						}
						else if(i<=75) {
							lucroTarde+=60;
						}
						else if(i<=85) {
							lucroTarde+=80;
						}
						else if(i<=91) {
							lucroTarde+=120; 
						}
						else if(i<=101) {
							lucroTarde+=250;
						}
					}
					if(romeu[i][i2].length()>4) {
						if(i<=55) {
							lucroTarde+=40;
						}
						else if(i<=75) {
							lucroTarde+=60;
						}
						else if(i<=85) {
							lucroTarde+=80;
						}
						else if(i<=91) {
							lucroTarde+=120; 
						}
						else if(i<=101) {
							lucroTarde+=250;
						}
					}
				}

				else {
					if(hamlet[i][i2].length()>4) {
						if(i<=106) {
							lucroNoite+=40;
						}
						else if(i<=126) {
							lucroNoite+=60;
						}
						else if(i<=136) {
							lucroNoite+=80;
						}
						else if(i<=142) {
							lucroNoite+=120;
						}
						else if(i<=152) {
							lucroNoite+=250;
						}
					}
					if(fera[i][i2].length()>4) {
						if(i<=106) {
							lucroNoite+=40;
						}
						else if(i<=126) {
							lucroNoite+=60;
						}
						else if(i<=136) {
							lucroNoite+=80;
						}
						else if(i<=142) {
							lucroNoite+=120;
						}
						else if(i<=152) {
							lucroNoite+=250;
						}
					}
					if(romeu[i][i2].length()>4) {
						if(i<=106) {
							lucroNoite+=40;
						}
						else if(i<=126) {
							lucroNoite+=60;
						}
						else if(i<=136) {
							lucroNoite+=80;
						}
						else if(i<=142) {
							lucroNoite+=120;
						}
						else if(i<=152) {
							lucroNoite+=250;
						}
					}
				}
			}
		}


		if(lucroManha>lucroTarde&&lucroManha>lucroNoite) {
			System.out.println("As peças tiveram mais lucro no período matutino: "+df.format(lucroManha));
			if(lucroTarde>lucroNoite) {
				System.out.println("As peças tiveram menos lucro no período noturno: "+df.format(lucroNoite));
			}
			else if(lucroNoite>lucroTarde) {
				System.out.println("As peças tiveram menos lucro no período vespertino: "+df.format(lucroTarde));
			}
			else {
				System.out.println("As peças tiveram menos lucro nos períodos vespertino e noturno:"+df.format(lucroTarde));
			}
		}
		else if(lucroTarde>lucroManha&&lucroTarde>lucroNoite) {
			System.out.println("As peças tiveram mais lucro no período vespertino: "+df.format(lucroTarde));
			if(lucroManha>lucroNoite) {
				System.out.println("As peças tiveram menos lucro no período noturno: "+df.format(lucroNoite));
			}
			else if(lucroNoite>lucroManha) {
				System.out.println("As peças tiveram menos lucro no período matutino: "+df.format(lucroManha));
			}
			else {
				System.out.println("As peças tiveram menos lucro nos períodos matutino e norturno: "+df.format(lucroNoite));
			}
		}
		else if(lucroNoite>lucroTarde&&lucroNoite>lucroManha) {
			System.out.println("As peças tiveram mais lucro no período noturno: "+df.format(lucroNoite));
			if(lucroManha>lucroTarde) {
				System.out.println("As peças tiveram menos lucro no período vespertino: "+df.format(lucroTarde));
			}
			else if(lucroManha<lucroTarde) {
				System.out.println("As peças tiveram menos lucro no período matutino: "+df.format(lucroManha));
			}
			else {
				System.out.println("As peças tiveram menos lucro nos períodos matutino e vespertino: "+df.format(lucroTarde));
			}
		}
		else if(lucroNoite==lucroTarde&&lucroNoite>lucroManha) {
			System.out.println("As peças vespertinas e noturnas tiveram mais lucro: "+df.format(lucroTarde));
			System.out.println("As peças tiveram menos lucro no período matutino: "+df.format(lucroManha));
		}
		else if(lucroNoite==lucroManha&&lucroNoite>lucroTarde) {
			System.out.println("As peças matutinas e noturnas tiveram mais lucro: "+df.format(lucroManha));
			System.out.println("As peças tiveram menos lucro no período vespertino: "+df.format(lucroTarde));
		}
		else if(lucroTarde==lucroManha&&lucroTarde>lucroNoite) {
			System.out.println("As peças matutinas e vespertinas tiveram mais lucro: "+df.format(lucroManha));
			System.out.println("As peças tiveram menos lucro no período noturno: "+df.format(lucroNoite));
		}
		else if(lucroTarde==lucroManha&&lucroTarde==lucroNoite) {
			System.out.println("As peças matutinas, vespertinas e noturnas tiveram o mesmo lucro: "+df.format(lucroManha));
		}

	}

}
