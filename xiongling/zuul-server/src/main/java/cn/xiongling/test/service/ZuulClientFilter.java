package cn.xiongling.test.service;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

@Component
public class ZuulClientFilter extends ZuulFilter {

    private static Logger log = (Logger) LoggerFactory.getLogger(ZuulClientFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String s = String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString());
        log.info(s);
        return true;
    }
}
