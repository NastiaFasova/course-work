package ipk.service.impl;

import ipk.model.Role;
import ipk.repository.RoleRepository;
import ipk.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getRoleByName(String roleName) {
        return roleRepository.getRoleByName(Role.RoleName.valueOf(roleName))
                .orElseThrow(RuntimeException::new);
    }
}
