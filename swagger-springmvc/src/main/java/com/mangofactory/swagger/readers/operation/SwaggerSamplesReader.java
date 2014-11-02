package com.mangofactory.swagger.readers.operation;

import static com.google.common.collect.Lists.newArrayList;

import java.util.Collection;
import java.util.List;

import com.mangofactory.swagger.scanners.RequestMappingContext;
import com.wordnik.swagger.model.Sample;


public abstract class SwaggerSamplesReader implements RequestMappingReader {

    @Override
    public void execute(RequestMappingContext context) {
        List<Sample> samples = (List<Sample>) context.get("samples");
        if(samples == null) {
            samples = newArrayList();
        }
        samples.addAll(this.readSamples(context));
        context.put("samples", samples);
    }

    abstract protected Collection<? extends Sample> readSamples(RequestMappingContext context);
}
