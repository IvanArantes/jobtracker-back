package br.com.iarts.jobsearch.users.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthResponse {
    public String token;
    public AuthResponse(String token){
        this.token = token;
    }
}
