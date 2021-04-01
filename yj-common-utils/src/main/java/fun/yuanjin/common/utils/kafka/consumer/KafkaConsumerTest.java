package fun.yuanjin.common.utils.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @ClassName KafkaConsumerAnalysis
 * @Description TODO
 * @Author yuanjin
 * @Date 2020-12-05 23:00
 * @Version 1.0
 */
public class KafkaConsumerTest {
    public static final String brokerList = "localhost:9092";
    public static final String topic = "topic-demo";
    public static final String groupId = "group.demo";
    public static final AtomicBoolean isRunning = new AtomicBoolean(true);

    // （1）配置客户端参数
    public static Properties initConfig() {
        Properties props = new Properties();
        // bootstrap.servers 指定消费者客户端连接kafka集群所需broker地址清单，格式为host1:port1,host2:port2,host3:port3
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerList);
        // key.serializer和value.serializer，broker端接收到消息必须以字节数组存在（byte[]），因此需要指定序列化器，两个参数均无默认值。
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        // 消费组的名称
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        // client.id，代表消费者客户端的id，如果不设置，KafkaConsumer会自动生成一个。例如consumer-1。
        props.put(ConsumerConfig.CLIENT_ID_CONFIG, "consumer.client.id.demo");
        return props;
    }

    public static void main(String[] args) {
        Properties props = initConfig();
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
        consumer.subscribe(Arrays.asList(topic));
        List<TopicPartition> partitions = new ArrayList<>();
        List<PartitionInfo> partitionInfos = consumer.partitionsFor(topic);
        if (partitionInfos != null) {
            for (PartitionInfo partitionInfo : partitionInfos) {
                partitions.add(new TopicPartition(partitionInfo.topic(), partitionInfo.partition()));
            }
        }
        consumer.assign(partitions);
        try {
            while (isRunning.get()) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
                Thread.sleep(2000000L);
                for (ConsumerRecord<String, String> record : records) {
                    System.out.println("topic = " + record.topic() +
                            ",partition = " + record.partition() +
                            ",offset = " + record.offset() +
                            ",key = " + record.key() +
                            ",value = " + record.value());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            consumer.close();
        }
    }
}
