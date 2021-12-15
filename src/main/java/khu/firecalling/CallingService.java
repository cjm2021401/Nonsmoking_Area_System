package khu.firecalling;

import ch.qos.logback.classic.Logger;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class CallingService {
    private final String from = "+13368919908";
    private final String to = "+821044274435";
    @Value("${Sid}")
    private String Sid;
    @Value("${Token}")
    private String Token;

    public void sendCall() throws URISyntaxException {
        Twilio.init(Sid, Token);
        Call call = Call.creator(new PhoneNumber(to), new PhoneNumber(from),
                        new URI("http://demo.twilio.com/docs/voice.xml"))
                .create();
    }
}
