package EstruturaDeDados;
public class No 
{
    private int codigoUsuario;
    private String nomeUsuario;
    
    private No proximo;
    
    /*-----------------------------------
            CONSTRUTOR DA CLASSE
    -----------------------------------*/
    
    public No(int codigoUsuario, String nomeUsuario) {
        this.codigoUsuario = codigoUsuario;
        this.nomeUsuario   = nomeUsuario;
    }
    
    /*-----------------------------------
                MÉTODOS DA CLASSE
    -----------------------------------*/
    
    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public No getProximo(){
        return proximo;
    }

    public void setProximo(No proximo){
        this.proximo = proximo;
    }

    // Método que retorna os dados do usuário.
    public String toString(){

        return getNomeUsuario();

    }

}
