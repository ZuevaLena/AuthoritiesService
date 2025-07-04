package ru.netology.authorizationservice.repository;


import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.netology.authorizationservice.model.Authorities;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {

    @PostConstruct
    void init(){
        System.err.println("Бин ЮЗЕРРЕПОЗИТОРИ СОЗДАЛСЯ");
    }
    private final Map<String, String> users = Map.of(
            "lena", "lenapass",
            "kolya", "kolyapass"
    );

    private final Map<String, List<Authorities>> authorities = Map.of(
            "lena", List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE),
            "kolya", List.of(Authorities.READ)
    );

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (users.containsKey(user) && users.get(user).equals(password)) {
            return authorities.getOrDefault(user, Collections.emptyList());
        }
        return Collections.emptyList();
    }

}
