package cl.utem.uf.indicator.persistence.repository;

import cl.utem.uf.indicator.persistence.model.Uf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UfRepository extends JpaRepository<Uf, Long> {

}
