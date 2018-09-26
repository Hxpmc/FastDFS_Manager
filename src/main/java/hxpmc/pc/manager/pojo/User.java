package hxpmc.pc.manager.pojo;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User  implements Serializable {
    private int id ;
    private String username;
    private String password;
    private List<Integer> roleId;
    private String salt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Integer> getRoleId() {
        if (CollectionUtils.isEmpty(roleId)){
            roleId = new ArrayList<Integer>();
        }
        return roleId;
    }

    public void setRoleId(List<Integer> roleId) {
        this.roleId = roleId;
    }
    public String getRoleIdStr(){
        if (CollectionUtils.isEmpty(roleId))
            return "";
        StringBuilder s =new StringBuilder();
        for (int id :roleId ){
            s.append(id);
            s.append(",");
        }
        return s.toString().substring(0,s.length()-1);
    }
    public void setRoleIdStr(String roleIdStr){
        if (StringUtils.isEmpty(roleIdStr)){
            return;
        }
        String[] str = roleIdStr.split(",");
        for (String s :str){
            if (StringUtils.isEmpty(s)){
                continue;
            }
            getRoleId().add(Integer.valueOf(s));
        }

    }

    public String getCredentials(){
        return username+salt;
    }
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}