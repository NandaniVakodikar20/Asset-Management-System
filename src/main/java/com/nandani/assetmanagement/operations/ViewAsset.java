
package com.nandani.assetmanagement.operations;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nandani.assetmanagement.entities.Asset;
import com.nandani.assetmanagement.util.HibernateUtil;

public class ViewAsset {

    public static void viewAsset(Scanner sc) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        System.out.println("Session created....");

        System.out.println("Enter Asset id to View:");
        int assetId = sc.nextInt();

        Asset asset = session.get(Asset.class, assetId);

        if (asset != null) {

            System.out.println("Asset Details:");
            System.out.println("Asset Id: " + asset.getAssetId());
            System.out.println("Asset Name: " + asset.getAssetName());
            System.out.println("Asset Type: " + asset.getAssetType());
            System.out.println("Asset Serial No: " + asset.getAssetSerialNo());
            System.out.println("Purchase Date: " + asset.getAssetPurchaseDate());

        } else {

            System.out.println("Asset Not Found..");
        }

        session.close();
    }
}
