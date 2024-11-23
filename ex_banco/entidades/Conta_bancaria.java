package entidades;
public class Conta_bancaria {

    private String n_conta;
    private String titular;
    private double saldo;


    public Conta_bancaria(String n_conta, String titular, double depos_ini) {
        
        this.n_conta = n_conta;
        this.titular = titular;
        deposito(depos_ini);
    }

    public Conta_bancaria(String n_conta, String titular) {
        
        this.n_conta = n_conta;
        this.titular = titular;
        this.saldo = 0;
    }

    public String getn_conta(){
        return this.n_conta;
    }

    public String gettitular(){
        return this.titular;
    }

    public double getsaldo(){
        return this.saldo;
    }

    public void settitular( String titular){
        this.titular = titular;
    }

    public void deposito(double valor){
        this.saldo += valor;
    }

    public void saque(double valor){
        this.saldo -= valor + 5.0;
    }

    public String toString(){
        return "conta "
                + n_conta
                + ", titular "
                + titular
                + ", saldo $"
                + String.format("%.2f",saldo);
    }
}
