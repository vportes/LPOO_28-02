public class Conta {
    private int numero;
    private String titular;
    protected double saldo;

    public Conta(){

    }

    public Conta(int numero, String nome, double saldo) {
        this.numero = numero;
        this.titular = nome;
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void saque(double quantia){
        saldo -= quantia + 5.0;
    }

    public void deposito(double quantia){
        saldo += quantia;
    }
    @Override
    public String toString() {
        return  "\n---"+
                "\nConta: " + + getNumero() +
                "\nTitular: " + getTitular() +
                "\nSaldo: " + String.format("%.2f",getSaldo()) +
                "\n---";
    }
}