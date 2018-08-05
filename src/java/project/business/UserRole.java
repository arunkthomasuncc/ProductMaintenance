/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.business;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


/**
 *
 * @author Arun
 */
@Entity
public class UserRole  implements Serializable{
    
    
    //private int id;
    @Id
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private UserPass userPass;
    
    private String roleName;
    
    
}
