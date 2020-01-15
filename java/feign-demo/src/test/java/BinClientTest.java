import feign.Feign;
import feign.gson.GsonDecoder;
import kr.latera.feigndemo.BinClient;
import org.junit.jupiter.api.Test;

public class BinClientTest {

    @Test
    void json() {
        BinClient client = Feign.builder()
                .decoder(new GsonDecoder())
                .target(BinClient.class, "https://httpbin.org");
        System.out.println(client.requestJson());
    }
}
