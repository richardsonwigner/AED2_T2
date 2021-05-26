package Cinema;
import EscritorLog.escreveLogs;

import java.util.Scanner;

public class menu 
{
    Scanner leitor = new Scanner(System.in);
    dadosAluno dados = new dadosAluno();

    private static escreveLogs logr = new escreveLogs();     

    //Principal Menu de Navegação
    public void menuPrincipal()
    {
        while(true)
        {
            int opcao =0;
            System.out.println("|||||||| MENU PRINCIPAL ||||||||");
            System.out.println("1: Verificar Ingressos Disponíveis");
            System.out.println("2: Verificar Alunos em Sala");   
            System.out.println("3: Pedir Dados do Aluno na Fila");

            if(filaCinema.fila.filaVazia() || Ingressos.pilhaIngressos.isEmpty())
            {
                System.out.println("4: Encerrar Programa");
            }     
                try
                {
                    opcao = Integer.parseInt(leitor.next());
                }
                catch(NumberFormatException ex)
                {
                    logr.receberString("Não é permitido letras no menu");
                    leitor.reset();
                }
                if(opcao <= liberaOpcoes() && opcao > 0)
                {
                    switch(opcao)
                    {
                        case 1:
                        menuPilha();
                        
                        break;
            
                        case 2:
                        menuAlunosSala();
                        break;
                        
                        case 3:
                        menuPedirDados();
                        break;
            
                        case 4:
                        encerrarPrograma();
                        break;
                    }
                }  
                else
                {
                    System.out.println("Opção Indisponível");
                }  
        }     
    }

    //Chama o método que verifica a quantidade de ingressos disponíveis em cada sala
    private void menuPilha()
    {
        System.out.println("Ingressos Disponíveis");
        Ingressos.imprimirIngressos();
        menuPrincipal();
    }

    //Chama o método que imprime os alunos que estão no cinema
    private void menuAlunosSala()
    {
        System.out.println("Alunos:\n");
        try
        {
            dadosAluno.imprimirDadosAlunos();
        }
        catch(NullPointerException ex)
        {
            logr.receberString("\nNão tem alunos no cinema");
        }
       
        menuPrincipal();
    }
    
    //Chama o método que pede os dados do aluno
    private void menuPedirDados()
    {       
        try
        {
            dados.colocarDados();
        }
        catch(NullPointerException ex)
        {
            logr.receberString("Fila Vazia");
        }
        menuPrincipal();
        
    }

    //Encerra o programa, só é possível encerrar o programa após a pilha de ingressos acabar ou a fila ficar vazia
    private void encerrarPrograma()
    {
        logr.receberString("Programa Finalizado.");
        System.exit(0);
    }

    //Método para liberar a opção de encerrar o programa 
    private int liberaOpcoes()
    {
        int opcoesPermitidas = 3;
        if(filaCinema.fila.filaVazia() || Ingressos.pilhaIngressos.isEmpty())
        {
            return opcoesPermitidas = 4;
        }
        return opcoesPermitidas;
    }
    
}
