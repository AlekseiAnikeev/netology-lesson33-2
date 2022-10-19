package ru.agentche.logger;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aleksey Anikeev aka AgentChe
 * Date of creation: 18.10.2022
 */
public class Filter {
    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        for (int value : source) {
            if (value >= treshold) {
                result.add(value);
                logger.log("Элемент " + value + " проходит");
            } else {
                logger.log("Элемент " + value + " не проходит");
            }
        }
        return result;
    }
}
