
package com.nandani.assetmanagement.operations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.nandani.assetmanagement.util.HibernateUtil;

import com.nandani.assetmanagement.entities.Asset;


public class AddAsset {
    
    public static void addAsset(Scanner sc) throws ParseException {

//      Configuration configuration =new Configuration();
//      configuration.configure();
//      System.out.println("configuration done..");
        
//      SessionFactory sessionFactory= configuration.buildSessionFactory();
//      System.out.println("seession Factory Created....");
    
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        System.out.println("Seession created....");
    
        Transaction transaction = session.beginTransaction();
    
        Asset asset = new Asset();
    
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
    
        System.out.println("Enter Asset id: ");
        asset.setAssetId(sc.nextInt());
    
        System.out.println("Enter Asset Name: ");
        asset.setAssetName(sc.next());
    
        System.out.println("Enter Asset Type :");
        asset.setAssetType(sc.next());
     
        System.out.println("Enter Asset Serial No:");
        asset.setAssetSerialNo(sc.next());
     
        System.out.println("Enter Purchase Date (dd-MM-yyyy):");
        asset.setAssetPurchaseDate(simpleDateFormat.parse(sc.next()));
     
        session.persist(asset);
        transaction.commit();

        System.out.println("Asset Insert Successfully..");
    
        session.close();
    }
}
