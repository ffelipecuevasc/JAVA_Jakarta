package org.fcuevas.session.servicio;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Arrays;
import java.util.Optional;

public class LoginCookieServicio implements ILoginServicio{
    @Override
    public Optional<String> getUsername(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies() != null ? request.getCookies() : new Cookie[0];
        return Arrays.stream(cookies).
                filter(c -> c.getName().equals("username")).
                map(Cookie::getValue).
                findAny();
    }
}
