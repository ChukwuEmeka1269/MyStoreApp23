package org.js9.database;

import org.js9.model.*;
import org.js9.util.RandomAlphaNumericGenerator;

import java.util.*;
import java.util.stream.Collectors;

public interface StaffDatabase {
    Map<String, Manager> storeManagers = new HashMap<>();
    Map<String, Cashier> storeCashiers = new HashMap<>();
    Map<String, Staff> firedStaffs = new HashMap<>();
    Map<String, Applicant> storeApplicants = new HashMap<>();

    default List<Manager> getManagers(){
        return new ArrayList<>(storeManagers.values());
    }

    default List<Cashier> getCashiers(){
        return new ArrayList<>(storeCashiers.values());
    }

    default String generateManagerId(){
        return RandomAlphaNumericGenerator.generateRandomAlphaNumericForStaff(StaffType.MANAGER, Manager.getStaffCount());
    }

    default String generateCashierId(){
        return RandomAlphaNumericGenerator.generateRandomAlphaNumericForStaff(StaffType.CASHIER, Cashier.getStaffCount());
    }

}
