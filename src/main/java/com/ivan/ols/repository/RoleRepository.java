/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.ols.repository;

import com.ivan.ols.entity.RoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ivans
 */
@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Long>{

}
