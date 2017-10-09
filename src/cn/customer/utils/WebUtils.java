package cn.customer.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

public class WebUtils {
    // 页面展示的性别或者爱好，不是在页面写死的，而是在程序中定义的，或者是数据库中有这样的一张表，从数据库取出然后再在页面展示。
    public static String sex[] = { "男", "女", "中" };
    public static String hobbies[] = { "唱歌", "跳舞", "篮球", "逛街", "data", "泡吧" };
    public static String type[] = {"普通","会员","VIP"};

    public static <T> T request2Bean(HttpServletRequest request, Class<T> clazz) {
        try {
            Map<String, String[]> map = request.getParameterMap();
            T bean = clazz.newInstance();
            ConvertUtils.register(new Converter() {
                @Override
                public Object convert(Class type, Object value) {
                    if (value == null) {
                        return null;
                    }
                    String str = (String) value;
                    if (str.trim().equals("")) {
                        return null;
                    }
                    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        return sf.parse(str);
                    } catch (ParseException e) {
                        throw new RuntimeException();
                    }
                }
            }, Date.class);
            BeanUtils.populate(bean, map);
            return bean;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
