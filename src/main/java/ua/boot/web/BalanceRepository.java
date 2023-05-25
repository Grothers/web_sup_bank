package ua.boot.web;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Repository
public class BalanceRepository {

    private final Map<Long, BigDecimal> storage = new HashMap<>(Map.of(1L,BigDecimal.ZERO));


    public BigDecimal getBalanceForId(Long accountId) {
        return storage.get(accountId);
    }
}
