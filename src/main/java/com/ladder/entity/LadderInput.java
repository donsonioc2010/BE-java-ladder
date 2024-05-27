package com.ladder.entity;

import java.util.InputMismatchException;
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

        int heightInput;
        try {
            heightInput = scanner.nextInt();

            if (heightInput > 0) {
                return heightInput;
            }
            throw new IllegalArgumentException("0보다 큰 숫자를 입력해야 합니다.");
        } catch (InputMismatchException e) {
            // nextInt에서 NumberFormatException이 터지긴하는데,
            // 메세지만 담아서 InputMismatchException로 변환하기 때문에 잡으로면 Mismatch를 사용해야함
            throw new IllegalArgumentException("숫자를 입력하셔야죠 고객님...");
        }
    }

    public String getPersonNames() {
        return personNames;
    }

    public int getHeight() {
        return height;
    }

}
