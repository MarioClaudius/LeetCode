package LeetCodeJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class problem0841 {
    public static void main(String[] args) {
        System.out.println(canVisitAllRooms(Arrays.asList(Arrays.asList(1,3), Arrays.asList(3,0,1), Arrays.asList(2), Arrays.asList(0))));
        System.out.println(canVisitAllRooms(Arrays.asList(Arrays.asList(1), Arrays.asList(2), Arrays.asList(3), Arrays.asList())));
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // initialize visited room map with false value for all room
        HashMap<Integer, Boolean> visitedRoom = new HashMap<>();
        for(int i = 0; i < rooms.size(); i++) {
            visitedRoom.put(i, false);
        }

        // always start from room 0, since it never locked, and put all the keys on the room into set
        List<Integer> keys = new ArrayList<>();
        for(int i = 0; i < rooms.get(0).size(); i++) {
            keys.add(rooms.get(0).get(i));
        }
        visitedRoom.put(0, true);

        while(!keys.isEmpty()) {
            int roomToOpen = keys.getFirst();
            keys.removeFirst();
            if (visitedRoom.get(roomToOpen)) {
                continue;
            }

            visitedRoom.put(roomToOpen, true);
            for(Integer keyFound : rooms.get(roomToOpen)) {
                keys.add(keyFound);
            }
        }

        boolean allRoomVisited = true;
        for(Integer room : visitedRoom.keySet()) {
            if (!visitedRoom.get(room)) {
                allRoomVisited = false;
                break;
            }
        }
        return allRoomVisited;
    }
}
