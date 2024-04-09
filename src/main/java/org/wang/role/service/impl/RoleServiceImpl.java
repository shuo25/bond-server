package org.wang.role.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.wang.role.entity.Role;
import org.wang.role.mapper.RoleMapper;
import org.wang.role.service.IRoleService;
/**
 * Author: 18615
 * Date: 2024/4/09 20:37
 */
@Service
@Slf4j
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
}
