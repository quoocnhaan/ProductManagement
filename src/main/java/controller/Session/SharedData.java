/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Session;

//import java.util.ArrayList;
import java.awt.Color;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import view.component.Product.Product_Component.Product_Component;

//import java.util.List;
//import model.DateRange;
//import model.Employee;
//import model.PayPeriod;
/**
 *
 * @author LENOVO
 */
public class SharedData {

    public static String fontName = "Roboto";
    public static Color mainColor = new Color(50, 94, 90);
    public static Color btnDefaultColor = new Color(243, 244, 245);
    public static int selectedAmount = 0;
    public static List<Product_Component> selectedProduct = new ArrayList<>();
    public static boolean beingSelected = false;
    public static Date date = Date.valueOf(LocalDate.now());
}
