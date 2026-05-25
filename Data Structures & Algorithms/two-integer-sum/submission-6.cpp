class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> output;
        unordered_map<int, int> seen;

        int i = 0;
        for (const int& num : nums) {
            if (seen.find(target - num) != seen.end()) {
                output.push_back(seen[target - num]);
                output.push_back(i);
                return output;
            }

            seen[num] = i;
            i++;
        }

        return output;
    }
};
