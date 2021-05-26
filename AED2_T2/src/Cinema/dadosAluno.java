package Cinema;

import java.util.Scanner;


import EstruturaDeDados.listaLigada;
import EscritorLog.escreveLogs;

public class dadosAluno
{
    static listaLigada[] alunosNoCinema;    
    static private int posicaoVetor = 0;
    String telefone;
    String email;
    private int capacidadeTotalCinema = 75;

    Scanner leitor = new Scanner(System.in);

    Ingressos pilhaIngressos = new Ingressos();
    filaCinema filaAluno = new filaCinema();

    private static escreveLogs logr = new escreveLogs();  

    public dadosAluno()
    {
        alunosNoCinema = new listaLigada[capacidadeTotalCinema];
    }

    //Adiciona os dados do aluno em um vetor de lista ligada
    public void adicionarAluno(String nome, String sala, String telefone, String email)
    {

        if(alunosNoCinema[0] == null)
        {
            inicializarVetor();
        }
            for(int x = 0; x < 4; x++)
            {
                switch(x)
                {
                    case 0:
                    alunosNoCinema[posicaoVetor].adiciona(x, nome);
                    break;

                    case 1:
                    alunosNoCinema[posicaoVetor].adiciona(x, sala);
                    break;

                    case 2:
                    alunosNoCinema[posicaoVetor].adiciona(x, telefone);
                    break;

                    case 3:
                    alunosNoCinema[posicaoVetor].adiciona(x, email);
                    break;
                }
            }
            logr.receberString("Aluno Adicionado Com Sucesso, Voltando ao menu principal");
            posicaoVetor++;
    }
    //Inicializa o vetor de lista ligada
    private void inicializarVetor()
    {
        for(int i = 0; i < capacidadeTotalCinema; i++)
        {
            alunosNoCinema[i] = new listaLigada();
        }
    }
    //Coloca os dados passado pelo aluno 
    public void colocarDados() throws NullPointerException
    {       
        String nome = filaAluno.colocarNome(); 
        String sala = pilhaIngressos.direcionarAluno();
        String telefone = "";
        String email = "";
        if(sala == "")
        {
            System.out.println("--------");
            System.out.println("Voltando ao menu principal");
            System.out.println("--------");
        }
        else
        {
            telefone = retornarTelefone(nome, telefone);
            email = retornarEmail(nome, email);

            logr.receberString(nome + " recebeu o ingresso da " +sala );
            Ingressos.gerenciarSala(sala);
            adicionarAluno(nome, sala, telefone, email);
        }

    }
    //Retorna o telefone passado pelo aluno
    private String retornarTelefone(String nome, String telefone)
    {
        Boolean loop = true;
        while(loop)
        {      
            try
            {
                System.out.println("Coloque os dados do aluno(a): " + nome);    
            
                System.out.println(nome + " deu o número do celular/telefone?");
                System.out.println("1: Sim||Outro número: Não");
                int opcao = Integer.parseInt(leitor.nextLine());
        
                if(opcao == 1)
                {        
                    while(telefone == "")
                    {
                        System.out.println("Coloque o Telefone(Pode conter o traço): ");
                        telefone = leitor.nextLine();
                        if(telefone == "")
                        {
                            System.out.println("Telefone não foi colocado");
                        }
                    }
                   
                    logr.receberString("Telefone: " + telefone +  " do aluno:" + nome + " adicionado com sucesso" );
                    
                    return telefone;
                }
                logr.receberString("Aluno Não Passou o Telefone");
                loop = false;
            }
            catch(NumberFormatException ex)
            {
                logr.receberString("\nNão é permitido colocar letras");
            }          
        }
        return "";
    }
    //retorna o email passado pelo aluno
    private String retornarEmail(String nome, String email)
    {
        while(email == "")
        {
            System.out.println("Email: ");
            email = leitor.nextLine();       
            if(email == "")
            {
                logr.receberString("Email não foi colocado");
            }
        }
        logr.receberString("Email: " + email +  " do aluno:" + nome + " adicionado com sucesso" );
        return email;
    }
    //Imprime os dados dos alunos que estão na lista ligada
    public static void imprimirDadosAlunos() throws NullPointerException
    {
        for(int i = 0; i < alunosNoCinema.length ; i++)
        {           
            if(alunosNoCinema[i].toString() == " ")
            {
                break;
            }
            System.out.print("|||||||||||||||");          
            System.out.print("\nNome : " + alunosNoCinema[i].pega(0) + "\nSala : " + alunosNoCinema[i].pega(1) + "\nTelefone : " + alunosNoCinema[i].pega(2) + "\nEmail : " + alunosNoCinema[i].pega(3));
            System.out.print("\n|||||||||||||||");
            System.out.println("\n");
        }
    }

}
