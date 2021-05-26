package Cinema;
import java.util.Random;

import EscritorLog.escreveLogs;
import EstruturaDeDados.pilhaLigada;


public class Ingressos
{
    //método para os ingressos(randomizar os ingressos)
    static pilhaLigada pilhaIngressos = new pilhaLigada();
    private int tamanhoOcupado = 0;
    private static escreveLogs logr = new escreveLogs();  


    static int sala1= 0;
    static int sala2= 0;
    static int sala3= 0;
    static int sala4= 0;
    static int sala5= 0;

    //Gera os ingressos e coloca em uma pilha
    private void gerarIngressos()
    {
        Random gerador = new Random();
        int quantidadeIngressos=5;
        while(tamanhoOcupado !=quantidadeIngressos)
        {
            int salaDoIngresso = gerador.nextInt(5);
         
                if(salaDoIngresso == 0 && sala1 < 15)
                {
                    pilhaIngressos.push(tamanhoOcupado, "sala1");
                    sala1++;
                    tamanhoOcupado++;
                }
                else if(salaDoIngresso == 1 && sala2 < 15)
                {
                    pilhaIngressos.push(tamanhoOcupado, "sala2");
                    sala2++;
                    tamanhoOcupado++;
                }
                else if(salaDoIngresso == 2 && sala3 < 15)
                {
                    pilhaIngressos.push(tamanhoOcupado, "sala3");
                    sala3++;
                    tamanhoOcupado++;
                }
                else if(salaDoIngresso == 3 && sala4 < 15)
                {
                    pilhaIngressos.push(tamanhoOcupado, "sala4");
                    sala4++;
                    tamanhoOcupado++;
                }
                else if(salaDoIngresso == 4 && sala5 < 15)
                {
                    pilhaIngressos.push(tamanhoOcupado, "sala5");
                    sala5++;     
                    tamanhoOcupado++;
                }                                                     
        }
        logr.receberString("Pilha inicializada com um total de " + tamanhoOcupado + " ingressos"); 
    }
    //Inicializa a pilha
    public void inicializarPilha()
    {
        if(pilhaIngressos.isEmpty())
        {
            gerarIngressos();
        }
        else
        {
            System.out.println("Pilha De Ingressos Já existe");
        }
    }    
    //Remove o elemento que está no topo da pilha e o retorna
    public String direcionarAluno() throws NullPointerException
    {
        String sala = pilhaIngressos.pop().toString();
        if(sala == "")
        {
            logr.receberString("Acabou os ingressos");
            return "";
        }
        return sala;
    }
  
    //Controla a quantidade disponível de ingressos em cada sala
    public static void gerenciarSala(String sala)
    {
        if(sala == "sala1")
        {
            sala1--;
        }
        else if(sala == "sala2")
        {
            sala2--;
        }
        if(sala == "sala3")
        {
            sala3--;
        }
        if(sala == "sala4")
        {
            sala4--;
        }
        if(sala == "sala5")
        {
            sala5--;
        }
    }
    //Imprime a quantidade de ingressos na sala
    public static void imprimirIngressos()
    {
        System.out.println(" ");
        System.out.println("Quantidade De Ingressos na Sala 1:" + sala1);
        System.out.println("Quantidade De Ingressos na Sala 2:" + sala2);
        System.out.println("Quantidade De Ingressos na Sala 3:" + sala3);
        System.out.println("Quantidade De Ingressos na Sala 4:" + sala4);
        System.out.println("Quantidade De Ingressos na Sala 5:" + sala5);
        System.out.println(" ");
        if(sala1 == 0 && sala2 == 0 && sala3 == 0 && sala4 ==0 && sala5 == 0)
        {
            logr.receberString("Não tem ingressos disponíveis");
        }
    }
    //Retorna o tamanho da pilha
    public int tamanhoDaPilha()
    {
        return pilhaIngressos.tamanho();
    }
}