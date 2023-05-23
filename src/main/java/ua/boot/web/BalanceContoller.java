package ua.boot.web;

import org.springframework.web.bind.annotation.*;
import ua.boot.web.model.TransferBalance;

import java.math.BigDecimal;

@RestController("/balance")
public class BalanceContoller {

    @GetMapping("/{accountId}")
    public BigDecimal getBalance(@PathVariable Long accountId){

    }

    @PostMapping("/add")
    public BigDecimal addMoney(@RequestBody TransferBalance amount) {
    }

    @PostMapping("/transfer")
    public BigDecimal transfer(@RequestBody TransferBalance transferBalance) {
    }


}
