package com.nal.demoflumeagent.model;

public class NetworkSourceModel {

    private String networkName;
    private String networkPort;
    private String topic;
    private String uriKafka;

    public NetworkSourceModel() {
    }

    public NetworkSourceModel(String networkName, String networkPort, String topic, String uriKafka) {
        this.networkName = networkName;
        this.networkPort = networkPort;
        this.topic = topic;
        this.uriKafka = uriKafka;
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

    public String getNetworkName() {
        return networkName;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }

    public String getNetworkPort() {
        return networkPort;
    }

    public void setNetworkPort(String networkPort) {
        this.networkPort = networkPort;
    }
}
