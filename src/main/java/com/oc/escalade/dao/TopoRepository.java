package com.oc.escalade.dao;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.oc.escalade.entities.Topo;
import com.oc.escalade.entities.Utilisateur;

@Repository
public interface TopoRepository extends JpaRepository<Topo, Long>
{
	public Collection<Topo> findAllByProprietaire(Utilisateur proprietaire);
	public Collection<Topo> findAllByEmprunteur(Utilisateur emprunteur);

}
