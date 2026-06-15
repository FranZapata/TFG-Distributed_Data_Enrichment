package com.tfg.Servicio_frontend.vistas.graficas;

import com.tfg.Servicio_frontend.layout.MainLayout;
import com.tfg.Servicio_frontend.servicio.GraficaServicio;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(
        value = "grafiacs",
        layout = MainLayout.class
)
@PageTitle("Gráficas")
public class GraficaView extends VerticalLayout {
    public GraficaView(GraficaServicio servicio) {

        setWidthFull();
        setPadding(true);
        setSpacing(true);
        getStyle().set("background-color", "#f8fafc");

        Div chartsGrid = new Div();
        chartsGrid.getStyle()
                .set("display", "grid")
                .set("grid-template-columns","1fr 1fr")
                .set("gap", "20px")
                .set("width", "100%");
        chartsGrid.setWidthFull();

        chartsGrid.add(
                createChartCard("Evolución del precio medio", buildEvolucionPrecioChart())
        );

        chartsGrid.add(
                createChartCard("Distribución de precios", buildDistribucionPreciosChart())
        );

        chartsGrid.add(
                createChartCard("Modelos más anunciados", buildModelosMasAnunciadosChart())
        );

        chartsGrid.add(
                createChartCard("Estado de los anuncios", buildEstadoAnunciosChart())
        );

        add(buildCabecera(),chartsGrid);
    }

    private Component buildCabecera(){
        H1 titulo = new H1("Gráficas");
        titulo.getStyle()
                .set("color", "#1e3a5f")
                .set("margin-bottom", "20px")
                .set("font-weight", "700");

        Button newChartButton = new Button("Nueva gráfica");
        newChartButton.addClickListener(
                e -> openNewChartDialog()
        );

        HorizontalLayout cabecera = new HorizontalLayout(titulo,newChartButton);
        cabecera.setWidthFull();
        cabecera.setJustifyContentMode(JustifyContentMode.BETWEEN);
        cabecera.setAlignItems(Alignment.CENTER);

        return cabecera;
    }

    private Component createChartCard(String titulo, Chart chart){
        VerticalLayout card = new VerticalLayout();

        card.setPadding(true);

        card.setSpacing(true);

        card.getStyle()
                .set("background-color", "white")
                .set("border-radius", "12px")
                .set("padding", "20px")
                .set("box-shadow", "0 4px 12px rgba(0,0,0,0.08)")
                .set("border", "1px solid #e5e7eb")
                .set("transition", "all 0.2s ease");

        H3 tituloChart = new H3(titulo);
        tituloChart.getStyle()
                .set("color", "#1e3a5f")
                .set("margin-top", "0")
                .set("margin-bottom", "10px")
                .set("border-bottom", "2px solid #e5e7eb")
                .set("padding-bottom", "8px");

        card.add(tituloChart, chart);

        return card;
    }

    private Chart buildEvolucionPrecioChart(){
        Chart chart = new Chart(ChartType.LINE);
        chart.setHeight("350px");
        Configuration config = chart.getConfiguration();

        XAxis xAxis = config.getxAxis();
        xAxis.setCategories( "L","M","X","J","V","S","D");

        YAxis yAxis = config.getyAxis();
        yAxis.setTitle("Precio (€)");

        config.addSeries(new ListSeries("Precio medio (€)",1800,1850,1900,1750,2100,2200,2150));

        return chart;
    }

    private Chart buildDistribucionPreciosChart(){
        Chart chart = new Chart(ChartType.COLUMN);
        chart.setHeight("350px");
        Configuration config = chart.getConfiguration();

        XAxis xAxis = config.getxAxis();
        xAxis.setCategories( "<1000€","1000-2000€","2000€-3000","3000-4000€","4000€+");

        YAxis yAxis = config.getyAxis();
        yAxis.setTitle("Anuncios");

        config.addSeries(new ListSeries("Cantidad de anuncios",15,30,22,18,10));

        return chart;
    }

    private Chart buildModelosMasAnunciadosChart(){
        Chart chart = new Chart(ChartType.BAR);
        chart.setHeight("350px");
        Configuration config = chart.getConfiguration();

        XAxis xAxis = config.getxAxis();
        xAxis.setCategories( "GS500","CB500F","ER5","MT03");

        YAxis yAxis = config.getyAxis();
        yAxis.setTitle("Anuncios");

        config.addSeries(new ListSeries("Cantidad de anuncios",35,20,18,12));

        return chart;
    }

    private Chart buildEstadoAnunciosChart(){
        Chart chart = new Chart(ChartType.PIE);
        chart.setHeight("350px");
        Configuration config = chart.getConfiguration();

        DataSeries series = new DataSeries();
        series.add(new DataSeriesItem("Nuevo",10));
        series.add(new DataSeriesItem("Seminuevo",30));
        series.add(new DataSeriesItem("Usado",60));

        config.addSeries(series);

        return chart;
    }

    private void openNewChartDialog() {
        Dialog dialog = new Dialog();

        dialog.setHeaderTitle("Nueva gráfica");

        ComboBox<String> chartType = new ComboBox<>("Tipo de gráfica");
        chartType.setItems("Líneas","Barras","Tarta");

        ComboBox<String> xVariable = new ComboBox<>("Variable X");
        xVariable.setItems("Precio","Modelo","Estado","Fecha");

        ComboBox<String> yVariable = new ComboBox<>("Variable Y");
        yVariable.setItems("Número anuncios","Precio medio");

        Button createButton = new Button("Crear");
        createButton.addClickListener(
                e -> Notification.show("Funcionalidad disponible próximamente")
        );

        Button cancelButton = new Button("Cancelar");

        cancelButton.addClickListener(e -> dialog.close());

        VerticalLayout content = new VerticalLayout(chartType,xVariable,yVariable);

        HorizontalLayout buttons = new HorizontalLayout(createButton,cancelButton);

        dialog.add(content);
        dialog.getFooter().add(cancelButton,createButton);

        dialog.open();
    }
}
