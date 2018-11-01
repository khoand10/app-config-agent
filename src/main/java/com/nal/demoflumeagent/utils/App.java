package com.nal.demoflumeagent.utils;

import com.nal.demoflumeagent.model.ExecSourceModel;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        ConfigFlume configFlume = new ConfigFlume();
        ExecSourceModel execSourceModel = new ExecSourceModel("/log/logs.txt","logs-server10","localhost:9092");
        configFlume.configExecSource(execSourceModel);
    }
}
