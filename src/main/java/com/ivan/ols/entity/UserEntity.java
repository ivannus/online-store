/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.ols.entity;

import com.ivan.ols.model.UserModel;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *
 * @author ivans
 */
@Entity(name = "user")
public class UserEntity extends UserModel {

    @Column
    @NotBlank
    private String username;
    @Transient
    private String confirmPassword;

    @Size(min = 1)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles;

    public UserEntity() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getLastName() == null) ? 0 : getLastName().hashCode());
        result = prime * result + ((getMotherLastName() == null) ? 0 : getMotherLastName().hashCode());
        result = prime * result + ((getDateBirth() == null) ? 0 : getDateBirth().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getPhoneNumber() == null) ? 0 : getPhoneNumber().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        //result = prime * result + ((username == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((confirmPassword == null) ? 0 : confirmPassword.hashCode());
        result = prime * result + ((roles == null) ? 0 : roles.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        UserEntity other = (UserEntity) obj;
        if (confirmPassword == null) {
            if (other.confirmPassword != null) {
                return false;
            }
        } else if (!confirmPassword.equals(other.confirmPassword)) {
            return false;
        }
        if (getEmail() == null) {
            if (other.getEmail() != null) {
                return false;
            }
        } else if (!getEmail().equals(other.getEmail())) {
            return false;
        }
        if (getEmail() == null) {
            if (other.getEmail() != null) {
                return false;
            }
        } else if (!getEmail().equals(other.getEmail())) {
            return false;
        }
        if (username == null) {
            if (other.username != null) {
                return false;
            }
        } else if (!username.equals(other.username)) {
            return false;
        }
        if (getId() == null) {
            if (other.getId() != null) {
                return false;
            }
        } else if (!getId().equals(other.getId())) {
            return false;
        }
        if (getLastName() == null) {
            if (other.getLastName() != null) {
                return false;
            }
        } else if (!getLastName().equals(other.getLastName())) {
            return false;
        }
        if (getMotherLastName() == null) {
            if (other.getMotherLastName() != null) {
                return false;
            }
        } else if (!getMotherLastName().equals(other.getMotherLastName())) {
            return false;
        }
        if (getPassword() == null) {
            if (other.getPassword() != null) {
                return false;
            }
        } else if (!getPassword().equals(other.getPassword())) {
            return false;
        }
        if (getDateBirth() == null) {
            if (other.getDateBirth() != null) {
                return false;
            }
        } else if (!getDateBirth().equals(other.getDateBirth())) {
            return false;
        }
        if (getGender() == null) {
            if (other.getGender() != null) {
                return false;
            }
        } else if (!getGender().equals(other.getGender())) {
            return false;
        }
        if (getPhoneNumber() == null) {
            if (other.getPhoneNumber() != null) {
                return false;
            }
        } else if (!getPhoneNumber().equals(other.getPhoneNumber())) {
            return false;
        }
        if (roles == null) {
            if (other.roles != null) {
                return false;
            }
        } else if (!roles.equals(other.roles)) {
            return false;
        }
        return true;
    }

    @Override
    public void getDetailsUser() {
        super.getDetailsUser();
    }
}
