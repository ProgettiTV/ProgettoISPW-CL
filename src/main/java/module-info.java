module com.example.pcb {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.pcb to javafx.fxml;
    exports com.example.pcb;
    exports com.example.pcb.bean_class;
    opens com.example.pcb.bean_class to javafx.fxml;
    exports com.example.pcb.dao_class;
    opens com.example.pcb.dao_class to javafx.fxml;
    exports com.example.pcb.gui_class;
    opens com.example.pcb.gui_class to javafx.fxml;
    exports com.example.pcb.design_pattern_decorator;
    opens com.example.pcb.design_pattern_decorator to javafx.fxml;
    exports com.example.pcb.design_pattern_decorator.dao_class_concrete_decorator;
    opens com.example.pcb.design_pattern_decorator.dao_class_concrete_decorator to javafx.fxml;
}