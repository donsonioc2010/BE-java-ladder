package com.ladder;

import com.ladder.entity.LadderInput;
import com.ladder.entity.LadderOutput;
import com.ladder.entity.Person;
import java.util.List;
import java.util.Scanner;

public class Week1 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            LadderInput ladderInput = LadderInput.of(scanner);
//            List<Person> persons = ladderInput.newPersonList();
//            LadderOutput output = LadderOutput.of(ladderInput, persons);

//            System.out.println(output.toStringLadder());
        }

    }

}
