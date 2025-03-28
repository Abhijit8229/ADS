import java.util.*;

class Team {
    String name;
    int points, wins, losses, draws, noResult;

    public Team(String teamName, int wins, int losses, int draws, int noResult, int points) {
        this.name = teamName;
        this.points = points;
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
        this.noResult = noResult;
    }

    @Override
    public String toString() {
        return name + ": Points=" + points + ", Wins=" + wins + ", Losses=" + losses + ", Draws=" + draws
                + ", NoResult=" + noResult;
    }

    public static int customCompare(Team t1, Team t2) {
        if (t1.points != t2.points)
            return t2.points - t1.points;
        if (t1.wins != t2.wins)
            return t2.wins - t1.wins;
        if (t1.losses != t2.losses)
            return t1.losses - t2.losses;
        if (t1.draws != t2.draws)
            return t2.draws - t1.draws;
        if (t1.noResult != t2.noResult)
            return t1.noResult - t2.noResult;
        return t1.name.compareTo(t2.name);
    }
}

class BinaryHeap {
    private final List<Team> heap;

    public BinaryHeap() {
        heap = new ArrayList<>();
    }

    public void add(Team team) {
        heap.add(team);
        swim(heap.size() - 1);
    }

    public Team poll() {
        if (heap.isEmpty())
            return null;
        Team top = heap.get(0);
        Collections.swap(heap, 0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        sink(0);
        return top;
    }

    private void swim(int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (Team.customCompare(heap.get(i), heap.get(parent)) < 0) {
                Collections.swap(heap, i, parent);
                i = parent;
            } else {
                break;
            }
        }
    }

    private void sink(int i) {
        int n = heap.size();
        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = i;

            if (left < n && Team.customCompare(heap.get(left), heap.get(smallest)) < 0) {
                smallest = left;
            }
            if (right < n && Team.customCompare(heap.get(right), heap.get(smallest)) < 0) {
                smallest = right;
            }
            if (smallest != i) {
                Collections.swap(heap, i, smallest);
                i = smallest;
            } else {
                break;
            }
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Team> teamList = new ArrayList<>();
        String topTeams = sc.nextLine();
        int tp = Integer.parseInt(topTeams);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] data = line.split(",");

            String name = data[0];
            int wins = Integer.parseInt(data[1]);
            int losses = Integer.parseInt(data[2]);
            int draws = Integer.parseInt(data[3]);
            int noResult = Integer.parseInt(data[4]);
            int points = Integer.parseInt(data[5]);

            teamList.add(new Team(name, wins, losses, draws, noResult, points));
        }

        BinaryHeap heap = new BinaryHeap();
        for (Team team : teamList) {
            heap.add(team);
        }

        System.out.println("Top " + topTeams + " teams:");
        for (int i = 0; i < tp; i++) {
            System.out.println(heap.poll());
        }

        sc.close();
    }
}
