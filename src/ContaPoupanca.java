public class ContaPoupanca extends Conta{
    private double taxaJuro;

    public ContaPoupanca(){
        super();
    }

    public ContaPoupanca(int numero, String nome, double saldo, double taxaJuro) {
        super(numero, nome, saldo);
        this.taxaJuro = taxaJuro;
    }

    public double getTaxaJuro() {
        return taxaJuro;
    }

    public void setTaxaJuro(double taxaJuro) {
        this.taxaJuro = taxaJuro;
    }

    public void atualizaSaldo(){
        saldo += saldo*taxaJuro;
    }
    @Override
    public void saque(double quantia){
        saldo -= quantia;
    }
    @Override
    public String toString() {
        return  "\n---"+
                "\nConta: " + + getNumero() +
                "\nTitular: " + getTitular() +
                "\nSaldo: " + String.format("%.2f",getSaldo()) +
                "\nTaxa Juros: " + getTaxaJuro() +
                "\n---";
    }
}