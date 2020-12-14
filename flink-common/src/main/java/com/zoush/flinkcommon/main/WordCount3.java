package com.zoush.flinkcommon.main;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.util.Collector;

/**
 * 1. DataStream范例
 */

public class WordCount3 {

	public static void main(String[] args) throws Exception {
		StreamExecutionEnvironment env=StreamExecutionEnvironment.getExecutionEnvironment();

		env.setParallelism(1); //设置并行度

		DataStream<Tuple2<String, Integer>> ds=env.socketTextStream("172.18.206.8", 9999) //读取套接字流，使用命令 nc -lk 9999 在终端输入
				.flatMap(new FlatMapFunction<String, Tuple2<String, Integer>>(){

					@Override
					public void flatMap(String value, Collector<Tuple2<String, Integer>> out) throws Exception {
						for(String e: value.split(" ")){
							out.collect(new Tuple2<>(e, 1));
						}
					}
				})
				.keyBy(0) //可根据多个字段分区
				.timeWindow(Time.seconds(5)) //滚动窗口
				.sum(1); //对第2个字段汇总

		ds.print(); //将DataStream写到标准输出

		env.execute("WordCount"); //执行
	}
}
