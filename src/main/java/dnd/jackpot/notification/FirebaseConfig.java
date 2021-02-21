package dnd.jackpot.notification;

import java.io.FileInputStream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Configuration
public class FirebaseConfig {

    @Value("classpath:firebase/jackpot-1611239774705-firebase-adminsdk-xlp80-fa2c872b91.json")
//    @Value("classpath:firebase/jackpot-d5f0e-firebase-adminsdk-46a97-cc8373fa78.json")
    private Resource resource;
    @Autowired
    private ResourceLoader resourceLoader;
    
 //   final Resource fileResource = resourceLoader.getResource("classpath:firebase/jackpot-1611239774705-firebase-adminsdk-xlp80-fa2c872b91.json");


    @PostConstruct
    public void initFirebase() {
        try {
      //  	getClass().getResourceAsStream(String path);
            FileInputStream serviceAccount = new FileInputStream(resource.getFile());
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
  //                  .setDatabaseUrl("https://{사용자마다 다름}.firebaseio.com")
                    .build();
            FirebaseApp.initializeApp(options);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
