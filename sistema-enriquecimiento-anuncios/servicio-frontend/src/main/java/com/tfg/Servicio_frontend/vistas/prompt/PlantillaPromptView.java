package com.tfg.Servicio_frontend.vistas.prompt;

import com.tfg.Servicio_frontend.dto.PromptDto;
import com.tfg.Servicio_frontend.layout.MainLayout;
import com.tfg.Servicio_frontend.servicio.PromptServicio;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.List;
import java.util.UUID;

import static com.vaadin.frontendtools.internal.commons.lang3.BooleanUtils.forEach;

@Route(
        value = "prompts",
        layout = MainLayout.class
)
@PageTitle("Gestión de Prompts")
public class PlantillaPromptView extends HorizontalLayout {
    private final PromptServicio promptServicio;
    private PromptDto selectedPrompt;
    private boolean creatingNewPrompt = false;
    private final H3 editorTitle = new H3("Editor de Prompt");

    // buildSearchPanel atributos
    private final VerticalLayout searchPanel = new VerticalLayout();
    private final ComboBox<String> sourceFilter = new ComboBox<>("Fuente");
    private final ComboBox<String> categoryFilter = new ComboBox<>("Categoría");
    private final Checkbox activeFilter = new Checkbox("Activo");
    private final TextField titleFilter = new TextField("Buscar");
    private final VerticalLayout promptList = new VerticalLayout();
    private final Button newPromptButton = new Button("Nuevo Prompt");

    // buildDetailPanel atributos
    private final VerticalLayout detailPanel = new VerticalLayout();
    private final TextField titleField = new TextField("Título");
    private final TextField versionField = new TextField("Versión");
    private final Checkbox activeField = new Checkbox("Activo");
    private final TextArea contentField = new TextArea("Contenido");
    private final Button saveButton = new Button("Guardar versión");

    public PlantillaPromptView(PromptServicio servicio) {
        this.promptServicio = servicio;

        setSizeFull();
        setPadding(true);
        setSpacing(true);

        add(
                buildSearchPanel(),
                buildDetailPanel()
        );

        loadPromptList();

        titleField.clear();
        versionField.clear();
        activeField.clear();
        contentField.clear();

        sourceFilter.addValueChangeListener(e -> loadPromptList());
        categoryFilter.addValueChangeListener(e -> loadPromptList());
        activeFilter.addValueChangeListener(e -> loadPromptList());
        titleFilter.addValueChangeListener(e -> loadPromptList());
    }

    private Component buildSearchPanel() {
        searchPanel.setWidth("320px");
        searchPanel.setHeightFull();
        searchPanel.setPadding(true);
        searchPanel.setSpacing(true);


        searchPanel.getStyle()
                .set("background-color", "white")
                .set("border", "1px solid #e5e7eb")
                .set("border-radius", "12px")
                .set("padding", "20px")
                .set("box-shadow", "0 4px 12px rgba(0,0,0,0.08)");

        H3 title = new H3("Búsqueda de Prompts");
        title.getStyle()
                .set("color", "#1e3a5f")
                .set("margin-top", "0");

        sourceFilter.setItems("Wallapop");
        sourceFilter.setWidthFull();
        sourceFilter.setValue("Wallapop");

        categoryFilter.setItems(
                "Motor",
                "Inmobiliario"
        );
        categoryFilter.setWidthFull();

        activeFilter.setValue(true);

        titleFilter.setWidthFull();
        titleFilter.setPlaceholder("Buscar por título...");

        promptList.setWidthFull();
        promptList.getStyle()
                .set("border", "1px solid #e5e7eb")
                .set("border-radius", "10px")
                .set("padding", "10px")
                .set("background-color", "#f8fafc");
        promptList.setHeight("400px");
        promptList.getStyle()
                .set("overflow-y", "auto");

        newPromptButton.setWidthFull();
        newPromptButton.getStyle()
                .set("background-color", "#1e3a5f")
                .set("color", "white")
                .set("font-weight", "600");
        newPromptButton.addClickListener(
                e -> clearPromptForm()
        );

        searchPanel.add(
                title,
                sourceFilter,
                categoryFilter,
                activeFilter,
                titleFilter,
                promptList,
                newPromptButton
        );

        return searchPanel;
    }

    private void loadPromptList(){
        promptList.removeAll();

        List<PromptDto> prompts = promptServicio.buscarTodo();
        if (categoryFilter.getValue()!= null) {
            prompts = prompts.stream()
                            .filter(p -> p.getCategoria().equals(categoryFilter.getValue()))
                            .toList();
        }

        if (activeFilter.getValue()) {
            prompts = prompts.stream()
                            .filter(PromptDto::getActivo)
                            .toList();
        }

        if (!titleFilter.isEmpty()) {
            String search = titleFilter.getValue()
                            .toLowerCase();
            prompts = prompts.stream()
                            .filter(p -> p.getTitulo().toLowerCase().contains(search))
                            .toList();
        }

        for (PromptDto prompt : prompts){
            VerticalLayout card = new VerticalLayout();

            Span title = new Span(prompt.getTitulo());
            title.getStyle()
                    .set("font-weight", "600")
                    .set("color", "#1e3a5f");

            Span statusIndicator = new Span("●");

            if (Boolean.TRUE.equals(prompt.getActivo())) {
                statusIndicator.getStyle()
                        .set("color", "#22c55e");
            } else {
                statusIndicator.getStyle()
                        .set("color", "#9ca3af");
            }

            HorizontalLayout cardHeader = new HorizontalLayout(statusIndicator, title);
            cardHeader.setAlignItems(Alignment.CENTER);

            Span version = new Span(prompt.getVersion());
            version.getStyle()
                    .set("font-size","0.85em")
                    .set("color","#6b7280");

            card.setPadding(false);
            card.setSpacing(false);
            card.setWidthFull();

            card.getStyle()
                    .set("padding", "10px")
                    .set("cursor", "pointer")
                    .set("border", "1px solid #e5e7eb")
                    .set("border-radius", "8px")
                    .set("background-color", "white");

            card.add(cardHeader, version);

            card.addClickListener(e -> {
                        selectedPrompt = prompt;
                        showPrompt(prompt);
                    }
            );
            promptList.add(card);
        }
    }

    private Component buildDetailPanel() {
        detailPanel.setSizeFull();
        detailPanel.setPadding(true);
        detailPanel.setSpacing(true);

        detailPanel.getStyle()
                .set("background-color", "white")
                .set("border", "1px solid #e5e7eb")
                .set("border-radius", "12px")
                .set("padding", "20px")
                .set("box-shadow", "0 4px 12px rgba(0,0,0,0.08)");

        HorizontalLayout header = new HorizontalLayout();
        header.setWidthFull();
        header.setAlignItems(Alignment.END);

        titleField.setWidth("400px");
        titleField.setPlaceholder("Título del prompt");

        versionField.setWidth("150px");
        versionField.setPlaceholder("v1.0");

        activeField.setLabel("Activo");

        header.add(
                titleField,
                versionField,
                activeField
        );

        editorTitle.getStyle()
                .set("color", "#1e3a5f")
                .set("margin-bottom", "0");

        contentField.setWidthFull();
        contentField.setHeight("500px");
        contentField.setPlaceholder(
                "Contenido del prompt..."
        );
        contentField.getStyle()
                .set("font-family", "monospace");

        saveButton.getStyle()
                .set("background-color", "#1e3a5f")
                .set("color","white")
                .set("font-weight", "600");
        saveButton.addClickListener(
                e -> savePrompt()
        );

        HorizontalLayout buttonBar = new HorizontalLayout();
        buttonBar.setWidthFull();
        buttonBar.setJustifyContentMode(JustifyContentMode.END);
        buttonBar.add(saveButton);

        detailPanel.add(
                editorTitle,
                header,
                contentField,
                buttonBar
        );

        return detailPanel;
    }

    private void savePrompt() {
        PromptDto prompt = new PromptDto();

        prompt.setId(UUID.randomUUID());
        prompt.setFuente(sourceFilter.getValue());
        prompt.setCategoria(categoryFilter.getValue());
        prompt.setTitulo(titleField.getValue());
        prompt.setVersion(versionField.getValue());
        prompt.setActivo(activeField.getValue());
        prompt.setContenido(contentField.getValue());

        if (prompt.getCategoria() == null && prompt.getFuente() == null){
            Notification.show("Debe seleccionar una fuente y una categoria en el panel de busqueda para poder guardar el prompt");
        }else {
            promptServicio.save(prompt);
            selectedPrompt = prompt;

            // Actualizar activo del resto de prompts de la misma categoría
            if (activeField.getValue()) {
                promptServicio.buscarTodo()
                        .stream()
                        .filter(p -> !p.getId().equals(prompt.getId())
                                &&
                                p.getActivo()
                                &&
                                p.getCategoria().equals(
                                        prompt.getCategoria()
                                ))
                        .forEach(
                                p -> p.setActivo(false)
                        );
            }

            loadPromptList();
            Notification.show("Nueva versión creada");
        }

    }

    private void showPrompt(PromptDto prompt){
        creatingNewPrompt = false;

        editorTitle.setText("Editar Prompt");
        titleField.setValue(prompt.getTitulo());
        versionField.setValue(prompt.getVersion());
        activeField.setValue(prompt.getActivo());
        contentField.setValue(prompt.getContenido());
    }

    private void clearPromptForm() {
        creatingNewPrompt = false;

        editorTitle.setText("Nuevo Prompt");
        selectedPrompt = null;
        creatingNewPrompt = true;
        titleField.clear();
        versionField.clear();
        activeField.setValue(false);
        contentField.clear();
    }
}
