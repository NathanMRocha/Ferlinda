import java.util.Locale;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locale.setDefault(new Locale("pt", "BR"));

        // Pergunta o nome da receita
        System.out.print("Qual o nome da sua receita? ");
        String nomeReceita = scanner.nextLine();

        // Cria uma nova receita com o nome informado
        Receita receita = new Receita(nomeReceita);

        // Pergunta quantos ingredientes serão adicionados
        System.out.print("Quantos ingredientes você deseja adicionar? ");
        int numIngredientes = scanner.nextInt();
        scanner.nextLine(); // Consome a quebra de linha

        // Loop para adicionar os ingredientes
        for (int i = 0; i < numIngredientes; i++) {
            System.out.print("Nome do ingrediente: ");
            String nomeIngrediente = scanner.nextLine();
            System.out.print("Quantidade em Kilo/Litros: ");
            double quantidade = scanner.nextDouble();
            System.out.print("Preço por Kilo/Litros: ");
            double preco = scanner.nextDouble();
            scanner.nextLine(); // Consome a quebra de linha

            // Adiciona o ingrediente à receita
            receita.adicionarIngrediente(new Ingrediente(nomeIngrediente, quantidade, preco));
        }

        // Pergunta o custo das embalagens
        System.out.print("Quanto você gastou com embalagens por unidade? ");
        double custoEmbalagens = scanner.nextDouble();
        receita.definirCustoEmbalagens(custoEmbalagens);

        // Pergunta a quantidade de unidades produzidas
        System.out.print("Quantas unidades essa receita produz? ");
        int quantidadeUnidades = scanner.nextInt();
        if (quantidadeUnidades <= 0) {
            System.out.println("A quantidade de unidades deve ser maior que zero.");
            scanner.close();
            return;
        }
        receita.definirQuantidadeUnidades(quantidadeUnidades);

        // Pergunta a porcentagem de lucro desejada
        System.out.print("Qual é a porcentagem de lucro desejada? ");
        double percentualLucro = scanner.nextDouble();

        // Calcula o custo total e o preço de venda
        double custoTotal = receita.custoTotal();
        double precoVendaTotal = receita.calcularPrecoVenda(percentualLucro);
        double precoVendaPorUnidade = receita.calcularPrecoVendaPorUnidade(percentualLucro);

        // Exibe os resultados
        System.out.printf("A receita \"%s\" teve o custo total de: R$ %.2f%n", nomeReceita, custoTotal);
        System.out.printf("Preço de venda total sugerido: R$ %.2f%n", precoVendaTotal);
        System.out.printf("Preço de venda por unidade sugerido: R$ %.2f%n", precoVendaPorUnidade);

        scanner.close();
    }
}