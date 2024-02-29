public class ContaPJ extends Conta{
    private double limiteEmprestimo;

    public ContaPJ() {
        super();
    }

    public ContaPJ(int numero, String nome, double saldo, double limiteEmprestimo) {
        super(numero, nome, saldo);
        this.limiteEmprestimo = limiteEmprestimo;
    }
    public void emprestimo(double quantia){
        if (quantia <= limiteEmprestimo){
            saldo += quantia;
        }
    }
    @Override
    public void saque(double quantia){
        super.saque(quantia);
    }
}