package pro.jianbing.aboutme.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pro.jianbing.aboutme.config.WebSecurityConfig;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * 常用获取客户端信息的工具
 *
 * @author DefaultAccount
 */
public final class NetworkUtil {
    /**
     * Logger for this class
     */
    private static final Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);

    /**
     * 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址;
     *
     * @param request
     * @return
     * @throws IOException
     */
    public static String getIpAddress(HttpServletRequest request) {
        // 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址

        String ip = request.getHeader("X-Forwarded-For");
        if (logger.isInfoEnabled()) {
            logger.info("getIpAddress(HttpServletRequest) - X-Forwarded-For - String ip=" + ip);
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
                if (logger.isInfoEnabled()) {
                    logger.info("getIpAddress(HttpServletRequest) - Proxy-Client-IP - String ip=" + ip);
                }
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
                if (logger.isInfoEnabled()) {
                    logger.info("getIpAddress(HttpServletRequest) - WL-Proxy-Client-IP - String ip=" + ip);
                }
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
                if (logger.isInfoEnabled()) {
                    logger.info("getIpAddress(HttpServletRequest) - HTTP_CLIENT_IP - String ip=" + ip);
                }
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
                if (logger.isInfoEnabled()) {
                    logger.info("getIpAddress(HttpServletRequest) - HTTP_X_FORWARDED_FOR - String ip=" + ip);
                }
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
                if (logger.isInfoEnabled()) {
                    logger.info("getIpAddress(HttpServletRequest) - getRemoteAddr - String ip=" + ip);
                }
            }
        } else if (ip.length() > 15) {
            String[] ips = ip.split(",");
            for (int index = 0; index < ips.length; index++) {
                String strIp = (String) ips[index];
                if (!("unknown".equalsIgnoreCase(strIp))) {
                    ip = strIp;
                    break;
                }
            }
        }

        if ("0:0:0:0:0:0:0:1".equals(ip)) {
            // 根据网卡取本机配置的IP
            InetAddress inet = null;
            try {
                inet = InetAddress.getLocalHost();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            assert inet != null;
            ip = inet.getHostAddress();
        }

        return ip;
    }

    public static String getAddressByIp(String ip){
        logger.info("用户上次登陆的IP : " + ip);
        Map<String,String> params = new HashMap<>(11);
        params.put("query", ip);
        params.put("co", "");
        params.put("resource_id", "6006");
        params.put("t", "1561774224004");
        params.put("ie", "utf8");
        params.put("oe", "gbk");
        params.put("cb", "op_aladdin_callback");
        params.put("format", "json");
        params.put("tn", "baidu");
        params.put("cb", "jQuery1102009188415896251856_1561774185767");
        params.put("_", "1561774185772");
        String result = HttpUtils.doGet("https://sp0.baidu.com/8aQDcjqpAAV3otqbppnN2DJv/api.php", params);
        logger.info("根据IP获取到的详细信息 : " + result);
        String location;
        if (result.contains("局域网")){
            location = "本地局域网";
        } else {
            String substring = result.substring(result.indexOf("location")+11);
            location = substring.substring(0, substring.indexOf(" "));
        }
        logger.info("解析出的上次登陆的地理地址 : " + location);
        return location;
    }
}
