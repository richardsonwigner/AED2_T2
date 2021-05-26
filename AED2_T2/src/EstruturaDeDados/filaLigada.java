package EstruturaDeDados;
public class filaLigada
{
    public Celula inicio;
    public Celula fim;
    private int totalDeElementos;

    public filaLigada()
    {
        totalDeElementos = 0;
        inicio = null;
        fim = null;
    }
    public boolean filaVazia()
    {
        if(this.totalDeElementos == 0)
        {
            return true;
        }
        return false;
    }
    public void adiciona(Object elemento)
    {
        Celula novo = new Celula(elemento,null);
        if(filaVazia())
        {
            this.inicio = novo;
            this.fim = novo;
        }
        else
        {
            // 0 -> 1-> null 
            this.fim.setProximo(novo);
            this.fim = novo;            
            
        }
        totalDeElementos++;
    }
    public void remove()
    {        
        if(filaVazia())
        {           
           System.out.println("Fila Vazia");
        }    
        this.inicio = inicio.getProximo();   
        totalDeElementos--;
    }

    public Object pega(int posicao) 
	{
		return pegaCelula(posicao).getElemento();
	}

    public boolean posicaoOcupada(int posicao)
	{
		return posicao >= 0 && posicao < this.totalDeElementos;
	}

    private Celula pegaCelula(int posicao) 
	{
		Celula atual = inicio;
		//Percorre a lista fazendo a célula atual apontar para o proximo da célula atual.
		for (int i = 0; i < posicao; i++)
		{
			atual = atual.getProximo();
		}
		return atual;
	}
    public int tamanho()
    {
        return totalDeElementos;
    }
    public String toString () 
	{
		if(this.totalDeElementos == 0) 
		{
			return " ";
		}	
		Celula atual = inicio;
	
		StringBuilder builder = new StringBuilder("");
	
		for(int i = 0; i < totalDeElementos; i++) 
		{
			builder.append(atual.getElemento());
			builder.append(" ");
	
			atual = atual.getProximo();
		}
	
		builder.append(" ");
	
		return builder.toString();
	}

}