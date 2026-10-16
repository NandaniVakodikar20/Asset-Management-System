
package com.nandani.assetmanagement.operations;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.nandani.assetmanagement.entities.Asset;
import com.nandani.assetmanagement.util.HibernateUtil;

public class DeleteAsset {

    public static void deleteAsset(Scanner sc) {

//      Configuration configuration = new Configuration();
//      configuration.configure();

//      System.out.println("configuration done..");

//      SessionFactory sessionFactory = configuration.buildSessionFactory();

//      System.out.println("Session Factory Created....");

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        System.out.println("Session created....");

        Transaction transaction = session.beginTransaction();

        System.out.println("Enter Asset id to Delete:");
        int assetId = sc.nextInt();

        Asset asset = session.get(Asset.class, assetId);

        if (asset != null) {

            session.remove(asset);

            transaction.commit();

            System.out.println("Asset Delete Successfully..");

        } else {

            System.out.println("Asset Not Found..");

            transaction.rollback();
        }

        session.close();
    }
}
