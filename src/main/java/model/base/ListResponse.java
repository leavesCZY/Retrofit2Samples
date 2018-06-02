package model.base;

import java.util.List;

/**
 * 作者：chenZY
 * 时间：2018/5/26 15:12
 * 描述：
 */
public class ListResponse<T> extends Response {

    private List<T> data;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

}
