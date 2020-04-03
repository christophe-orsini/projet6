package com.oc.escalade.entities;

public enum RoleEnum
{
	UTILISATEUR (1),
	MEMBRE (2),
	ADMINISTRATEUR (4);

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
