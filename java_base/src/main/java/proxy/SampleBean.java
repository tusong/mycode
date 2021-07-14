package proxy;

/**
 * @author tusong
 * @version V1.0
 * @Package proxy
 * @ClassName SampleBean.java
 * @date 2021/7/6
 * @Description: 此处添加类描述……
 */
public class SampleBean {
    private String value;

    public SampleBean() {
    }

    public SampleBean(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
