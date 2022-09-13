package me.banfan.model.api;

import lombok.Data;

import java.util.List;

@Data
public class PortType {

    private String name;
    // 如果isBase == true, field为空
    private boolean isBase;
    private List<Port> field;

    public PortType(java.lang.String name, boolean isBase) {
        this.name = name;
        this.isBase = isBase;
    }

    public static final PortType StringType = new PortType("String",true);
    public static final PortType IntType = new PortType("Int",true);
    public static final PortType ListType = new PortType("List",true);

}
