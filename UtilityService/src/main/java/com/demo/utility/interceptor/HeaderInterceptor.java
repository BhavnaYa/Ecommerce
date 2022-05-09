package com.demo.utility.interceptor;

import com.demo.utility.bean.ExceptionFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@RequiredArgsConstructor
@Component
@Slf4j
public class HeaderInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        if (!Boolean.parseBoolean(request.getHeader("validated"))) {
            ExceptionFormat exceptionFormat = new ExceptionFormat();
            exceptionFormat.setMessage("Invalid token");
            exceptionFormat.setPath(request.getServletPath());
            exceptionFormat.setTimestamp(new Date());
            response.getWriter().write(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(exceptionFormat));
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return false;
        }
        return true;
    }

}
