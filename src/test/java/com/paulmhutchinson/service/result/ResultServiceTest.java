package com.paulmhutchinson.service.result;

import com.paulmhutchinson.domain.filter.FilterFactory;
import com.paulmhutchinson.domain.result.Result;
import com.paulmhutchinson.domain.result.ResultFactory;
import com.paulmhutchinson.domain.stock.StockFactory;
import com.paulmhutchinson.service.filter.FilterService;
import com.paulmhutchinson.service.recognizer.RecognizerService;
import org.apache.commons.collections4.SetUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ResultServiceTest {

    private static final Result RESULT = ResultFactory.buildDefaultResult();

    private ResultService resultService;

    @Before
    public void init() {
        FilterService filterService = new FilterService(FilterFactory.buildDefaultFilters());
        RecognizerService recognizerService = new RecognizerService(SetUtils.emptySet());//RecognizerFactory.buildDefaultRecognizers());
        resultService = new ResultService(filterService, recognizerService);
    }

    @Test
    public void getResult_withDefaultValues_expectCorrectResult() throws IOException {
        Result result = resultService.getResult(StockFactory.buildDefaultStocks());

        assertEquals(RESULT.toString(), result.toString());
    }
}
