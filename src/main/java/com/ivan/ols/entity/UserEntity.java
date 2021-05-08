/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.ols.entity;

import com.ivan.ols.model.UserModel;
import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 *
 * @author ivans
 */
@Entity(name = "user")
public class UserEntity extends UserModel {

    @Transient
    private String confirmPassword;
    
    private boolean isEnabled;
    
    /*@Column
    @ElementCollection(targetClass=String.class)
    private List<GrantedAuthority> userRole;*/
    
    /*@Size(min = 1)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles;*/

    public UserEntity() {
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }
    
    /*public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    */

    @Override
    public void getDetailsUser() {
        getDetailsUser();
    }

}
