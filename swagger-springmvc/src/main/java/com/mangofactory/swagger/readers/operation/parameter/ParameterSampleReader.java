package com.mangofactory.swagger.readers.operation.parameter;

import com.mangofactory.swagger.readers.Command;
import com.mangofactory.swagger.scanners.RequestMappingContext;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.core.MethodParameter;

import static org.apache.commons.lang.StringUtils.*;

public class ParameterSampleReader implements Command<RequestMappingContext> {
  @Override
  public void execute(RequestMappingContext context) {
    MethodParameter methodParameter = (MethodParameter) context.get("methodParameter");
    ApiParam apiParam = methodParameter.getParameterAnnotation(ApiParam.class);
    String sample = "";
    if (null != apiParam && !isBlank(apiParam.trueType())) {
        sample = apiParam.sample();
    }
    context.put("sample", sample);
  }
}
