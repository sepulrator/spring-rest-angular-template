package org.spring.template.datastore.entity.mongodb;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;

/**
 * Created by osman on 14.5.2017.
 */
@Document
public class ServiceLog {

    @Id
    private Long id;
    @Field("className")
    private String className;
    @Field("methodName")
    private String methodName;
    @Field("request")
    private String request;
    @Field("response")
    private String response;

    public ServiceLog() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
