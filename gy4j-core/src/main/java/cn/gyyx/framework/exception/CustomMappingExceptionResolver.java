package cn.gyyx.framework.exception;

import cn.gyyx.framework.util.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * springmvc自定义异常处理类
 * @author
 * @create 2017-11-08 14:22
 **/
@Controller
public class CustomMappingExceptionResolver {

    private static final Logger LOG = LoggerFactory.getLogger(CustomMappingExceptionResolver.class);

    @ExceptionHandler
    @ResponseBody
    public void exp(Exception ex) throws Exception{
        LOG.error(ExceptionUtil.getStackTraceAsString(ex));
        throw ex;
    }
}
