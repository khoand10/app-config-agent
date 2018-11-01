package com.nal.demoflumeagent.model;

public class ExecSourceModel {

    private String urlFile;
    private String topic;
    private String uriKafka;

    public ExecSourceModel () {
    }

    public ExecSourceModel(String urlFile, String topic, String uriKafka) {
        this.urlFile = urlFile;
        this.topic = topic;
        this.uriKafka = uriKafka;
    }

    public String getUrlFile() {
        return urlFile;
    }

    public void setUrlFile(String urlFile) {
        this.urlFile = urlFile;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getUriKafka() {
        return uriKafka;
    }

    public void setUriKafka(String uriKafka) {
        this.uriKafka = uriKafka;
    }

    @Override
    public String toString() {
        return "ExecSourceModel{" +
                "urlFile='" + urlFile + '\'' +
                ", topic='" + topic + '\'' +
                ", uriKafka='" + uriKafka + '\'' +
                '}';
    }
}
