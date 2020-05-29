package com.oc.escalade.entities;

public enum RoleEnum
{
	ROLE_UTILISATEUR (1, "Utilisateur"),
	ROLE_MEMBRE (2, "Membre"),
	ROLE_ADMINISTRATEUR (4, "Administrateur");

	private int value;
	private String name;
	
	RoleEnum(int value, String name)
	{
		this.value = value;
		this.name = name;
	}

	public int getValue()
	{
		return value;
	}

	public void setValue(int value)
	{
		this.value = value;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}
