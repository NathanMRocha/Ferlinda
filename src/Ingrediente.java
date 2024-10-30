public class Ingrediente {
    private  String nome;
    private double quantidade;
    private double precoPorUnidade;

    public Ingrediente(String nome, double quantidade, double precoPorUnidade){
        this.nome = nome;
        this.quantidade = quantidade;
        this.precoPorUnidade = precoPorUnidade;
    }
    public double custoTotal(){
        return quantidade * precoPorUnidade;
    }
}
