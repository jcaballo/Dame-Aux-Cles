package com.dameauxcles.model;

import java.util.ArrayList;

public class User extends Person{

	public User(int iDPERSONNE, String lOGINPERSONNE, String mDPPERSONNE, boolean iSADMIN) {
		super(iDPERSONNE, lOGINPERSONNE, mDPPERSONNE, iSADMIN);
	}

	private ArrayList<Alert> alertsList;
	
}
