package com.nal.demoflumeagent.utils;

import com.nal.demoflumeagent.model.ExecSourceModel;
import com.nal.demoflumeagent.model.HttpSourceModel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConfigFlume {

    private String exec = "./apache-flume-1.8.0-bin/start.sh";

    public void configExecSource(ExecSourceModel execSourceModel) {
        String data = "";
        String content = "";
        String fileName = "./apache-flume-1.8.0-bin/conf/exec.conf";
        clear(fileName, Flume.DEFAUL_EXEC);
        try {
            data = new String(Files.readAllBytes(Paths.get(fileName)),
                    StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String line : data.split("\n")) {
            if (line.contains("#")) {
                String newRow = "";
                if (line.contains("command")) {
                    newRow = line.split("#")[0] + execSourceModel.getUrlFile() + "\n";
                }
                if (line.contains("topic")) {
                    newRow = line.split("#")[0] + execSourceModel.getTopic() + "\n";
                }

                if (line.contains("brokerList")) {
                    newRow = line.split("#")[0] + execSourceModel.getUriKafka() + "\n";
                }
                content += newRow;
            } else {
                content += line + "\n";
            }
        }
        write(fileName, content);
        write(exec, Flume.execRun);
    }

    public void configHttpSource(HttpSourceModel httpSourceModel) {
        String data = "";
        String content = "";
        String fileName = "./apache-flume-1.8.0-bin/conf/http.conf";
        clear(fileName, Flume.DEFAUL_HTTP);
        try {
            data = new String(Files.readAllBytes(Paths.get(fileName)),
                    StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String line : data.split("\n")) {
            if (line.contains("#")) {
                String newRow = "";
                if (line.contains("sources.r1.port")) {
                    newRow = line.split("#")[0] + httpSourceModel.getPort() + "\n";
                }
                if (line.contains("topic")) {
                    newRow = line.split("#")[0] + httpSourceModel.getTopic() + "\n";
                }

                if (line.contains("brokerList")) {
                    newRow = line.split("#")[0] + httpSourceModel.getUriKafka() + "\n";
                }
                content += newRow;
            } else {
                content += line + "\n";
            }
        }
        write(fileName, content);
        write(exec, Flume.httpRun);
    }

    public void clear(String fileName, String defaul) {
        write(fileName, defaul);
    }

    public void write(String fileName, String content) {
        try {
            File f = new File(fileName);
            FileWriter fw = new FileWriter(f);
            fw.write(content);
            fw.close();
        } catch (IOException ex) {
            System.out.println("Loi ghi file: " + ex);
        }
    }

}
