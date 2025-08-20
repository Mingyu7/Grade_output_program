package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    Button print_A, print_B, print_C, print_D, print_F, print_All;
    String grade = "2001 15 34 78 92\n" +
            "2002 25 40 35 20\n" +
            "2003 30 50 45 30\n" +
            "2004 40 20 60 40\n" +
            "2005 15 25 35 30\n" +
            "2006 45 35 20 25\n" +
            "2007 35 50 40 30\n" +
            "2008 60 70 50 40\n" +
            "2009 20 30 40 50\n" +
            "2010 25 45 35 30\n" +
            "2011 30 50 60 40\n" +
            "2012 70 20 30 40\n" +
            "2013 50 60 20 40\n" +
            "2015 15 25 35 45\n" +
            "2016 88 99 88 99\n" +
            "2017 60 40 50 30\n" +
            "2018 55 45 35 25\n" +
            "2019 99 88 99 99\n" +
            "2020 75 80 70 50";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button s_print_A = findViewById(R.id.print_A);
        Button s_print_B = findViewById(R.id.print_B);
        Button s_print_C = findViewById(R.id.print_C);
        Button s_print_D = findViewById(R.id.print_D);
        Button s_print_F = findViewById(R.id.print_F);

        Button s_print_All = findViewById(R.id.print_All);


        /** A학점 출력 **/
        s_print_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeToFile(grade);

                // 파일 경로 설정
                String filePath = getFilesDir() + "/grade.txt";

                // 파일 처리 및 결과 출력
                String result = processFile(filePath,"A");

                Intent intent = new Intent(MainActivity.this, Print_std.class);
                intent.putExtra("grade.txt", result);
                startActivity(intent);


            }
        });
        /** B학점 출력 **/
        s_print_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeToFile(grade);

                // 파일 경로 설정
                String filePath = getFilesDir() + "/grade.txt";

                // 파일 처리 및 결과 출력
                String result = processFile(filePath,"B");

                Intent intent = new Intent(MainActivity.this, Print_std.class);
                intent.putExtra("grade.txt", result);
                startActivity(intent);
            }
        });
        /** C 학점 출력 **/
        s_print_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeToFile(grade);

                // 파일 경로 설정
                String filePath = getFilesDir() + "/grade.txt";

                // 파일 처리 및 결과 출력
                String result = processFile(filePath,"C");

                Intent intent = new Intent(MainActivity.this, Print_std.class);
                intent.putExtra("grade.txt", result);
                startActivity(intent);
            }
        });
        /** D 학점 출력 **/
        s_print_D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeToFile(grade);

                // 파일 경로 설정
                String filePath = getFilesDir() + "/grade.txt";

                // 파일 처리 및 결과 출력
                String result = processFile(filePath,"D");

                Intent intent = new Intent(MainActivity.this, Print_std.class);
                intent.putExtra("grade.txt", result);
                startActivity(intent);
            }
        });
        /** F 학점 출력 **/
        s_print_F.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeToFile(grade);

                // 파일 경로 설정
                String filePath = getFilesDir() + "/grade.txt";

                // 파일 처리 및 결과 출력
                String result = processFile(filePath,"F");

                Intent intent = new Intent(MainActivity.this, Print_std.class);
                intent.putExtra("grade.txt", result);
                startActivity(intent);
            }
        });
        /** 전체 출력 **/
        s_print_All.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeToFile(grade);

                // 파일 경로 설정
                String filePath = getFilesDir() + "/grade.txt";

                // 파일 처리 및 결과 출력
                String result = processFile(filePath,"all");

                Intent intent = new Intent(MainActivity.this, Print_std.class);
                intent.putExtra("grade.txt", result);
                startActivity(intent);
            }
        });


    }

    private void writeToFile(String data) {
        try {
            FileOutputStream fos = openFileOutput("grade.txt", Context.MODE_PRIVATE);
            fos.write(data.getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String processFile(String filePath,String filer_code) {
        StringBuilder result = new StringBuilder();
        ArrayList<ArrayList<Object>> data = new ArrayList<>();

        try {
            Scanner sc = new Scanner(new File(filePath));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] numbers = line.split(" ");
                ArrayList<Object> row = new ArrayList<>();

                for (String num : numbers) {
                    row.add(Integer.parseInt(num));
                }

                data.add(row);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "파일을 찾을 수 없습니다";
        }

        double totalAverageSum = 0.0;
        int rowCount = 0;

        // 총점 및 평균 계산
        for (ArrayList<Object> row : data) {
            int sum = 0;
            for (int i = 1; i <= 4; i++) {  // 중간, 기말, 리포트, 출석
                sum += (int) row.get(i);
            }
            double average = sum / 4.0;

            row.add(sum);        // 총점 추가
            row.add(average);    // 평균 추가
            totalAverageSum += average;
            rowCount++;
        }

        double all_avg = totalAverageSum / rowCount;

        // 학점 계산 및 필터링
        for (ArrayList<Object> row : data) {
            double std_avg = (double) row.get(6);  // 평균

            String grade=null;
            // 학점 계산
            if (std_avg >= all_avg * 1.2) { // A학점
                grade = "A";
            } else if (std_avg >= all_avg && std_avg < all_avg * 1.2) { // B학점
                grade = "B";
            } else if (std_avg >= all_avg * 0.8 && std_avg < all_avg) { // C학점
                grade = "C";
            } else if (std_avg >= all_avg * 0.7 && std_avg < all_avg * 0.8) { // D학점
                grade = "D";
            } else{ // F학점
                grade = "F";
            }

            row.add(grade); // 학점 추가

            // 필터된 학점만 출력
            if (grade.equals(filer_code)) {
                result.append(String.format("%-10d %-10d %-10d %-10d %-10d %-10d %-10.2f %s\n",
                        row.get(0), row.get(1), row.get(2), row.get(3), row.get(4), row.get(5), row.get(6), grade));
            }// 전체 학점 출력
            else if (filer_code.equals("all")) {
                result.append(String.format("%-10d %-10d %-10d %-10d %-10d %-10d %-10.2f %s\n",
                        row.get(0), row.get(1), row.get(2), row.get(3), row.get(4), row.get(5), row.get(6), grade));
            }
        }

        return result.toString().trim(); // 필터된 결과 문자열 반환
    }

}


