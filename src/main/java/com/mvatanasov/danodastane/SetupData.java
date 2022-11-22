package com.mvatanasov.danodastane;

import com.mvatanasov.danodastane.dao.RoleRepository;
import com.mvatanasov.danodastane.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SetupData {

    @Autowired
    RoleRepository roleRepository;

    @PostConstruct
    public void init(){

//        if(roleRepository.deleteRoles()) {
//            Role ceo = new Role(1, "CEO");
//            roleRepository.save(ceo);
//
//            Role teamLead = new Role(2, "Team Lead");
//            roleRepository.save(teamLead);
//            Role dev = new Role(3, "Developer");
//            roleRepository.save(dev);
//            Role unassigned = new Role(4, "Unassigned");
//            roleRepository.save(unassigned);
//        }
    }
}
