package com.paulmhutchinson.util.input;

import com.google.gson.GsonBuilder;
import com.paulmhutchinson.domain.filter.Filter;
import com.paulmhutchinson.domain.filter.FilterAdapter;
import com.paulmhutchinson.domain.input.Input;
import com.paulmhutchinson.domain.recognizer.Recognizer;
import com.paulmhutchinson.domain.recognizer.RecognizerAdapter;
import com.paulmhutchinson.domain.sorter.Sorter;
import com.paulmhutchinson.domain.sorter.SorterAdapter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class InputUtil {

    public static final String SYMBOL_FILE_PREFIX = "symbols/";

    private InputUtil() {
        throw new AssertionError();
    }

    public static Input process(String filename) throws IOException {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Filter.class, new FilterAdapter());
        gsonBuilder.registerTypeAdapter(Recognizer.class, new RecognizerAdapter());
        gsonBuilder.registerTypeAdapter(Sorter.class, new SorterAdapter());
        return gsonBuilder
                .create()
                .fromJson(extractJsonFromFile(filename), Input.class);
    }

    private static String extractJsonFromFile(String filename) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filename)));
    }
}
