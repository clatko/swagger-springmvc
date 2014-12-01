package com.mangofactory.swagger.readers.operation.parameter;

import com.mangofactory.swagger.readers.Command;
import com.mangofactory.swagger.scanners.RequestMappingContext;
import com.wordnik.swagger.annotations.ApiParam;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.ISODateTimeFormat;
import org.springframework.core.MethodParameter;

public class ParameterSampleReader implements Command<RequestMappingContext> {
  @Override
  public void execute(RequestMappingContext context) {
    MethodParameter methodParameter = (MethodParameter) context.get("methodParameter");
    ApiParam apiParam = methodParameter.getParameterAnnotation(ApiParam.class);
    String sample = "";
    if(null != apiParam) {
        sample = apiParam.sample();
        // parse sample date here so we can reuse in uri sample
        if(apiParam.trueType().equals("datetime") && !apiParam.defaultValue().equals("")) {
            DateTime tmp = new DateTime(DateTimeZone.UTC);
            sample = ISODateTimeFormat.dateTimeNoMillis().withZoneUTC().
                    print(tmp.plusSeconds(Integer.parseInt(apiParam.defaultValue())));
        }
    }
    context.put("sample", sample);
  }
}
