package org.js9.service;

import org.js9.model.Applicant;
import org.js9.model.Cashier;

public interface ManagerService {
    void hire(Applicant applicant);
    void fire(String cashier);
}
