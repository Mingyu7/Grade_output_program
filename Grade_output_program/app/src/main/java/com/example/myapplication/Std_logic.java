package com.example.myapplication;


import java.util.ArrayList;
import java.util.Scanner;
import java.io .*;



public class Std_logic {

    public String processFile(String filePath) {
        StringBuilder result = new StringBuilder(); // 결과를 저장할 StringBuilder
        ArrayList<ArrayList<Object>> data = new ArrayList<>();

        try {
            // 파일을 읽기 위한 Scanner
            Scanner sc = new Scanner(new File(filePath));

            // 파일을 한 줄씩 읽어 처리
            while (sc.hasNextLine()) {
                // 한 줄 읽기
                String line = sc.nextLine();

                // 숫자들을 공백 기준으로 분리
                String[] numbers = line.split(" ");

                // 각 행을 저장할 ArrayList<Object> (학점 포함을 위해 Object 타입 사용)
                ArrayList<Object> row = new ArrayList<>();

                // 분리된 숫자를 Integer로 변환하여 ArrayList에 추가
                for (String num : numbers) {
                    row.add(Integer.parseInt(num));
                }

                // 2차원 ArrayList에 행을 추가
                data.add(row);
            }

            // 파일 읽기 완료 후 닫기
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "File not found!";
        }

        // 각 행의 평균들의 합을 구할 변수
        double totalAverageSum = 0.0;
        int rowCount = 0;  // 행의 수를 세기 위한 변수

        // 각 행의 합과 평균 계산 및 각 행의 마지막에 추가
        for (ArrayList<Object> row : data) {
            // 첫 번째 숫자는 제외하고 2, 3, 4, 5번째 숫자만 더함
            int sum = 0;
            for (int i = 1; i <= 4; i++) {  // 두 번째 숫자부터 다섯 번째 숫자까지
                sum += (int) row.get(i);
            }
            double average = sum / 4.0;  // 4개의 숫자로 나누어 평균 계산

            // 합과 평균을 각각 해당 행의 마지막에 추가
            row.add(sum);                 // 합을 추가
            row.add(average);              // 평균을 추가 (소수점 유지)

            // 전체 평균의 합에 이 행의 평균 추가
            totalAverageSum += average;
            rowCount++;  // 행의 수 증가
        }

        // 전체 평균 계산
        double overallAverage = totalAverageSum / rowCount;

        // 학점 계산 및 각 행에 학점 추가
        for (ArrayList<Object> row : data) {
            double rowAverage = (double) row.get(row.size() - 1);  // 마지막 값이 해당 행의 평균

            // 학점 기준에 따라 학점 결정
            String grade;
            if (rowAverage >= overallAverage * 1.2) {
                grade = "A";
            } else if (rowAverage >= overallAverage) {
                grade = "B";
            } else if (rowAverage >= overallAverage * 0.8) {
                grade = "C";
            } else {
                grade = "F";
            }

            row.add(grade); // 학점 추가

            // 각 행의 값을 공백으로 구분하여 결과 문자열에 추가
            for (Object value : row) {
                result.append(value).append(" ");
            }
            result.append("\n");  // 각 행이 끝날 때 줄바꿈 추가
        }

        return result.toString().trim(); // 최종 결과 문자열 반환 (마지막 줄바꿈 제거)
    }
    }









