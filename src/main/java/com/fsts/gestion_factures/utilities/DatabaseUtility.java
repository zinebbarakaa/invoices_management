package com.fsts.gestion_factures.utilities;

import com.fsts.gestion_factures.entities.User;
import com.fsts.gestion_factures.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.logging.Logger;

@Component
@RequiredArgsConstructor
public class DatabaseUtility {




    private final UserRepository userRepository;

    public void initDatabase() {
        Logger.getLogger("Database utility").info("Seeding database ...");
        initUser();
        Logger.getLogger("Database utility").info("Database seeding complete");
    }





    public void initUser() {

//        Check table is empty
        if (userRepository.count() > 0) return;
        userRepository.deleteAll();

        User user = User.builder()
                .idUser(1L)
                .nom("zineb")
                .tel("09766534")
                .email("zineb@gmail.com")
                .build();

    }






}

