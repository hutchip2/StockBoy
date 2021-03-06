package com.paulmhutchinson.domain.filter.price.spread.minimum;

import com.paulmhutchinson.domain.filter.FilterType;
import com.paulmhutchinson.domain.filter.price.spread.SpreadFilter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component("MinSpreadFilter")
public abstract class MinSpreadFilter extends SpreadFilter {

    private transient BigDecimal minSpread;

    public MinSpreadFilter() {}

    public MinSpreadFilter(FilterType filterType, String filterValue) {
        super(filterType, filterValue);
        this.minSpread = new BigDecimal(filterValue);
    }

    protected boolean isGreaterThanMinSpread(BigDecimal spread) {
        return spread.compareTo(minSpread) >= 0;
    }
}
