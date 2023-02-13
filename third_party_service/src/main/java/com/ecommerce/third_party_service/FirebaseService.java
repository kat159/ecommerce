package com.ecommerce.third_party_service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.cloud.StorageClient;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.Map;


@Service
public class FirebaseService {
    @EventListener
    public void firebaseInit(ApplicationReadyEvent event) throws IOException {
        // initialize firebase with service account key
        ClassPathResource serviceAccount = new ClassPathResource("firebase-admin-key.json");
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount.getInputStream()))
                .build();
        FirebaseApp.initializeApp(options);
    }

    public void deleteFile(String name) {
        Bucket bucket = StorageClient.getInstance().bucket("ecommerce-6ee5d.appspot.com");

        if (StringUtils.isEmpty(name)) {
            
            return;
        }
        Blob blob = bucket.get(name);

        if (blob == null) {
            
            return;
        }
        blob.delete();
    }

    public String getFirebaseToken(@RequestBody Map<String, String> body) throws FirebaseAuthException {
        String username = body.get("username");
        if (username == null) {
            throw new IllegalArgumentException("Username is required");
            // return new Result().error("Username is required");
        }
        // generate firebase token
        String customToken = FirebaseAuth.getInstance().createCustomToken(username);
        // return new Result().ok(customToken);
        return customToken;
    }
}
