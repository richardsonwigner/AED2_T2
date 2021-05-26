package EscritorLog;
  
import java.io.*;  
import Cinema.*;

public class escreveLogs 
{

    filaCinema logFila = new filaCinema();
    Ingressos logIngressos = new Ingressos();

    private void escritorArquivo(String mensagem)  throws java.io.IOException
    {     
       File file = new File ("log.txt");
       try 
       {
           BufferedWriter out = new BufferedWriter(new FileWriter(file, true));
           out.write(mensagem);
           out.newLine();
           out.close();
       } 
       catch (IOException e)
       {
           System.out.println("Erro ao escrever arquivo");
       }
    }
      
  public void receberString(String mensagem)
    {
     try
        {
            System.out.println("\nAVISO: "+ mensagem);
            escritorArquivo("\n"+mensagem);
        }
     catch(IOException ex)
        {
            System.out.println("Erro na leitura");
        }
    }
}
        
        
        

  
    

