package ml.pic.tech.integration.admin.lte.Repository;
import ml.pic.tech.integration.admin.lte.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    public Role findByRoleName(String roleName);
}
