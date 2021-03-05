package site.shelli.serverchan.proxy.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shen_xi
 * @create 2021/03/05 12:49
 */
@Getter
@Setter
@Builder
public class GotifyBody {
    private String title;
    private String message;
    private String priority;
    private Extra extras;

    @Getter
    @Setter
    public static class Extra {
        @JsonProperty("client::display")
        private Map<String, String> clientDisplay;
        @JsonProperty("client::notification")
        private Map<String, Map<String, String>> clientNotification;
        @JsonProperty("android::action")
        private Map<String, Map<String, String>> androidAction;

        public Extra(String contentType, String notifyUrl, String receiveUrl) {
            if (contentType != null) {
                clientDisplay = new HashMap<String, String>() {{
                    put("contentType", contentType);
                }};
            }
            if (notifyUrl != null) {
                clientNotification = new HashMap<String, Map<String, String>>() {{
                    put("click", new HashMap<String, String>() {{
                        put("url", notifyUrl);
                    }});
                }};
            }
            if (receiveUrl != null) {
                androidAction = new HashMap<String, Map<String, String>>() {{
                    put("onReceive", new HashMap<String, String>() {{
                        put("intentUrl", receiveUrl);
                    }});
                }};
            }
        }
    }
}
