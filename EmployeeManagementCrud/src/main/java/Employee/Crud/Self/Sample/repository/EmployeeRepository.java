package Employee.Crud.Self.Sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Employee.Crud.Self.Sample.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>
{

}
