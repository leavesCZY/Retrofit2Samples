package model.base;

/**
 * 作者：chenZY
 * 时间：2018/5/26 15:11
 * 描述：
 */
public class EntityResponse<T> extends Response {

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
