package com.oc.escalade;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.oc.escalade.entities.Utilisateur;
import com.oc.escalade.service.UtilisateurService;

@SpringBootTest
class UtilisateurTests
{
	@Autowired
	private UtilisateurService utilisateurService;
	
	@Test
	void inscriptionUtilisateurOK()
	{
		// arrange
		String expected = "utilisateur@gmail.com";
				
		// act
		Utilisateur utilisateur = utilisateurService.inscription(expected, "password");
		String actual = utilisateur.getEmail();
				
		// assert
		assertEquals(expected, actual);	
	}
	
	@Test
	void inscriptionUtilisateurKO()
	{
		// arrange
		String expected = "utilisateur2@gmail.com";
		utilisateurService.inscription(expected, "password");
				
		// act
			
		// assert
		assertThrows(RuntimeException.class, () -> {utilisateurService.inscription(expected, "password");});
	}
}
