import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



class Person {
    int age;
    String name;
    int idx;

    Person (int age, String name, int idx) {
        this.age = age;
        this.name = name;
        this.idx = idx;
    }

    @Override
    public String toString() {
        return age + " " + name;
    }
}

public class Problem10814 {
   
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Person> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            arr.add(new Person(Integer.parseInt(str.split(" ")[0]), str.split(" ")[1], i));
        }
        arr.sort((p1, p2) -> {
            int ageCompare = Integer.compare(p1.age, p2.age); // 나이 비교
            if (ageCompare == 0) { // 나이가 같으면
                return Integer.compare(p1.idx, p2.idx); // 빨리들어온 순
            }
            return ageCompare;
        });
        for(int i = 0; i < n; i++) {
            System.out.println(arr.get(i).toString());
        }

    }

}