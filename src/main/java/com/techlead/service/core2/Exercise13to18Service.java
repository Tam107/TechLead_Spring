package com.techlead.service.core2;

import java.util.Set;

public interface Exercise13to18Service {
    public interface Exercise13To18Service {
        /** Bài tập 13: Hãy viết một chương trình Java để nhập một mảng các số nguyên từ người dùng và
         tạo một HashSet để lưu trữ các phần tử của mảng. Sau đó, hãy hiển thị các phần tử trùng lặp trong mảng.*/
        Set<Integer> removeDuplicate(int[] arr);

        /** Bài tập 14:Hãy tạo một chương trình Java để nhập hai tập hợp (HashSet) các số nguyên từ người dùng.
         Hãy tìm và hiển thị các phần tử chung (giao) của hai tập hợp.*/
        Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2);

        /** Bài tập 15: Hãy tạo một chương trình Java để nhập hai tập hợp (HashSet) các số nguyên từ người dùng.
         Hãy tìm và hiển thị tất cả các phần tử thuộc cả hai tập hợp (hợp) của hai tập hợp này.*/
        Set<Integer> union(Set<Integer> set1, Set<Integer> set2);

        /** Bài tập 16: Hãy viết một chương trình Java để nhập một tập hợp (HashSet) các số nguyên từ người dùng
         và tìm phần tử lớn nhất và nhỏ nhất trong tập hợp.*/
        int[] findMaxAndMin(Set<Integer> set);

        /** Bài tập 17: Hãy viết một chương trình Java để nhập một tập hợp (HashSet) các chuỗi từ người dùng và
         xóa tất cả các phần tử trùng lặp, chỉ giữ lại một phần tử duy nhất cho mỗi giá trị.*/
        Set<String> removeDuplicate(Set<String> set);

        /** Bài tập 18: Hãy viết một chương trình Java để nhập một tập hợp (HashSet) các chuỗi từ người dùng và
         đếm số lượng phần tử trong tập hợp.*/
        int countWords(Set<String> set);
    }
}
