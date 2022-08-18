package com.heying;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;

public class JacksonJsonSerializer {
    private ObjectMapper objectMapper = new ObjectMapper();

    public String serialize(Object obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }
    public<T>T deserialize(String json,Class<T> tClass) throws JsonProcessingException {
        return objectMapper.readValue(json,tClass);
    }

    public static void main(String[] args) throws JsonProcessingException {
        final Student aaa = new Student(111, "aaa", 180, new Date(), 200.5);
        final JacksonJsonSerializer jacksonJsonSerializer = new JacksonJsonSerializer();
        final String json = jacksonJsonSerializer.serialize(aaa);
        System.out.println(json);

        final Student student = jacksonJsonSerializer.deserialize(json, Student.class);
        System.out.println(student);
    }
}
