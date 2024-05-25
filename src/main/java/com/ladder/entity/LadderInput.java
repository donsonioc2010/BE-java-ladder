package com.ladder.entity;

import java.util.Scanner;

public class LadderInput {
    private String personNames;
    private int height;

    private LadderInput(String personNames, int height) {
        this.personNames = personNames;
        this.height = height;
    }

    public static LadderInput of(Scanner scanner) {
        String personNames = getPersonNames(scanner);
        int height = getLadderHeight(scanner);

        return new LadderInput(personNames, height);
    }

    private static String getPersonNames(Scanner scanner) {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    private static int getLadderHeight(Scanner scanner) {
        System.out.println("최대 사다리 높이는 몇개인가요?");
        return scanner.nextInt();
    }

    public String getPersonNames() {
        return personNames;
    }

    public int getHeight() {
        return height;
    }

}
