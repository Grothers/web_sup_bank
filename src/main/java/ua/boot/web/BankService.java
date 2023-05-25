package ua.boot.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ua.boot.web.model.TransferBalance;

import java.math.BigDecimal;

@AllArgsConstructor
@Service
public class BankService {

    private final BalanceRepository repository;

    public BigDecimal getBalance(Long accountId) {
       BigDecimal balance =  repository.getBalanceForId(accountId);

       if (balance == null){
           throw new IllegalArgumentException("Balance is null");
       }
       return balance;

    }

    public BigDecimal addMoney(Long to, BigDecimal amount) {
        return null;
    }

    public void makeTransfer(TransferBalance transferBalance) {

    }
}
