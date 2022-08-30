package logic.controller.guicontroller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.*;
import javafx.stage.Screen;

import java.util.List;

public class ChartGUI {
    public BarChart<String,Number> newBarChart(String xAxis, String yAxis, String title){
        final CategoryAxis newCategoryAxis = new CategoryAxis();
        final NumberAxis newNumberAxis = new NumberAxis();
        final BarChart<String,Number> newBarChart = new BarChart<>(newCategoryAxis,newNumberAxis);
        newBarChart.setTitle(title);
        newCategoryAxis.setLabel(xAxis);
        newNumberAxis.setLabel(yAxis);
        newBarChart.setPrefWidth((Screen.getPrimary().getBounds().getWidth()/2));
        return newBarChart;
    }

    public PieChart newPieChart(ObservableList<PieChart.Data> valueList, String title){
        PieChart newPieChart = new PieChart(valueList);
        newPieChart.setTitle(title);
        newPieChart.setPrefHeight((Screen.getPrimary().getBounds().getHeight()-100)/2);
        newPieChart.setPrefWidth(Screen.getPrimary().getBounds().getWidth()/3);
        return newPieChart;
    }

    public LineChart<String, Number> newLineChart(String xAxis, String yAxis, String title){
        final CategoryAxis categoryAxis = new CategoryAxis();
        final NumberAxis numberAxis = new NumberAxis();
        LineChart<String, Number> newLineChart = new LineChart<>(categoryAxis,numberAxis);
        categoryAxis.setLabel(xAxis);
        numberAxis.setLabel(yAxis);
        newLineChart.setTitle(title);
        newLineChart.setPrefWidth((Screen.getPrimary().getBounds().getWidth()/2));
        return newLineChart;
    }

    public XYChart.Series<String,Number> newSeries(List<Double> dataList, List<String> seriesName, String name){
        XYChart.Series<String, Number> newSeries = new XYChart.Series<>();
        newSeries.setName(name);
        for (int i = 0;i < dataList.size(); i++){
            newSeries.getData().add(new XYChart.Data<>(seriesName.get(i),dataList.get(i)));
        }
        return newSeries;
    }

    public ObservableList<PieChart.Data> value(List<Double> dataList,List<String> seriesName){
        ObservableList<PieChart.Data> newData = FXCollections.observableArrayList();
        for (int i = 0; i < dataList.size(); i++){
            newData.add(new PieChart.Data(seriesName.get(i),dataList.get(i)));
        }
        return newData;
    }
}
