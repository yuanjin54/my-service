package fun.yuanjin.common.utils.kafka.consumer;

import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.Future;

/**
 * @ClassName KafkaProducerTest
 * @Description TODO
 * @Author yuanjin
 * @Date 2021-01-03 17:43
 * @Version 1.0
 */
public class KafkaProducerTest {
    public static final String brokerList = "localhost:9092";
    public static final String topic = "topic-demo";

    public static Properties initConfig() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerList);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "producer.client.id.demo");
        props.put(ProducerConfig.RETRIES_CONFIG, 10);//配置消息发送重试次数
        return props;
    }

    public static void main(String[] args) throws InterruptedException {
        Properties props = initConfig();
        // （2）创建相应的生产者实例；
        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        // （3）构建待发送的消息；
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, "我擦，大傻逼ww");
        try {
            // （4）发送消息；
            Future<RecordMetadata> send = producer.send(record);
            String jsonString = JSONObject.toJSONString(send);

            System.out.println(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Thread.sleep(2000000L);
        // （5）关闭生产者实例。
        producer.close();
    }
}
