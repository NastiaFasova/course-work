package ipk.service.impl;

import ipk.model.Role;
import ipk.repository.RoleRepository;
import ipk.service.RoleService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private static final Logger LOGGER = Logger.getLogger(RoleServiceImpl.class);
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role save(Role role) {
        LOGGER.info("The role was saved");
        return roleRepository.save(role);
    }

    @Override
    public Role getRoleByName(String roleName) {
        LOGGER.info("The role was retrieved by roleName");
        return roleRepository.getRoleByName(Role.RoleName.valueOf(roleName)).orElseThrow();
    }
}
