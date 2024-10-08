public class ContaCorrente extends ContaBancaria {
    private double chequeEspecial = 1000.00;

    public ContaCorrente(String titular) {
        super(titular);
    }

    @Override
    public boolean sacar(double valor) {
        if (saldo + chequeEspecial >= valor) {
            if (saldo >= valor) {
                saldo -= valor;
            } else {
                chequeEspecial -= (valor - saldo);
                saldo = 0;
            }
            System.out.printf("Sacado: R$%.2f\n", valor);
            return true;
        } else {
            System.out.println("Saldo insuficiente e cheque especial não cobre o valor.");
            return false;
        }
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.printf("Cheque Especial disponível: R$%.2f\n", chequeEspecial);
    }
}
