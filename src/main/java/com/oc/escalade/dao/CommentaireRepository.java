package com.oc.escalade.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.oc.escalade.entities.Commentaire;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long>
{

}
