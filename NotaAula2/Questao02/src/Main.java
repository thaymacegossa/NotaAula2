import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a distância percorrida (km): ");
        double distancia = scanner.nextDouble();

        System.out.print("Digite o tempo de espera (minutos): ");
        int tempoEspera = scanner.nextInt();

        System.out.print("Digite a tarifa base: R$");
        double tarifaBase = scanner.nextDouble();

        System.out.print("Digite o fator de demanda (ex: 1.5 para aumento de 50%): ");
        double fatorDemanda = scanner.nextDouble();

        CorridaUber corrida = new CorridaUber(distancia, tempoEspera, tarifaBase, fatorDemanda);

        corrida.exibirDetalhesCorrida();

        scanner.close();
    }
}

