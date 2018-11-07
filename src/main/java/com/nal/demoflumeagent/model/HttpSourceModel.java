package com.nal.demoflumeagent.model;

public class HttpSourceModel {

    private String port;
    private String topic;
    private String uriKafka;

    public HttpSourceModel(){
    }

    public HttpSourceModel(String port, String topic, String uriKafka) {
        this.port = port;
        this.topic = topic;
        this.uriKafka = uriKafka;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
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
        return "HttpSourceModel{" +
                "port='" + port + '\'' +
                ", topic='" + topic + '\'' +
                ", uriKafka='" + uriKafka + '\'' +
                '}';
    }
}
