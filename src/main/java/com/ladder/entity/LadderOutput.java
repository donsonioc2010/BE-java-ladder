package com.ladder.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class LadderOutput {
    private static final Random random = new Random();
    private static final String PREFIX_NEED_LADDER = "|-";
    private static final String PREFIX_NO_NEED_LADDER = "| ";
    private static final String PREFIX_LAST_LADDER = "|\n";

    private LadderInput ladderInput;
    private List<Person> persons = new ArrayList<>();

    private LadderOutput(LadderInput ladderInput, List<Person> persons) {
        this.ladderInput = ladderInput;
        this.persons = persons;
    }

    public static LadderOutput of(LadderInput ladderInput, List<Person> persons) {
        return new LadderOutput(ladderInput, persons);
    }

    public String toStringLadder() {
        StringBuilder stringBuilder = new StringBuilder();

        int height = ladderInput.getHeight();

        IntStream.range(0, height)
            .forEach( index ->
                persons.forEach( person -> stringBuilder.append(addStairs(person)))
            );
        return stringBuilder.toString();
    }

    private String addStairs(Person person) {
        if (person.isLast()) {
            return PREFIX_LAST_LADDER;
        }

        // 0인 경우만 사다리를 만들자.. 1,2은 사다리를 만들지 않는다
        boolean isCreateSadari = random.nextInt(3) == 0;

        if (isCreateSadari) {
            return PREFIX_NEED_LADDER;
        }
        return PREFIX_NO_NEED_LADDER;
    }

}
