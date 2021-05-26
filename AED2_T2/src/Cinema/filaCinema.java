package Cinema;

import EstruturaDeDados.filaLigada;


import EscritorLog.escreveLogs;


public class filaCinema 
{
    static filaLigada fila = new filaLigada();
    private  static escreveLogs logr = new escreveLogs();   

    //Inicializa a fila com número de alunos na fila
    public void adicionarNaFila()
    {
        int NúmeroDeAlunos = 93;
        for(int i = 1; i <= NúmeroDeAlunos; i++)
        {
            fila.adiciona("Aluno N°" + i);
        }
        logr.receberString("Fila inicializada com um total de " + tamanhoDaFila() + " alunos");
    }
    //Pega o primeiro elemento da fila, remove da fila e retorna sua String
    public String colocarNome()
    {
        try
        {
            String aluno = (String)fila.pega(0);
            fila.remove();
            return aluno;
        }
        catch(IllegalArgumentException ex )
        {
            logr.receberString("Fila Vazia");
        }
        return "";
    }   
    //Retorna o primeiro da fila
    public String primeroDaFila()
    {
        return (String)fila.pega(0);
    }
    //Retorna o tamanho da fila
    public int tamanhoDaFila()
    {
        return fila.tamanho();
    }
}
