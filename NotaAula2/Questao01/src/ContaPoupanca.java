public class ContaPoupanca extends ContaBancaria {
    private double selic;  // Taxa Selic

    public ContaPoupanca(String titular, double selic) {
        super(titular);
        this.selic = selic;
    }

    public void calcularRendimento() {
        double rendimento;

        if (selic > 8.5) {
            rendimento = saldo * 0.005;  // 0,5% ao mês
        } else {
            rendimento = saldo * (0.7 * (selic / 100));  // 70% da Selic ao mês
        }

        saldo += rendimento;  // Atualiza o saldo com o rendimento
        System.out.printf("Rendimento calculado: R$%.2f\n", rendimento);
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.printf("Taxa Selic: %.2f%%\n", selic);
    }
}
