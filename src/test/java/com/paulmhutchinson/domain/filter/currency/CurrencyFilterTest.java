package com.paulmhutchinson.domain.filter.currency;

import com.paulmhutchinson.domain.stock.Currency;
import com.paulmhutchinson.domain.stock.StockFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import yahoofinance.Stock;

import java.util.*;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class CurrencyFilterTest {

    private static final Set<Currency> CURRENCIES = Collections.singleton(Currency.USD);
    private static final Set<String> VALID_SYMBOLS = new HashSet<>(Arrays.asList("A", "B", "C", "D", "E"));

    private List<Stock> stocks = StockFactory.buildDefaultStocks();
    private CurrencyFilter currencyFilter;

    @Before
    public void init() {
        currencyFilter = new CurrencyFilter(CURRENCIES.toString());
    }

    @Test
    public void apply_WithListOfStocks_ExpectOnlyStocksWithValidCurrencies() {
        List<Stock> validStocks = StockFactory.getStocksFromSymbols(stocks, VALID_SYMBOLS);

        currencyFilter.filter(stocks);

        assertTrue(stocks.equals(validStocks));
    }
}
