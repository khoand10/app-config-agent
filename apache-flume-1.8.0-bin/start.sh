bin/flume-ng agent --conf conf --conf-file conf/log-exec.conf  -Dflume.root.logger=DEBUG,console --name a1 -Xmx512m -Xms256m