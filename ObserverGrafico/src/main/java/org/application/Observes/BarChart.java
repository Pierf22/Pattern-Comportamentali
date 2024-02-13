package org.application.Observes;

import org.application.Subjects.Dataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;

public class BarChart implements Observer{
    DefaultCategoryDataset graphset=new DefaultCategoryDataset();
    Dataset dataset; //subject
    public BarChart(Dataset dataset) {
        dataset.attach(this);
        this.dataset = dataset;
        for(String key:dataset.getData().keySet()){
            graphset.setValue(dataset.getData().get(key),"", key);
        }
    }
    @Override
    public void update() {
        for(String key:dataset.getData().keySet()){
            graphset.setValue(dataset.getData().get(key), "", key);
        }

    }
    public JFrame getChart() {
        JFreeChart barChart= ChartFactory.createBarChart("", "", "percentuale", graphset, PlotOrientation.VERTICAL, false, true, false);
        ChartPanel chartPanel=new ChartPanel(barChart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        chartPanel.setPreferredSize(new Dimension(500, 400));


        JFrame frame=new JFrame("grafico a Barre");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(chartPanel);
        frame.pack();
        frame.setAlwaysOnTop(true);

        return frame;

    }
}
