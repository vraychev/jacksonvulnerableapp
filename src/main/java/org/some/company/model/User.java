package org.some.company.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

public class User {
    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
    public Object name;
    public String email;
}
