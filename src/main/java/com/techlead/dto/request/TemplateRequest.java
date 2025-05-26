package com.techlead.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;


public class TemplateRequest {

    private String templateFilePath;

    private Map<String, String> params;

    private String outputExtension;

    public String getTemplateFilePath() {
        return templateFilePath;
    }

    public void setTemplateFilePath(String templateFilePath) {
        this.templateFilePath = templateFilePath;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public String getOutputExtension() {
        return outputExtension;
    }

    public void setOutputExtension(String outputExtension) {
        this.outputExtension = outputExtension;
    }
}
