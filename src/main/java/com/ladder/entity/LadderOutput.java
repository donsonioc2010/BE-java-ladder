package com.ladder.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class LadderOutput {
    private static final Random random = new Random();

    private LadderInput ladderInput;
    private List<Person> persons = new ArrayList<>();

    private LadderOutput(LadderInput ladderInput, List<Person> persons) {
        this.ladderInput = ladderInput;
        this.persons = persons;
    }

    public static LadderOutput of(LadderInput ladderInput, List<Person> persons) {
        return new LadderOutput(ladderInput, persons);
    }

//    public String toStringLadder() {
//        StringBuilder stringBuilder = new StringBuilder();
//
//        int height = ladderInput.getHeight();
//
//        IntStream.range(0, height)
//            .forEach( index ->
//                persons.forEach(persons -> stringBuilder.append(addStairs(persons)))
//            );
//        return stringBuilder.toString();
//    }
//
//    private String addStairs(Person persons) {
//        if (persons.isLast()) {
//            return PREFIX_LAST_LADDER;
//        }
//
//        // 0인 경우만 사다리를 만들자.. 1,2은 사다리를 만들지 않는다
//        boolean isCreateSadari = random.nextInt(3) == 0;
//
//        if (isCreateSadari) {
//            return PREFIX_NEED_LADDER;
//        }
//        return PREFIX_NO_NEED_LADDER;
//    }

}
