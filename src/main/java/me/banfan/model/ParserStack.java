package me.banfan.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Stack;


/**
 * 入栈 : 记录 link , 记录 keyNode , 初始化 group:name/start
 * 出栈 : 记录 link , 设置 group:duration
 * <p>
 * <p>
 * 线程 map {
 * time,
 * stack,
 * root,
 * }
 */
public class ParserStack extends Stack<String> {

    private static final ParserStack value = new ParserStack();
    private static final ObjectMapper mapper = new ObjectMapper();
    private int time = 0;
    private GoGraphLinksModel graphLinksModel = new GoGraphLinksModel();

    public String push(String item) {
        String from = "NULL";
        time++;
        if (size()!= 0) {
            from = peek();
        }
        String to = item;
        graphLinksModel.addLink(from, to, "", time);
        graphLinksModel.addKeyNode(item, item, time + "00 0");
        graphLinksModel.addGroupNode(item, time, 1);
        return super.push(item);
    }


    public String pop() {
        time++;
        String from = super.pop();
        String to = "NULL";
        if (size()!=0) {
            to = super.peek();
        }else {
            String s = null;
            try {
                s = mapper.writeValueAsString(graphLinksModel);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            System.out.println();
            System.out.println();
            System.out.println(s);
        }
        graphLinksModel.addLink(from, to, "", time);
        graphLinksModel.setGroupNode(to, time+1);

        return from;
    }

    public static ParserStack get(){
        return value;
    }
}
