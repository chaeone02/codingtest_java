package cw;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int[] solution(int[] fees, String[] records) {

        // 1. fees 파싱하여 저장
        int baseTime = fees[0];
        int baseFee = fees[1];
        int extraTime = fees[2];
        int extraFee = fees[3];

        // 2. records 파싱하여 저장
        Map<Integer, Integer> inTimeMap = new HashMap<>();
        Map<Integer, Integer> parkingMap = new TreeMap<>();

        for (String record : records) {
            String[] arr = record.split(" ");
            String[] carTime = arr[0].split(":");
            int parkingWhen = Integer.parseInt(carTime[0]) * 60 + Integer.parseInt(carTime[1]);
            int carNum = Integer.parseInt(arr[1]);
            String sign = arr[2];

            // 2-1. IN이면 저장, OUT이면 주차시간 계산
            int parkingTime = 0;
            if (sign.equals("IN")) {
                inTimeMap.put(carNum, parkingWhen);
            } else if (sign.equals("OUT")) {
                int temp = inTimeMap.get(carNum);
                parkingTime = parkingWhen - temp;
                inTimeMap.remove(carNum);
                
                // 3. 차량번호 : 총 주차시간
                parkingMap.put(carNum, parkingMap.getOrDefault(carNum, 0) + parkingTime);
            }
        }

        // 3-1. 출차하지 않고 남아있는 차량 처리
        for (int key : inTimeMap.keySet()) {
            int temp = inTimeMap.get(key);
            parkingMap.put(key, parkingMap.getOrDefault(key, 0) + 1439 - temp);
        }

        // 4. 요금 계산
        for (int key : parkingMap.keySet()) {
            int time = parkingMap.get(key);
            if (time <= baseTime) {
                parkingMap.put(key, baseFee);
            } else {
                int fee = baseFee + ((time + extraTime - 1) - baseTime) / extraTime * extraFee;
                parkingMap.put(key, fee);
            }
        }

        // 5. 출력; parkingMap이 TreeMap이므로 차량번호 기준으로 이미 정렬되어 있음
        int[] answer = new int[parkingMap.size()];
        int num = 0;
        for (int key : parkingMap.keySet()) {
            answer[num++] = parkingMap.get(key);
        }
        return answer;
    }
}