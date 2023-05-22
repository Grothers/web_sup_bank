package ua.boot.web;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController("/balance")
public class BalanceContoller {

    @GetMapping("/{accountId}")
    public BigDecimal getBalance(@PathVariable Long accountId){

    }

    @PostMapping("/{accountId}")
    public BigDecimal addMoney(@PathVariable Long accountId,
                               @RequestBody BigDecimal amount
    ) {
    }

    @PostMapping("/transfer")
    public BigDecimal transfer(@PathVariable Long accountId,
                               @RequestBody BigDecimal amount
    ) {
    }
}
