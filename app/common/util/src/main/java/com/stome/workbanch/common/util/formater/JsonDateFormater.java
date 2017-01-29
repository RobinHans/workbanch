/**
 * Stome.com Co.,Ltd.
 * Copyright (c) 2004-2017, All Rights Reserved.
 */
package com.stome.workbanch.common.util.formater;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

/** 
 * JSON日期解析工具类
 * 
 * 注意:jackson目前只支持以下四种类型的日期字符串，否则会抛出异常org.codehaus.jackson.map.JsonMappingException: 
 * yyyy-MM-dd'T'HH:mm:ss.SSSZ
 * yyyy-MM-dd'T'HH:mm:ss.SSS'Z'
 * EEE, dd MMM yyyy HH:mm:ss zzz
 * yyyy-MM-dd
 * 
 * @author Robin 
 * @date 2017-01-29 08:01:07 
 * @version $id: JsonDateFormater.java v1.0 
 */
public class JsonDateFormater extends JsonSerializer<Date> {

    /** 
     * @see org.codehaus.jackson.map.JsonSerializer#serialize(java.lang.Object, org.codehaus.jackson.JsonGenerator, org.codehaus.jackson.map.SerializerProvider) 
     */
    @Override
    public void serialize(Date value, JsonGenerator jgen,
                          SerializerProvider provider) throws IOException, JsonProcessingException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        String formatedDate = format.format(value);
        jgen.writeString(formatedDate);
    }

}
