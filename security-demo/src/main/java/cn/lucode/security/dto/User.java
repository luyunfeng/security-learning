package cn.lucode.security.dto;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * @author yunfeng.lu
 * @create 2017/11/5.
 */
public class User {
    public interface PrintUser{}
    public interface PrintUserDetail extends PrintUser{}

    private String name;
    private String password;

    @JsonView(PrintUser.class)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonView(PrintUserDetail.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
