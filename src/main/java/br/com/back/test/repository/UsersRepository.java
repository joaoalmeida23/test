package br.com.back.test.repository;

import br.com.back.test.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, String> {

}
