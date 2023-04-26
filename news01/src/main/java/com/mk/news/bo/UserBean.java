package com.mk.news.bo;

import com.com.bean.ObjectBean;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Map;

/**
 * @author hua
 */
@Data
public class UserBean extends ObjectBean {
    @NotBlank(message = "不能为空！")
    private String id;
    @Pattern(regexp = "^[A-Za-z0-9]+$",message = "只能是数字和字母")
    private String name;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",message = "长度至少为8,包含大小写字母、数字和特殊字符")
    private  String password;
    @NotEmpty
    private List<Map<String,Object>> list;

}
