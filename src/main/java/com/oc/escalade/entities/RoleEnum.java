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
}
