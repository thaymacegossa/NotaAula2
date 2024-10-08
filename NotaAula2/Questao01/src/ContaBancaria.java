public abstract class ContaBancaria {
    protected String titular;
    protected double saldo;


    public ContaBancaria(String titular) {
        this.titular = titular;
        this.saldo = 0.0;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.printf("Depositado: R$%.2f\n", valor);
    }

    public boolean sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            System.out.printf("Sacado: R$%.2f\n", valor);
            return true;
        } else {
            System.out.println("Saldo insuficiente.");
            return false;
        }
    }

    public void exibirDados() {
        System.out.println("Titular: " + titular);
        System.out.printf("Saldo: R$%.2f\n", saldo);
    }
}
