package com.techlead.service.core1;

import com.techlead.service.core1.helper.Item;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class Level5Service {

    // 5.1 reverses: Cho đầu vào là 1 mảng, Viết một function để đảo ngược thứ tự phần tử trong mảng
    public String[] reverseArray(String[] arr){
        int length = arr.length -1;
        for(int i = 0; i < arr.length / 2;i++){
            String tmp = arr[i];
            arr[i] = arr[length];
            arr[length] = tmp;
            length--;
        }

        return arr;
    }

    // 5.2
    public String[][] chunk(String[] arr, int size) {

        // handle special case
        if (arr == null || arr.length == 0 || size <= 0) {
            return new String[0][];
        }

        int numChunk = (int) Math.ceil((double) arr.length / 2);
        String[][] result = new String[numChunk][];


        for (int index = 0; index < numChunk; index++) {
            int start = index * size;
            int chunkLength = Math.min(size, arr.length - start);
            // Tạo mảng con
            result[index] = Arrays.copyOfRange(arr, start, start + chunkLength);
        }

        return result;
    }

    // 5.3
    public int[] removeDups(int[] arr, int n) {

        HashMap<Integer, Boolean> mp = new HashMap<>();
        // Tạo ArrayList để lưu các phần tử duy nhất
        ArrayList<Integer> uniqueElements = new ArrayList<>();

        // Duyệt qua mảng
        for (int i = 0; i < n; i++) {
            if (mp.get(arr[i]) == null) {
                // Nếu phần tử chưa xuất hiện, thêm vào ArrayList
                uniqueElements.add(arr[i]);
            }
            // Thêm phần tử vào HashMap
            mp.put(arr[i], true);
        }

        // Chuyển ArrayList thành mảng int[]
        int[] result = new int[uniqueElements.size()];
        for (int i = 0; i < uniqueElements.size(); i++) {
            result[i] = uniqueElements.get(i);
        }

        return result;
    }

    // 5.4
    public List<Map<String, Integer>> uniqueArrayObject(List<Map<String, Integer>> arr) {
        if (arr == null || arr.isEmpty()) {
            return new ArrayList<>();
        }

        Set<String> seen = new HashSet<>();
        List<Map<String, Integer>> result = new ArrayList<>();
        for (Map<String, Integer> map : arr) {
            String normalized = map.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .map(entry -> entry.getKey() + ":" + entry.getValue())
                    .collect(Collectors.joining(","));
            if (seen.add(normalized)) {
                result.add(map);
            }
        }
        return result;
    }

    // 5.5
    public Map<Object, List<Map<String, Object>>> groupBy(List<Map<String, Object>> collection, String field) {
        // Kiểm tra đầu vào
        if (collection == null || field == null || field.isEmpty()) {
            throw new IllegalArgumentException("Collection không được null và field không được null hoặc rỗng");
        }

        // Tạo map kết quả
        Map<Object, List<Map<String, Object>>> result = new HashMap<>();

        // Duyệt qua từng đối tượng trong collection
        for (Map<String, Object> item : collection) {
            // Lấy giá trị của trường cần nhóm
            Object key = item.get(field);

            // Nếu key chưa tồn tại trong result, tạo một danh sách mới
            if (!result.containsKey(key)) {
                result.put(key, new ArrayList<>());
            }

            // Thêm đối tượng hiện tại vào danh sách tương ứng với key
            result.get(key).add(item);
        }

        return result;
    }

    // 5.6
    public String trimSpace(String s1) {
        String[] arrStr1 = s1.trim().split("\\s+");
        String newStr = "";
        for(int i = 0; i< arrStr1.length;i++){
            if (i == arrStr1.length -1){
                newStr+=arrStr1[i];
            }
            else {
                newStr+=arrStr1[i]+" ";
            }

        }
        return newStr;
    }

    // 5.7
    public List<Map<String, Integer>> mapKeys(String[] keys, List<Map<String, Integer>> collections) {

        return collections.stream().map(
                item -> {
                    Map<String, Integer> newMap = new LinkedHashMap<>();
                    for (String key : keys) {
                        if (item.containsKey(key)) {
                            newMap.put(key, item.get(key));
                        }
                    }
                    return newMap;
                }
        ).collect(Collectors.toList());

    }

    // 5.8
    public List<Item> switchOrder(List<Item> arr, int id, int newOrder) {
        // Tìm đối tượng có id và oldOrder
        Item target = null;
        int oldOrder = -1;
        for (Item item : arr) {
            if (item.getId() == id) {
                target = item;
                oldOrder = item.getOrder();
                break;
            }
        }

        // Kiểm tra hợp lệ
        if (target == null || newOrder < 0 || newOrder >= arr.size() || oldOrder == newOrder) {
            return null; // Không làm gì nếu id không tồn tại, newOrder không hợp lệ, hoặc không cần thay đổi
        }

        // Điều chỉnh order của các đối tượng bị ảnh hưởng
        if (newOrder < oldOrder) {
            // Di chuyển lên: tăng order của các đối tượng trong khoảng [newOrder, oldOrder-1]
            for (Item item : arr) {
                if (item.getOrder() >= newOrder && item.getOrder() < oldOrder) {
                    item.setOrder(item.getOrder() + 1);
                }
            }
        } else {
            // Di chuyển xuống: giảm order của các đối tượng trong khoảng [oldOrder+1, newOrder]
            for (Item item : arr) {
                if (item.getOrder() > oldOrder && item.getOrder() <= newOrder) {
                    item.setOrder(item.getOrder() - 1);
                }
            }
        }

        // Cập nhật order của đối tượng mục tiêu
        target.setOrder(newOrder);
        return arr;
    }

    // 5.9
    public Map<String, Integer> sumAll(List<Map<String, Object>> arr) {
        Map<String, Integer> result = new HashMap<>();

        for(Map<String, Object> item: arr){
            // iterate each value in the object?
            for(Map.Entry<String, Object>entry : item.entrySet()){
                String key = entry.getKey();
                Object value = entry.getValue();

                // transform to int
                int intValue;
                if(value instanceof Integer){
                    intValue = (Integer) value;
                }else {
                    continue;
                }

                // add to result
                result.put(key, result.getOrDefault(key, 0) + intValue);
            }
        }
        return result;
    }


    // java core
    private static List<Map<String, Integer>> uniqueArrayObj(List<Map<String, Integer>> arr) {
        if (arr == null || arr.size() == 0) {
            return new ArrayList<>();
        }
        HashSet<String> seen = new HashSet<>();
        List<Map<String, Integer>> result = new ArrayList<>();

//      Duyệt qua từng Map
        for (int i = 0; i < arr.size(); i++) {
            Map<String, Integer> map = arr.get(i);

            // Chuẩn hóa Map: sắp xếp key và tạo chuỗi key:value
            TreeSet<String> sortedKeys = new TreeSet<>(map.keySet());
            StringBuilder normalized = new StringBuilder();
            boolean first = true;
            for (String key : sortedKeys) {
                if (!first) {
                    normalized.append(",");
                }
                normalized.append(key).append(":").append(map.get(key));
                first = false;
            }

            String normalizedStr = normalized.toString();
            if (!seen.contains(normalizedStr)) {
                seen.add(normalizedStr);
                result.add(map);
            }
        }

        return result;
    }
}
