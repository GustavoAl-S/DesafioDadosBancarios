package Models;

public class Conta {

    private Cliente cliente;
    private double saldo;

    public Conta(Cliente cliente, double saldo) {
        this.cliente = cliente;
        this.saldo = saldo;
    }

    public boolean depositar(double valorDeposito){
        if (valorDeposito > 0){
            saldo += valorDeposito;
            return true;
        }else {
            System.out.println("Valor de deposito invalido.");
            return false;
        }

    }

    public boolean sacar(double valorSaque){
        if (valorSaque > saldo || valorSaque < 0){
            System.out.println("Saldo insuficiente ou valor inválido.");
            return false;
        }else{
            saldo -= valorSaque;
            return true;
        }
    }

    public double consultarSaldo(){
        return getSaldo();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public static boolean verificarConta(String tipoDeConta){
        if (!tipoDeConta.equalsIgnoreCase("Corrente") && !tipoDeConta.equalsIgnoreCase("Poupanca")){
            return false;
        }else {
            return true;
        }
    }
}
