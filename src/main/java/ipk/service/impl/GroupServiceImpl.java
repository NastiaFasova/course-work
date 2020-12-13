package ipk.service.impl;

import ipk.model.Group;
import ipk.model.Lesson;
import ipk.model.Listener;
import ipk.model.Role;
import ipk.repository.GroupRepository;
import ipk.service.GroupService;
import ipk.service.ListenerService;
import ipk.service.RoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final RoleService roleService;
    private final ListenerService listenerService;

    public GroupServiceImpl(GroupRepository groupRepository, RoleService roleService, ListenerService listenerService) {
        this.groupRepository = groupRepository;
        this.roleService = roleService;
        this.listenerService = listenerService;
    }

    @Override
    public Group save(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public List<Listener> getListenersByGroupId(Long id) {
        return groupRepository.getListenersByGroupId(id);
    }



    @Override
    public Group addListenerToGroup(Listener listener, Group group) {
        Role role = roleService.getRoleByName("LISTENER");
        listener.setRoles(Set.of(role));
        listenerService.save(listener);
        List<Listener> listeners = group.getListeners();
        listeners.add(listener);
        groupRepository.save(group);
        return group;
    }

    @Override
    public Group updateListener(Listener listener, Group group) {
        Listener listenerByEmail = listenerService.getByEmail(listener.getEmail());
        group.getListeners().remove(listenerByEmail);
        Set<Role> roles = listener.getRoles();
        listenerByEmail.setRoles(roles);
        listenerByEmail.setName(listener.getName());
        listenerByEmail.setSurname(listener.getSurname());
        listenerByEmail.setEmail(listener.getEmail());
        listenerService.save(listenerByEmail);
        List<Listener> listeners = group.getListeners();
        listeners.add(listenerByEmail);
        groupRepository.save(group);
        return null;
    }

    @Override
    public Group deleteListenerFromGroup(Listener listener, Long id) {
        Group group = groupRepository.findById(id).orElseThrow(RuntimeException::new);
        group.getListeners().remove(listener);
        groupRepository.save(group);
        return group;
    }

    @Override
    public Page<Group> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return groupRepository.findAll(pageable);
    }

    @Override
    public Group findById(Long id) {
        return groupRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Lesson> getAllLessonsByGroupId(long id) {
        return groupRepository.getAllLessonsByGroupId(id);
    }


}
