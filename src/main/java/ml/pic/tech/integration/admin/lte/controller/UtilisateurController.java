package ml.pic.tech.integration.admin.lte.controller;

import ml.pic.tech.integration.admin.lte.entity.Utilisateur;
import ml.pic.tech.integration.admin.lte.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/utilisateur")
public class UtilisateurController {
    @Autowired
    private AccountService service;

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        model.addAttribute("roles", service.roleList());
        return "utilisateur/ajout";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Utilisateur utilisateur, Model model) {

        model.addAttribute("utilisateur", service.addUser(utilisateur));
        return "utilisateur/details";
    }

    @GetMapping
    public String utilisateurPage(@RequestParam(defaultValue = "0") int page, Model model) {
        Page<Utilisateur> utilisateurPage = service.allUsersPage(page);

        model.addAttribute("utilisateurs", utilisateurPage.getContent());
        model.addAttribute("totalElement", utilisateurPage.getTotalElements());
        model.addAttribute("totalPage", new int[utilisateurPage.getTotalPages()]);
        model.addAttribute("nbTotalPage", utilisateurPage.getTotalPages());
        model.addAttribute("currentPage", page);

        return "utilisateur/liste";
    }

    @GetMapping("/update")
    public String update(@RequestParam Long id, Model model) {
        model.addAttribute("utilisateur", service.utilisateurById(id));
        model.addAttribute("roles", service.roleList());
        return "utilisateur/ajout";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id) {
        service.deleteU(id);
        return "redirect:";
    }

    @GetMapping("/details")
    public String details(@RequestParam Long id, Model model) {

        model.addAttribute("utilisateur", service.utilisateurById(id));
        return "utilisateur/details";
    }


}
