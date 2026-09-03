package cw;

import java.util.*;

class privacies {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        // 1. today 파싱
        String[] todayArray = today.split("\\.");
        int todayDate = (Integer.parseInt(todayArray[0]) - 2000) * 336 
            + Integer.parseInt(todayArray[1]) * 28 
            + Integer.parseInt(todayArray[2]);
        
        // 2. terms 파싱
        HashMap<String, Integer> termsMap = new HashMap<>();
        for (String t : terms) {
            String[] termArray = t.split(" ");
            termsMap.put(termArray[0], Integer.parseInt(termArray[1]));
        }
        
        // 3. privacies 파싱
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] privacyArray = privacies[i].split(" ");
            String[] startDateArray = privacyArray[0].split("\\.");
            
            int startDate = (Integer.parseInt(startDateArray[0]) - 2000) * 336 
            + Integer.parseInt(startDateArray[1]) * 28 
            + Integer.parseInt(startDateArray[2]);
            String term = privacyArray[1];
            int termDate = termsMap.get(term) * 28;
            
            if (todayDate - startDate >= termDate) {
                list.add(i+1);
            }
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}