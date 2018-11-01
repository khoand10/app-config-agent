package com.nal.demoflumeagent.utils;

public class Flume {
    public static String DEFAUL_DATA = "a1.sources = r1\n" +
            "a1.sinks = sink1\n" +
            "a1.channels = channel1\n" +
            "a1.sources.r1.type = exec\n" +
            "a1.sources.r1.command = tail -F #sourcefile\n" +
            "a1.sources.r1.channels = c1\n" +
            "\n" +
            "a1.channels.channel1.type = memory\n" +
            "a1.channels.channel1.capacity = 10000\n" +
            "a1.channels.channel1.transactionCapacity = 1000\n" +
            "\n" +
            "a1.sources.r1.channels = channel1\n" +
            "\n" +
            "a1.sinks.sink1.type = org.apache.flume.sink.kafka.KafkaSink\n" +
            "a1.sinks.sink1.topic = #topicname\n" +
            "a1.sinks.sink1.brokerList = #uri\n" +
            "a1.sinks.sink1.batchSize = 100\n" +
            "a1.sinks.sink1.channel = channel1\n";
}
