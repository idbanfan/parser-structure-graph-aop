package me.banfan.model.api;

import me.banfan.model.Node;

import java.util.ArrayList;
import java.util.List;

public class Api extends Node.KeyNode {

    private String name;
    private List<Port> input = new ArrayList<>();
    private List<Port> output = new ArrayList<>();

    public Api(String name) {
        super(name, name, "");
        this.name = name;
    }

    public void addInput(String portName) {
        Port port1 = new Port(this, portName, PortType.StringType, null, true);
        input.add(port1);
    }

    public void addOutput(String portName) {
        Port port1 = new Port(this, portName, PortType.StringType, null, false);
        output.add(port1);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Port> getInput() {
        return input;
    }

    public void setInput(List<Port> input) {
        this.input = input;
    }

    public List<Port> getOutput() {
        return output;
    }

    public void setOutput(List<Port> output) {
        this.output = output;
    }
}
