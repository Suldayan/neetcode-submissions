class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int i = 0;
        int j = people.length - 1;
        int boats = 0;

        Arrays.sort(people);
        while (i <= j) {
            final int leftPerson = people[i];
            final int rightPerson = people[j];
            final int weightSum = leftPerson + rightPerson;

            if (weightSum == limit) {
                System.out.println(String.format("Equal: %d + %d = %d, Boats: %d", leftPerson, rightPerson, weightSum, boats));
                boats++;
                j--;
                i++;
            } else if (weightSum < limit) {
                System.out.println(String.format("Less: %d + %d = %d, Boats: %d", leftPerson, rightPerson, weightSum, boats));
                boats++;
                j--;
                i++;
            } else {
                System.out.println(String.format("More: %d + %d = %d, Boats: %d", leftPerson, rightPerson, weightSum, boats));
                boats++;
                j--;
            } 
        }

        return boats;
    }
}