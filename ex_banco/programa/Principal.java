package programa;
import java.util.Scanner;

import entidades.Conta_bancaria;


public class Principal{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        Conta_bancaria conta;
        
        System.out.print("digite numero da conta: ");
        String n_conta = sc.nextLine();
        System.out.print("digite nome do titular da conta: ");
        String titular = sc.nextLine();
        System.out.println("Irá fazer deposito inicial (s/n) ?");
        char resposta = sc.next().charAt(0);
        if (resposta == 's'){
            System.out.print("digite o valor do deposito inicial: ");
            double saldo = sc.nextDouble();
            conta = new Conta_bancaria(n_conta,titular,saldo);
        }
        else{
            conta = new Conta_bancaria(n_conta,titular);
        }
        System.out.println();
        System.out.println("Dados da Conta:");
        System.out.print(conta);
        System.out.println();
        System.out.print("digite o valor para deposito: ");
        double valor = sc.nextDouble();
        conta.deposito(valor);
        System.out.println();
        System.out.println("Dados da Conta:");
        System.out.print(conta);
        System.out.println();
        System.out.print("digite o valor para saque: ");
        double valor_sac = sc.nextDouble();
        conta.saque(valor_sac);
        System.out.println();
        System.out.println("Dados da Conta:");
        System.out.print(conta);
        sc.close();
    }
}