package com.java.entity.vo.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.ruoyi.common.core.domain.entity.SysUser;
import lombok.Data;

import java.util.List;

@Data
public class MsClassStudentPageVo {
    @TableId(type = IdType.AUTO)
    private Integer classId;

    private String className;

    private List<SysUser> userList;
}
