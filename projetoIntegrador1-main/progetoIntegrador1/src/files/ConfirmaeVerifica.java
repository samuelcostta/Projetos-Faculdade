package files;

import java.util.Scanner;

public class ConfirmaeVerifica {
	
	public static boolean confirmaAgendamentoManutencao(String matriz[][],double peca,double sessao,double area) {
		int inicio=0, fim=0, x=0;
		if(sessao==0) {
			fim=153;
		}
		else if(sessao==2) {
			inicio+=51;
			if(area==0) {
				fim=inicio+51;
			}
		}
		else if(sessao==3) {
			inicio+=102;
			if(area==0) {
				fim=inicio+51;
			}
		}
		else if(area==0) {
			fim=inicio+51;
		}
		if(area==1) {
			fim=inicio+5;
		}
		else if(area==2) {
			inicio+=5;
			fim=inicio+20;
		}
		else if(area==3) {
			inicio+=25;
			fim=inicio+10;
		}
		else if(area==4) {
			inicio+=35;
			fim=inicio+6;
		}
		else if(area==5) {
			inicio+=41;
			fim=inicio+10;
		}

		for (int i=inicio;i<fim;i++) {
			for (int i2=0;i2<5;i2++) {
				if(matriz[i][i2].length()>6) {
					x++;
				}
			}
		}

		if(x==0) {
			return false;
		}
		else {
			return true;
		}
	}

	public static int confirmaManutencao(String hamlet[][], String fera[][], String romeu[][], double peca, double sessao, double area, Scanner sc) {
		String confirma="";
		int jumpCode2=0;
		if(peca==1) {
			if(confirmaAgendamentoManutencao(hamlet, peca, sessao, area)==true) {//teste para saber se a administração confirma realizar manutenção em área onde existe(m) ingresso(s) comprado(s)
				System.out.println("Há ingressos comprados onde se deseja fazer manutenção!\nDigite 'sim' se quiser continuar ou 'não' para voltar ao menu agendamento de manutenção");
				confirma=sc.next();

				while(!confirma.equalsIgnoreCase("sim")&&!confirma.equalsIgnoreCase("não")) {
					System.out.println("Entrada inválida!\nHá ingressos comprados onde se deseja fazer manutenção!\nDigite 'sim' se quiser continuar ou 'não' para voltar ao menu agendamento de manutenção");
					confirma=sc.next();
				}
				if(confirma.equalsIgnoreCase("sim")) {
					jumpCode2=0;
				}
			}
			else if(confirma.equalsIgnoreCase("não")) {
				jumpCode2=1;
			}
		}
		if(peca==2) {
			if(confirmaAgendamentoManutencao(fera, peca, sessao, area)==true) {//teste para saber se a administração confirma realizar manutenção em área onde existe(m) ingresso(s) comprado(s)
				System.out.println("Há ingressos comprados onde se deseja fazer manutenção!\nDigite 'sim' se quiser continuar ou 'não' para voltar ao menu agendamento de manutenção");
				confirma=sc.next();

				while(!confirma.equalsIgnoreCase("sim")&&!confirma.equalsIgnoreCase("não")) {
					System.out.println("Entrada inválida!\nHá ingressos comprados onde se deseja fazer manutenção!\nDigite 'sim' se quiser continuar ou 'não' para voltar ao menu agendamento de manutenção");
					confirma=sc.next();
				}
				if(confirma.equalsIgnoreCase("sim")) {
					jumpCode2=0;
				}
			}
			else if(confirma.equalsIgnoreCase("não")) {
				jumpCode2=1;
			}
		}
		if(peca==3) {
			if(confirmaAgendamentoManutencao(romeu, peca, sessao, area)==true) {//teste para saber se a administração confirma realizar manutenção em área onde existe(m) ingresso(s) comprado(s)
				System.out.println("Há ingressos comprados onde se deseja fazer manutenção!\nDigite 'sim' se quiser continuar ou 'não' para voltar ao menu agendamento de manutenção");
				confirma=sc.next();

				while(!confirma.equalsIgnoreCase("sim")&&!confirma.equalsIgnoreCase("não")) {
					System.out.println("Entrada inválida!\nHá ingressos comprados onde se deseja fazer manutenção!\nDigite 'sim' se quiser continuar ou 'não' para voltar ao menu agendamento de manutenção");
					confirma=sc.next();
				}
				if(confirma.equalsIgnoreCase("sim")) {
					jumpCode2=0;
				}
			}
			else if(confirma.equalsIgnoreCase("não")) {
				jumpCode2=1;
			}
		}
		return jumpCode2;

	}

	public static boolean verificaCPF(String CPF) {
			if (CPF.equals("00000000000") || CPF.equals("11111111111") ||
			CPF.equals("22222222222") || CPF.equals("33333333333") ||
			CPF.equals("44444444444") || CPF.equals("55555555555") ||
			CPF.equals("66666666666") || CPF.equals("77777777777") ||
			CPF.equals("88888888888") || CPF.equals("99999999999") ||
			(CPF.length() != 11)) {  
			return(false);
		}
		else {
			char dig10, dig11;
			int soma=0, i, auxDigito, num=0, peso=10;

			for (i=0;i<9;i++) {
				num=(int)(CPF.charAt(i)-48);//transformação do caractere em número de acordo com a tabela ASCII
				soma+=(peso*num);
				peso--;
			}

			auxDigito = 11-(soma%11);
			if((auxDigito==10)||(auxDigito==11)) {
				dig10='0';
			}
			else {
				dig10=(char)(auxDigito+48);//transformação do caractere em número de acordo com a tabela ASCII
			}

			soma=0;
			peso=11;
			for(i=0;i<10;i++) {
				num=(int)(CPF.charAt(i)-48);//transformação do caractere em número de acordo com a tabela ASCII
				soma+=(peso*num);
				peso--;
			}

			auxDigito=11-(soma%11);
			if((auxDigito==10)||(auxDigito==11)) {
				dig11='0';
			}
			else {
				dig11=(char)(auxDigito+48);//transformação do caractere em número de acordo com a tabela ASCII
			}

			if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) {
				return(true);
			}
			else return(false);
		}
	}

	public static boolean verificaLotacao(String matriz[][], double sessao, double area) {
		//true== tem espaço, false==lotado
		int inicial=0, valorFinal=0, contador=0;

		if(sessao==2) {
			inicial+=51;
		}
		if (sessao==3){
			inicial+=102;
		}

		if (area==1) {
			valorFinal=inicial+5;
			for(int i=inicial; i<valorFinal;i++) {
				for (int i2=0; i2<5;i2++){
					if(matriz[i][i2].equals("")) {
						contador++;
					}
				}
			}
		}
		else if (area==2) {
			inicial+=5;
			valorFinal=inicial+20;
			for(int i=inicial; i<valorFinal;i++) {
				for (int i2=0; i2<5;i2++){
					if(matriz[i][i2].equals("")) {
						contador++;
					}
				}
			}
		}
		else if (area==3) {
			inicial+=25;
			valorFinal=inicial+10;
			for(int i=inicial; i<valorFinal;i++) {
				for (int i2=0; i2<5;i2++){
					if(matriz[i][i2].equals("")) {
						contador++;
					}
				}
			}
		}
		else if (area==4) {
			inicial+=35;
			valorFinal=inicial+6;
			for(int i=inicial; i<valorFinal;i++) {
				for (int i2=0; i2<5;i2++){
					if(matriz[i][i2].equals("")) {
						contador++;
					}
				}
			}
		}
		else if (area==5) {
			inicial+=41;
			valorFinal=inicial+10;
			for(int i=inicial; i<valorFinal;i++) {
				for (int i2=0; i2<5;i2++){
					if(matriz[i][i2].equals("")) {
						contador++;
					}
				}
			}
		}


		if(contador==0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public static int verificaManutencaoLotacao(double peca,double area,double sessao, String matriz[][]) {

		Imprime.imprimeAssentosVazios(matriz,sessao, area, peca);
		if(verificaManutencaoParaCompra(matriz, sessao, area)==true) {
			System.out.println("Peça: "+Imprime.imprimePeca(1)+"\nPeríodo: "+Imprime.imprimePeriodo(sessao)+"\nÁrea: "+Imprime.imprimeArea(area)+Colors.BLACK_BOLD+"\nEstá em manutenção!"+Colors.RESET+"\nVoltando ao menu\n");
			return 1;
		}
		else if(verificaLotacao(matriz, sessao, area)==false) {
			System.out.println("Peça: "+Imprime.imprimePeca(1)+"\nPeríodo: "+Imprime.imprimePeriodo(sessao)+"\nÁrea: "+Imprime.imprimeArea(area)+Colors.BLACK_BOLD+"\nEstá lotada!"+Colors.RESET+"\nVoltando ao menu\n");
			return 1;
		}
		else {
			return 0;
		}

	}

	public static boolean verificaManutencaoParaCompra(String matriz[][], double sessao, double area) {
		int inicio=0;

		if(sessao==2) {
			inicio+=51;
		}
		else if (sessao==3){
			inicio+=102;
		}
		if(area==2) {
			inicio+=5;
		}
		if(area==3) {
			inicio+=25;
		}
		if(area==4) {
			inicio+=35;
		}
		if(area==5) {
			inicio+=41;
		}
		if(matriz[inicio][0].equals("1")) {
			return true;
		}
		else {
			return false;
		}
	}

}
