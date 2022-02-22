package files;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ProjetoIntegrador {

	public static void main(String[] args) {
		//3 peças: hamlet, romeu e julieta, a bela e a fera
		String CPF="", hamlet[][]=new String[153][5], fera[][]=new String[153][5], romeu[][]=new String[153][5], confirma;//escolha de 5 colunas: MMC entre as quantidades de assentos das áreas
		double menu, peca=0, sessao=0, area=0, compra=0, menu3, menu4;//Validação em double para que quando o usuário digitar número decimal não dê erro
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
				//informa e valida peça
				peca=Valida.validaPeca(sc);
				//informa e valida sessão
				sessao=Valida.validaSessao(sc);
				System.out.println("Peça selecionada: "+Imprime.imprimePeca(peca)+" sessão do período "+Imprime.imprimePeriodo(sessao));
				//informa e valida área
				area=Valida.validaArea(sc);
				//teste de manutenção seguido de teste de lotação
				if(peca==1) {
					jumpCode=ConfirmaeVerifica.verificaManutencaoLotacao(peca,area,sessao,hamlet);
				}
				else if(peca==2) {
					jumpCode=ConfirmaeVerifica.verificaManutencaoLotacao(peca,area,sessao,fera);
				}
				else {
					jumpCode=ConfirmaeVerifica.verificaManutencaoLotacao(peca,area,sessao,romeu);
				}
				//Se essa área está em manutenção ou lotada jumpCode==1 e pula essa parte
				if (jumpCode==0) {
					//verifica se número digitado do assento é válido e se o assento está livre
					if(peca==1) {
						compra=Valida.validaAssento(hamlet, area, sessao, peca, sc);
					}
					else if(peca==2) {
						compra=Valida.validaAssento(fera,  area, sessao, peca, sc);
					}
					else if(peca==3) {
						compra=Valida.validaAssento(romeu,  area, sessao, peca, sc);
					}
					//confirmação de compra
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
					System.out.println("\nNão há compras registradas no CPF:"+Imprime.imprimeCPF(CPF));
				}
			}//end menu 2

			else if(menu==3) {
				do {//até sair do menu
					menu3=Valida.validaMenu3(sc);
					VendaseReceita.imprimeVendasReceita(menu3, hamlet, fera, romeu, df);
				}while(menu3!=3);
			}//end menu 3

			else if(menu==4) {
				do {//até sair do menu
					menu4=Valida.validaMenu4(sc);
					//reset de valor:				
					jumpCode2=0;
					if(menu4==1) {//Agenda manutenção de área
						//Informa e valida a peça onde vai ocorrer a manutenção
						peca=Valida.validaManutencaoPeca(sc);
						//Informa e valida a sessão onde vai ocorrer a manutenção
						sessao=Valida.validaManutencaoSessao(sc);
						//Informa e valida a ára onde vai ocorrer a manutenção
						area=Valida.validaManutencaoArea(sc);
						//Verifica se há ingressos comprados na área onde vai acontecer manutenção e pede confirmação para continuar, se houver	
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
							System.out.println("\nManutenção na peça: "+Imprime.imprimePeca(peca)+" período "+Imprime.imprimePeriodo(sessao)+" área "+Imprime.imprimeArea(area)+" agendada com sucesso!\n");
						}
					}//fim agendamento de manutenção por área

					if(menu4==2) {//agendamento de manutenção de uma sessão
						//Informa e valida a peça onde vai ocorrer a manutenção
						peca=Valida.validaManutencaoPeca(sc);
						//Informa e valida a sessão onde vai ocorrer a manutenção
						sessao=Valida.validaManutencaoSessao(sc);
						//Verifica se há ingressos comprados na sessão onde vai acontecer manutenção e pede confirmação para continuar, se houver	
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
							System.out.println("\nManutenção na peça: "+Imprime.imprimePeca(peca)+" período "+Imprime.imprimePeriodo(sessao)+" agendada com sucesso!\n");
						}						
						
					}//fim agendamento de manutenção por sessão

					if(menu4==3) {
						//Informa e valida a peça onde vai ocorrer a manutenção
						peca=Valida.validaManutencaoPeca(sc);
						//Verifica se há ingressos comprados na peça na qual vai acontecer manutenção e pede confirmação para continuar, se houver	
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
							System.out.println("\nManutenção na peça: "+Imprime.imprimePeca(peca)+" agendada com sucesso!\n");
						}	
					}//fim de agendamento de manutenção por peça	
				}while(menu!=4);
			}//end menu 4 agendar manutenção
			/*else if(menu==9) {
				loop++;
			}*/
		}while(loop==0);

		sc.close();
	}//end main

}//end class
