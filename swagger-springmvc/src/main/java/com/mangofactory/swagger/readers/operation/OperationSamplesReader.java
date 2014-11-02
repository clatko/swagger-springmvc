package com.mangofactory.swagger.readers.operation;

import com.google.common.collect.Lists;
import com.mangofactory.swagger.scanners.RequestMappingContext;
import com.wordnik.swagger.annotations.ApiSample;
import com.wordnik.swagger.annotations.ApiSamples;
import com.wordnik.swagger.model.Sample;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.method.HandlerMethod;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;


public class OperationSamplesReader extends SwaggerSamplesReader {

    @Override
    protected Collection<Sample> readSamples(RequestMappingContext context) {
      HandlerMethod handlerMethod = context.getHandlerMethod();
      Method method = handlerMethod.getMethod();
      ApiSamples annotation = AnnotationUtils.findAnnotation(method, ApiSamples.class);

      List<Sample> samples = Lists.newArrayList();
      if (null != annotation) {
        for (ApiSample sample : annotation.value()) {
          samples.add(OperationSampleReader.getApiSample(sample));
        }
      }

      return samples;
    }
}

