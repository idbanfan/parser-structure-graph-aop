package me.banfan.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class Node {


    @Data
    @NoArgsConstructor
    public static class KeyNode extends Node {
        private String key;
        private String text;
        private String size;
        @JsonProperty("isGroup")
        private boolean isGroup = true;
        private String loc;
        private int duration = 9;
        public KeyNode(String key, String text, int locW, int locH) {
            this.key = key;
            this.text = text;
            this.loc = locW + " " + locH;
        }
        public KeyNode(String key, String text, String loc) {
            this.key = key;
            this.text = text;
            this.loc = loc;
        }

        public String getLoc() {
            return loc;
        }

        public void setLoc( int locW, int locH) {
            this.loc = locW + " " + locH;
        }

        public String getSize() {
            return size;
        }

        public int getSizeH() {
            return Integer.parseInt(size.split(" ")[1]);
        }

        public int getSizeW() {
            return Integer.parseInt(size.split(" ")[0]);
        }

        public void setSize(int w, int h) {
            this.size = w + " " + h;
        }

        public int getLocH() {
            return Integer.parseInt(loc.split(" ")[1]);
        }

        public int getLocW() {
            return Integer.parseInt(loc.split(" ")[0]);
        }
    }

    @Data
    public static class GroupNode extends Node {
        private String group;
        private List<Integer> points;
        private int start;
        private int duration;

        public GroupNode(String group, int start, int duration) {
            this.group = group;
            this.start = start;
            this.duration = duration;
        }
    }


}


