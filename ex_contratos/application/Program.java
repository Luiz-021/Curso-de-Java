package ex_contratos.application;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import ex_contratos.entities.Contract;
import ex_contratos.entities.Installment;
import ex_contratos.services.ContractService;
import ex_contratos.services.PaypalService;

public class Program {
    public static void main(String[] args) throws ParseException{
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre os dados do contrato:");
        System.out.print("Número: ");
        int number = sc.nextInt();
        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(sc.next(),fmt);
        System.out.print("Valor do contrato: ");
        double totalvalue = sc.nextDouble();

        Contract obj = new Contract(number, date, totalvalue);

        System.out.print("Digite o número de parcelas: ");
        int n = sc.nextInt();
        
        ContractService contractService = new ContractService(new PaypalService());

        contractService.processContract(obj, n);

        System.out.println("Parcelas:");

        for(Installment installment : obj.getInstallments()){
            System.out.println(installment);
        }

        sc.close();
    }
}
