package com.nal.demoflumeagent.utils;

public class Flume {
    public static final String DEFAUL_HTTP = "a1.sources = r1\n" +
            "a1.sinks = sink1\n" +
            "a1.channels = channel1\n" +
            "a1.sources.r1.type = com.nal.flume.source.HTTPSource\n" +
            "a1.sources.r1.port = #portListen\n" +
            "a1.sources.r1.channels = c1\n" +
            "a1.sources.r1.handler = org.apache.flume.source.http.JSONHandler\n" +
            "a1.sources.r1.handler.nickname = random props" +
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
    public static String DEFAUL_EXEC = "a1.sources = r1\n" +
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

    public static String execRun = "bin/flume-ng agent --conf conf --conf-file conf/exec.conf  -Dflume.root.logger=DEBUG,console --name a1 -Xmx512m -Xms256m";
    public static String httpRun = "bin/flume-ng agent --conf conf --conf-file conf/http.conf  -Dflume.root.logger=DEBUG,console --name a1 -Xmx512m -Xms256m";

}
