package org.js9.service;

import org.js9.database.StaffDatabase;
import org.js9.model.*;
import org.js9.util.NameFormat;

import java.util.Map;

public class ManagerServiceImpl implements ManagerService, StaffDatabase {
    @Override
    public void hire(Applicant applicant) {
      if(!applicant.getQualification().equals(Qualification.SecondarySchool)){
          if(applicant.getAge() >= 16){
              if(applicant.getAppliedPosition().equals(Post.MANAGER)){
                  if(!applicant.getQualification().equals(Qualification.OrdinaryDiploma)){
                      System.out.printf("%s, you are qualified for this position. You are hired!\n", applicant.getFirstName()+" " + applicant.getLastName());
                      System.out.println("Adding applicant to the Managers database.................................");
                      var manager = new Manager(applicant.getFirstName(), applicant.getLastName(),   applicant.getGender(), applicant.getEmail(), StaffType.MANAGER);

                      //TODO : Maybe we can write a method to generate company specific email for the new manager.
                      manager.setEmail(applicant.getEmail());
                      storeManagers.put(generateManagerId(), manager);
                  }else {
                      System.out.println("Sorry your qualification is not up to the requirement for this position.");
                  }
              }else {
                  System.out.printf("%s, you are qualified for the position of a %s. You are hired!\n", applicant.getFirstName()+" " + applicant.getLastName(), Post.CASHIER);
                  System.out.println("Adding applicant to the Cashiers database............................................");
                  var cashier = new Cashier(applicant.getFirstName(), applicant.getLastName(),   applicant.getGender(), applicant.getEmail(), StaffType.CASHIER);

                  //TODO : Maybe we can write a method to generate company specific email for the new manager.
                  cashier.setEmail(applicant.getEmail());
                  storeCashiers.put(generateCashierId(), cashier);
              }
          }else{
              System.out.println("XXXXXXXXXXXXXXXXXXXXXX AGE LIMIT VIOLATION NOT HIRED! XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
              System.out.println("Sorry your are ineligible for this position due to age limit.");
          }
      }else{
          System.out.println("XXXXXXXXXXXXXXXXXXXXXX QUALIFICATION DISQUALIFICATION NOT HIRED! XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

          System.out.println("We do not hire secondary school graduates.Sorry.");
      }
    }

    @Override
    public void fire(String cashierId) {
        Map<String, Cashier> storeCashiersMap = StaffDatabase.storeCashiers;
        if(storeCashiersMap.containsKey(cashierId)){
            Cashier cashier = storeCashiersMap.get(cashierId);
            String cashierName = NameFormat.formatName(cashier.getFirstName(), cashier.getLastName());
            System.out.printf("%s has been fired.", cashierName);
            System.out.printf("Removing %s from the database......", cashierName);
            storeCashiersMap.remove(cashier.getStaffId());
            System.out.printf("%s has been removed successfully.", cashierName);
        }else{
            System.out.println("Staff may have been fired or does not exist.");
        }
    }

}
