package com.rh.project.entity;




import java.util.ArrayList;
import java.util.List;


import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
	private String firstname;
	private String lastname;
	private String project;
	
	
	@NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "role_id", nullable = true)
    private Role roles;
	
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_equipes",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "equipes_id")
            )
    private List<Equipe> equipes =  new ArrayList<Equipe>();
    
	public void addEquipe(Equipe equipe) {
		this.equipes.add(equipe);
    }
	
	
	
}


