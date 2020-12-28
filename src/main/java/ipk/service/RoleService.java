package ipk.service;

import ipk.model.Role;

public interface RoleService {
    Role save(Role role);

    Role getRoleByName(String roleName);
}
