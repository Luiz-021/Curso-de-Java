package ex_contratos.services;

import java.time.LocalDate;

import ex_contratos.entities.Contract;
import ex_contratos.entities.Installment;

public class ContractService {
    OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract( Contract contract, int months){
        double basicQuota = contract.getTotalvalue() / months;

        for( int i = 1; i <= months; i++){
            LocalDate dueDate = contract.getDate().plusMonths(i);
            
            double  interest = onlinePaymentService.interest(basicQuota, i);
            double fee = onlinePaymentService.paymentFee(basicQuota + interest);
            double quota = basicQuota + interest + fee;

            contract.getInstallments().add(new Installment(dueDate, quota));
        }

    }
}
