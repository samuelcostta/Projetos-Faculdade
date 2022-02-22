package files;

public class Imprime {

	public static String imprimeArea(double area) {
		if (area==1) {
			return "Platéia A";
		}
		else if (area==2) {
			return "Platéia B";
		}
		else if (area==3) {
			return "Camarote";
		}
		else if (area==4) {
			return "Frisa";
		}
		else if (area==5) {
			return "Balcão Nobre";
		}
		else {
			return "";
		}
	}

	public static void imprimeAssentosVazios(String matriz[][], double sessao, double area, double peca) {
		//sessao 1=manhã, 2= tarde, 3=noite
		String texto="", nomePlateia;
		int inicial=0, valorFinal=0, i3=1, i4=0, i5=0, aux=0;

		if(sessao==1) {
			System.out.println(Colors.RESET+"Peça: "+imprimePeca(peca)+"\nSessão: matutina \nPreço: "+imprimePreco(area)+"\n");
		}
		else if(sessao==2) {
			inicial+=51;
			System.out.println(Colors.RESET+"Peça: "+imprimePeca(peca)+"\nSessão: vespertina \nPreço: "+imprimePreco(area)+"\n");
		}
		else if (sessao==3){
			System.out.println(Colors.RESET+"Peça: "+imprimePeca(peca)+"\nSessão: noturna\nPreço: "+imprimePreco(area)+"\n");
			inicial+=102;
		}

		System.out.println("Assento "+Colors.GREEN_BOLD+"LIVRE");
		System.out.println(Colors.RESET+"Assento "+Colors.RED_BOLD+"OCUPADO");
		System.out.println(Colors.RESET+"Área em "+Colors.YELLOW_BOLD+"MANUTENÇÃO\n"+Colors.RESET);

		if (area==1) {
			nomePlateia="PlatéiaA";
			valorFinal=inicial+5;

			for(int i=inicial; i<valorFinal;i++) {
				if(i==inicial) {
					System.out.println(Colors.BROWN+"            -----------------");
					System.out.println("            |     PALCO     |");
					System.out.println("            -----------------"+Colors.RESET);
				}
				System.out.print(Colors.RESET+nomePlateia+" "+i3+": ");
				for (int i2=0; i2<5;i2++){
					i4++;
					if(matriz[i][i2].equals("")) {
						if(i4<10) {
							texto=Colors.GREEN_BOLD+i4+"   ";
						}
						else if(i4<100) {
							texto=Colors.GREEN_BOLD+i4+"  "+Colors.RESET;
						}
					}
					else if(matriz[i][i2].equals("1")) {
						if(i4<10) {
							texto=Colors.YELLOW_BOLD+i4+"   ";
						}
						else if(i4<100) {
							texto=Colors.YELLOW_BOLD+i4+"  "+Colors.RESET;
						}
					}
					else {
						if(i4<10) {
							texto=Colors.RED_BOLD+i4+"   ";
						}
						else if(i4<100) {
							texto=Colors.RED_BOLD+i4+"  "+Colors.RESET;
						}
					}
					System.out.print(texto);
				}
				i3++;
				System.out.println();

			}
		}

		else if (area==2) {
			inicial+=5;
			valorFinal= inicial+20;
			nomePlateia="PlatéiaB";

			for(int i=inicial; i<valorFinal;i++) {
				if(i==inicial) {
					System.out.println(Colors.BROWN+"                    -----------------");
					System.out.println("                    |     PALCO     |");
					System.out.println("                    -----------------"+Colors.RESET);
				}
				if(i3%2==1) {
					i5++;
					if(i5<10) {
						System.out.print(Colors.RESET+nomePlateia+" "+i5+":   ");
					}
					else {
						System.out.print(Colors.RESET+nomePlateia+" "+i5+":  ");
					}
				}

				for (int i2=0; i2<5;i2++){
					i4++;
					if(matriz[i][i2].equals("")) {
						if(i4<=10) {
							texto+=Colors.GREEN_BOLD+i4+"  ";
						}
						if(i4>10&&i4<=40) {
							texto+=Colors.GREEN_BOLD+i4+" ";
						}
						if(i4>40) {
							texto+=Colors.GREEN_BOLD+i4+" "+Colors.RESET;
						}
					}
					else if(matriz[i][i2].equals("1")) {
						if(i4<=10) {
							texto+=Colors.YELLOW_BOLD+i4+"  ";
						}
						if(i4>10&&i4<=40) {
							texto+=Colors.YELLOW_BOLD+i4+" ";
						}
						if(i4>40) {
							texto+=Colors.YELLOW_BOLD+i4+" "+Colors.RESET;
						}
					}
					else {
						if(i4<=10) {
							texto+=Colors.RED_BOLD+i4+"  ";
						}
						if(i4>10&&i4<=40) {
							texto+=Colors.RED_BOLD+i4+" ";
						}
						if(i4>40) {
							texto+=Colors.RED_BOLD+i4+" "+Colors.RESET;
						}
					}
					System.out.print(texto);
					texto="";
				}
				if(i3%2==0) {
					System.out.println();
				}
				i3++;
			}
		}

		else if (area==3) {
			inicial+=25;
			valorFinal=inicial+10;
			nomePlateia="Camarote";

			for(int i=inicial; i<valorFinal;i++) {
				if(i==inicial) {
					System.out.println(Colors.BROWN+"            -----------------");
					System.out.println("            |     PALCO     |");
					System.out.println("            -----------------"+Colors.RESET);
				}
				if(aux%2==0) {
					System.out.print(Colors.RESET+nomePlateia+" "+i3+": ");
					i3++;
					aux++;
				}
				else {
					System.out.print("            ");
					aux++;
				}

				for (int i2=0; i2<5;i2++){
					i4++;
					if(matriz[i][i2].equals("")) {
						if(i4<=10) {
							texto=Colors.GREEN_BOLD+i4+"   ";
						}
						if(i4>10&&i4<=45) {
							texto=Colors.GREEN_BOLD+i4+"  ";
						}
						if(i4>45) {
							texto=Colors.GREEN_BOLD+i4+"  "+Colors.RESET;
						}
					}
					else if(matriz[i][i2].equals("1")) {
						if(i4<=10) {
							texto=Colors.YELLOW_BOLD+i4+"   ";
						}
						if(i4>10&&i4<=45) {
							texto=Colors.YELLOW_BOLD+i4+"  ";
						}
						if(i4>45) {
							texto=Colors.YELLOW_BOLD+i4+"  "+Colors.RESET;
						}
					}
					else {
						if(i4<=10) {
							texto=Colors.RED_BOLD+i4+"   ";
						}
						if(i4>10&&i4<=45) {
							texto=Colors.RED_BOLD+i4+"  ";
						}
						if(i4>45) {
							texto=Colors.RED_BOLD+i4+"  "+Colors.RESET;
						}
					}
					System.out.print(texto);
				}
				System.out.println();
			}
		}

		else if (area==4) {
			inicial+=35;
			valorFinal=inicial+6;
			nomePlateia="Frisa";

			for(int i=inicial; i<valorFinal;i++) {
				if(i==inicial) {
					System.out.println(Colors.BROWN+"                     -----------------");
					System.out.println("                     |     PALCO     |");
					System.out.println("                     -----------------\n"+Colors.RESET);
				}
				for (int i2=0; i2<5;i2++){
					i4++;
					if(matriz[i][i2].equals("")) {
						if(i4<10) {
							texto=Colors.GREEN_BOLD+i4+"  ";
						}
						else if(i4<100) {
							texto=Colors.GREEN_BOLD+i4+" "+Colors.RESET;
						}
					}
					else if(matriz[i][i2].equals("1")) {
						if(i4<10) {
							texto=Colors.YELLOW_BOLD+i4+"  ";
						}
						else if(i4<100) {
							texto=Colors.YELLOW_BOLD+i4+" "+Colors.RESET;
						}
					}
					else {
						if(i4<10) {
							texto=Colors.RED_BOLD+i4+"  ";
						}
						else if(i4<100) {
							texto=Colors.RED_BOLD+i4+" "+Colors.RESET;
						}
					}
					if((i4-1)%5==0) {
						if(i3%2==0) {
							System.out.print("    ");
						}
						System.out.print(Colors.RESET+nomePlateia+" "+i3+": ");
					}
					System.out.print(texto);
				}
				i3++;
				if(i3%2==1) {
					System.out.println();
				}
			}
		}

		else if (area==5) {

			inicial+=41;
			valorFinal=inicial+10;
			nomePlateia="Balcão Nobre";

			for(int i=inicial; i<valorFinal;i++) {
				if(i==inicial) {
					System.out.println(Colors.BROWN+"                 ---------------------");
					System.out.println("                 |       PALCO       |");
					System.out.println("                 ---------------------"+Colors.RESET);
				}
				System.out.print(Colors.RESET+nomePlateia+" "+i3+": ");
				for (int i2=0; i2<5;i2++){
					i4++;
					if(matriz[i][i2].equals("")) {
						if(i4<=10) {
							texto=" "+Colors.GREEN_BOLD+i4+"   ";
						}
						if(i4>10&&i4<=45) {
							texto=" "+Colors.GREEN_BOLD+i4+"  ";
						}
						if(i4>45) {
							texto=Colors.GREEN_BOLD+i4+"   "+Colors.RESET;
						}
					}
					else if(matriz[i][i2].equals("1")) {
						if(i4<=10) {
							texto=" "+Colors.YELLOW_BOLD+i4+"   ";
						}
						if(i4>10&&i4<=45) {
							texto=" "+Colors.YELLOW_BOLD+i4+"  ";
						}
						if(i4>45) {
							texto=Colors.YELLOW_BOLD+i4+"   "+Colors.RESET;
						}
					}
					else {
						if(i4<=10) {
							texto=" "+Colors.RED_BOLD+i4+"   ";
						}
						if(i4>10&&i4<=45) {
							texto=" "+Colors.RED_BOLD+i4+"  ";
						}
						if(i4>45) {
							texto=Colors.RED_BOLD+i4+"   "+Colors.RESET;
						}
					}
					System.out.print(texto);
				}
				i3++;
				System.out.println();

			}
		} 
		System.out.println();
	}

	public static String imprimeCPF(String CPF) {
		return(CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." +
				CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
	}

	public static int imprimeIngressos(String hamlet[][], String fera[][], String romeu[][], double area, double sessao, String CPF, int opcao) {
		int linha=0, coluna=0, num=0, contagem=0, inicio=0, fim=153;
		//Opção 1 imprime ingressos do menu 2, opção diferente de 1 imprime ingressos de uma área que irá ser interditada
		if (sessao==0) {//manutenção será numa peça
		}
		else if(opcao!=1) {
			if(area==0) {//manutenção será numa sessão
				if(sessao==1) {
					fim=51;
				}
				else if(sessao==2) {
					inicio=51;
					fim=102;
				}
				else if(sessao==2) {
					inicio=102;
				}
			}
			else{//manutenção será numa área
				if(sessao==2) {
					inicio=51;
				}
				else if(sessao==3) {
					inicio=102;
				}
				if(area==1) {
					fim=inicio+5;
				}
				else if(area==2) {
					fim=inicio+20;
				}
				else if(area==3) {
					fim=inicio+10;
				}
				else if(area==4) {
					fim=inicio+6;
				}
				else if(area==5) {
					fim=inicio+10;
				}
			}
		}

		for(linha=inicio;linha<fim;linha++) {
			for(coluna=0;coluna<5;coluna++) {
				if(linha<=4){
					area=1;
					sessao=1;
					num=linha*5+coluna+1; 
				}
				else if(linha<=24) {
					area=2;
					sessao=1;
					num=linha*5+coluna-24;
				}
				else if (linha<=34) {
					area=3;
					sessao=1;
					num=linha*5+coluna-124;		
				}
				else if (linha<=40) {
					area=4;
					sessao=1;
					num=linha*5+coluna-174;		
				}
				else if (linha<=50) {
					area=5;
					sessao=1;
					num=linha*5+coluna-224;		
				}
				else if(linha<=55) {
					area=1;
					sessao=2;
					num=linha*5+coluna-254; 
				}
				else if(linha<=75) {
					area=2;
					sessao=2;
					num=linha*5+coluna-279; 
				}
				else if(linha<=85) {
					area=3;
					sessao=2;
					num=linha*5+coluna-379; 
				}
				else if(linha<=91) {
					area=4;
					sessao=2;
					num=linha*5+coluna-429; 
				}
				else if(linha<=101) {
					area=5;
					sessao=2;
					num=linha*5+coluna-459; 
				}
				else if(linha<=106) {
					area=1;
					sessao=3;
					num=linha*5+coluna-509; 
				}
				else if(linha<=126) {
					area=2;
					sessao=3;
					num=linha*5+coluna-534;
				}
				else if(linha<=136) {
					area=3;
					sessao=3;
					num=linha*5+coluna-634;
				}
				else if(linha<=142) {
					area=4;
					sessao=3;
					num=linha*5+coluna-684;
				}	
				else if(linha<=152) {
					area=5;
					sessao=3;
					num=linha*5+coluna-714;
				}

				if(opcao==1) {
					if(hamlet[linha][coluna].equals(CPF)) {
						contagem++;
						System.out.println(Colors.BLACK_BOLD+"\nCOMPROVANTE DE PAGAMENTO"+Colors.RESET+"\nPeça: "+imprimePeca(1)+"\nPeríodo: "+imprimePeriodo(sessao)+"\nÁrea: "+imprimeArea(area)+"\nValor: "+imprimePreco(area)+"\nCPF: "+imprimeCPF(CPF)+"\nAssento número: "+num);
					}
					if(fera[linha][coluna].equals(CPF)) {
						contagem++;
						System.out.println(Colors.BLACK_BOLD+"\nCOMPROVANTE DE PAGAMENTO"+Colors.RESET+"\nPeça: "+imprimePeca(2)+"\nPeríodo: "+imprimePeriodo(sessao)+"\nÁrea: "+imprimeArea(area)+"\nValor: "+imprimePreco(area)+"\nCPF: "+imprimeCPF(CPF)+"\nAssento número: "+num);
					}
					if(romeu[linha][coluna].equals(CPF)) {
						contagem++;
						System.out.println(Colors.BLACK_BOLD+"\nCOMPROVANTE DE PAGAMENTO"+Colors.RESET+"\nPeça: "+imprimePeca(3)+"\nPeríodo: "+imprimePeriodo(sessao)+"\nÁrea: "+imprimeArea(area)+"\nValor: "+imprimePreco(area)+"\nCPF: "+imprimeCPF(CPF)+"\nAssento número: "+num);
					}
				}
				else {
					if(hamlet!=null) {
						if(hamlet[linha][coluna].length()>6) {
							System.out.println(Colors.BLACK_BOLD+"\nDados do cliente que comprou:"+Colors.RESET+"\nPeça: "+imprimePeca(1)+"\nPeríodo: "+imprimePeriodo(sessao)+"\nÁrea: "+imprimeArea(area)+"\nValor: "+imprimePreco(area)+"\nCPF: "+imprimeCPF(hamlet[linha][coluna])+"\nAssento número: "+num);
						}
					}
					if(fera!=null) {
						if(fera[linha][coluna].length()>6) {
							System.out.println(Colors.BLACK_BOLD+"\nDados do cliente que comprou:"+Colors.RESET+"\nPeça: "+imprimePeca(2)+"\nPeríodo: "+imprimePeriodo(sessao)+"\nÁrea: "+imprimeArea(area)+"\nValor: "+imprimePreco(area)+"\nCPF: "+imprimeCPF(fera[linha][coluna])+"\nAssento número: "+num);
						}
					}
					if(romeu!=null) {
						if(romeu[linha][coluna].length()>6) {
							System.out.println(Colors.BLACK_BOLD+"\nDados do cliente que comprou:"+Colors.RESET+"\nPeça: "+imprimePeca(3)+"\nPeríodo: "+imprimePeriodo(sessao)+"\nÁrea: "+imprimeArea(area)+"\nValor: "+imprimePreco(area)+"\nCPF: "+imprimeCPF(romeu[linha][coluna])+"\nAssento número: "+num);
						}
					}

				}
			}
		}
		return contagem;
	}

	public static void imprimeMenuPrincipal(){
		System.out.println(Colors.BLACK_BOLD+"\nMenu Principal"+Colors.RESET);
		System.out.println("Digite o número idicado para entrar na opção desejada:");
		System.out.println("(1) Comprar ingresso");
		System.out.println("(2) Imprimir ingresso");
		System.out.println("(3) Estatísticas de vendas");
		System.out.println("(4) Agendar manutenção");
		//System.out.println("(9) Sair"); //caso for implementar fechamento
	}

	public static String imprimePeca(double a) {
		if(a==1) {
			return Colors.BLACK_ITALIC+"Hamlet"+Colors.RESET;
		}
		else if(a==2) {
			return Colors.BLACK_ITALIC+"A Bela e a Fera"+Colors.RESET;
		}
		else if(a==3) {
			return Colors.BLACK_ITALIC+"Romeu e Julieta"+Colors.RESET;
		}
		else {
			return "";
		}

	}

	public static String imprimePeriodo(double a) {
		if(a==1) {
			return "matutino";
		}
		if(a==2) {
			return "vespertino";
		}
		if(a==3) {
			return "noturno";
		}
		else {
			return "";
		}

	}

	public static String imprimePreco(double area) {
		if(area==1) {
			return"R$40,00";
		}
		else if(area==2) {
			return"R$60,00";
		}
		else if(area==3) {
			return"R$80,00";
		}
		else if(area==4) {
			return"R$120,00";
		}
		else if(area==5) {
			return"R$250,00";
		}
		else {
			return "";
		}
	}

	public static void imprimeTabelaPreco() {
		System.out.println("   Área           Preço");
		System.out.println("(1)Platéia A      R$40,00");
		System.out.println("(2)Platéia B      R$60,00");
		System.out.println("(3)Camarote       R$80,00");
		System.out.println("(4)Frisa          R$120,00");
		System.out.println("(5)Balcão Nobre   R$250,00");
	}

}