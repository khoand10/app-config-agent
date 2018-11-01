package com.nal.demoflumeagent.utils;

import com.nal.demoflumeagent.model.ExecSourceModel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ConfigFlume {

    public void configExecSource(ExecSourceModel execSourceModel) {
        String data = "";
        String content = "";
        String fileName = "/Users/Khoand/Documents/nal/1/demo-flume-agent/apache-flume-1.8.0-bin/conf/exec.conf";
        clear(fileName);
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
        //System.out.println("new data>>>>\n"+content);
        write(fileName, content);
    }

    public void clear(String fileName){
        write(fileName, Flume.DEFAUL_DATA);
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
