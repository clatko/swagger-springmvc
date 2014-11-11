package com.mangofactory.swagger.readers.operation;

import com.google.common.collect.Lists;
import com.mangofactory.swagger.scanners.RequestMappingContext;
import com.wordnik.swagger.annotations.ApiSample;
import com.wordnik.swagger.model.Sample;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.method.HandlerMethod;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;


public class OperationSampleReader extends SwaggerSamplesReader {

  @Override
  protected Collection<? extends Sample> readSamples(RequestMappingContext context) {
    HandlerMethod handlerMethod = context.getHandlerMethod();
    Method method = handlerMethod.getMethod();
    ApiSample annotation = AnnotationUtils.findAnnotation(method, ApiSample.class);
    List<Sample> samples = Lists.newArrayList();
    if (null != annotation) {
      samples.add(OperationSampleReader.getApiSample(annotation));
    }
    return samples;
  }

  public static Sample getApiSample(ApiSample param) {
    return new Sample(
            param.value(),
            param.path(),
            param.language()
    );
  }


}

