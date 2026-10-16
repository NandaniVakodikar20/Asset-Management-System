
package com.nandani.assetmanagement.operations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nandani.assetmanagement.util.HibernateUtil;
import com.nandani.assetmanagement.entities.Asset;

public class UpdateAsset {

    public static void updateAsset(Scanner sc) throws ParseException {

//      Configuration configuration = new Configuration();
//      configuration.configure();

//      System.out.println("configuration done..");

//      SessionFactory sessionFactory = configuration.buildSessionFactory();

//      System.out.println("Session Factory Created....");

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        System.out.println("Session created....");

        Transaction transaction = session.beginTransaction();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        System.out.println("Enter Asset id to Update:");
        int assetId = sc.nextInt();

        Asset asset = session.get(Asset.class, assetId);

        if (asset != null) {

            System.out.println("Enter Asset Name:");
            asset.setAssetName(sc.next());

            System.out.println("Enter Asset Type:");
            asset.setAssetType(sc.next());

            System.out.println("Enter Asset Serial No:");
            asset.setAssetSerialNo(sc.next());

            System.out.println("Enter Purchase Date (dd-MM-yyyy):");
            asset.setAssetPurchaseDate(simpleDateFormat.parse(sc.next()));

            transaction.commit();

            System.out.println("Asset Update Successfully..");

        } else {

            System.out.println("Asset Not Found..");

            transaction.rollback();
        }

        session.close();
    }
}
