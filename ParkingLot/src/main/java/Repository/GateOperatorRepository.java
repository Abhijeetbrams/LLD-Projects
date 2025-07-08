package Repository;

import Model.GateOperator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GateOperatorRepository extends JpaRepository<GateOperator, Integer> {

    Optional<GateOperator> findByEmpId(String empId);
}
