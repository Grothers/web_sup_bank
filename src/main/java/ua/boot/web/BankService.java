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
        BigDecimal currentBalance = repository.getBalanceForId(to);
        if (currentBalance == null){
            repository.save(to,amount);
            return amount;
        } else{
            BigDecimal updateBalance = currentBalance.add(amount);
            repository.save(to, updateBalance);
            return updateBalance;
        }
    }

    public void makeTransfer(TransferBalance transferBalance) {
        BigDecimal fromBalance = repository.getBalanceForId(transferBalance.getFrom());
        BigDecimal toBalance = repository.getBalanceForId(transferBalance.getTo());
        if (fromBalance == null|| toBalance == null) throw new IllegalArgumentException("No ids");

        if (transferBalance.getAmount().compareTo(fromBalance) > 0)
            throw new IllegalArgumentException("No money");

        BigDecimal updatedFromBalance = fromBalance.subtract(transferBalance.getAmount());
        BigDecimal updatedToBalance = toBalance.add(transferBalance.getAmount());
        repository.save(transferBalance.getFrom(),updatedFromBalance);
        repository.save(transferBalance.getFrom(),updatedToBalance);



    }

    }

