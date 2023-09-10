package org.js9.service;

import org.js9.model.Applicant;
import org.js9.model.Customer;
import org.js9.util.CustomerAccountBalanceComparator;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public interface ManagerService {

    Queue<Customer> fifoQueue = new ArrayDeque<>();
    Queue<Customer> priorityQueue = new PriorityQueue<>(new CustomerAccountBalanceComparator());
    void hire(Applicant applicant);
    void fire(String cashier);



     default boolean addCustomerToFifoQueue(Customer customer){
         return fifoQueue.offer(customer);
     }

     default boolean addCustomerToPriorityQueue(Customer customer){
         return priorityQueue.offer(customer);
     }

     default Queue<Customer> getPriorityQueue(){
         return priorityQueue;
     }

     default Queue<Customer> getFifoQueue(){
         return fifoQueue;
     }













}
