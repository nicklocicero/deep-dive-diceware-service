package edu.cnm.deepdive.diceware;

import java.security.SecureRandom;
import java.util.Random;
import java.util.ResourceBundle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@Configuration
public class DicewareConfiguration {

  @Value("${oauth.clientId}")
  private String clientId;

  @Bean
  public Random getRandom() {
    return new SecureRandom();
  }

  @Bean
  public ResourceBundle getBundle() {
    return ResourceBundle.getBundle("wordlist");
  }

  @Bean
  public ResourceServerTokenServices tokenServices() {
    return new GoogleTokenServices(clientId);
  }

}
