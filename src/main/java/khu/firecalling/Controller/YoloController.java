package khu.firecalling.Controller;

import khu.firecalling.CallingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Map;

@RestController
@RequestMapping("yolo")
public class YoloController {
    private final CallingService callingService;
    private Logger logger= LoggerFactory.getLogger(YoloController.class);

    @Autowired
    public YoloController(CallingService callingService){
        this.callingService=callingService;
    }

    @PostMapping("/ciga")
    public void ReceiveRequest(@RequestParam Map<String, Object> allParameters){
        try {
            callingService.sendCall();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
