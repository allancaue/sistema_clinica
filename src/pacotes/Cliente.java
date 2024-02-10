package pacotes;

public class Cliente {

    private int idade;
    private String nomeCliente;
    private int lugarNaFila;

    public Cliente(String nome, int idade) {
        this.nomeCliente = nome;
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }
    public int getLugarNaFila() {
        return lugarNaFila;
    }
    
    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public void setLugarNaFila(int lugarNaFila) {
        this.lugarNaFila = lugarNaFila;
    }
    

}
