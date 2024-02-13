package org.application;

import org.application.Observes.BarChart;
import org.application.Observes.PieChart;
import org.application.Subjects.Dataset;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        //subject
        Dataset dataset=new Dataset();
        //observers
        PieChart chart=new PieChart(dataset);
        BarChart barChart=new BarChart(dataset);
        JFrame frame=chart.getChart();
        JFrame frame1=barChart.getChart();
        Scanner scanner=new Scanner(System.in);
        String key, keyValue;
        double value;
        int input = 0;
        while(input!=-1){
            System.out.print("1: inserisci una chiave valore\n" +
                    "-1: chiudi il programma: ");
            input=scanner.nextInt();
            if (input == 1) {
                System.out.print("Inserisci una coppia chiave:valore: ");
                keyValue = scanner.next();
                key = keyValue.split(":")[0];
                value = Double.parseDouble(keyValue.split(":")[1]);
                dataset.addData(key, value);
            }

    }frame.dispose();
        frame1.dispose();
    }
}