package com.ocloudwork.spring.demo.constant;

/**
 * 性别枚举类型
 * @author minghui
 *
 */
public enum Gender {
	UNKNOWN("0", ""),MAN("1", "男"), WONMAN("2", "女");

    private String value;
    private String desc;
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private Gender(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
