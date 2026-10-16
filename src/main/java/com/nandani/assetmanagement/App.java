
package com.nandani.assetmanagement;

/**
 * Hello world!
 *
 */

import java.util.Scanner;

import com.nandani.assetmanagement.operations.AddAsset;
import com.nandani.assetmanagement.operations.UpdateAsset;
import com.nandani.assetmanagement.operations.ViewAsset;
import com.nandani.assetmanagement.operations.DeleteAsset;
import com.nandani.assetmanagement.util.HibernateUtil;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n Asset Mangaement System ");
            System.out.println("1. Add Asset");
            System.out.println("2. Update Asset");
            System.out.println("3. View Asset");
            System.out.println("4. Delete Asset");
            System.out.println("5. Exit");

            System.out.println("Enter Your Choice:");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    AddAsset.addAsset(sc);
                    break;

                case 2:
                    UpdateAsset.updateAsset(sc);
                    break;

                case 3:
                    ViewAsset.viewAsset(sc);
                    break;

                case 4:
                    DeleteAsset.deleteAsset(sc);
                    break;

                case 5:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();

        HibernateUtil.getSessionFactory().close();
    }
}
