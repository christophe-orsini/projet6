package com.oc.escalade.dao;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.oc.escalade.entities.Commentaire;
import com.oc.escalade.entities.Site;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long>
{
	Collection<Commentaire> findAllBySiteOrderByDateModificationDesc(Site site);
}
