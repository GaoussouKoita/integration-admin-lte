package ml.pic.tech.integration.admin.lte.service;



import ml.pic.tech.integration.admin.lte.Repository.RoleRepository;
import ml.pic.tech.integration.admin.lte.Repository.UtilisateurRepository;
import ml.pic.tech.integration.admin.lte.entity.Role;
import ml.pic.tech.integration.admin.lte.entity.Utilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {


    private UtilisateurRepository utilisateurRepository;
    private RoleRepository roleRepository;

    public AccountService(UtilisateurRepository utilisateurRepository,
                          RoleRepository roleRepository) {
        this.utilisateurRepository = utilisateurRepository;
        this.roleRepository = roleRepository;

    }

    public Utilisateur addUser(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    public Utilisateur loadUtilisateurByLogin(String login) {
        return utilisateurRepository.findByLogin(login);
    }

    public List<Utilisateur> allUsers() {
        return utilisateurRepository.findAll();
    }
    public Page<Utilisateur> allUsersPage(int page) {
        return utilisateurRepository.findAll(PageRequest.of(page, 7));
    }

    public List<Role> roleList() {
        return roleRepository.findAll();
    }

    public Utilisateur utilisateurById(Long id) {
     return utilisateurRepository.findById(id).get();
    }

    public void deleteU(long id){
        utilisateurRepository.deleteById(id);
    }
}
