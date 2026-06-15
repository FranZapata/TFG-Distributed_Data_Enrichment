package com.tfg.Servicio_frontend.layout;

import com.tfg.Servicio_frontend.vistas.busqueda.BusquedaView;
import com.tfg.Servicio_frontend.vistas.dashboard.DashboardView;
import com.tfg.Servicio_frontend.vistas.graficas.GraficaView;
import com.tfg.Servicio_frontend.vistas.prompt.PlantillaPromptView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;

public class MainLayout extends AppLayout {

    private static final String PRIMARY_COLOR = "#1e3a5f";
    private static final String BUTTON_COLOR = "#f3f4f6";
    private static final String BUTTON_HOVER = "#e5e7eb";

    public MainLayout(){
        createHeader();
    }

    private void createHeader() {

        H1 logo = new H1("\uD83D\uDD0D Análisis anuncios segunda mano");
        logo.getStyle()
                .set("color", "white")
                .set("font-size", "1.7em")
                .set("margin", "0")
                .set("font-weight", "600");

        RouterLink dashboard = new RouterLink("Dashboard", DashboardView.class);
        dashboard.getStyle().set("text-decoration","none");
        styleMenuButton(dashboard);

        RouterLink search = new RouterLink("Búsqueda", BusquedaView.class);
        search.getStyle().set("text-decoration","none");
        styleMenuButton(search);

        RouterLink charts = new RouterLink("Gráficas", GraficaView.class);
        charts.getStyle().set("text-decoration","none");
        styleMenuButton(charts);

        RouterLink prompts = new RouterLink("Prompts", PlantillaPromptView.class);
        charts.getStyle().set("text-decoration","none");
        styleMenuButton(prompts);


        HorizontalLayout menu = new HorizontalLayout(dashboard, search, charts, prompts);
        menu.setSpacing(true);
        menu.setPadding(false);
        menu.setMargin(false);

        HorizontalLayout header = new HorizontalLayout(logo, menu);
        header.setWidthFull();
        header.setAlignItems(FlexComponent.Alignment.CENTER);
        header.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);
        header.getStyle()
                .set("background-color", PRIMARY_COLOR)
                .set("padding", "15px 25px")
                .set("border-radius", "12px")
                .set("margin", "10px")
                .set("box-shadow","0 2px 8px rgba(0,0,0,0.15)");

        addToNavbar(header);
        getStyle().set("background-color", "#f8fafc");
    }

    private void styleMenuButton(RouterLink link) {

        link.getStyle()
                .set("padding", "10px 18px")
                .set("background-color", BUTTON_COLOR)
                .set("border-radius", "8px")
                .set("text-decoration", "none")
                .set("color", "#374151")
                .set("font-weight", "500")
                .set("transition", "0.2s");
    }
}
