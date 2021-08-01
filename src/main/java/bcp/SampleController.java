package bcp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

@RestController
public class SampleController {

    private static Logger LOG = LoggerFactory.getLogger(SampleController.class);
    private byte[] update;

    @GetMapping("/")
    public String sayHello(@RequestParam(value = "name", defaultValue = "Guest") String name) {
        LOG.debug("Debug method sayHello {} " + LocalTime.now());
        LOG.info("Info method sayHello {} " + LocalTime.now());
        return "Hello " + name + "!!";
    }

    @GetMapping("/slowApi")
    public String timeConsumingAPI(@RequestParam(value = "delay", defaultValue = "0") Integer delay) throws InterruptedException {
        if(delay == 0) {
            Random random = new Random();
            delay = random.nextInt(10);
        }

        TimeUnit.SECONDS.sleep(delay);
        return "Result";
    }

    @GetMapping("/cpuLoad")
    public String cpuLoad()  {
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 10000; j++) {
                Math.atan(Math.sqrt(Math.pow(9, 10)));
            }
        }
        return "Done";
    }

}
