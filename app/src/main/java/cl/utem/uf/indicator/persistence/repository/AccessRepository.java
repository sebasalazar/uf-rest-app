package cl.utem.uf.indicator.persistence.repository;

import cl.utem.uf.indicator.persistence.model.Access;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessRepository extends JpaRepository<Access, Long> {

}
