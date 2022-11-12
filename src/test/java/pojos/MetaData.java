package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MetaData {
    private Object meta;
    private GoRestDataPojo data;

    public MetaData(Object meta, GoRestDataPojo data) {
        this.meta = meta;
        this.data = data;
    }

    public MetaData() {
    }

    public Object getMeta() {
        return meta;
    }

    public void setMeta(Object meta) {
        this.meta = meta;
    }

    public GoRestDataPojo getData() {
        return data;
    }

    public void setData(GoRestDataPojo data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MetaData{" +
                "meta=" + meta +
                ", data=" + data +
                '}';
    }
}
