package com.paulmhutchinson.domain.input;

import com.google.gson.annotations.SerializedName;
import com.paulmhutchinson.domain.filter.Filter;
import com.paulmhutchinson.domain.recognizer.Recognizer;
import com.paulmhutchinson.domain.sorter.Sorter;

import java.util.Set;

public class Input {

    @SerializedName("filters") private Set<Filter> filters;
    @SerializedName("recognizers") private Set<Recognizer> recognizers;
    @SerializedName("sorters") private Set<Sorter> sorters;
    @SerializedName("symbols") private Set<String> symbols;
    @SerializedName("symbolFile") private String symbolFile;
    @SerializedName("output") private Boolean output;

    public Input() {
    }

    public Input(Set<Filter> filters, Set<Recognizer> recognizers, Set<Sorter> sorters, Set<String> symbols, String symbolFile, Boolean output) {
        this.filters = filters;
        this.recognizers = recognizers;
        this.sorters = sorters;
        this.symbols = symbols;
        this.symbolFile = symbolFile;
        this.output = output;
    }

    public Set<Filter> getFilters() {
        return filters;
    }

    public void setFilters(Set<Filter> filters) {
        this.filters = filters;
    }

    public Set<Recognizer> getRecognizers() {
        return recognizers;
    }

    public void setRecognizers(Set<Recognizer> recognizers) {
        this.recognizers = recognizers;
    }

    public Set<Sorter> getSorters() {
        return sorters;
    }

    public void setSorters(Set<Sorter> sorters) {
        this.sorters = sorters;
    }

    public Set<String> getSymbols() {
        return symbols;
    }

    public void setSymbols(Set<String> symbols) {
        this.symbols = symbols;
    }

    public String getSymbolFile() {
        return symbolFile;
    }

    public void setSymbolFile(String symbolFile) {
        this.symbolFile = symbolFile;
    }

    public Boolean isOutput() {
        return output;
    }

    public void setOutput(Boolean output) {
        this.output = output;
    }
}