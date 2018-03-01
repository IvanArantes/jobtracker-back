package br.com.iarts.jobsearch.users.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@Table(name= "application_user", schema = "auth")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String password;
    private String email;

    @Enumerated(EnumType.ORDINAL)
    private Sex sex;
    private String country;
    private String state;
    private String city;

}
