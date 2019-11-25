package kr.latera.corsmapping;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

public class SignInRequiredInterceptor extends HandlerInterceptorAdapter {

    private List<String> allowedMethods;

    public SignInRequiredInterceptor(String ...allowedMethods) {
        this.allowedMethods = Arrays.asList(allowedMethods);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (allowedMethods.indexOf(request.getMethod()) > -1) {
            response.r
            return false;
        }

    }
}
