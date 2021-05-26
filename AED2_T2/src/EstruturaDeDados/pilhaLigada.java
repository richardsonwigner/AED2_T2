package EstruturaDeDados;
public class pilhaLigada
{
    No topo;
    int tamanhoDaPilha;

    public pilhaLigada()
    {
        topo = null;
        tamanhoDaPilha = 0;
    }

    public boolean isEmpty(){
        return topo == null;
    }

    public void push(int codigo, String nome){

        No novoNo = new No(codigo,nome);

        if ( isEmpty() ){
            topo = novoNo;
            novoNo.setProximo(null);
        }else{
            novoNo.setProximo(topo);
            topo = novoNo;
        }

        tamanhoDaPilha++;

    }

    public String pop(){

        String resultado = "";

        if ( !isEmpty() ){

            resultado = top();

            No auxiliar = topo;

            topo = topo.getProximo();
            auxiliar.setProximo(null);

            tamanhoDaPilha--;
            
        }

        return resultado; 

    }

    public String top(){
        if ( !isEmpty() )
            return topo.toString();
        return "";
    }
    public int tamanho()
    {
       return this.tamanhoDaPilha;
    }

    public String print(){

        String resultado = "";

        if ( !isEmpty() ){

            No auxiliar = topo;
            
            while ( auxiliar != null ){

                resultado = resultado + auxiliar.toString();
                auxiliar = auxiliar.getProximo();

            }
            
        }

        return resultado;
    }
}
