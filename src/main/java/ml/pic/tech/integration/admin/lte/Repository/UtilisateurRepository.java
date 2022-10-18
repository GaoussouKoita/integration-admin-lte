package ml.pic.tech.integration.admin.lte.Repository;

import ml.pic.tech.integration.admin.lte.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    public Utilisateur findByLogin(String login);
}
