package com.tfg.Servicio_frontend.vistas.busqueda;

import com.tfg.Servicio_frontend.dto.AnuncioDto;
import com.tfg.Servicio_frontend.dto.AnuncioInmobiliarioDto;
import com.tfg.Servicio_frontend.dto.AnuncioMotoDto;
import com.tfg.Servicio_frontend.layout.MainLayout;
import com.tfg.Servicio_frontend.servicio.AnuncioServicio;
import com.tfg.Servicio_frontend.servicio.mock.MockAnuncioServicio;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Route(
        value = "busqueda",
        layout = MainLayout.class
)
@PageTitle("Búsqueda")
public class BusquedaView extends HorizontalLayout {

    private final VerticalLayout panelFiltros = new VerticalLayout();
    private final VerticalLayout panelResultados = new VerticalLayout();
    private final VerticalLayout filtrosDinamicos = new VerticalLayout();

    private final ComboBox<String> categoriaCombo = new ComboBox<>("Categoría");

    private final AnuncioServicio anuncioServicio;
    private List<AnuncioDto> anuncios;
    private final Select<String> ordenacionSelect = new Select<>();

    private final VerticalLayout cardsContainer = new VerticalLayout();

    private int paginaActual = 0;
    private static final int TAMANO_PAGINA = 16;
    private final HorizontalLayout paginacion = new HorizontalLayout();

    private AnuncioDto anuncioSeleccionado;

    private final Span contadorResultados = new Span();
    
    public BusquedaView(
            AnuncioServicio anuncioServicio
    ) {
        this.anuncioServicio = anuncioServicio;

        this.anuncios = anuncioServicio.buscarTodo();

        // Configuracion
        categoriaCombo.setItems(
                "Motor",
                "Inmobiliaria"
        );
        categoriaCombo.setValue("Motor");
        categoriaCombo.addValueChangeListener(event -> {

            updateFiltros();
        });

        cardsContainer.getStyle()
                .set("display","flex")
                .set("flex-wrap", "wrap")
                .set("gap", "24px");

        setWidthFull();
        add(
                crearPanelFiltros(),
                crearPanelResultados()
        );

        updateFiltros();
        refrescarResultados();

        getStyle().set("background-color","#f8fafc");

    }

    private Component crearPanelResultados() {
        panelResultados.setWidthFull();
        panelResultados.setPadding(false);

        panelResultados.add(
                crearBarraOrdenacion()
        );

        cardsContainer.setWidthFull();

        panelResultados.add(contadorResultados,cardsContainer, paginacion);


        return panelResultados;
    }

    private Component crearBarraOrdenacion() {
        HorizontalLayout layout =
                new HorizontalLayout();

        ordenacionSelect.setLabel("Ordenar por");

        ordenacionSelect.setItems(
                "Precio",
                "Título"
        );

        ordenacionSelect.setValue("Precio");

        ordenacionSelect.addValueChangeListener(
                e -> refrescarResultados()
        );

        layout.add(ordenacionSelect);

        return layout;
    }

    private Component crearPanelFiltros() {
        panelFiltros.setWidth("320px");

        panelFiltros.add(
                new H3("Filtros")
        );

        panelFiltros.add(categoriaCombo);
        panelFiltros.add(filtrosDinamicos);

        panelFiltros.getStyle()
                .set("background-color", "white")
                .set("border", "1px solid #e5e7eb")
                .set("border-radius", "12px")
                .set("padding", "20px")
                .set("box-shadow", "0 4px 12px rgba(0,0,0,0.08)");

        return panelFiltros;
    }

    private void updateFiltros() {
        filtrosDinamicos.removeAll();

        if ("Motor".equals(categoriaCombo.getValue())) {

            crearFiltrosMotor();

        } else {

            crearFiltrosInmobiliario();
        }

        Button searchButton = new Button("Buscar");
        searchButton.addClickListener(e -> refrescarResultados());
        filtrosDinamicos.add(searchButton);

        Button saveSearchButton = new Button("Guardar búsqueda");
        searchButton.addClickListener(e -> Notification.show("Busqueda guardada"));
        filtrosDinamicos.add(saveSearchButton);
    }

    private void crearFiltrosInmobiliario() {
        Select<String> tipoPropiedad = new Select<>();
        tipoPropiedad.setLabel("Tipo");

        tipoPropiedad.setItems(
                "Casa",
                "Piso",
                "Garaje",
                "Ático",
                "Campo"
        );

        NumberField precioMin =
                new NumberField("Precio mínimo");

        NumberField precioMax =
                new NumberField("Precio máximo");

        NumberField m2Min =
                new NumberField("m² mínimo");

        NumberField m2Max =
                new NumberField("m² máximo");

        Select<String> estado =
                new Select<>();

        estado.setLabel("Estado");

        estado.setItems(
                "Nuevo",
                "Seminuevo",
                "Usado"
        );

        filtrosDinamicos.add(
                tipoPropiedad,
                precioMin,
                precioMax,
                m2Min,
                m2Max,
                estado
        );
    }

    private void crearFiltrosMotor() {
        TextField marca = new TextField("Marca");

        TextField modelo = new TextField("Modelo");

        NumberField precioMin = new NumberField("Precio mínimo");

        NumberField precioMax = new NumberField("Precio máximo");

        NumberField kmMin = new NumberField("KM mínimo");

        NumberField kmMax = new NumberField("KM máximo");

        Checkbox a2 = new Checkbox("Apto A2");

        Select<String> estado = new Select<>();

        estado.setLabel("Estado");

        estado.setItems(
                "Nuevo",
                "Seminuevo",
                "Usado"
        );

        filtrosDinamicos.add(
                marca,
                modelo,
                precioMin,
                precioMax,
                kmMin,
                kmMax,
                a2,
                estado
        );
    }

    private void refrescarResultados() {
        cardsContainer.removeAll();

        List<AnuncioDto> ads =
                new ArrayList<>(anuncios);

        aplicarOrdenacion(ads);

        int fromIndex = paginaActual * TAMANO_PAGINA;

        int toIndex = Math.min(fromIndex + TAMANO_PAGINA, ads.size());

        List<AnuncioDto> pageAds = ads.subList(fromIndex, toIndex);
        renderCards(pageAds);

        buildPaginacion(ads.size());

        contadorResultados.setText(
                "Se han encontrado " +
                        ads.size() +
                        " anuncios"
        );
    }

    private void buildPaginacion(int size) {
        paginacion.removeAll();

        int pages = (int) Math.ceil((double)  size/ TAMANO_PAGINA);

        for (int i = 0; i < pages; i++) {
            int page = i;

            Button button = new Button(String.valueOf(i + 1));
            button.addClickListener(
                    e -> {
                        paginaActual = page;
                        refrescarResultados();
                    }
            );

            paginacion.add(button);
        }
    }

    private Component crearCard(AnuncioDto ad) {

        // Diseno card
        VerticalLayout card = new VerticalLayout();
        card.setWidth("380px");
        card.getStyle()
                .set("background-color", "white")
                .set("border-radius", "12px")
                .set("padding", "12px")
                .set("border", "1px solid #e5e7eb")
                .set("box-shadow", "0 4px 12px rgba(0,0,0,0.08)")
                .set("transition", "all 0.2s ease");

        // Espacio para la imagen
        Image imagen =
                new Image(
                        ad.getUrlImagen(),
                        ad.getTitulo()
                );
        imagen.setWidthFull();
        imagen.setHeight("180px");
        imagen.getStyle()
                .set("object-fit", "cover")
                .set("border-radius", "8px");



        // Titulo
        H4 titulo = new H4(ad.getTitulo());
        titulo.getStyle()
                .set("color", "#1e3a5f")
                .set("font-size", "1.1em")
                .set("font-weight", "600")
                .set("margin-top", "10px")
                .set("margin-bottom", "5px");

        // Precio
        Span precio = new Span(String.format("%.2f €", ad.getPrecioValor()));
        precio.getStyle()
                .set("color", "#2563eb")
                .set("font-size", "1.3em")
                .set("font-weight", "700");

        // Enlace
        Anchor enlace = new Anchor(ad.getUrlOrigen(), "Ver anuncio");
        enlace.setTarget("_blank");
        enlace.getStyle()
                .set("background-color", "#1e3a5f")
                .set("color", "white")
                .set("padding", "6px 12px")
                .set("font-size", "0.9em")
                .set("font-weight", "600")
                .set("border-radius", "8px")
                .set("text-decoration", "none")
                .set("text-align", "center");

        HorizontalLayout actionBar = new HorizontalLayout(precio, enlace);
        actionBar.setWidthFull();
        actionBar.setAlignItems(FlexComponent.Alignment.CENTER);
        actionBar.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);

        card.add(imagen, titulo, actionBar);

        card.addClickListener(event -> {
            if (anuncioSeleccionado != null && anuncioSeleccionado.getIdAnuncio().equals(ad.getIdAnuncio())){
                anuncioSeleccionado = null;
            }else{
                anuncioSeleccionado = ad;
            }
            refrescarResultados();
        });

        if (anuncioSeleccionado != null && anuncioSeleccionado.getIdAnuncio().equals(ad.getIdAnuncio())) {

            card.getStyle()
                    .set("border", "2px solid #2563eb")
                    .set("box-shadow", "0 6px 16px rgba(37,99,235,0.25)");
        }

        return card;
    }

    private void aplicarOrdenacion(List<AnuncioDto> anuncios) {
        if ("Precio".equals(ordenacionSelect.getValue())) {
            anuncios.sort(
                    Comparator.comparing(AnuncioDto::getPrecioValor)
            );

        } else {
            anuncios.sort(
                    Comparator.comparing(AnuncioDto::getTitulo)
            );
        }
    }

    private void renderCards(List<AnuncioDto> ads){
        int cardsPerRow = 4;
        for(int i = 0; i < ads.size(); i += cardsPerRow){
            HorizontalLayout row = new HorizontalLayout();
            row.setWidthFull();
            row.setJustifyContentMode(JustifyContentMode.START);
            boolean rowContainsSelected = false;

            for (int j = i; j < Math.min(i + cardsPerRow,ads.size()); j++){
                AnuncioDto ad = ads.get(j);
                row.add(crearCard(ad));
                if (anuncioSeleccionado != null && anuncioSeleccionado.getIdAnuncio().equals(ad.getIdAnuncio())){
                    rowContainsSelected = true;
                }
            }

            cardsContainer.add(row);
            if (rowContainsSelected) {
                cardsContainer.add(buildExpandedDetail(anuncioSeleccionado));
            }

        }
    }

    private Component buildExpandedDetail(AnuncioDto anuncioSeleccionado) {
        VerticalLayout detail = new VerticalLayout();
        detail.setWidthFull();

        detail.getStyle()
                .set("background-color", "#ffffff")
                .set("border", "2px solid #2563eb")
                .set("border-radius", "12px")
                .set("padding", "25px")
                .set("box-shadow", "0 6px 16px rgba(37,99,235,0.15)");

        H2 title = new H2(anuncioSeleccionado.getTitulo());
        title.getStyle()
                .set("color", "#1e3a5f")
                .set("font-weight", "700");

        Span price = new Span(anuncioSeleccionado.getPrecioValor() + " €");

        Paragraph description = new Paragraph(anuncioSeleccionado.getDescripcion());

        detail.add(title,price,description);

        if(anuncioSeleccionado instanceof AnuncioMotoDto motor){
            // Mostrar información de tipo motor
            FormLayout form = new FormLayout();

            form.addFormItem(new Span(motor.getMarca()),"Marca");

            form.addFormItem(new Span(motor.getModelo()),"Modelo");

            form.addFormItem(new Span(String.valueOf(motor.getKilometros())),"Kilómetros");

            form.addFormItem(
                    new Span(Boolean.TRUE.equals(motor.getEsParaA2()) ? "Sí" : "No"), "Apta para A2");

            detail.add(new H4("Información de la moto"), form);
        }

        if(anuncioSeleccionado instanceof AnuncioInmobiliarioDto inmobiliario){
            // Mostrar información de tipo inmobiliario
            FormLayout form = new FormLayout();

            form.addFormItem(new Span(inmobiliario.getTipoPropiedad()),"Tipo");

            form.addFormItem(new Span(String.valueOf(inmobiliario.getMetrosCuadrados())),"m²");

            form.addFormItem(new Span(inmobiliario.getEstado()),"Estado");

            detail.add(new H4("Información del inmueble"),form);
        }

        detail.add(title,price,description);

        Button detailButton = new Button("Ver detalle completo");
        detailButton.setEnabled(false);


        detail.add(detailButton);

        return detail;
    }
}
