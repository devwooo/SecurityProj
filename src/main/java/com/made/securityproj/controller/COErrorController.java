package com.made.securityproj.controller;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class COErrorController implements ErrorController {

    @RequestMapping(value = "/error")
    public String handlerError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());

            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return "pages/co/COError";
            } else if (statusCode == HttpStatus.UNAUTHORIZED.value()) {
                return "pages/co/notAuthrized";
            } else {
                return "pages/co/COError";
            }

        }
        return "pages/co/COError";
    }

}
