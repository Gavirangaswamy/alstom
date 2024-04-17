package com.alstom.alstomsecondservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AlstomSecondService {

    public List<Integer> listTransformation(List<Integer> input) {
        List<Integer> output = new ArrayList<>(input);

        if (output.size() > 6) {
            Integer elementAtIndexSix = output.remove(6);

            output.add(2, elementAtIndexSix);
        } else {
            log.info("No change, list is too short: {}", output);
        }

        log.info("Transformed List : {}", output);

        return output;
    }

}
