package com.ecommerce.third_party_service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FirebaseServiceTest {

    @Autowired FirebaseService firebaseService;

    @Test
    public void deleteFile() {
        firebaseService
                .deleteFile("https://firebasestorage.googleapis.com/v0/b/ecommerce-6ee5d.appspot.com/o/brand-logo%2F1675911412123_undefined?alt=media&token=72326a9e-d9c2-4bea-b5c8-aacb1e4293f3");
    }
}
