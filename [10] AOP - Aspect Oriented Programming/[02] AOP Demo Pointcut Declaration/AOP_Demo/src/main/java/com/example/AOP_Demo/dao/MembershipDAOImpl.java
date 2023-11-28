package com.example.AOP_Demo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {

    @Override
    public boolean addSillyNumber() {

        System.out.println(getClass() + " DOING DB WORK: ADDING A MEMBERSHIP");
        return true;
    }

    @Override
    public void goToSleep() {
        System.out.println("Inside goToSleep()");
    }
}
