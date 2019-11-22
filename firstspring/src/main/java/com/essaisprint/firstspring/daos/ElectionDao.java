package com.essaisprint.firstspring.daos;

import com.essaisprint.firstspring.models.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * ElectionDao
 */

@Repository
public interface ElectionDao extends JpaRepository<Election, Long> {

    
}
