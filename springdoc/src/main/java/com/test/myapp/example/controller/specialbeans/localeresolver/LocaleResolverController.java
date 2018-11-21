package com.test.myapp.example.controller.specialbeans.localeresolver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Locale;

/**
 * Usage: LocaleResolver 效果测试：localhost:8080/accept-header-resolver.do
 * @author: srfan
 * Date: 10/30/18 11:37 AM
 */
@Controller
public class LocaleResolverController {
    @RequestMapping(value="/accept-header-resolver.do", method = RequestMethod.GET)
    public ModelAndView resolveLocale(HttpServletRequest request) {
        String clientLocale = "";
        // 获取客户端支持的语言
        Enumeration<Locale> locales = request.getLocales();

        while (locales.hasMoreElements()) {
            Locale locale = locales.nextElement();
            clientLocale += locale + ",";
        }
        RequestContext requestContext = new RequestContext(request);
        String value = requestContext.getMessage("message.locale");

        ModelAndView modelAndView = new ModelAndView("localeResolver");

        modelAndView.addObject("clientLocale", clientLocale);
        modelAndView.addObject("currentLocale", requestContext.getLocale());
        modelAndView.addObject("localeResource", value);
        return modelAndView;
    }
}
