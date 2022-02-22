package files;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ProjetoIntegrador {

	public static void main(String[] args) {
		//3 pe�as: hamlet, romeu e julieta, a bela e a fera
		String CPF="", hamlet[][]=new String[153][5], fera[][]=new String[153][5], romeu[][]=new String[153][5], confirma;//escolha de 5 colunas: MMC entre as quantidades de assentos das �reas
		double menu, peca=0, sessao=0, area=0, compra=0, menu3, menu4;//Valida��o em double para que quando o usu�rio digitar n�mero decimal n�o d� erro
		int loop=0, jumpCode, jumpCode2;

		Scanner sc= new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("R$ 00.00");

		//substitui null por "" nas matrizes:
		Acoes.preencheMatriz(hamlet);
		Acoes.preencheMatriz(fera);
		Acoes.preencheMatriz(romeu);
		
		do {//O programa fica esperando entrada indefinidamente como descrito pelo professor	
			menu=Valida.validaMenuPrincipal(sc);
			//Menu comprar ingresso
			if(menu==1) {
				//informa e valida CPF		
				CPF=Valida.validaCPF(sc, 1);
				//informa e valida pe�a
				peca=Valida.validaPeca(sc);
				//informa e valida sess�o
				sessao=Valida.validaSessao(sc);
				System.out.println("Pe�a selecionada: "+Imprime.imprimePeca(peca)+" sess�o do per�odo "+Imprime.imprimePeriodo(sessao));
				//informa e valida �rea
				area=Valida.validaArea(sc);
				//teste de manuten��o seguido de teste de lota��o
				if(peca==1) {
					jumpCode=ConfirmaeVerifica.verificaManutencaoLotacao(peca,area,sessao,hamlet);
				}
				else if(peca==2) {
					jumpCode=ConfirmaeVerifica.verificaManutencaoLotacao(peca,area,sessao,fera);
				}
				else {
					jumpCode=ConfirmaeVerifica.verificaManutencaoLotacao(peca,area,sessao,romeu);
				}
				//Se essa �rea est� em manuten��o ou lotada jumpCode==1 e pula essa parte
				if (jumpCode==0) {
					//verifica se n�mero digitado do assento � v�lido e se o assento est� livre
					if(peca==1) {
						compra=Valida.validaAssento(hamlet, area, sessao, peca, sc);
					}
					else if(peca==2) {
						compra=Valida.validaAssento(fera,  area, sessao, peca, sc);
					}
					else if(peca==3) {
						compra=Valida.validaAssento(romeu,  area, sessao, peca, sc);
					}
					//confirma��o de compra
					confirma=Valida.validaConfirmaCompra(compra, peca, sessao, area, CPF, sc);
					if(confirma.equalsIgnoreCase("sim")) {
						if(peca==1) {
							Acoes.incluiCPFNaMatriz(hamlet, compra, sessao, area, CPF);
						}
						else if(peca==2) {
							Acoes.incluiCPFNaMatriz(fera, compra, sessao, area, CPF);
						}
						else if(peca==3) {
							Acoes.incluiCPFNaMatriz(romeu, compra, sessao, area, CPF);
						}
					}
				}
			}//fim da compra, menu 1

			else if(menu==2) {//imprimir ingresso
				CPF=Valida.validaCPF(sc, 2);
				if(Imprime.imprimeIngressos(hamlet, fera, romeu, area, sessao, CPF, 1)==0) {
					System.out.println("\nN�o h� compras registradas no CPF:"+Imprime.imprimeCPF(CPF));
				}
			}//end menu 2

			else if(menu==3) {
				do {//at� sair do menu
					menu3=Valida.validaMenu3(sc);
					VendaseReceita.imprimeVendasReceita(menu3, hamlet, fera, romeu, df);
				}while(menu3!=3);
			}//end menu 3

			else if(menu==4) {
				do {//at� sair do menu
					menu4=Valida.validaMenu4(sc);
					//reset de valor:				
					jumpCode2=0;
					if(menu4==1) {//Agenda manuten��o de �rea
						//Informa e valida a pe�a onde vai ocorrer a manuten��o
						peca=Valida.validaManutencaoPeca(sc);
						//Informa e valida a sess�o onde vai ocorrer a manuten��o
						sessao=Valida.validaManutencaoSessao(sc);
						//Informa e valida a �ra onde vai ocorrer a manuten��o
						area=Valida.validaManutencaoArea(sc);
						//Verifica se h� ingressos comprados na �rea onde vai acontecer manuten��o e pede confirma��o para continuar, se houver	
						jumpCode2=ConfirmaeVerifica.confirmaManutencao(hamlet, fera, romeu, peca, sessao, area, sc);
						if(jumpCode2==0) {
							//Imprime ingressos de quem comprou para registro e interdita
							if(peca==1) {
								Imprime.imprimeIngressos(hamlet, null, null, area, sessao, CPF, 0);
								Acoes.interditaArea(hamlet, peca, sessao, area);
							}
							else if(peca==2) {
								Imprime.imprimeIngressos(null, fera, null, area, sessao, CPF, 0);
								Acoes.interditaArea(fera, peca, sessao, area);
							}
							else if(peca==3) {
								Imprime.imprimeIngressos(null, null, romeu, area, sessao, CPF, 0);
								Acoes.interditaArea(romeu, peca, sessao, area);
							}
							System.out.println("\nManuten��o na pe�a: "+Imprime.imprimePeca(peca)+" per�odo "+Imprime.imprimePeriodo(sessao)+" �rea "+Imprime.imprimeArea(area)+" agendada com sucesso!\n");
						}
					}//fim agendamento de manuten��o por �rea

					if(menu4==2) {//agendamento de manuten��o de uma sess�o
						//Informa e valida a pe�a onde vai ocorrer a manuten��o
						peca=Valida.validaManutencaoPeca(sc);
						//Informa e valida a sess�o onde vai ocorrer a manuten��o
						sessao=Valida.validaManutencaoSessao(sc);
						//Verifica se h� ingressos comprados na sess�o onde vai acontecer manuten��o e pede confirma��o para continuar, se houver	
						jumpCode2=ConfirmaeVerifica.confirmaManutencao(hamlet, fera, romeu, peca, sessao, area, sc);
						if(jumpCode2==0) {
							//Imprime ingressos de quem comprou para registro e interdita
							if(peca==1) {
								Imprime.imprimeIngressos(hamlet, null, null, 0, sessao, CPF, 0);
								Acoes.interditaArea(hamlet, peca, sessao, 0);
							}
							if(peca==2) {
								Imprime.imprimeIngressos(null, fera, null, 0, sessao, CPF, 0);
								Acoes.interditaArea(fera, peca, sessao, 0);
							}
							if(peca==3) {
								Imprime.imprimeIngressos(null, null, romeu, 0, sessao, CPF, 0);
								Acoes.interditaArea(romeu, peca, sessao, 0);
							}
							System.out.println("\nManuten��o na pe�a: "+Imprime.imprimePeca(peca)+" per�odo "+Imprime.imprimePeriodo(sessao)+" agendada com sucesso!\n");
						}						
						
					}//fim agendamento de manuten��o por sess�o

					if(menu4==3) {
						//Informa e valida a pe�a onde vai ocorrer a manuten��o
						peca=Valida.validaManutencaoPeca(sc);
						//Verifica se h� ingressos comprados na pe�a na qual vai acontecer manuten��o e pede confirma��o para continuar, se houver	
						jumpCode2=ConfirmaeVerifica.confirmaManutencao(hamlet, fera, romeu, peca, sessao, area, sc);
						if(jumpCode2==0) {
							//Imprime ingressos de quem comprou para registro e interdita
							if(peca==1) {
								Imprime.imprimeIngressos(hamlet, null, null, 0, 0, CPF, 0);
								Acoes.interditaArea(hamlet, peca, 0, 0);
							}
							if(peca==2) {
								Imprime.imprimeIngressos(null, fera, null, 0, 0, CPF, 0);
								Acoes.interditaArea(fera, peca, 0, 0);
							}
							if(peca==3) {
								Imprime.imprimeIngressos(null, null, romeu, 0, 0, CPF, 0);
								Acoes.interditaArea(romeu, peca, 0, 0);
							}
							System.out.println("\nManuten��o na pe�a: "+Imprime.imprimePeca(peca)+" agendada com sucesso!\n");
						}	
					}//fim de agendamento de manuten��o por pe�a	
				}while(menu!=4);
			}//end menu 4 agendar manuten��o
			/*else if(menu==9) {
				loop++;
			}*/
		}while(loop==0);

		sc.close();
	}//end main

}//end class
