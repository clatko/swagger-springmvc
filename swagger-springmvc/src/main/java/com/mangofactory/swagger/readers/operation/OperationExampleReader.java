package com.mangofactory.swagger.readers.operation;

import com.mangofactory.swagger.scanners.RequestMappingContext;
import com.wordnik.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.method.HandlerMethod;

public class OperationExampleReader implements RequestMappingReader {
    @Override
    public void execute(RequestMappingContext context) {
        String example = "";

        HandlerMethod handlerMethod = context.getHandlerMethod();
        ApiOperation methodAnnotation = handlerMethod.getMethodAnnotation(ApiOperation.class);
        if ((null != methodAnnotation) && !StringUtils.isBlank(methodAnnotation.example())) {
            example = methodAnnotation.example();
        }
        context.put("example", example);
    }
}
