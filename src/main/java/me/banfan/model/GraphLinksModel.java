package me.banfan.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GraphLinksModel {

    @JsonProperty("class")
    private String classA = "GraphLinksModel";
    private List<Node> nodeDataArray = new ArrayList<>();
    private List<Link> linkDataArray = new ArrayList<>();

    public void addLink(String from, String to, String text, int time) {
        linkDataArray.add(new Link(from, to, text, time));
    }

    public void addKeyNode(String key,
                           String text,
                           String loc) {

        for (int i = 0; i < nodeDataArray.size(); i++) {
            Node node = nodeDataArray.get(nodeDataArray.size()-1-i);
            if (node instanceof Node.KeyNode){
                Node.KeyNode keyNode = (Node.KeyNode) node;
                if (keyNode.getKey().equals(key)) {
                    return;
                }
            }
        }

        nodeDataArray.add(new Node.KeyNode(key, text, getKeyNodeSize()+"00 0"));
    }

    public void addGroupNode(String group,
                             int start,
                             int duration) {
        nodeDataArray.add(new Node.GroupNode(group, start, duration));
    }

    public void setGroupNode(String group,
                             int time) {

        for (int i = 0; i < nodeDataArray.size(); i++) {
            Node node = nodeDataArray.get(nodeDataArray.size()-1-i);
            if (node instanceof Node.GroupNode){
                Node.GroupNode groupNode = (Node.GroupNode) node;
                if (groupNode.getGroup().equals(group)) {
                    groupNode.setDuration(time - groupNode.getStart());
                    return;
                }
            }
        }

    }

    public int getKeyNodeSize() {
        int count = 0;
        for (int i = 0; i < nodeDataArray.size(); i++) {
            Node node = nodeDataArray.get(nodeDataArray.size()-1-i);
            if (node instanceof Node.KeyNode){
                count++;
            }
        }
        return count;
    }

}