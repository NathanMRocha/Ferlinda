import java.util.ArrayList;
import java.util.List;

public class Receita {
    private String nome;
    private List<Ingrediente> ingredientes;
    private double custoEmbalagens;
    private int quantidadeUnidades;

    public Receita(String nome) {
        this.nome = nome;
        this.ingredientes = new ArrayList<>();
        this.custoEmbalagens = 0;
        this.quantidadeUnidades = 1; // Default para 1 unidade
    }

    public void adicionarIngrediente(Ingrediente ingrediente) {
        ingredientes.add(ingrediente);
    }

    public void definirCustoEmbalagens(double custoEmbalagens) {
        this.custoEmbalagens = custoEmbalagens;
    }

    public void definirQuantidadeUnidades(int quantidadeUnidades) {
        this.quantidadeUnidades = quantidadeUnidades > 0 ? quantidadeUnidades : 1;
    }

    public double custoTotal() {
        double total = custoEmbalagens * quantidadeUnidades;
        for (Ingrediente ingrediente : ingredientes) {
            total += ingrediente.custoTotal();
        }
        return total;
    }

    public double calcularPrecoVenda(double percentualLucro) {
        double custo = custoTotal();
        return custo + (custo * percentualLucro / 100);
    }

    public double calcularPrecoVendaPorUnidade(double percentualLucro) {
        double precoVendaTotal = calcularPrecoVenda(percentualLucro);
        if (quantidadeUnidades == 0) {
            throw new IllegalArgumentException("Quantidade de unidades não pode ser zero.");
        }
        return precoVendaTotal / quantidadeUnidades;
    }

}