package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class Print_std extends AppCompatActivity {
    TextView tv_ID, tv_Mid, tv_Final, tv_Report, tv_Att, tv_Sum, tv_Avg, tv_Credit, tv_Output;
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
        setContentView(R.layout.activity_print_std);
        // 출력하는 페이지

        TextView tv_ID = findViewById(R.id.tv_ID); //학번
        TextView tv_Mid = findViewById(R.id.tv_Mid); //중간고사
        TextView tv_Final = findViewById(R.id.tv_Final); //기말고사
        TextView tv_Report = findViewById(R.id.tv_Report); //리포트
        TextView tv_Att = findViewById(R.id.tv_Att); //출석
        TextView tv_Sum = findViewById(R.id.tv_Sum); //합계
        TextView tv_Avg = findViewById(R.id.tv_Avg); //평균
        TextView tv_Credit = findViewById(R.id.tv_Credit);//학점

        TextView tv_Output = findViewById(R.id.tv_Output);//전체출력

        // 인텐트로부터 파일 이름 받기
        Intent intent = getIntent();
        String grade_file = intent.getStringExtra("grade.txt");
        tv_Output.setText(grade_file);




        /** 학번 정렬 **/
        tv_ID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_Output.setText("");
                Toast.makeText(Print_std.this, "학번 정렬", Toast.LENGTH_SHORT).show();
                writeToFile(grade);

                // 파일 경로 설정
                String filePath = getFilesDir() + "/grade.txt";

                // 파일 처리 및 결과 출력
                String result = processFile(filePath,"stdId_sort");
                tv_Output.setText(result);

            }
        });
        /** 중간고사 정렬 **/
        tv_Mid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_Output.setText("");
                Toast.makeText(Print_std.this, "중간고사 정렬", Toast.LENGTH_SHORT).show();
                writeToFile(grade);

                // 파일 경로 설정
                String filePath = getFilesDir() + "/grade.txt";

                // 파일 처리 및 결과 출력
                String result = processFile(filePath,"midterm_sort");
                tv_Output.setText(result);

            }

        });
        /** 기말고사 정렬 **/
        tv_Final.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_Output.setText("");
                Toast.makeText(Print_std.this, "기말고사 정렬", Toast.LENGTH_SHORT).show();
                writeToFile(grade);

                // 파일 경로 설정
                String filePath = getFilesDir() + "/grade.txt";

                // 파일 처리 및 결과 출력
                String result = processFile(filePath,"finalExam_sort");
                tv_Output.setText(result);
            }
        });
        /** 리포트 정렬 **/
        tv_Report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_Output.setText("");
                Toast.makeText(Print_std.this, "리포트 정렬", Toast.LENGTH_SHORT).show();
                writeToFile(grade);

                // 파일 경로 설정
                String filePath = getFilesDir() + "/grade.txt";

                // 파일 처리 및 결과 출력
                String result = processFile(filePath,"report_sort");
                tv_Output.setText(result);
            }
        });
        /** 출석 정렬 **/
        tv_Att.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_Output.setText("");
                Toast.makeText(Print_std.this, "출석 정렬", Toast.LENGTH_SHORT).show();
                writeToFile(grade);

                // 파일 경로 설정
                String filePath = getFilesDir() + "/grade.txt";

                // 파일 처리 및 결과 출력
                String result = processFile(filePath,"attendance_sort");
                tv_Output.setText(result);
            }
        });
        /** 총합 정렬 **/
        tv_Sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_Output.setText("");
                Toast.makeText(Print_std.this, "총점 정렬", Toast.LENGTH_SHORT).show();
                writeToFile(grade);

                // 파일 경로 설정
                String filePath = getFilesDir() + "/grade.txt";

                // 파일 처리 및 결과 출력
                String result = processFile(filePath,"sum_sort");
                tv_Output.setText(result);
            }
        });
        /** 평균 정렬 **/
        tv_Avg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_Output.setText("");
                Toast.makeText(Print_std.this, "평균 정렬", Toast.LENGTH_SHORT).show();
                writeToFile(grade);

                // 파일 경로 설정
                String filePath = getFilesDir() + "/grade.txt";

                // 파일 처리 및 결과 출력
                String result = processFile(filePath,"avg_sort");
                tv_Output.setText(result);
            }
        });
        /** 학점 정렬 **/
        tv_Credit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_Output.setText("");
                Toast.makeText(Print_std.this, "학점 정렬", Toast.LENGTH_SHORT).show();
                writeToFile(grade);

                // 파일 경로 설정
                String filePath = getFilesDir() + "/grade.txt";

                // 파일 처리 및 결과 출력
                String result = processFile(filePath,"Credit_sort");
                tv_Output.setText(result);
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


    public String processFile(String filePath,String sort_code) {
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
            return "File not found!";
        }


        double totalAverageSum = 0.0;
        int rowCount = 0;

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

        double all_avg = totalAverageSum / rowCount; //전체 평균

        // 정렬 기준에 따라 정렬
        switch (sort_code) {
            case "Credit_sort":
                Credit_sort(data);
                break;
            case "midterm_sort":
                midterm_sort(data);
                break;
            case "finalExam_sort":
                finalExam_sort(data);
                break;
            case "report_sort":
                report_sort(data);
                break;
            case "attendance_sort":
                attendance_sort(data);
                break;
            case "sum_sort":
                sum_sort(data);
                break;
            case "avg_sort":
                avg_sort(data);
                break;
            case "stdId_sort":
                stdId_sort(data);
                break;
        }


        for (ArrayList<Object> row : data) {
            double std_avg = (double) row.get(row.size() - 1);  // 학생평균

            String grade;
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

            // 각 행의 값을 고정된 폭으로 출력
            result.append(String.format("%-10d %-10d %-10d %-10d %-10d %-10d %-10.2f %s\n",
                    row.get(0), row.get(1), row.get(2), row.get(3), row.get(4), row.get(5), row.get(6), grade));
        }

        return result.toString().trim(); // 최종 결과 문자열 반환
    }

    private void stdId_sort( ArrayList<ArrayList<Object>> data ){
        // 학번 기준으로 정렬
        Collections.sort(data, new Comparator<ArrayList<Object>>() {
            @Override
            public int compare(ArrayList<Object> row1, ArrayList<Object> row2) {
                return Integer.compare((int) row1.get(0), (int) row2.get(0)); // 학번 비교
            }
        });
    }
    private void midterm_sort( ArrayList<ArrayList<Object>> data ){
        // 중간고사 점수를 기준으로 정렬
        Collections.sort(data, new Comparator<ArrayList<Object>>() {
            @Override
            public int compare(ArrayList<Object> row1, ArrayList<Object> row2) {
                return Integer.compare((int) row2.get(1), (int) row1.get(1)); // 중간고사 점수 비교
            }
        });
    }

    private void finalExam_sort( ArrayList<ArrayList<Object>> data ){
        // 기말 점수를 기준으로 정렬
        Collections.sort(data, new Comparator<ArrayList<Object>>() {
            @Override
            public int compare(ArrayList<Object> row1, ArrayList<Object> row2) {
                return Integer.compare((int) row2.get(2), (int) row1.get(2)); // 기말고사 점수 비교
            }
        });
    }
    private void report_sort( ArrayList<ArrayList<Object>> data ){
        // 리포트 점수를 기준으로 정렬
        Collections.sort(data, new Comparator<ArrayList<Object>>() {
            @Override
            public int compare(ArrayList<Object> row1, ArrayList<Object> row2) {
                return Integer.compare((int) row2.get(3), (int) row1.get(3)); // 리포트 점수 비교
            }
        });
    }

    private void attendance_sort( ArrayList<ArrayList<Object>> data ){
        // 출석 점수를 기준으로 정렬
        Collections.sort(data, new Comparator<ArrayList<Object>>() {
            @Override
            public int compare(ArrayList<Object> row1, ArrayList<Object> row2) {
                return Integer.compare((int) row2.get(4), (int) row1.get(4)); // 출석 점수 비교
            }
        });
    }
    private void sum_sort( ArrayList<ArrayList<Object>> data ){
        // 총점 기준으로 정렬 (올림차순)
        Collections.sort(data, new Comparator<ArrayList<Object>>() {
            @Override
            public int compare(ArrayList<Object> row1, ArrayList<Object> row2) {
                return Integer.compare((int) row1.get(5), (int) row2.get(5)); // 총점 점수 비교
            }
        });
    }
    private void avg_sort(ArrayList<ArrayList<Object>> data) {
        // 평균 점수 기준으로 정렬 (올림차순)
        Collections.sort(data, new Comparator<ArrayList<Object>>() {
            @Override
            public int compare(ArrayList<Object> row1, ArrayList<Object> row2) {
                return Double.compare((double) row1.get(6), (double) row2.get(6)); // 평균 점수 비교
            }
        });
    }

    private void Credit_sort(ArrayList<ArrayList<Object>> data) {
        // 학점 기준으로 정렬
        Collections.sort(data, new Comparator<ArrayList<Object>>() {
            @Override
            public int compare(ArrayList<Object> row1, ArrayList<Object> row2) {
                return Double.compare((double) row2.get(6), (double) row1.get(6)); // 평균 점수 비교
            }
        });
    }

}






