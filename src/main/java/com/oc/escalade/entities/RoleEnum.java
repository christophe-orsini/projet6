package com.oc.escalade.entities;

public enum RoleEnum
{
	ROLE_UTILISATEUR (1),
	ROLE_MEMBRE (2),
	ROLE_ADMINISTRATEUR (4);

	private int value;
	
	RoleEnum(int value)
	{
		this.value = value;
	}
	
	public int value()
	{
		return value;
	}
	
	@Override
	public String toString()
	{
		switch(value)
		{
			case 1:
				return "Utilisateur";
			case 2:
				return "Membre de l'association";
			case 4:
				return "Administrateur du site";
			default:
				return "Inconnu";
		}
	}
}
