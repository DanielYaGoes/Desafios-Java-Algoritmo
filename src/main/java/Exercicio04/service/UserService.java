package Exercicio04.service;

import Exercicio04.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User create(User user);
    List<User> getAll();
    Optional<User> getById(Long id);
    User update(Long id, User user);
    void delete(Long id);
}