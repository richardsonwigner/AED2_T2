package Cinema;

import java.time.format.DateTimeFormatter;

import EscritorLog.escreveLogs;

import java.time.LocalDateTime;

public class App
{
  static menu menuNavegacao = new menu();
  private static escreveLogs logr = new escreveLogs();  
  //Chama os métodos que inicializa a pilha de ingressos e a fila de alunos
  public static void main(String[] args) throws Exception
  {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
    LocalDateTime now = LocalDateTime.now();  
    escreveLogs logs = new escreveLogs();

    logs.receberString("||||||||Data e Hora Da Execução: " + dtf.format(now));  

    Ingressos cinemaIngressos = new Ingressos();

    filaCinema filaAlunos = new filaCinema();

    cinemaIngressos.inicializarPilha();

    filaAlunos.adicionarNaFila();

    iniciarMenu();
        
  }
  //Chama o método para inicializar o menu 
  public static void iniciarMenu()
  {   
    logr.receberString("MenuInicializado");
    menuNavegacao.menuPrincipal();
  }
    
}
  