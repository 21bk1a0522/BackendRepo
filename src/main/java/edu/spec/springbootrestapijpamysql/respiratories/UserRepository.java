package edu.spec.springbootrestapijpamysql.respiratories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.spec.springbootrestapijpamysql.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

}
