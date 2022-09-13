package me.banfan.model.api;

import me.banfan.model.Node;

public class Port extends Node.KeyNode {

    private Api api;
    private String name;
    private PortType type;
    private PortLink portLink;
    private boolean isInput;


    public Port(Api api, String name, PortType type, PortLink portLink, boolean isInput) {
        super();

        if (isInput) {
            int inputCount = api.getInput().size();
            setSize(40, 40);
            setLoc(
                    api.getLocW() / 2 + getSizeW() / 2,
                    api.getLocH() - api.getSizeH() / 2 + getSizeH() / 2 + getSizeH() * inputCount);
        } else {
            int outputCount = api.getOutput().size();
            setSize(40, 40);
            setLoc(
                    api.getLocW() / 2 - getSizeW() / 2,
                    api.getLocH() - api.getSizeH() / 2 + getSizeH() / 2 + getSizeH() * outputCount);
        }

        this.api = api;
        this.name = name;
        this.type = type;
        this.portLink = portLink;
        this.isInput = isInput;
    }

    public void toApi() {

    }

    public void addLink() {

    }
}
