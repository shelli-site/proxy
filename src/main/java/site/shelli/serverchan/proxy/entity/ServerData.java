package site.shelli.serverchan.proxy.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author shen_xi
 * @create 2021/03/05 12:04
 */
@Getter
@Setter
public class ServerData {
    private String proxyUrl;
    private String token;
    private String title;
    private String desp;
    private String url;
}
