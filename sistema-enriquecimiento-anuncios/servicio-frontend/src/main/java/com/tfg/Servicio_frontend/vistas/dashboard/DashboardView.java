package com.tfg.Servicio_frontend.vistas.dashboard;

import com.tfg.Servicio_frontend.layout.MainLayout;
import com.tfg.Servicio_frontend.servicio.DashboardServicio;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.ChartType;
import com.vaadin.flow.component.charts.model.Configuration;
import com.vaadin.flow.component.charts.model.ListSeries;
import com.vaadin.flow.component.charts.model.XAxis;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(
        value = "",
        layout = MainLayout.class
)
@PageTitle("Dashboard")
public class DashboardView extends VerticalLayout {

    public DashboardView(DashboardServicio servicioDashboard) {

        // Configuración
        setSizeFull();
        setPadding(true);
        setSpacing(true);

        H1 titulo = new H1("Dashboard");
        add(titulo);

        add(buildKpis(servicioDashboard));
        add(buildAnunciosPorDiaChart());
        add(buildPrecioMedioChart());
        add(buildBusquedasGuardadas());
    }

    private Component buildKpis(DashboardServicio servicio){
        HorizontalLayout layout = new HorizontalLayout();
        layout.setWidthFull();

        layout.add(
                createKpiCard("Anuncios", servicio.getTotalAds().toString()),
                createKpiCard("Motor", servicio.getMotorAds().toString()),
                createKpiCard("Inmuebles", servicio.getInmobiliarioAds().toString()),
                createKpiCard("Búsquedas guardadas", servicio.getSavedSearches().toString())
        );



        return layout;
    }

    private Component createKpiCard(String titulo, String valor) {
        VerticalLayout card = new VerticalLayout();
        card.getStyle()
                .set("border","1px solid #ddd")
                .set("border-radius","10px")
                .set("padding","20px");

        H3 kpiValue = new H3(valor);
        Span kpiTitle = new Span(titulo);

        card.add(kpiValue,kpiTitle);
        return card;
    }

    private Chart buildAnunciosPorDiaChart(){
        Chart chart = new Chart(ChartType.LINE);
        chart.setHeight("400px");
        Configuration config = chart.getConfiguration();

        config.setTitle("Anuncios analizados esta semana");
        config.addSeries(new ListSeries(120,145,170,220,190,260,300)); // Datos mock

        XAxis xAxis = new XAxis();
        xAxis.setCategories( "L","M","X","J","V","S","D");
        config.addxAxis(xAxis);

        return chart;
    }

    private Chart buildPrecioMedioChart(){
        Chart chart = new Chart(ChartType.LINE);
        chart.setHeight("400px");
        Configuration config = chart.getConfiguration();

        config.setTitle("Precio medio por modelo");

        config.addSeries(new ListSeries(1800,2200,1600,2500));

        XAxis xAxis = new XAxis();
        xAxis.setCategories( "GS500","CB500F","ER5","MT03");
        config.addxAxis(xAxis);

        return chart;

    }

    private Component buildBusquedasGuardadas(){
        HorizontalLayout layout = new HorizontalLayout();
        layout.add(new H3("Búsquedas guardadas"));

        layout.add(
                new Button("Motos A2 < 3000€"),
                new Button("Honda CB500F Madrid"),
                new Button("Pisos Valencia"),
                new Button("Garajes Sevilla")
        );

        return layout;
    }
}
