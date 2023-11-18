package com.ntreddy.dd.ecommerce.service;

import com.ntreddy.dd.ecommerce.domain.Role;

public interface RoleService {
    Role findByName(String name);
}
