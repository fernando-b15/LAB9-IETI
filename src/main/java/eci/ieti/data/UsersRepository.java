package eci.ieti.data;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import eci.ieti.data.model.User;

public interface UsersRepository extends MongoRepository<User, String> {

    User findByName(String name);

}
