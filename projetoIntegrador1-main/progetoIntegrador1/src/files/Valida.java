package files;

import java.util.Scanner;

public class Valida {
	
	public static double validaArea(Scanner sc) {
		double area;
		Imprime.imprimeTabelaPreco();
		System.out.println("Deseja comprar em qual área? Digite o número localizador da área: ");
		area=sc.nextDouble();
		while(area!=1&&area!=2&&area!=3&&area!=4&&area!=5) {
			System.out.println("\nNosso sistema não reconhece essa entrada, digite de acordo com a área que deseja comprar:");
			Imprime.imprimeTabelaPreco();
			area=sc.nextDouble();
		}
		return area;
	}
	
	public static double validaAssento(String matriz[][], double area, double sessao, double peca, Scanner sc) {
		double compra;
		System.out.println("\nDigite o número correspondente ao assento que deseja comprar:");
		compra=sc.nextDouble();
		while(validaCompraNumero(compra, area)==false||validaCompraAssentoVazio(compra, area, sessao, matriz)==false) {
			if(validaCompraNumero(compra, area)==false) {
				System.out.println("Essa entrada não corresponde a um assento\n");
				Imprime.imprimeAssentosVazios(matriz,sessao, area, peca);
				System.out.println("Digite o número correspondente ao assento que deseja comprar:");
				compra=sc.nextDouble();
			}
			else {//O número deve entrar aqui validado para não ter erro out of bounds
				if(validaCompraAssentoVazio(compra, area, sessao, matriz)==false) {
					System.out.println("Esse assento está ocupado.\n");
					Imprime.imprimeAssentosVazios(matriz,sessao, area, peca);
					System.out.println("Digite o número correspondente ao assento que deseja comprar:");
					compra=sc.nextDouble();
				}
			}
		}
		return compra;
	}
	
	public static boolean validaCompraAssentoVazio(double compra, double area,double sessao, String matriz[][]) {

		int a=(int) ((compra-1)/5), b=(int) ((compra-1)%5);

		if (sessao==2) {
			a+=51;
		}
		if (sessao==3) {
			a+=102;
		}

		if(area==1) {
			if (matriz[a][b].equals("")) {
				return true;
			}
			else {
				return false;
			}
		}
		else if(area==2) {
			a+=5;
			if (matriz[a][b].equals("")) {
				return true;
			}
			else {
				return false;
			}
		}
		else if(area==3) {
			a+=25;
			if (matriz[a][b].equals("")) {
				return true;
			}
			else {
				return false;
			}
		}
		else if(area==4) {
			a+=35;
			if (matriz[a][b].equals("")) {
				return true;
			}
			else {
				return false;
			}
		}
		else if(area==5) {
			a+=41;
			if (matriz[a][b].equals("")) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}

	}
	
	public static boolean validaCompraNumero(double compra, double area) {

		if(area==1) {
			if (compra!=1&&compra!=2&&compra!=3&&compra!=4&&compra!=5&&compra!=6&&compra!=7&&compra!=8&&compra!=9&&compra!=10&&compra!=11&&compra!=12&&compra!=13&&
					compra!=14&&compra!=15&&compra!=16&&compra!=17&&compra!=18&&compra!=19&&compra!=20&&compra!=21&&compra!=22&&compra!=23&&compra!=24&&compra!=25) {
				return false;
			}
			else {
				return true;
			}
		}
		else if(area==2) {
			if (compra!=1&&compra!=2&&compra!=3&&compra!=4&&compra!=5&&compra!=6&&compra!=7&&compra!=8&&compra!=9&&compra!=10&&compra!=11&&compra!=12&&compra!=13&&
					compra!=14&&compra!=15&&compra!=16&&compra!=17&&compra!=18&&compra!=19&&compra!=20&&compra!=21&&compra!=22&&compra!=23&&compra!=24&&compra!=25&&compra!=26&&compra!=27&&compra!=28&&compra!=29&&compra!=30&&compra!=31&&compra!=32&&compra!=33&&compra!=34&&compra!=35&&compra!=36&&compra!=37&&compra!=38&&
					compra!=39&&compra!=40&&compra!=41&&compra!=42&&compra!=43&&compra!=44&&compra!=45&&compra!=46&&compra!=47&&compra!=48&&compra!=49&&compra!=50&&compra!=51&&compra!=52&&compra!=53&&compra!=54&&compra!=55&&compra!=56&&compra!=57&&compra!=58&&compra!=59&&compra!=60&&compra!=61&&compra!=62&&compra!=63&&
					compra!=64&&compra!=65&&compra!=66&&compra!=67&&compra!=68&&compra!=69&&compra!=70&&compra!=71&&compra!=72&&compra!=73&&compra!=74&&compra!=75&&compra!=76&&compra!=77&&compra!=78&&compra!=79&&compra!=80&&compra!=81&&compra!=82&&compra!=83&&compra!=84&&compra!=85&&compra!=86&&compra!=87&&compra!=88&&
					compra!=89&&compra!=90&&compra!=91&&compra!=92&&compra!=93&&compra!=94&&compra!=95&&compra!=96&&compra!=97&&compra!=98&&compra!=99&&compra!=100) {
				return false;
			}
			else {
				return true;
			}
		}
		else if(area==3) {
			if (compra!=1&&compra!=2&&compra!=3&&compra!=4&&compra!=5&&compra!=6&&compra!=7&&compra!=8&&compra!=9&&compra!=10&&compra!=11&&compra!=12&&compra!=13&&
					compra!=14&&compra!=15&&compra!=16&&compra!=17&&compra!=18&&compra!=19&&compra!=20&&compra!=21&&compra!=22&&compra!=23&&compra!=24&&compra!=25&&compra!=26&&compra!=27&&compra!=28&&compra!=29&&compra!=30&&compra!=31&&compra!=32&&compra!=33&&compra!=34&&compra!=35&&compra!=36&&compra!=37&&compra!=38&&
					compra!=39&&compra!=40&&compra!=41&&compra!=42&&compra!=43&&compra!=44&&compra!=45&&compra!=46&&compra!=47&&compra!=48&&compra!=49&&compra!=50) {
				return false;
			}
			else {
				return true;
			}
		}
		else if(area==4) {
			if (compra!=1&&compra!=2&&compra!=3&&compra!=4&&compra!=5&&compra!=6&&compra!=7&&compra!=8&&compra!=9&&compra!=10&&compra!=11&&compra!=12&&compra!=13&&
					compra!=14&&compra!=15&&compra!=16&&compra!=17&&compra!=18&&compra!=19&&compra!=20&&compra!=21&&compra!=22&&compra!=23&&compra!=24&&compra!=25&&compra!=26&&compra!=27&&compra!=28&&compra!=29&&compra!=30) {
				return false;
			}
			else {
				return true;
			}
		}
		else if(area==5) {
			if (compra!=1&&compra!=2&&compra!=3&&compra!=4&&compra!=5&&compra!=6&&compra!=7&&compra!=8&&compra!=9&&compra!=10&&compra!=11&&compra!=12&&compra!=13&&
					compra!=14&&compra!=15&&compra!=16&&compra!=17&&compra!=18&&compra!=19&&compra!=20&&compra!=21&&compra!=22&&compra!=23&&compra!=24&&compra!=25&&compra!=26&&compra!=27&&compra!=28&&compra!=29&&compra!=30&&compra!=31&&compra!=32&&compra!=33&&compra!=34&&compra!=35&&compra!=36&&compra!=37&&compra!=38&&
					compra!=39&&compra!=40&&compra!=41&&compra!=42&&compra!=43&&compra!=44&&compra!=45&&compra!=46&&compra!=47&&compra!=48&&compra!=49&&compra!=50) {
				return false;
			}
			else {
				return true;
			}
		}
		else {
			return false;
		}

	}
	
	public static String validaConfirmaCompra(double compra, double peca, double sessao, double area, String CPF, Scanner sc) {
		String confirma, transformaCompra;
		transformaCompra=Double.toString(compra);//transforma double compra em String para deletar os 2 últimos caracteres: 20.0-->20
		System.out.println(Colors.BLACK_BOLD+"\nDetalhes da compra"+Colors.RESET);
		System.out.println("Peça: "+Imprime.imprimePeca(peca)+"\nPeríodo: "+Imprime.imprimePeriodo(sessao)+"\nÁrea: "+Imprime.imprimeArea(area)+"\nValor: "+Imprime.imprimePreco(area)+"\nCPF: "+Imprime.imprimeCPF(CPF)+"\nAssento número: "+transformaCompra.substring(0,transformaCompra.length()-2)+" \nDeseja confirmar? Digite 'sim' ou 'não'");
		confirma=sc.next();
		while(!confirma.equalsIgnoreCase("sim")&&!confirma.equalsIgnoreCase("não")) {
			System.out.println("Digite 'sim' para confirmar a compra ou 'não' para voltar ao menu inicial");
			confirma=sc.next();
		}
		return confirma;
	}
	
	public static String validaCPF(Scanner sc, int i) {
		String CPF;
		if(i==1) {
			System.out.println("Informe seu CPF");
			System.out.println("Exemplo: 04689149607");
		}
		if(i==2) {
			System.out.println("Digite o CPF para localizar o(s) ingresso(s)");
			System.out.println("Exemplo: 04689149607");
		}
		sc.nextLine();
		CPF=sc.nextLine();
		while(ConfirmaeVerifica.verificaCPF(CPF.replaceAll("\\s",""))==false) {
			System.out.println("O CPF digitado é inválido, informe novamente usando apenas números");
			CPF=sc.nextLine();
		}
		return CPF.replaceAll("\\s","");
	}

	public static double validaManutencaoArea(Scanner sc) {
		double area;
		System.out.println("Digite a área onde a manutenção irá ocorrer:\n(1) Platéia A\n(2) Platéia B\n(3) Camarote\n(4) Frisa\n(5) Balcão Nobre");
		area=sc.nextDouble();

		while(area!=1&&area!=2&&area!=3&&area!=4&&area!=5) {
			System.out.println("Entrada inválida!\nDigite a área onde a manutenção irá ocorrer de acordo com o número indicado:\n(1) Platéia A\n(2) Platéia B\n(3) Camarote\n(4) Frisa\n(5) Balcão Nobre");
			area=sc.nextDouble();
		}
		return area;
	}

	public static double validaManutencaoPeca(Scanner sc) {
		double peca;
		System.out.println("Digite a peça onde quer fazer a manutenção:\n(1) "+Imprime.imprimePeca(1)+"\n(2) "+Imprime.imprimePeca(2)+"\n(3) "+Imprime.imprimePeca(3));
		peca=sc.nextDouble();

		while(peca!=1&&peca!=2&&peca!=3) {
			System.out.println("Entrada inválida\nDigite a peça onde quer fazer a manutenção de acordo com o número indicado:\n(1) "+Imprime.imprimePeca(1)+"\n(2) "+Imprime.imprimePeca(2)+"\n(3) "+Imprime.imprimePeca(3));
			peca=sc.nextDouble();
		}
		return peca;
	}

	public static double validaManutencaoSessao(Scanner sc) {
		double sessao;
		System.out.println("Digite o período da manutenção:\n(1) Matutino\n(2) Vespertino\n(3) Noturno");
		sessao=sc.nextDouble();

		while(sessao!=1&&sessao!=2&&sessao!=3) {
			System.out.println("Entrada inválida!\nDigite o período da manutenção de acordo com o número indicado:\n(1) Matutino\n(2) Vespertino\n(3) Noturno");
			sessao=sc.nextDouble();
		}
		return sessao;
	}
	
	public static double validaMenuPrincipal(Scanner sc) {
		double menu=0;
		Imprime.imprimeMenuPrincipal();
		menu=sc.nextDouble();
		while(menu!=1&&menu!=2&&menu!=3&&menu!=4) {//&&menu!=9
			System.out.println("\nDado inserido inválido, digite uma das opções indicadas abaixo:");
			Imprime.imprimeMenuPrincipal();
			menu=sc.nextDouble();
		}
		return menu;
	}
	
	public static double validaMenu3(Scanner sc) {
		double menu3;
		System.out.println("Visualizar estatísticas: \n(1) Venda de ingressos\n(2) Receita\n(3) Voltar ao menu principal");
		menu3=sc.nextDouble();

		while (menu3!=1&&menu3!=2&&menu3!=3) {
			System.out.println("Entrada inválida, digite o número de acordo com o menu desejado: \n(1) Venda de ingressos\n(2) Receita\n(3) Voltar ao menu principal");
			menu3=sc.nextDouble();
		}
		return menu3;
	}

	public static double validaMenu4(Scanner sc) {
		double menu4;
		System.out.println("Agendamento de manutenção:\n(1) De uma área\n(2) De um período\n(3) De uma peça\n(4) Voltar ao menu principal");
		menu4=sc.nextDouble();

		while(menu4!=1&&menu4!=2&&menu4!=3&&menu4!=4) {
			System.out.println("Entrada inválida! Digite um número de acordo com o menu\nAgendamento de manutenção:\n(1) De uma área\n(2) De um período\n(3) De uma peça\n(4) Voltar ao menu principal");
			menu4=sc.nextDouble();
		}
		return menu4;
	}

	public static double validaPeca(Scanner sc) {
		double peca;
		System.out.println("Deseja comprar ingresso de qual peça?\n(1) Hamlet\n(2) A Bela e a Fera\n(3) Romeu e Julieta");
		peca=sc.nextDouble();
		while(peca!=1&&peca!=2&&peca!=3) {
			System.out.println("Nosso sistema não reconhece essa entrada, digite o número referente à peça que deseja comprar:\n(1) Hamlet\n(2) A Bela e a Fera\n(3) Romeu e Julieta");
			peca=sc.nextDouble();
		}
		return peca;
	}
	
	public static double validaSessao(Scanner sc) {
		double sessao;
		System.out.println("Digite o número de acordo com a sessão que deseja:\n(1) Matutina\n(2) Vespertina\n(3) Noturna");
		sessao=sc.nextDouble();
		while(sessao!=1&&sessao!=2&&sessao!=3) {
			System.out.println("Nosso sistema não reconhece essa entrada, digite o número referente à sessao que deseja comprar:\n(1) Matutina\n(2) Vespertina\n(3) Noturna");
			sessao=sc.nextDouble();
		}
		return sessao;
	}

}
