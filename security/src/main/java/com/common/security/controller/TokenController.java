package com.common.security.controller;

import com.ecommerce.common.utils.Result;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;
import com.google.firebase.FirebaseApp;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("security/token")
public class TokenController {

    @EventListener
    public void firebaseInit(ApplicationReadyEvent event) throws IOException {
        // initialize firebase with service account key
        ClassPathResource serviceAccount = new ClassPathResource("firebase-admin-key.json");
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount.getInputStream()))
                .build();
        FirebaseApp.initializeApp(options);
    }

    @PostMapping("firebase")
    @ApiOperation("Generate Firebase Token")
    public Result getFirebaseToken(@RequestBody Map<String, String> body) throws FirebaseAuthException {
        String username = body.get("username");
        if (username == null) {
            return new Result().error("Username is required");
        }
        // generate firebase token
        String customToken = FirebaseAuth.getInstance().createCustomToken(username);
        return new Result().ok(customToken);
    }
}
