/**
 * Stome.com Co.,Ltd.
 * Copyright (c) 2004-2017, All Rights Reserved.
 */
package com.stome.workbanch.common.util;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/** 
 * ToString工具类
 * 
 * @author Robin 
 * @date 2017-01-29 08:16:17 
 * @version $id: ToString.java v1.0 
 */
public class ToString implements Serializable {

    /** TODO [用一句话描述这个变量表示什么，必填] */
    private static final long serialVersionUID = -4693295721034998165L;

    /** 
     * @see java.lang.Object#toString() 
     */
    @Override
    public String toString() {
        // TODO Auto-generated method stub 
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
