package com.example.interestgraphassignment.util;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class Plotter extends Application {
    private static List<Integer> xValues;
    private static List<Integer> clusterSizes;
    private static List<Integer> clusterNumbers;

    public static void createPlots(List<Integer> x, List<Integer> sizes, List<Integer> numbers) {
        xValues = x;
        clusterSizes = sizes;
        clusterNumbers = numbers;
        launch();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Interest Graph Plots");

        NumberAxis xAxis1 = new NumberAxis();
        NumberAxis yAxis1 = new NumberAxis();
        xAxis1.setLabel("x");
        yAxis1.setLabel("Average Cluster Size");

        LineChart<Number, Number> sizeChart = new LineChart<>(xAxis1, yAxis1);
        sizeChart.setTitle("Cluster Size vs x");

        XYChart.Series<Number, Number> sizeSeries = new XYChart.Series<>();
        sizeSeries.setName("Cluster Size");

        for (int i = 0; i < xValues.size(); i++) {
            sizeSeries.getData().add(new XYChart.Data<>(xValues.get(i), clusterSizes.get(i)));
        }

        sizeChart.getData().add(sizeSeries);

        NumberAxis xAxis2 = new NumberAxis();
        NumberAxis yAxis2 = new NumberAxis();
        xAxis2.setLabel("x");
        yAxis2.setLabel("Number of Clusters");

        LineChart<Number, Number> numberChart = new LineChart<>(xAxis2, yAxis2);
        numberChart.setTitle("Number of Clusters vs x");

        XYChart.Series<Number, Number> numberSeries = new XYChart.Series<>();
        numberSeries.setName("Number of Clusters");

        for (int i = 0; i < xValues.size(); i++) {
            numberSeries.getData().add(new XYChart.Data<>(xValues.get(i), clusterNumbers.get(i)));
        }

        numberChart.getData().add(numberSeries);

        VBox vbox = new VBox(sizeChart, numberChart);
        Scene scene = new Scene(vbox, 800, 600);
        stage.setScene(scene);
        stage.show();
    }
}